package com.cssl.tiantian.service.ProductCategory;

import com.cssl.tiantian.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategory> findAll(Integer parentId);
}
