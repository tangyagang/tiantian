package com.cssl.tiantian.service.product;

import com.cssl.tiantian.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    //根据ID查询一个商品信息
    public Product findProductByProId(int proId);
    //获取数量
    public int findCount(String proName);
    //根据商品名称模糊查询
    public List<Product> findProductByProName(String proName,int pageNo,int pageSize);
    //根据商品分类查询所有商品
    public List<Product> findProductByPcId(int pcId,int pageNo,int pageSize);
    //分类查询所有商品数量
    public int findCountByPcId(int pcId);
    //分类查询所有商品(三级分类)
    public List<Product> findProductByPcId3(int pcId,int pageNo,int pageSize);
    //分类查询所有商品数量(三级分类)
    public int findCountByPcId3(int pcId);
}
