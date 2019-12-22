package com.cssl.tiantian.service.product;

import com.cssl.tiantian.dao.product.ProductMapper;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.vo.ProductAddVo;
import com.cssl.tiantian.pojo.vo.ProductChangeVo;
import com.cssl.tiantian.pojo.vo.ProductModifyVo;
import com.cssl.tiantian.tools.PojoTransformationMap;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Resource
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
    public List<Product> findProductByPcId(int pcId,String proName,int choose,int pageNo,int pageSize) {
        return productMapper.getProductByPcId(pcId,proName,choose,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int findCountByPcId(int pcId,String proName) {
        return productMapper.getCountByPcId(pcId, proName);
    }

    @Override
    public List<Product> findProductByPcId3(int pcId,String proName,int choose, int pageNo, int pageSize) {
        return productMapper.getProductByPcId3(pcId, proName,choose,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int findCountByPcId3(int pcId,String proName) {
        return productMapper.getCountByPcId3(pcId, proName);
    }

    @Override
    public List<Product> findAllByOrder(String proName,int pageNo,int pageSize) {
        return productMapper.getAllByOrder(proName,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public PageInfo<Product> findAllByPrice(String proName,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list = productMapper.getAllByPrice(proName);
        //Page<Product> list = productMapper.getAllByPrice();
        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Product> findAllByOrderCount(String proName,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list = productMapper.getAllByOrderCount(proName);
        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        return pageInfo;
    }

    @Override
    public int modifyProductById(Product product) {
        return productMapper.updateProductById(PojoTransformationMap.objectMap(product));
    }

    @Override
    public int modifyStockById(int proId, int stock) {
        return productMapper.updateStockById(proId,stock);
    }

    @Override
    public PageInfo<Product> findAllByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Product> list = productMapper.getAll();
        return new PageInfo<Product>(list);
    }

    @Override
    public int modifyByProIds(int[] proIds,int isDelete) {
        return productMapper.updateByProIds(proIds,isDelete);
    }

    @Override
    public int delByProIds(int[] proIds) {
        return productMapper.delByProIds(proIds);
    }

    @Override
    public PageInfo<Product> findAllByAdminId(int adminId,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Product> list = productMapper.getAllByAdminId(adminId);
        return new PageInfo<>(list);
    }

    @Override
    public int modifyProductById(ProductModifyVo productModifyVo) {
        return productMapper.updateProductById(PojoTransformationMap.objectMap(productModifyVo));
    }

    @Override
    public int modifyProductById(ProductChangeVo productChangeVo) {
        return productMapper.updateProductById(PojoTransformationMap.objectMap(productChangeVo));
    }

    @Override
    public int addProduct(ProductAddVo productAddVo) {
        if (productMapper.saveProduct(productAddVo) > 0){
            return productAddVo.getProId();
        }
        return 0;
    }


}
