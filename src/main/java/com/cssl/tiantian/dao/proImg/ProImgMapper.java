package com.cssl.tiantian.dao.proImg;


import com.cssl.tiantian.pojo.ProImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProImgMapper {

    //新增图片数据
    public int saveProImg(@Param("params") Map<String,Object> map);
    //根据商品ID查询数据
    public List<ProImg> getProImgByProId(@Param("proId")int proId);
    //根据图片ID修改数据
    public int updateProImgById(@Param("proImg") Map<String,Object> map);
}
