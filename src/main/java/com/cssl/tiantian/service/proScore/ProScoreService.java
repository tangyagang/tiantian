package com.cssl.tiantian.service.proScore;

import com.cssl.tiantian.pojo.ProScore;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProScoreService {

    //根据商品ID查询所有评论，ID为空则查询所有
    public PageInfo<ProScore> findAllByProId(@Param("proId")Integer proId,int pageNo,int pageSize);
}
