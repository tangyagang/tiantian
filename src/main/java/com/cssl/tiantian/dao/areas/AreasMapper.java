package com.cssl.tiantian.dao.areas;

import com.cssl.tiantian.pojo.Areas;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreasMapper {

    //根据区县ID查询区县信息
    public Areas getAreasByAreaId(@Param("areaId") int areaId);

    //根据市ID查询下面所有的区县
    public List<Areas> getAreasByCityCode(@Param("cityCode")int cityCode);
}
