package com.cssl.tiantian.dao.productCategory;

import com.cssl.tiantian.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryMapper {

    //根据父类ID查询所有之类（包括自己）
    public List<ProductCategory> getAll(@Param("parentId") Integer parentId);
    //根据ID查询所属分类(一、二级分类)
    public ProductCategory getProductCategoryByPcId(@Param("pcId")int pcId);
    //根据ID查询所属分类(三级分类)
    public ProductCategory getProductCategoryByPcId3(@Param("pcId")int pcId);
}
