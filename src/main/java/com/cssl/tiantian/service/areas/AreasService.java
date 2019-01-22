package com.cssl.tiantian.service.areas;

import com.cssl.tiantian.pojo.Areas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreasService {

    public Areas findAreasByAreaId(int areaId);


    //根据市ID查询下面所有的区县
    public List<Areas> findAreasByCityCode(int cityCode);
}
