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
    //获取数量
    public int getCount(@Param("proName") String proName);
    //根据商品名称模糊查询
    public List<Product> getProductByProName(@Param("proName")String proName);
}
