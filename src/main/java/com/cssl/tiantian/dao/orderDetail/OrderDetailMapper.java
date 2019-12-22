package com.cssl.tiantian.dao.orderDetail;

import com.cssl.tiantian.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface OrderDetailMapper {

    //添加订单详情
    public int saveOderDetailByMap(List<OrderDetail> list);
    //根据订单ID查询冻结金额
    public List<OrderDetail> getOrderDetailByOrderId(@Param("orderIds") Integer[] orderIds, @Param("userId") int userId);
    //根据订单ID修改冻结金额
    public int updateFrozenPrice(@Param("orderIds") Integer[] orderIds,@Param("frozenPrice")double frozenPrice);
    //根据用户ID查询所有订单详情
    public List<OrderDetail> getAllByUserId(@Param("userId")int userId);
    //根据用户ID和商店ID查询订单详情
    public List<OrderDetail> getAllByUserIdAndShopId(@Param("userId")int userId,@Param("shopId")int shopId);






}
