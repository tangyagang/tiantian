package com.cssl.tiantian.service.order;

import com.cssl.tiantian.dao.order.OrderMapper;
import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> findAllByUserId(int userId,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Order> orders = orderMapper.getAllByUserId(userId);
        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);
        return pageInfo;
    }
}
