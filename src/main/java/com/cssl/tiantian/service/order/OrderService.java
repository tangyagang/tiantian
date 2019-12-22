package com.cssl.tiantian.service.order;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.vo.AdminSearchOrderVo;
import com.cssl.tiantian.pojo.vo.SearchOrderVo;
import com.cssl.tiantian.pojo.vo.SuperOrderListSearch;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    //根据用户ID查询用户订单,分页查询
    public PageInfo<Order> findAllByUserId(int userId,int pageNo,int pageSize);
    //根据用户ID查询用户订单
    public List<Order> findAll(int userId);
    //添加订单，并返回生成的订单ID
    public int addOrder(Order order);
    //根据ID查询订单
    public Order findOrderById(int orderId);
    //根据搜索条件查询相关订单
    public PageInfo<Order> findOrderBySearch(SearchOrderVo searchOrder, int pageNo, int pageSize);
    //根据搜索条件查询相关订单
    public List<Order> findOrderBySearch(SearchOrderVo searchOrder);
    //改变订单状态
    public int modifyStatusByUserId(Integer[] orderIds,int status,int userId);
    //查询所有订单
    public PageInfo<Order> findAll(SuperOrderListSearch search,int pageNo, int pageSize);


    //根据卖家ID查询所有订单
    public PageInfo<Order> findAllByAdminId(AdminSearchOrderVo adminSearchOrderVo, int pageNo, int pageSize);
    //根据orderId获取特定订单
    public Order findOrderByOrderId(int orderId,int userId);
    //根据ID改变订单状态
    public int modifyStatusByOrderId(int orderId,int status);



}
