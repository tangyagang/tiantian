package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.Provinces;
import com.cssl.tiantian.pojo.RecAddress;
import com.cssl.tiantian.pojo.vo.RecAddressAddVo;
import com.cssl.tiantian.service.provinces.ProvincesService;
import com.cssl.tiantian.service.recAddress.RecAddressService;
import com.cssl.tiantian.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/userManager")
public class RecAddressController {

    @Autowired
    private ProvincesService provincesService;
    @Resource
    private RecAddressService recAddressService;

    @RequestMapping("/recAddress")
    public String toAddressModify(ModelMap modelMap){
        List<Provinces> addressList = provincesService.findAll();
        List<RecAddress> recAddresses = recAddressService.findAll(Constants.USER_SESSION.getUserId());
        int count = recAddressService.findCountByUserId(Constants.USER_SESSION.getUserId());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("addressList",addressList);
        modelMap.put("recAddresses", recAddresses);
        modelMap.put("count", count);
        return "/userManager/recAddress";
    }

    @RequestMapping("/doAddressAdd")
    @ResponseBody
    public boolean doAddressAdd(RecAddressAddVo recAddressAdd){
        int userId = Constants.USER_SESSION.getUserId();
        recAddressAdd.setUserId(userId);
        if (recAddressService.findCountByUserId(userId) < 15){
            int isDefault = recAddressAdd.getIsDefault();
            if (isDefault > 0){
                //默认地址
                //1、根据用户ID将其他地址改为非默认地址：0
                recAddressService.modifyNotDefault(userId);
            }
            //2、添加地址
            if (recAddressService.addRecAddress(recAddressAdd) > 0){
                return true;
            }
            return false;
        }
        return false;
    }

    //修改为默认地址
    @RequestMapping("/modifyIsDefault")
    public String modifyIsDefault(int recAddressId){
        recAddressService.updateIsDefault(Constants.USER_SESSION.getUserId(), recAddressId);
        return "redirect:/userManager/recAddress";
    }

    //跳转修改地址页面
    @RequestMapping("/recAddressModify")
    public String recAddressModify(int recAddressId,ModelMap modelMap){
        RecAddress recAddress = recAddressService.findRecAddressById(recAddressId);
        List<Provinces> addressList = provincesService.findAll();
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("recAddress", recAddress);
        modelMap.put("addressList", addressList);
        return "/userManager/recAddressModify";
    }

    //修改地址
    @RequestMapping("/doRecAddressModify")
    @ResponseBody
    public boolean doRecAddressModify(RecAddressAddVo recAddressAdd){
        int userId = Constants.USER_SESSION.getUserId();
        int isDefault = recAddressAdd.getIsDefault();
        if (isDefault > 0){
            //默认地址
            //1、根据用户ID将其他地址改为非默认地址：0
            recAddressService.modifyNotDefault(userId);
        }
        //2、修改地址
        if (recAddressService.modifyRecAddress(recAddressAdd) > 0){
            return true;
        }
        return false;
    }

    //删除地址
    @RequestMapping("/delRecAddress")
    @ResponseBody
    public boolean delRecAddress(int recAddressId){
        if (recAddressService.delRecAddressById(recAddressId) > 0){
            return true;
        }
        return false;
    }





}
