package com.cssl.tiantian.service.sellOrder;


import com.cssl.tiantian.dao.sellOrder.SellProductMapper;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.vo.ProIdVo;
import com.cssl.tiantian.vo.SellProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellProductServiceImpl implements SellProductService {
    @Autowired
    SellProductMapper sellProductMapper;
    @Override
    public List<Product> getAllByUser(int userId) {
        return sellProductMapper.getAllByUser(userId);
    }

    @Override
    public int updateByProId(SellProductVo vo) {return sellProductMapper.updateByProId(vo); }

    @Override
    public Integer  addProduct(Product product) {
        return sellProductMapper.insertProduct(product);
    }

    @Override
    public int updateProductByProduct(Product product) {
        return sellProductMapper.updateProductByProduct(product);
    }

    @Override
    public int inserProImgs(List<ProIdVo> ProIdVo) {
        return sellProductMapper.inserProImgs(ProIdVo);
    }

    @Override
    public Product getProductByProId(int proId) {
        return sellProductMapper.getProductByProId(proId);
    }
}
