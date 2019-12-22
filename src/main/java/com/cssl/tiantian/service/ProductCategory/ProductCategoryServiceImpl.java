package com.cssl.tiantian.service.ProductCategory;

import com.cssl.tiantian.dao.productCategory.ProductCategoryMapper;
import com.cssl.tiantian.pojo.ProductCategory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findAll(Integer parentId) {
        return productCategoryMapper.getAll(parentId);
    }

    @Override
    public ProductCategory findProductCategoryByPcId(int pcId) {
        return productCategoryMapper.getProductCategoryByPcId(pcId);
    }

    @Override
    public List<ProductCategory> findProductCategoryByPcId3(int pcId) {
        return productCategoryMapper.getProductCategoryByPcId3(pcId);
    }

    @Override
    public int addProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.saveProductCategory(productCategory);
    }

    @Override
    public PageInfo<ProductCategory> findAllByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProductCategory> list = productCategoryMapper.getAll(null);
        return new PageInfo<ProductCategory>(list);
    }

    @Override
    public PageInfo<ProductCategory> findProductCategoryByPcName(int pageNo, int pageSize,String pcName,int typeId) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProductCategory> list = productCategoryMapper.getProductCategoryByPcName(pcName,typeId);
        return new PageInfo<ProductCategory>(list);
    }

    @Override
    public int modifyProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.updateProductCategory(productCategory);
    }

    @Override
    public int delProductCategory(int pcId) {
        return productCategoryMapper.delProductCategory(pcId);
    }
}
