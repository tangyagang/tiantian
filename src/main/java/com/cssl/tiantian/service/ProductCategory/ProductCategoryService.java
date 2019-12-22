package com.cssl.tiantian.service.ProductCategory;

import com.cssl.tiantian.pojo.ProductCategory;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryService {

    //根据父类ID查询所有之类（包括自己）
    public List<ProductCategory> findAll(Integer parentId);
    //根据ID查询所属分类
    public ProductCategory findProductCategoryByPcId(int pcId);
    //根据ID查询所属分类(三级分类)
    public List<ProductCategory> findProductCategoryByPcId3(int pcId);
    //添加分类
    public int addProductCategory(ProductCategory productCategory);
    //分页查询所有分类
    public PageInfo<ProductCategory> findAllByPage(int pageNo,int pageSize);
    //查询所有子类及所属父类、根据分类名称模糊查询
    public PageInfo<ProductCategory> findProductCategoryByPcName(int pageNo, int pageSize,String pcName,int typeId);
    //根据ID修改分类
    public int modifyProductCategory(ProductCategory productCategory);
    //根据ID删除分类
    public int delProductCategory(int pcId);



}
