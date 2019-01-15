package com.cssl.tiantian.dao.order;

import com.cssl.tiantian.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {

    //根据用户ID查询用户订单
    public List<Order> getAllByUserId(@Param("userId")int userId);
    //添加订单，并返回生成的订单ID
    public int saveOrder(@Param("order")Order order);
    //根据ID查询订单
    public Order getOrderById(@Param("orderId")int orderId);
}
