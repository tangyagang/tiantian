package com.cssl.tiantian.controller.superManager;
/**
 * 商品分类的增删改
 */

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superManager")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/categoryAdd")
    public String toCategoryAdd(ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll(null);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("list",list);
        return "/superManager/categoryAdd";
    }

    @RequestMapping("/getProductCategory")
    @ResponseBody
    public List<ProductCategory> getProductCategory(int parentId){
        List<ProductCategory> list = productCategoryService.findAll(parentId);
        return list;
    }

    @RequestMapping("/addProductCategory")
    public String addProductCategory(ProductCategory productCategory){
        productCategory.setTypeId(3);
        Map<String,Object> map = new HashMap<String,Object>();
        if(productCategoryService.addProductCategory(productCategory)>0){
            return "redirect:/superManager/categoryList";
        }else {
            map.put("message","添加失败，请检查输入内容！");
        }
        return "redirect:/superManager/categoryAdd";
    }

    @RequestMapping("/categoryList")
    public String getCategoryList(String pcName,String pageNo,ModelMap modelMap){
        modelMap.put("pcName",pcName);
        pcName = pcName != null && !"".equals(pcName) ? "%"+pcName+"%" : null;
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        PageInfo<ProductCategory> pageInfo = productCategoryService.findProductCategoryByPcName(pn, 50,pcName,3);
        int[] numbs = Page.getPageNumbers(pn,pageInfo.getPages());
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("numbs",numbs);
        return "/superManager/categoryList";
    }

    @RequestMapping("/categoryModify")
    public String categoryModify(Integer pcId,ModelMap modelMap){
        ProductCategory productCategory = productCategoryService.findProductCategoryByPcId(pcId);
        List<ProductCategory> list = productCategoryService.findAll(null);
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("pc",productCategory);
        modelMap.put("list",list);
        return "/superManager/categoryModify";
    }

    @RequestMapping("/doCategoryModify")
    public String doCategoryModify(ProductCategory productCategory){
        if (productCategoryService.modifyProductCategory(productCategory) > 0){
            return "redirect:/superManager/categoryList";
        }
        Integer pcId = productCategory.getPcId();
        return "redirect:/superManager/categoryModify?pcId="+pcId;
    }

    @RequestMapping("/delProductCategory")
    @ResponseBody
    public boolean delProductCategory(int pcId){
        if (productCategoryService.delProductCategory(pcId) > 0){
            return true;
        }
        return false;
    }

}
