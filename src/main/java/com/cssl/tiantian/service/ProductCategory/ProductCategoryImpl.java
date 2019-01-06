package com.cssl.tiantian.service.ProductCategory;

import com.cssl.tiantian.dao.productCategory.ProductCategoryMapper;
import com.cssl.tiantian.pojo.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findAll(Integer parentId) {
        return productCategoryMapper.getAll(parentId);
    }
}
