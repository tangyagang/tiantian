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
    public List<Product> getProductByProName(String proName,int pageNo,int pageSize) {
        return productMapper.getProductByProName(proName,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public List<Product> findProductByPcId(int pcId,int pageNo,int pageSize) {
        return productMapper.getProductByPcId(pcId,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int getCountByPcId(int pcId) {
        return productMapper.getCountByPcId(pcId);
    }

    @Override
    public List<Product> findProductByPcId3(int pcId, int pageNo, int pageSize) {
        return productMapper.getProductByPcId3(pcId,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int findCountByPcId3(int pcId) {
        return productMapper.getCountByPcId3(pcId);
    }


}
