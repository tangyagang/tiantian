package com.cssl.tiantian.service.productCollect;

import com.cssl.tiantian.pojo.ProductCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCollectService {

    //根据用户查询所有的商品收藏
    public List<ProductCollect> findAllProductCollectByUserId(int userId,String proName);
    //根据ID删除商品收藏
    public int delByProductCollectIds(Integer[] productCollectIds);
    //根据用户ID和商品ID添加收藏
    public boolean addCollection(int userId,int proId);
    //根据用户查询所有的商品收藏
    public List<ProductCollect> findAllProductCollectByUserIdAndProId(int userId,int proId);













}
