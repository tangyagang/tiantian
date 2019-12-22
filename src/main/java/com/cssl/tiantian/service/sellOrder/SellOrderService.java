package com.cssl.tiantian.service.sellOrder;



import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.vo.SellFindVo;

import java.util.List;

public interface SellOrderService {
    public List<Order> getAll1(int userId);

    public List<Order> getStatusByUserID(int userId, int status);

    public List<Order> getOrderByOption(SellFindVo vo);

    public List<Integer>  getShopIdByUser(int UserId);

    //根据orderId获取特定订单
    public Order getOrderByOrderId(int orderId, int userId);


    public int closeOrder(int orderId);
    public int updateOrderDetail(int orderId);
    public int addUserMoney(int userId, double cost);

    public  int updateOrderByStatus(int orderId, int Status);


    public List<Order> getOrderByUserId(int userId,int currentPage,int pageSize);

    //获取卖家订单总量
    public int findCountByUserId(int userId);


}
