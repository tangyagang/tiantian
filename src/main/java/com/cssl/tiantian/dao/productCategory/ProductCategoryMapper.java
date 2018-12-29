package com.cssl.tiantian.dao.productCategory;

import com.cssl.tiantian.pojo.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryMapper {

    public List<ProductCategory> getAll();
}
