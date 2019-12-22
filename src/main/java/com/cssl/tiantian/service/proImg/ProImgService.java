package com.cssl.tiantian.service.proImg;

import com.cssl.tiantian.pojo.ProImg;
import com.cssl.tiantian.pojo.vo.ProImgVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ProImgService {

    //新增图片数据
    public int addProImg(ProImgVo proImgVo);
    //根据商品ID查询数据
    public List<ProImg> findProImgByProId(int proId);
    //根据图片ID修改数据
    public int modifyProImgById(ProImgVo proImgVo);

}
