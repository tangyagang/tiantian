package com.cssl.tiantian.service.product;

import com.cssl.tiantian.dao.product.ProductMapper;
import com.cssl.tiantian.pojo.Product;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public int findCount(String proName) {
        return productMapper.getCount(proName);
    }

    @Override
    public List<Product> findProductByProName(String proName,int pageNo,int pageSize) {
        return productMapper.getProductByProName(proName,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public List<Product> findProductByPcId(int pcId,int pageNo,int pageSize) {
        return productMapper.getProductByPcId(pcId,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int findCountByPcId(int pcId) {
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

    @Override
    public List<Product> findAllByOrder(int pageNo,int pageSize) {
        return productMapper.getAllByOrder((pageNo-1)*pageSize,pageSize);
    }

    @Override
    public PageInfo<Product> findAllByPrice(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list = productMapper.getAllByPrice();
        //Page<Product> list = productMapper.getAllByPrice();
        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Product> findAllByOrderCount(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list = productMapper.getAllByOrderCount();
        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }


}
