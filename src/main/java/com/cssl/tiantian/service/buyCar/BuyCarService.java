package com.cssl.tiantian.service.buyCar;

import com.cssl.tiantian.pojo.Buycar;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BuyCarService {

    //根据商店ID分类，根据商店ID拆分订单
    public int[] findShopIdByGroupShopId(@Param("buyCarIds")Integer[] buyCarIds,@Param("userId")int userId);
    //根据商店ID、用户ID，查询所有购物车信息
    public List<Buycar> findBuycarByShopId(int shopId,int userId);
    //将商品添加到购物车
    public int addByCar(int userId,int proId,int num);
    //根据用户ID查询所有购物车信息
    public PageInfo<Buycar> findAllByUserId(int userId,int pageNo,int pageSize);
    //根据用户ID查询所有购物车信息
    public List<Buycar> findAllByUserId(int userId);
    //根据ID修改数量
    public boolean modifyBuyCar(int buyCarId, int num);
    //根据ID删除购物车
    public boolean deleteBuyCarById(Integer[] buyCarIds);
    //根据ID查询购物车信息
    public List<Buycar> findAllBuycarById(Integer[] buyCarId);
    //根据ID查询一条购物车信息
    public Buycar findBuyCarById(int buyCarId);
    //根据商品ID和用户ID查询购物车信息
    public Buycar findBuycarByProIdAndUserId(int proId,int userId);
    //根据购物车ID删除购物车信息
    public boolean deleteBuyCarById(int buyCarId);









}
