package com.cssl.tiantian.service.product;

import com.cssl.tiantian.pojo.Product;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    //按价格从高到底排序查询所有（天天精选）
    public List<Product> findAllByOrder(int pageNo,int pageSize);
    //查询所有9.9元的商品（9.9）
    public PageInfo<Product> findAllByPrice(int pageNo, int pageSize);
    //根据销量查询所有商品
    public PageInfo<Product> findAllByOrderCount(int pageNo, int pageSize);
    //根据ID修改库存
    public int modifyProductById(Product product);
    //根据ID修改库存
    public int modifyStockById(int proId,int stock);
}
