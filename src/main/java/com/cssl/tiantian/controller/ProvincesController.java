package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Areas;
import com.cssl.tiantian.pojo.Cities;
import com.cssl.tiantian.pojo.Provinces;
import com.cssl.tiantian.service.areas.AreasService;
import com.cssl.tiantian.service.cities.CitiesService;
import com.cssl.tiantian.service.provinces.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.geom.Area;
import java.util.List;

@Controller
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;
    @Autowired
    private CitiesService citiesService;
    @Autowired
    private AreasService areasService;

    //查询所有的省市区
    @RequestMapping("/provinces")
    public void getAll(){
        List<Provinces> list = provincesService.findAll();
        System.out.println(list.size());
    }

    //根据省ID查询下面的市
    @RequestMapping("/getCity")
    @ResponseBody
    public List<Cities> getCity(int provinceCode){
        List<Cities> list = citiesService.findCitiesByProvinceCode(provinceCode);
        return list;
    }
    //根据市ID查询下面的区县
    @RequestMapping("/getAreas")
    @ResponseBody
    public List<Areas> getAreas(int cityCode){
        List<Areas> list = areasService.findAreasByCityCode(cityCode);
        return list;
    }
}
