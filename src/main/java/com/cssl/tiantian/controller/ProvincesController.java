package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Provinces;
import com.cssl.tiantian.service.provinces.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;

    @RequestMapping("/provinces")
    public void getAll(){
        List<Provinces> list = provincesService.findAll();
        System.out.println(list.size());
    }
}
