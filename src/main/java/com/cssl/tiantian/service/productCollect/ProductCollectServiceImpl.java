package com.cssl.tiantian.service.productCollect;

import com.cssl.tiantian.dao.productCollect.ProductCollectMapper;
import com.cssl.tiantian.pojo.ProductCollect;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductCollectServiceImpl implements ProductCollectService {

    @Resource
    private ProductCollectMapper productCollectMapper;


    @Override
    public List<ProductCollect> findAllProductCollectByUserId(int userId,String proName) {
        return productCollectMapper.getAllProductCollectByUserId(userId,proName);
    }

    @Override
    public int delByProductCollectIds(Integer[] productCollectIds) {
        return productCollectMapper.delByProductCollectIds(productCollectIds);
    }

    @Override
    public boolean addCollection(int userId, int proId) {
        if (productCollectMapper.saveCollection(userId, proId) > 0)
            return true;
        return false;
    }

    @Override
    public List<ProductCollect> findAllProductCollectByUserIdAndProId(int userId, int proId) {
        return productCollectMapper.getAllProductCollectByUserIdAndProId(userId, proId);
    }
}
