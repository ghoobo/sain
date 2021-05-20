package com.sain.mapper;

import com.sain.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {

    public void addOrder(Order order);

    public void updateOrder(String id);

    public int takeCar(String id);

    public int returnCar(String id);

    public int selectCountById(int id);

    public int selectCountByAdmin(int id);

    public List<Order> selectById(@Param("offset") int offset, @Param("limit") int limit, @Param("id") int id);

    public List<Order> selectOrderByAdmin(@Param("offset") int offset, @Param("limit") int limit, @Param("id") int id);

}
