package com.sain.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:
 * @Date: 2018/9/12 19:08
 * @Description:
 */
public class BaiDuUtil {
    private static Logger logger = LoggerFactory.getLogger(BaiDuUtil.class);
    private static final String BAIDU_APP_KEY = "Na0vFG8NiWhYPIgG0K6awhY6YDu5Z6HP";

    /**
     * 输入中文地址
     *
     * @param address
     * @return lng(经度), lat(纬度)
     */
    public static Map<String, Object> getLatitude(String address) {
        String res;
        try {
            // 将地址转换成utf-8的16进制
            address = URLEncoder.encode(address, "UTF-8");
            URL resjson = new URL("http://api.map.baidu.com/geocoder/v2/?callback=renderOption&output=json&address=" + address + "&ak=" + BAIDU_APP_KEY);
            BufferedReader in = new BufferedReader(new InputStreamReader(resjson.openStream()));
            StringBuilder sb = new StringBuilder();
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }
            in.close();
            String str = sb.toString();
            if (SSHValidateHelper.isNotEmptyString(str)) {
                Map<String, Object> map = new HashMap<>();
                String subStr = str.substring(str.indexOf('(') + 1, str.indexOf("})") + 1);
                //字符串转成json格式
                JSONObject jsonObj = JSONObject.parseObject(subStr);
                //获取经度
                Object lng = jsonObj.getJSONObject("result").getJSONObject("location").get("lng");
                //获取纬度
                Object lat = jsonObj.getJSONObject("result").getJSONObject("location").get("lat");
                map.put("lng", lng);
                map.put("lat", lat);
                //返回经纬度
                return map;
            }
        } catch (Exception e) {
            logger.error("地址解析出现异常！", e);
        }
        return null;
    }

    /**
     * 地址的经纬度坐标 key lng(经度),lat(纬度)
     *
     * @param lng(经度),lat(纬度)
     * @return 返回中文地址
     */
    public static String getAddress(String lng, String lat) {
        String res;
        String address = null;
        try {
//            http://api.map.baidu.com/reverse_geocoding/v3/?output=json&coordtype=wgs84ll&location=" + lat + "," + lng + "&ak= + BAIDU_APP_KEY
            URL resjson = new URL("http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location=" + lat + "," + lng + "&output=json&pois=1&ak=" + BAIDU_APP_KEY);
            BufferedReader in = new BufferedReader(new InputStreamReader(resjson.openStream()));
            StringBuilder sb = new StringBuilder();
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }
            in.close();
            String str = sb.toString();
            String subStr = str.substring(str.indexOf('(') + 1, str.indexOf("})") + 1);
            JSONObject jsonObj = JSONObject.parseObject(subStr);
            //获取匹配到的中文地址
            JSONObject object = (JSONObject) jsonObj.getJSONObject("result").get("addressComponent");
            if (!SSHValidateHelper.isEmpty(object)) {
                String street_number = "";
                if (!SSHValidateHelper.isEmpty(object.get("street_number"))) {
                    street_number = object.get("street_number").toString();
                    street_number=street_number.replace("号","")+"号";
                }
                // 省、市、区、街道号、拼接
                address = object.get("province").toString() + object.get("city").toString() + object.get("district").toString() + object.get("street").toString() + street_number;
            }
            JSONArray array = (JSONArray) jsonObj.getJSONObject("result").get("pois");
            if (!SSHValidateHelper.isEmpty(array)) {
                JSONObject object1 = (JSONObject) array.get(0);
                if (!SSHValidateHelper.isEmpty(object1)) {
                    // 详细地址
                    address = address + object1.get("name");
                }
            }
        } catch (Exception e) {
            logger.error("反向地址解析出现异常！", e);
        }
        return address;
    }

    public static void main(String args[]) {
//        Map<String, Object> map = BaiDuUtil.getLatitude("福建省福州市仓山区福建农林大学");
        // //输出地址所对应的经纬度
        // if (null != map) {
        //     System.out.print("福建省福州市闽侯县福州大学：");
        //     System.out.print("经度" + map.get("lng"));
        //     System.out.print(",纬度" + map.get("lat"));
        //     System.out.println();
        // }

        //输出经纬度对应的中文地址
        // System.out.println("经度" + map.get("lng") + ",纬度" + map.get("lat") + "  对应的中文地址是：" + BaiDuUtil.getAddress("120.12385572053700000000","30.29511582271730000000"));
        String[] split = "113.915766,34.622973".split(",");
        System.out.println(BaiDuUtil.getAddress(split[0], split[1]));
//        Map<String, Object> map = BaiDuUtil.getLatitude("河南省郑州市金水区郑州大学北校区");
//        System.out.println(map);
    }
}
