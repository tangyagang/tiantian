package com.cssl.tiantian.service.orderDetail;

import com.cssl.tiantian.pojo.OrderDetail;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailService {

    //添加订单详情
    public int addOderDetailByMap(List<OrderDetail> list);
    //根据订单ID查询冻结金额,并修改卖家余额
    public boolean modifyUserMoneyByOrderId( Integer[] orderIds, int userId);
    //根据订单ID修改冻结金额
    public int modifyFrozenPrice( Integer[] orderIds,double frozenPrice);
    //根据用户ID查询所有订单详情
    public PageInfo<OrderDetail> findAllByUserId(int userId,int pageNo,int pageSize);





}
