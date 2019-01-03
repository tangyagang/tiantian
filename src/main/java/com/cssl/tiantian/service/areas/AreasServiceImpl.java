package com.cssl.tiantian.service.areas;

import com.cssl.tiantian.dao.areas.AreasMapper;
import com.cssl.tiantian.pojo.Areas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreasServiceImpl implements AreasService{

    @Autowired
    private AreasMapper areasMapper;

    @Override
    public Areas findAreasByAreaId(int areaId) {
        return areasMapper.getAreasByAreaId(areaId);
    }
}
