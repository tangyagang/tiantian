package com.cssl.tiantian.service.order;

import com.cssl.tiantian.dao.order.OrderMapper;
import com.cssl.tiantian.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAllByUserId(int userId) {
        List<Order> orders = orderMapper.getAllByUserId(userId);
        return orders;
    }
}
