package com.cssl.tiantian.dao.sellOrder;


import com.cssl.tiantian.pojo.Product;
import com.cssl.tiantian.vo.ProIdVo;
import com.cssl.tiantian.vo.SellProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellProductMapper {
    public List<Product> getAllByUser(int userId);

    public int updateByProId(SellProductVo vo);

    public  Product getProductByProId(@Param("proId") int proId);


    //修改商品的方法
    public  int updateProductByProduct(Product product);

    //添加商品方法
    public Integer  insertProduct(Product product);

    //批量添加商品图片的方法
    public int  inserProImgs(List<ProIdVo> ProIdVo);
}
