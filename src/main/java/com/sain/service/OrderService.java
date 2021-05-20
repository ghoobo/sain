package com.sain.service;

import com.sain.entity.Order;

import java.util.Map;

public interface OrderService {

    public void addOrder(Order order);

    public void updateOrder(String id);

    public Map takeCar(String id);

    public Map returnCar(String id);

    public Map showOrder(int page, int limit, int id);

    public Map selectOrderByAdmin(int page, int limit, int id);

}
