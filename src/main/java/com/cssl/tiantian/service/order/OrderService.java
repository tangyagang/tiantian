package com.cssl.tiantian.service.order;

import com.cssl.tiantian.pojo.Buycar;
import com.cssl.tiantian.pojo.Order;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    //根据用户ID查询用户订单
    public PageInfo<Order> findAllByUserId(int userId,int pageNo,int pageSize);
    //添加订单，并返回生成的订单ID
    public int addOrder(Order order);
    //根据ID查询订单
    public Order findOrderById(int orderId);
}
