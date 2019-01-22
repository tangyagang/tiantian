package com.cssl.tiantian.dao.cities;

import com.cssl.tiantian.pojo.Cities;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CitiesMapper {

    //根据省ID查询所有的市，区
    public List<Cities> getCitiesByProvinceCode(@Param("provinceCode")int provinceCode);
}
