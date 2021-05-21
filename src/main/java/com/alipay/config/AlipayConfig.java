package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101700710435";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC+ANEZwt5xfRxZDhWTamRv7T8vBmAGly6SoajYL94jhI9fA3A2Tihqpk8nHm6xTnB2xM/xdwrcuDpUIB4PcNIJVv2/9YsHwggqUrP6igTsFYn9Kv2cA2BlaEIjd9NAg4lI2SyCparN4FxmYvgVyW7U9gUaI+h8pcZCI8iwwhz+eqZVQ7Ivqh8h3O0ivGx7qlXgcsjwRLQHNEbCH5gyUu+tRrRNBStQ/aP+BwWtZxxRdw6aFtXiQE6aDJIC9OrsMfvKScjdWorIUrS9xPPQMTR92It3im7RfNXArd50CynTX+71BUHPx9V/XQXjG8Fh73Rkm35p+MuB4EYykzKTsQSZAgMBAAECggEAS/AlokcpAnC/cLRZWTavd7B5jUDeBiRMP9yOkADppoZnitDj+0BXlPBtODRIh2LTPhTBCz/Jvpd+8Hp5qTAtMgBroFnxvCMHgmrVde/NsdGV+fJBtCYBU+ZMcMKGUwV/S/dIe9rcnjXqmB08C/Ea89B0D5OEarUSvQJyRnr+fZI1LbMY6TmblGPjcxofZ3Q9ZjyBI6ltGN+6BeFYYyQgWfRTTLwDwR8f26XlYdyKifm7Oeb6hhFVmOV/sjgb5SfoFdO5yx9lYdUP1Sdt3chNNDITqrwFjhY/ab/T6MjnLpJ0q1FxGMuZ90gfiMuTdCAq5+XArl76GmnBaZU1xKw49QKBgQDhJZEPF27oMTPSbGtbpfBP96WWYZHHIYyQzFR3uKq7qvMl42OqjPUAlBL7Yqj1g83CzIS5HJxkzUM62gMi8HM3BEaagoVZ4FBgkAdzRAMAyJF2Dwjmt4YRqFxpISZeh5TyYd01X+yl0VJhTg0dpYdGC/5T6kBwTGBKRjurcZ9f7wKBgQDYCl6lg+5s4XBAu0ksa4y5TxpRPDHFAhGW2EYJfiNbA8aq1Wu+Tw3+lZNFfjiZ5Gvgdo3qVHuet4Sn0wHPDA8seVmh3tpOtqroPyT8H3oQmLJormFpqlTuBhaL3ZK+u3q7syn1zIhO9N643P/mCIIIK3kWAyEsbb+Xpwp9J8bb9wKBgGfTOReqiLyOpAUvdjqnRTC7VSMKD32y3O2RLIqhICq25LXeLIHjyr/fiPlgP+YoR+TDB5mNthlOBujGzJd6JseCM0ThV7lglfBRuv3OqUvdMictO7+ZdjwCVcstPFJvV6KGusn4WFsHMmQo6Cd5w+3rbfcomVqv/d+Cj9W56fMFAoGAJCHv3HzpVpqJ3Lm2LlC6k4+wVh/cLxf+ex0m8ZWAMku6YX4abBTqwUahAAFxVAPJKxyI9cU1e8Ez1aHL7qYUr5qILDOKjZmtkfRlqilVkAsJ48oujq6nT7wC71eaoH3YtCXuAac4sQPxcDe+MOoBXX5v3Qee98BPR/zvGymY79cCgYEAl3iSBRk956QBsZ28rFhAZ3Fa0bBYzxowlTseMzTC23AyVME61lmMKQqv+QerGtGZlk32QsGKNgxpz2fUn6M/E77da4t1Nh2Mpag1PwXWUTza9dYOTdN89lVVb6PbbTZ++nMXv6WAcipQk7h6QpbAqWlBmKNNtw5ACoFa8XxJD+g=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAporDJIXKz5P+7VFbyowMTD1vo6VWcUqL/bH0ANzMmp/D8JoXpd3aGoAciT5HWrvTFY2blMw/QKEyNXo/uJoTzcoGAcAeIc44pEgCHGTo1Gu6RC+0/pZlaylSQgBS0ypSe3Zkl6pSdNsRpMatMlz3KwD9Q020z9zyYT49S6WoXAvbjI2RbGyv6I3D9gnu/4A1zfH61tPEEi0jgkVvDIfOR0BirtvJu2lcuqKheKwXCIvDOex7mzKEZrzfw/nSvIepHhIQX4qNCCuF9HvKZBuTEjVz6HONrxbnlFprA6IYiZvn17OHV67qF9PqjkjtkbIcEH25GQG74L6DZqnmekaoXQIDAQAB\n";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/sain/order/updateOrder";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

