package com.cssl.tiantian.service.cities;

import com.cssl.tiantian.dao.cities.CitiesMapper;
import com.cssl.tiantian.pojo.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    private CitiesMapper citiesMapper;

    @Override
    public List<Cities> findCitiesByProvinceCode(int provinceCode) {
        return citiesMapper.getCitiesByProvinceCode(provinceCode);
    }
}
