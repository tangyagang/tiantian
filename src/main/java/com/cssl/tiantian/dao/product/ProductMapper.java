package com.cssl.tiantian.dao.product;

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.vo.ProductAddVo;
import com.cssl.tiantian.tools.PojoTransformationMap;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface ProductMapper {

    public List<Product> getAll();
    //根据ID查询商品信息
    public Product getProductByProId(@Param("proId") int proId);
    //根据ID查询商品数量
    public int getCount(@Param("proName") String proName);
    //根据商品名称模糊查询
    public List<Product> getProductByProName(@Param("proName")String proName,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    //分类查询所有商品(一、二级分类)
    public List<Product> getProductByPcId(@Param("pcId")int pcId,@Param("proName")String proName,@Param("choose")int choose,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    //分类查询所有商品数量(一、二级分类)
    public int getCountByPcId(@Param("pcId")int pcId,@Param("proName")String proName);
    //分类查询所有商品(三级分类)
    public List<Product> getProductByPcId3(@Param("pcId")int pcId,@Param("proName")String proName,@Param("choose")int choose,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    //分类查询所有商品数量(三级分类)
    public int getCountByPcId3(@Param("pcId")int pcId,@Param("proName")String proName);
    //按价格从高到底排序查询所有（天天精选）
    public List<Product> getAllByOrder(@Param("proName")String proName,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
    //查询所有9.9元的商品（9.9包邮）
    public List<Product> getAllByPrice(@Param("proName")String proName);
    //根据销量查询所有商品
    public  List<Product> getAllByOrderCount(@Param("proName")String proName);
    //根据ID修改商品
    public int updateProductById(@Param("product")Map<String,Object> product);
    //根据ID修改库存
    public int updateStockById(@Param("proId")int proId,@Param("stock")int stock);
    //根据ID修改商品状态(商品上架、下架用)
    public int updateByProIds(@Param("proIds")int[] proIds,@Param("isDelete")int isDelete);
    //根据ID删除商品
    public int delByProIds(@Param("proIds")int[] proIds);


    //根据卖家ID查询所有商品信息
    public List<Product> getAllByAdminId(@Param("adminId")int adminId);
    //发布商品
    public int saveProduct(@Param("productAddVo")ProductAddVo productAddVo);








}
