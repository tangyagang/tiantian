package com.cssl.tiantian.dao.provinces;

import com.cssl.tiantian.pojo.Provinces;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvincesMapper {
    //获取所有是省市区
    public List<Provinces> getAll();
}
