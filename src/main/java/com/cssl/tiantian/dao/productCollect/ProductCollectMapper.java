package com.cssl.tiantian.dao.productCollect;

import com.cssl.tiantian.pojo.ProductCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCollectMapper {

    //根据用户查询所有的商品收藏
    public List<ProductCollect> getAllProductCollectByUserId(@Param("userId") int userId,@Param("proName")String proName);
    //根据ID删除商品收藏
    public int delByProductCollectIds(@Param("productCollectIds")Integer[] productCollectIds);
    //根据用户ID和商品ID添加收藏
    public int saveCollection(@Param("userId") int userId,@Param("proId")int proId);
    //根据用户查询所有的商品收藏
    public List<ProductCollect> getAllProductCollectByUserIdAndProId(@Param("userId") int userId,@Param("proId")int proId);









}
