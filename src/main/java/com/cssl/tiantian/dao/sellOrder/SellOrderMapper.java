package com.cssl.tiantian.dao.sellOrder;


import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.vo.SellFindVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellOrderMapper {

    //根据用户ID查询用户订单
    public List<Order> getAllByUserId(@Param("userId") int userId);

    public List<Order> getAll1(@Param("userId") int userId);

    //根据Order.Status查询用户订单
    public List<Order> getStatusByUserID(@Param("userId") int userId, @Param("status") int status);

    //根据条件查询用户订单
    public List<Order> getOrderByOption(SellFindVo vo);

    //根据USER查询其名下店铺ID
    public List<Integer>  getShopIdByUser(int userId);

    //根据orderId获取特定订单
    public Order getOrderByOrderId(int orderId);

    public  int updateOrderByStatus(@Param("orderId") int orderId, @Param("Status") int Status);
    //根据orderId将订单设定为关闭状态,并归零cost及orderDetail中frozenPrice字段
    public int updateOrderInClose(int orderId);
    public int updateOrderDetail(int orderId);
    public int updateUserMoneyByUserId(@Param("userId") int userId, @Param("cost") double cost);

}
