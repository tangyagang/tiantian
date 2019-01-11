package com.cssl.tiantian.service.order;

import com.cssl.tiantian.pojo.Order;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    //根据用户ID查询用户订单
    public PageInfo<Order> findAllByUserId(int userId,int pageNo,int pageSize);
}
