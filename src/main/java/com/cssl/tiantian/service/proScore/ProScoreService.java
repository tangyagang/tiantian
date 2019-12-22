package com.cssl.tiantian.service.proScore;

import com.cssl.tiantian.pojo.ProScore;
import com.cssl.tiantian.pojo.vo.ProScoreVo;
import com.cssl.tiantian.pojo.vo.ScoreSearch;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ProScoreService {

    //根据商品ID查询所有评论，ID为空则查询所有
    public PageInfo<ProScore> findAllByProId(Integer proId,int pageNo,int pageSize);
    //添加评论
    public int addProScore(ProScoreVo proScoreVo);
    //根据用户ID查询所有评论
    public PageInfo<ProScore> findAllByUserId(ScoreSearch scoreSearch,int userId, int pageNo, int pageSize);
    //根据用户ID查询所有评论
    public List<ProScore> findAllByUserId(ScoreSearch scoreSearch,int userId);









}
