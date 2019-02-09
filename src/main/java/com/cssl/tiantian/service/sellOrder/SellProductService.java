package com.cssl.tiantian.service.sellOrder;



import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.vo.ProIdVo;
import com.cssl.tiantian.vo.SellProductVo;

import java.util.List;

public interface SellProductService {

    public List<Product> getAllByUser(int userId);


    public int updateByProId(SellProductVo vo);

    public Integer  addProduct(Product product);


    public  int updateProductByProduct(Product product);

    //批量添加商品图片的方法
    public int  inserProImgs(List<ProIdVo> ProIdVo);


    public  Product getProductByProId(int proId);
}
