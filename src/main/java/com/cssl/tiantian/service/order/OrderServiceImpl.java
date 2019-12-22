package com.cssl.tiantian.service.order;

import com.cssl.tiantian.dao.order.OrderMapper;
import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.vo.AdminSearchOrderVo;
import com.cssl.tiantian.pojo.vo.SearchOrderVo;
import com.cssl.tiantian.pojo.vo.SuperOrderListSearch;
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

    @Override
    public List<Order> findAll(int userId) {
        return orderMapper.getAllByUserId(userId);
    }

    @Override
    public int addOrder(Order order) {
        if (orderMapper.saveOrder(order) > 0){
            return order.getOrderId();
        }
        return 0;
    }

    @Override
    public Order findOrderById(int orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public PageInfo<Order> findOrderBySearch(SearchOrderVo searchOrder, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Order> list = orderMapper.getOrderBySearch(searchOrder);
        PageInfo<Order> pageInfo = new PageInfo<Order>(list);
        return pageInfo;
    }

    @Override
    public List<Order> findOrderBySearch(SearchOrderVo searchOrder) {
        return orderMapper.getOrderBySearch(searchOrder);
    }

    @Override
    public int modifyStatusByUserId(Integer[] orderIds, int status, int userId) {
        return orderMapper.updateStatusByUserId(orderIds, status, userId);
    }

    @Override
    public PageInfo<Order> findAll(SuperOrderListSearch search, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Order> list = orderMapper.getAll(search);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Order> findAllByAdminId(AdminSearchOrderVo adminSearchOrderVo, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Order> list = orderMapper.getAllByAdminId(adminSearchOrderVo);
        return new PageInfo<>(list);
    }

    @Override
    public Order findOrderByOrderId(int orderId, int userId) {
        return null;
    }

    @Override
    public int modifyStatusByOrderId(int orderId, int status) {
        return orderMapper.updateStatusByOrderId(orderId, status);
    }


}
