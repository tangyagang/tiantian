package com.cssl.tiantian.dao.product;

import com.cssl.tiantian.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    public List<Product> getAll();

    //根据ID查询商品信息
    public Product getProductByProId(@Param("proId") int proId);
    //根据ID查询商品数量
    public int getCount(@Param("proName") String proName);
    //根据商品名称模糊查询
    public List<Product> getProductByProName(@Param("proName")String proName,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    //分类查询所有商品(一、二级分类)
    public List<Product> getProductByPcId(@Param("pcId")int pcId,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    //分类查询所有商品数量(一、二级分类)
    public int getCountByPcId(@Param("pcId")int pcId);
    //分类查询所有商品(三级分类)
    public List<Product> getProductByPcId3(@Param("pcId")int pcId,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    //分类查询所有商品数量(三级分类)
    public int getCountByPcId3(@Param("pcId")int pcId);

}
