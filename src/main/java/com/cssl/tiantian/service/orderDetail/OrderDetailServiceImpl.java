package com.cssl.tiantian.service.orderDetail;

import com.cssl.tiantian.dao.orderDetail.OrderDetailMapper;
import com.cssl.tiantian.pojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public int addOderDetailByMap(List<OrderDetail> list) {
        return orderDetailMapper.saveOderDetailByMap(list);
    }
}
