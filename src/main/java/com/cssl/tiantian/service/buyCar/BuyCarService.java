package com.cssl.tiantian.service.buyCar;

import com.cssl.tiantian.pojo.Buycar;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;


public interface BuyCarService {

    //将商品添加到购物车
    public int addByCar(int userId,int proId,int num);
    //根据用户ID查询所有购物车信息
    public PageInfo<Buycar> findAllByUserId(int userId,int pageNo,int pageSize);
    //根据ID修改数量
    public boolean modifyBuyCar(int buyCarId, int num);
    //根据ID删除购物车
    public boolean deleteBuyCarById(int[] buyCarIds);

}
