package com.cssl.tiantian.service.provinces;

import com.cssl.tiantian.dao.product.ProductMapper;
import com.cssl.tiantian.dao.provinces.ProvincesMapper;
import com.cssl.tiantian.pojo.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Autowired
    private ProvincesMapper provincesMapper;

    @Override
    public List<Provinces> findAll() {
        return provincesMapper.getAll();
    }
}
