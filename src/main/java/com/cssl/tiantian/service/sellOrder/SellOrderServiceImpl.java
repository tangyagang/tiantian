package com.cssl.tiantian.service.sellOrder;


import com.cssl.tiantian.dao.sellOrder.SellOrderMapper;
import com.cssl.tiantian.pojo.Order;
import com.cssl.tiantian.pojo.OrderDetail;
import com.cssl.tiantian.vo.SellFindVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellOrderServiceImpl implements SellOrderService {
    @Autowired
    SellOrderMapper orderMapper;
    @Override
    public List<Order> getAll1(int userid) {
        List<Order> ord=orderMapper.getAll1(userid);
        return   removeOrd(ord,userid);
    }

    @Override
    public List<Order> getStatusByUserID(int userId, int status) {
        return removeOrd(orderMapper.getStatusByUserID(userId,status),userId);
    }

    @Override
    public List<Order> getOrderByOption(SellFindVo vo) {
        return removeOrd(orderMapper.getOrderByOption(vo),vo.getShopId());
    }

    @Override
    public List<Integer> getShopIdByUser(int UserId) {
        return orderMapper.getShopIdByUser(UserId);
    }



    @Override
    public Order getOrderByOrderId(int orderId,int userId) {
        return remove(orderMapper.getOrderByOrderId(orderId),userId);
    }

    @Override
    public int closeOrder(int orderId) {
        return orderMapper.updateOrderInClose(orderId);
    }

    @Override
    public int updateOrderDetail(int orderId) {
        return orderMapper.updateOrderDetail(orderId);
    }

    @Override
    public int addUserMoney(int userId,double cost) {
        return orderMapper.updateUserMoneyByUserId(userId,cost);
    }

    @Override
    public int updateOrderByStatus(int orderId, int Status) {
        return orderMapper.updateOrderByStatus(orderId,Status);
    }

    //剔除订单中其他卖家商品
    public Order remove(Order ord,int userid){
        List<Integer> Id1=orderMapper.getShopIdByUser(userid);
        List<OrderDetail> aa=ord.getOrderDetails();
        for (int s = 0; s < ord.getOrderDetails().size(); s++) {
            OrderDetail ode = ord.getOrderDetails().get(s);
            boolean sa=true;
            for (int i = 0;i< Id1.size(); i++) {
                if (ode.getShop().getShopId()==Id1.get(i)) {
                    sa=false;
                }
            }
            if(sa){
                aa.remove(s);
            }
        }
        ord.setOrderDetails(aa);
        return ord;
    }


    //剔除订单List中其他卖家商品
    public List<Order> removeOrd(List<Order> ord,int userid){
        List<Integer> Id=orderMapper.getShopIdByUser(userid);
        for (Order oo : ord) {
            List<OrderDetail> aa=oo.getOrderDetails();
            for (int s = 0; s < oo.getOrderDetails().size(); s++) {
                OrderDetail ode = oo.getOrderDetails().get(s);
                boolean sa=true;
                for (int i = 0;i< Id.size(); i++) {
                    if (ode.getShop().getShopId()==Id.get(i)) {
                        sa=false;
                    }
                }
                if(sa){
                    aa.remove(s);
                }
            }
            oo.setOrderDetails(aa);
        }
        return ord;
    }
}
