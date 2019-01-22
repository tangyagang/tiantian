package com.cssl.tiantian.service.cities;

import com.cssl.tiantian.pojo.Cities;

import java.util.List;

public interface CitiesService {


    //根据省ID查询所有的市，区
    public List<Cities> findCitiesByProvinceCode(int provinceCode);
}
