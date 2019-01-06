package com.cssl.tiantian.dao.productCategory;

import com.cssl.tiantian.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryMapper {

    public List<ProductCategory> getAll(@Param("parentId") Integer parentId);
}
