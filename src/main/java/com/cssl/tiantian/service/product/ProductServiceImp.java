package com.cssl.tiantian.service.product;

import com.cssl.tiantian.dao.product.ProductMapper;
import com.cssl.tiantian.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.getAll();
    }

    @Override
    public Product findProductByProId(int proId) {
        return productMapper.getProductByProId(proId);
    }

    @Override
    public int getCount(String proName) {
        return productMapper.getCount(proName);
    }

    @Override
    public List<Product> getProductByProName(String proName) {
        return productMapper.getProductByProName(proName);
    }
}
