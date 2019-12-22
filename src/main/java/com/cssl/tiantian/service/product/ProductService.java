package com.cssl.tiantian.service.product;

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.vo.ProductAddVo;
import com.cssl.tiantian.pojo.vo.ProductChangeVo;
import com.cssl.tiantian.pojo.vo.ProductModifyVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductService {

    //查询所有商品
    public List<Product> findAll();
    //根据ID查询一个商品信息
    public Product findProductByProId(int proId);
    //获取数量
    public int findCount(String proName);
    //根据商品名称模糊查询
    public List<Product> findProductByProName(String proName,int pageNo,int pageSize);
    //根据商品分类查询所有商品
    public List<Product> findProductByPcId(int pcId,String proName,int choose,int pageNo,int pageSize);
    //分类查询所有商品数量
    public int findCountByPcId(int pcId,String proName);
    //分类查询所有商品(三级分类)
    public List<Product> findProductByPcId3(int pcId,String proName,int choose,int pageNo,int pageSize);
    //分类查询所有商品数量(三级分类)
    public int findCountByPcId3(int pcId,String proName);
    //按价格从高到底排序查询所有（天天精选）
    public List<Product> findAllByOrder(String proName,int pageNo,int pageSize);
    //查询所有9.9元的商品（9.9）
    public PageInfo<Product> findAllByPrice(String proName,int pageNo, int pageSize);
    //根据销量查询所有商品
    public PageInfo<Product> findAllByOrderCount(String proName,int pageNo, int pageSize);
    //根据ID修改库存
    public int modifyProductById(Product product);
    //根据ID修改库存
    public int modifyStockById(int proId,int stock);
    //分页查询所有商品
    public PageInfo<Product> findAllByPage(int pageNo,int pageSize);
    //根据ID修改商品状态(商品上架、下架用)
    public int modifyByProIds(int[] proIds,int isDelete);
    //根据ID删除商品
    public int delByProIds(int[] proIds);


    //根据卖家ID查询所有商品信息
    public PageInfo<Product> findAllByAdminId(int adminId,int pageNo,int pageSize);
    //根据ID修改商品（快速修改）
    public int modifyProductById(ProductModifyVo productModifyVo);
    //根据ID修改商品
    public int modifyProductById(ProductChangeVo productChangeVo);
    //发布商品
    public int addProduct(ProductAddVo productAddVo);











}
