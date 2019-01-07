package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.Page;
import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.product.ProductService;
import com.cssl.tiantian.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    //分类查询所有商品(一、二级分类)
    @RequestMapping("/doDetail")
    public String doDetail(@RequestParam(value = "pcId",required = false) int pcId,String pageNo, ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findAll(null);
        ProductCategory productCategory = productCategoryService.findProductCategoryByPcId(pcId);
        Page page = new Page<>();
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount = productService.findCountByPcId(pcId);//总数据量
        List<Product> products = productService.findProductByPcId(pcId,pn, Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(products);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        modelMap.put("productCategorys",list);
        modelMap.put("productCategory",productCategory);
        modelMap.put("page",page);
        modelMap.put("numbs",numbs);
        return "/detail";
    }

    //分类查询所有商品(三级分类)
    @RequestMapping("/doDetail2")
    public String doDetail2(@RequestParam(value = "pcId",required = false) int pcId,String pageNo, ModelMap modelMap){
        List<ProductCategory> list = productCategoryService.findProductCategoryByPcId3(pcId);//所有同级分类
        ProductCategory productCategory = productCategoryService.findProductCategoryByPcId(pcId);//查询所属分类
        Page page = new Page<>();
        Integer pn = pageNo != null && pageNo.equals("") ? Integer.parseInt(pageNo) : 1;//当前页码
        int totalCount = productService.findCountByPcId3(pcId);//总数据量
        List<Product> products = productService.findProductByPcId3(pcId,pn, Constants.PAGE_SIZE);//结果集
        int totalPage = totalCount % Constants.PAGE_SIZE == 0 ? totalCount / Constants.PAGE_SIZE : totalCount / Constants.PAGE_SIZE + 1;//总页数
        page.setList(products);
        page.setPageNo(pn);
        page.setPageSize(Constants.PAGE_SIZE);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        int[] numbs = Page.getPageNumbers(pn,totalPage);
        modelMap.put("productCategorys",list);
        modelMap.put("productCategory",productCategory);
        modelMap.put("page",page);
        modelMap.put("numbs",numbs);
        return "/detail2";
    }
   /* @RequestMapping("/pro")
    public void findProductByProId(){
        Product product = productService.findProductByProId(1);
        int count = productService.getCount("手1");
        List<Product> products = productService.getProductByProName("手");
        System.out.println(">,..>>"+count);
        System.out.println(product.getProName()+">>>"+product.getShop().getShopName()+">>>"+product.getShop().getUser().getUserName());
    }*/

    /**
     * 把当前商品的id，添加到cookie里面
     * @param proId
     * @param request
     * @param response
     */
    private void addHistory(String proId, HttpServletRequest request,
                            HttpServletResponse response){
        Cookie ck = null;
        Cookie[] cks = request.getCookies();
        if (cks != null && cks.length > 0){
            for (Cookie cookie : cks) {
                String key = cookie.getName();
                if(key.equals("history")){
                    ck = cookie;
                    break;
                }
            }
        }
        if (ck == null){
            //说明客户端不存在一个叫做history的cookie，就只能创建一个新的
            ck = new Cookie("history",proId);
        }else {
            String value = ck.getValue();
            String[] proIds = value.split(",");
            String[] newProIds = replaceProIds(proIds,proId);
            String idStr = "";
            for (String newProId : newProIds) {
                idStr += newProId+",";
            }
            idStr = idStr.substring(idStr.length()-1);
            ck.setValue(idStr);
        }
        ck.setMaxAge(60*60*27*7);//设置cookie的有效时间为7天
        response.addCookie(ck);
    }
    /**
     * 去掉数组中重复的值（id)，生成新的数组，把id放到新的数组的最前面
     * @param proIds
     * @param proId
     * @return
     */
    public String[] replaceProIds(String[] proIds, String proId){
        int index = -1;
        for (int i=0;i<proIds.length;i++){
            if (proIds[i].equals(proId)){
                index = i;
                break;
            }
        }
        if(index >= 0){
            //有重复，去掉重复 25,26,24,38    24
            proIds[index] = null;
            //移位，把index之前的数字依次往后移一位
            for (int i=index-1;i>=0;i--){
                String temp = proIds[i];//index前面一位
                proIds[i] = proIds[i+1];
                proIds[i+1] = temp;
            }
            //最后把本次的id添加到最前面
            proIds[0] = proId;
            return  proIds;
        }else {
            //没有重复
            if (proIds.length == 5){
                //达到最大数
                //去掉最后一位
                proIds[proIds.length-1] = null;
                //移位，把index之前的数字依次往后移一位
                for (int i=index-1;i>=0;i--){
                    String temp = proIds[i];//index前面一位
                    proIds[i] = proIds[i+1];
                    proIds[i+1] = temp;
                }
                //最后把本次的id添加到最前面
                proIds[0] = proId;
                return proIds;
            }else {
                //没有达到最大数
                String[] newProIds = new String[proIds.length+1];
                for (int i=0;i<proIds.length;i++){
                    newProIds[i+1] = proIds[i];
                }
                //最后把本次的id添加到最前面
                proIds[0] = proId;
                return newProIds;
            }
        }
    }
    /**
     * 检查id在ids中是否存在
     */
    /*private boolean exists(String[] ids,String id){
        boolean flag = false;
        for(String str : ids){
            if(str.equals(id)){
                flag = true;
            }
        }
        return flag;
    }*/
}
