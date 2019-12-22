package com.cssl.tiantian.dao.shop;

import com.cssl.tiantian.pojo.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {

    //查询所有店铺||根据店铺名称和用户名称模糊查询店铺
    public List<Shop> getAllByShopNameAndUserName(@Param("shopName") String shopName, @Param("userName") String userName);
    //根据商店ID删除商店
    public int deleteShopByShopId(@Param("shopId")int shopId);
    //根据用户ID，分类查询购买过的店铺及商品
    public List<Shop> getAllByUserIdAndShopName(@Param("userId")int userId,@Param("shopName")String shopName);

    //根据用户ID查询旗下所属商店
    public List<Shop> getAllByUserId(@Param("adminId")int adminId);











}
