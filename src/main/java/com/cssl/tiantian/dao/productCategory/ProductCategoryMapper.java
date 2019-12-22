package com.cssl.tiantian.dao.productCategory;

import com.cssl.tiantian.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductCategoryMapper {

    //根据父类ID查询所有子类（包括自己）
    public List<ProductCategory> getAll(@Param("parentId") Integer parentId);
    //根据ID查询所属分类
    public ProductCategory getProductCategoryByPcId(@Param("pcId")int pcId);
    //根据ID查询所属分类的同级(三级分类)
    public List<ProductCategory> getProductCategoryByPcId3(@Param("pcId")int pcId);
<<<<<<< HEAD
    //添加分类
    public int saveProductCategory(ProductCategory productCategory);
    //查询所有子类及所属父类、根据分类名称模糊查询
    public List<ProductCategory> getProductCategoryByPcName(@Param("pcName")String pcName,@Param("typeId")int typeId);
    //根据ID修改分类
    public int updateProductCategory(ProductCategory productCategory);
    //根据ID删除分类
    public int delProductCategory(@Param("pcId") int pcId);


=======

    public  List<ProductCategory> findMenuByParentId(@Param("pcId") Integer pcId);
>>>>>>> github/master
}
