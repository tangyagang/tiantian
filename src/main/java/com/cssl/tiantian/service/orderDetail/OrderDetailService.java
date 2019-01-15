package com.cssl.tiantian.service.orderDetail;

import com.cssl.tiantian.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    //添加订单详情
    public int addOderDetailByMap(List<OrderDetail> list);
}
