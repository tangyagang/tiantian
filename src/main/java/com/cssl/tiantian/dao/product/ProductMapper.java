package com.cssl.tiantian.dao.product;

import com.cssl.tiantian.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    public List<Product> getAll();

    //根据ID查询商品信息
    public Product getProductByProId(int proId);
}
