package com.cssl.tiantian.service.orderDetail;

import com.cssl.tiantian.dao.orderDetail.OrderDetailMapper;
import com.cssl.tiantian.dao.user.UserMapper;
import com.cssl.tiantian.pojo.OrderDetail;
import com.cssl.tiantian.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addOderDetailByMap(List<OrderDetail> list) {
        return orderDetailMapper.saveOderDetailByMap(list);
    }

    @Override
    public boolean modifyUserMoneyByOrderId(Integer[] orderIds, int userId) {
        List<OrderDetail> list = orderDetailMapper.getOrderDetailByOrderId(orderIds, userId);
        for (int i=0;i<list.size();i++){
            User user = new User();
            int uId = list.get(i).getShop().getUser().getUserId();
            User  u = userMapper.getUserByUserId(uId);
            double frozenPrice = list.get(i).getFrozenPrice();//冻结金额
            double money =u.getMoney();//余额
            user.setUserId(uId);
            user.setMoney(frozenPrice+money);
            if (userMapper.updateUser(user) == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public int modifyFrozenPrice(Integer[] orderIds,double frozenPrice) {
        return orderDetailMapper.updateFrozenPrice(orderIds, frozenPrice);
    }

    @Override
    public PageInfo<OrderDetail> findAllByUserId(int userId,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<OrderDetail> list = orderDetailMapper.getAllByUserId(userId);
        return new PageInfo<>(list);
    }
}
