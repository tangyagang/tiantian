package com.cssl.tiantian.dao.order;

import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.vo.AdminSearchOrderVo;
import com.cssl.tiantian.pojo.vo.SearchOrderVo;
import com.cssl.tiantian.pojo.vo.SuperOrderListSearch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    //根据用户ID查询用户订单
    public List<Order> getAllByUserId(@Param("userId")int userId);
    //添加订单，并返回生成的订单ID
    public int saveOrder(@Param("order")Order order);
    //根据ID查询订单
    public Order getOrderById(@Param("orderId")int orderId);
    //根据搜索条件查询相关订单
    public List<Order> getOrderBySearch(SearchOrderVo searchOrder);
    //改变订单状态
    public int updateStatusByUserId(@Param("orderIds") Integer[] orderIds,@Param("status")int status,@Param("userId") int userId);
    //查询所有订单
    public List<Order> getAll(@Param("search") SuperOrderListSearch search);


    //卖家
    //根据搜索条件查询相关订单
    public List<Order> getAllByAdminId(AdminSearchOrderVo adminSearchOrderVo);
    //根据ID改变订单状态
    public int updateStatusByOrderId(@Param("orderId")int orderId,@Param("status")int status);



}
