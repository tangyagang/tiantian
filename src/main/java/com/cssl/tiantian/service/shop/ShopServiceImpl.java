package com.cssl.tiantian.service.shop;

import com.cssl.tiantian.dao.orderDetail.OrderDetailMapper;
import com.cssl.tiantian.dao.shop.ShopMapper;
import com.cssl.tiantian.pojo.OrderDetail;
import com.cssl.tiantian.pojo.Shop;
import com.cssl.tiantian.service.orderDetail.OrderDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public PageInfo<Shop> findAllByShopNameAndUserName(int pageNo,int pageSize,String shopName, String userName) {
        PageHelper.startPage(pageNo,pageSize);
        List<Shop> list = shopMapper.getAllByShopNameAndUserName(shopName,userName);
        return new PageInfo<Shop>(list);
    }

    @Override
    public int deleteShopByShopId(int shopId) {
        return shopMapper.deleteShopByShopId(shopId);
    }

    @Override
    public List<Shop> findAllByUserIdAndShopName(int userId, String shopName) {
        List<Shop> shopList = shopMapper.getAllByUserIdAndShopName(userId, shopName);
        List<Shop> list = new ArrayList<>();
        for (Shop shop : shopList) {
            List<OrderDetail> orderDetailList = orderDetailMapper.getAllByUserIdAndShopId(userId, shop.getShopId());
            shop.setOrderDetails(orderDetailList);
            list.add(shop);
        }
        return list;
    }

    @Override
    public List<Shop> findAllByUserId(int adminId) {
        return shopMapper.getAllByUserId(adminId);
    }
}
