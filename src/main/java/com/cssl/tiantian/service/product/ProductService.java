package com.cssl.tiantian.service.product;

import com.cssl.tiantian.pojo.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    //根据ID查询一个商品信息
    public Product findProductByProId(int proId);
}
