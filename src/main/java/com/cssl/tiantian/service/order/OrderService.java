package com.cssl.tiantian.service.order;

import com.cssl.tiantian.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    //根据用户ID查询用户订单
    public List<Order> findAllByUserId(int userId);
}
