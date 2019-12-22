package com.cssl.tiantian.service.shop;

import com.cssl.tiantian.pojo.Shop;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ShopService {

    //查询所有店铺||根据店铺名称和用户名称模糊查询店铺
    public PageInfo<Shop> findAllByShopNameAndUserName(int pageNo,int pageSize,String shopName,String userName);
    //根据商店ID删除商店
    public int deleteShopByShopId(int shopId);
    //根据用户ID，分类查询购买过的店铺及商品
    public List<Shop> findAllByUserIdAndShopName(int userId,String shopName);

    //根据用户ID查询旗下所属商店
    public List<Shop> findAllByUserId(int adminId);


}
