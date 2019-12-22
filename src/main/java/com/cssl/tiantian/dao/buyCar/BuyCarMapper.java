package com.cssl.tiantian.dao.buyCar;

import com.cssl.tiantian.pojo.Buycar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BuyCarMapper {

    //根据商店ID分类，根据商店ID拆分订单
    public int[] getShopIdByGroupShopId(@Param("buyCarIds")Integer[] buyCarIds,@Param("userId")int userId);
    //根据商店ID、用户ID，查询所有购物车信息
    public List<Buycar> getBuycarByShopId(@Param("shopId")int shopId,@Param("userId")int userId);
    //将商品添加到购物车
    public int saveByCar(@Param("userId") int userId, @Param("proId") int proId, @Param("num") int num);
    //根据用户ID查询所有购物车信息
    public List<Buycar> getAllByUserId(@Param("userId")int userId);
    //根据ID修改数量
    public int updateBuyCar(@Param("buyCarId")int buyCarId,@Param("num") int num);
    //根据ID删除购物车
    public int deleteBuyCarById(@Param("buyCarIds")Integer[] buyCarIds);
    //根据ID查询购物车信息
    public List<Buycar> getAllBuycarById(@Param("buyCarIds") Integer[] buyCarIds);
    //根据ID查询一条购物车信息
    public Buycar getBuyCarById(int buyCarId);
    //根据商品ID和用户ID查询购物车信息
    public Buycar getBuycarByProIdAndUserId(@Param("proId")int proId,@Param("userId")int userId);
    //根据购物车ID删除购物车信息
    public int delBuyCarById(@Param("buyCarId")int buyCarId);












}
