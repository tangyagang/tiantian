package com.cssl.tiantian.service.ProductCategory;

import com.cssl.tiantian.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryService {

    //根据父类ID查询所有之类（包括自己）
    public List<ProductCategory> findAll(Integer parentId);
    //根据ID查询所属分类
    public ProductCategory findProductCategoryByPcId(@Param("pcId")int pcId);
    //根据ID查询所属分类(三级分类)
    public List<ProductCategory> findProductCategoryByPcId3(int pcId);
}
