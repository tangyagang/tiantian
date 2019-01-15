package com.cssl.tiantian.dao.orderDetail;

import com.cssl.tiantian.pojo.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailMapper {

    //添加订单详情
    public int saveOderDetailByMap(List<OrderDetail> list);
}
