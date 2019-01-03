package com.cssl.tiantian.service.areas;

import com.cssl.tiantian.pojo.Areas;
import org.apache.ibatis.annotations.Param;

public interface AreasService {

    public Areas findAreasByAreaId(int areaId);
}
