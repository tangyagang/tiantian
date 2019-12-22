package com.cssl.tiantian.controller;



import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.pojo.ProductCategory;
import com.cssl.tiantian.pojo.User;
import com.cssl.tiantian.service.ProductCategory.ProductCategoryService;
import com.cssl.tiantian.service.sellOrder.SellProductService;
import com.cssl.tiantian.vo.ProIdVo;
import com.cssl.tiantian.vo.SellProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class SellProductController {
    @Autowired
    SellProductService sellProductService;
    @Autowired
    ProductCategoryService productCategoryService;



    //添加商品
    @RequestMapping("/sellManager/SellAdd")
    public String list(ModelMap modelMap){
        List<ProductCategory> pro=productCategoryService.findAll(1);
        modelMap.put("CateList",pro);
        return "/sellManager/SellProductAdd";
    }

    //三级分类栏级联的ajax方法
    @RequestMapping( value = "/sellManager/pcId",method = RequestMethod.POST)
    @ResponseBody
    public  List<ProductCategory> list2(@RequestParam(value = "pdd") int pdd){
        List<ProductCategory> pro= productCategoryService.findMenuByParentId(pdd);
        return pro;
    }


    //根据卖家ID查询名下所有SHOP并返回商品List
    @RequestMapping("/sellManager/SellProductController")
    public  String  findAll(HttpServletRequest request,ModelMap modelmap){
        User user=(User)request.getSession().getAttribute("User");
        modelmap.put("ProductList",sellProductService.getAllByUser(user.getUserId()));
        return "/sellManager/SellProductList";
    }


    //商品列表快速修改库存及价格的方法
    @RequestMapping("/sellManager/SellProductUpdate")
    public String updatePro(@ModelAttribute SellProductVo vo, HttpServletRequest request,ModelMap modelMap){
        sellProductService.updateByProId(vo);
        User user=(User)request.getSession().getAttribute("User");
        modelMap.put("ProductList",sellProductService.getAllByUser(user.getUserId()));
        return "/sellManager/SellProductList";
    }

    //修改商品的方法
    @RequestMapping("/sellManager/ProChange")
    public String ProChange(@ModelAttribute Product product, HttpServletRequest request,ModelMap modelMap, @RequestParam (value = "pcId1") int id1,
                            @RequestParam (value = "pcId2") int id2, @RequestParam (value = "pcId3") int id3){
        ProductCategory productCategory=new ProductCategory();
        product.setProductCategory(productCategory);
        if(id2>id1){
            product.getProductCategory().setPcId(id2);
            if(id3>id2){
                product.getProductCategory().setPcId(id3);
            }
        }else{
            product.getProductCategory().setPcId(id1);
        }
        sellProductService.updateProductByProduct(product);
        User user=(User)request.getSession().getAttribute("User");
        modelMap.put("ProductList",sellProductService.getAllByUser(user.getUserId()));
        return "/sellManager/SellProductList";
    }


    //点击商品列表中详情时跳转到商品详情页面的方法
    @RequestMapping("/sellManager/ProductChange")
    public String ProChange(ModelMap modelMap,@RequestParam(value = "proId")int proId){
        List<ProductCategory> pro=productCategoryService.findAll(1);
        Product product=sellProductService.getProductByProId(proId);
        int Category=0;
        if(product.getProductCategory().getTypeId()==3){
            for(ProductCategory cate:pro){
                for(ProductCategory cate2:cate.getProductCategorys()){
                    if(cate2.getPcId()==product.getProductCategory().getParentId()){
                        Category=cate2.getParentId();
                    }
                }
            }
        }
        modelMap.put("Category",Category);
        modelMap.put("Product",product);
        modelMap.put("CateList",pro);
        return "/sellManager/ProductChange";
    }

    /* 商品添加,尚未加事务控制
    *  第一次调用添加商品方法 向商品表单添加商品，返回商品自增ID
    *  第二次传入商品图片VO类，并根据商品ID查询SHOPID，向图片表添加数据。
    * */
    @RequestMapping("/sellManager/addProduct")
    public String addProduct(@RequestParam Map<String, Object> map, @RequestParam(value = "file") MultipartFile file,
                             @RequestParam(value = "file1",required = false)MultipartFile[] file1,
                            ModelMap modelMap,HttpServletRequest request ) throws IOException {
        Product pro=new Product();
        ProductCategory pCate=new ProductCategory();
        if(Integer.parseInt(map.get("pcId2").toString())>Integer.parseInt(map.get("pcId1").toString())){
            pCate.setPcId(Integer.parseInt(map.get("pcId2").toString()));
                if(Integer.parseInt(map.get("pcId3").toString())>Integer.parseInt(map.get("pcId2").toString())){
                    pCate.setPcId(Integer.parseInt(map.get("pcId3").toString()));
                }
        }else{
            pCate.setPcId(Integer.parseInt(map.get("pcId1").toString()));
        }
        pro.setProductCategory(pCate);
        if(map.get("proName")!=null){
            pro.setProName(map.get("proName").toString());
        }
        if(map.get("proPrice")!=null){
            pro.setProPrice(Double.parseDouble(map.get("proPrice").toString()));
        }
        if(map.get("stock")!=null){
            pro.setStock((Integer.parseInt(map.get("stock").toString())));
        }
        if(map.get("description")!=null){
            pro.setDescription(map.get("description").toString());
        }
        if(map.get("newPrice")!=null){
            pro.setIsPrice(1);
            pro.setNewPrice(Double.parseDouble(map.get("newPrice").toString()));
        }else{
            pro.setIsPrice(0);
        }

        if(!file.isEmpty()){
            String fileName=file.getOriginalFilename();
            String path="F:/1/img/";
            String newName= UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
            File newUrl=new File(path+newName);
            try {
                file.transferTo(newUrl);
                pro.setProUrl(path+newName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pro.setCreateTime(new Date());
        sellProductService.addProduct(pro);

        //向商品图片表插入数据
        List<ProIdVo> list=new ArrayList();
        if (file1!=null||file1.length>0){
        for(MultipartFile fe:file1){

            if(!fe.isEmpty()){
                ProIdVo proIdVo=new ProIdVo();
                String fileName=fe.getOriginalFilename();
                String path="F:/1/img/";
                String newName= UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
                File newUrl=new File(path+newName);
                fe.transferTo(newUrl);
                proIdVo.setProImgUrl(path+newName);
                proIdVo.setProId(pro.getProId());
                list.add(proIdVo);
            }
        }
            sellProductService.inserProImgs(list);
        }

        User user=(User)request.getSession().getAttribute("User");
        modelMap.put("ProductList",sellProductService.getAllByUser(user.getUserId()));
        return "/sellManager/SellProductList";
    }
}
