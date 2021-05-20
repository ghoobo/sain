var flag;
function toOpenMap1() {
    flag = 1;
    layui.use('layer', function(){
        layer.open({
            title:"选择位置",
            content:$("#mapLayer"),
            type:1,
            area:["800px","500px"],
            maxmin:true
        })
    });
}
function toOpenMap2() {
    flag = 2;
    layui.use('layer', function(){
        layer.open({
            title:"选择位置",
            content:$("#mapLayer"),
            type:1,
            area:["800px","500px"],
            maxmin:true
        })
    });
}

// 百度地图API功能
var map = new BMap.Map("allmap");    // 创建Map实例
map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
//添加地图类型控件
map.addControl(new BMap.MapTypeControl({
    mapTypes:[
        BMAP_NORMAL_MAP,
        BMAP_HYBRID_MAP
    ]}));
// map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
var mapStyle = {style: "dark" };     //设置地图北京黑色
// map.setMapStyle(mapStyle);

var geolocation = new BMap.Geolocation();
geolocation.getCurrentPosition(function(r){
    if(this.getStatus() == BMAP_STATUS_SUCCESS){
        var mk = new BMap.Marker(r.point);
        map.addOverlay(mk);
        map.panTo(r.point);
    }
},{enableHighAccuracy: true})
//单击获取点击的经纬度
/*map.addEventListener("click",function(e){
    alert(e.point.lng + "," + e.point.lat);
});*/
var point = new BMap.Point(116.331398,39.897445);
map.centerAndZoom(point,12);
var geoc = new BMap.Geocoder();
map.addEventListener("click", function(e){
    var pt = e.point;
    geoc.getLocation(pt, function(rs){
        var addComp = rs.addressComponents;
        // alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
        var address = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
        if (flag==1){
            $("#take_location").val(address)
        }else {
            $("#return_location").val(address)
        }
        layer.closeAll('page');
    });
});