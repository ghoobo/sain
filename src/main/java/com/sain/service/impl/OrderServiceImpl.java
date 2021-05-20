package com.sain.service.impl;

import com.sain.entity.Order;
import com.sain.mapper.OrderMapper;
import com.sain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void updateOrder(String id) {
        orderMapper.updateOrder(id);
    }

    @Override
    public @ResponseBody
    Map takeCar(String id) {
        int count = orderMapper.takeCar(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isTake","更改成功");
        }else{
            map.put("isTake","更改失败");
        }
        return map;
    }

    @Override
    public @ResponseBody
    Map returnCar(String id) {
        int count = orderMapper.returnCar(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isReturn","更改成功");
        }else{
            map.put("isReturn","更改失败");
        }
        return map;
    }

    @Override
    public Map showOrder(int page, int limit, int id) {
        int offset=(page-1)*limit;
        List<Order> list = orderMapper.selectById(offset, limit, id);
        int count = orderMapper.selectCountById(id);
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @Override
    public Map selectOrderByAdmin(int page, int limit, int id) {
        int offset=(page-1)*limit;
        List<Order> list = orderMapper.selectOrderByAdmin(offset, limit, id);
        int count = orderMapper.selectCountByAdmin(id);
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

}
