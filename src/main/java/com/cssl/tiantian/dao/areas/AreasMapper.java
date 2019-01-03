package com.cssl.tiantian.dao.areas;

import com.cssl.tiantian.pojo.Areas;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AreasMapper {

    public Areas getAreasByAreaId(@Param("areaId") int areaId);
}
