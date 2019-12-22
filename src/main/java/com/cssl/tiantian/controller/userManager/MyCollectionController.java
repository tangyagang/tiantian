package com.cssl.tiantian.controller.userManager;

import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCollect;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.service.productCollect.ProductCollectService;
import com.cssl.tiantian.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userManager")
public class MyCollectionController {

    @Resource
    private ProductCollectService productCollectService;
    @Resource
    private ProductService productService;

    //跳转到收藏页面
    @RequestMapping("/myCollection")
    public String toMyCollection(@RequestParam(value = "pageNo",required = false)String pageNo,
                                 @RequestParam(value = "proName",required = false)String proName,
                                 ModelMap modelMap){
        Integer pn = pageNo != null && !pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        List<ProductCollect> productCollectList = productCollectService.findAllProductCollectByUserId(Constants.USER_SESSION.getUserId(),proName);
        PageInfo<Product> pageInfo = productService.findAllByOrderCount(null,pn,4 );
        int isDelete = 0;
        int isPrice = 0;
        for (int i=0;i<productCollectList.size();i++){
            if (productCollectList.get(i).getProduct().getIsDelete() == 1){
                isDelete++;
            }
            if (productCollectList.get(i).getProduct().getIsPrice() == 1){
                isPrice++;
            }
        }
        if (proName != null && proName != ""){
            modelMap.put("proName",proName);
        }
        modelMap.put("user", Constants.USER_SESSION);//用户信息
        modelMap.put("productCollectList", productCollectList);
        modelMap.put("pageInfo",pageInfo );
        modelMap.put("isDelete", isDelete);
        modelMap.put("isPrice", isPrice);
        return "/userManager/myCollection";
    }

    @RequestMapping("/deleteProductCollect")
    public String deleteProductCollect(@RequestParam(value = "productCollectIds") List<Integer> productCollectIds){
        Integer[] ids = productCollectIds.toArray(new Integer[productCollectIds.size()]);
        productCollectService.delByProductCollectIds(ids);
        return "redirect:/userManager/myCollection";
    }

    //添加宝贝收藏
    @RequestMapping("/proCollection")
    public String proCollection(int proId){
        if (productCollectService.findAllProductCollectByUserIdAndProId(Constants.USER_SESSION.getUserId(),proId).size()==0){
            if(productCollectService.addCollection(Constants.USER_SESSION.getUserId(), proId)){
                return "redirect:/userManager/myCollection";
            }
        }

        return "redirect:/productDetails?proId="+proId;
    }







}
