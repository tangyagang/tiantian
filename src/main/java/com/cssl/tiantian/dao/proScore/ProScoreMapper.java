package com.cssl.tiantian.dao.proScore;

import com.cssl.tiantian.pojo.ProScore;
import com.cssl.tiantian.pojo.vo.ProScoreVo;
import com.cssl.tiantian.pojo.vo.ScoreSearch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface ProScoreMapper {

    //根据商品ID查询所有评论，ID为空则查询所有
    public List<ProScore> getAllByProId(@Param("proId")Integer proId);
    //添加评论
    public int saveProScore(@Param("params")Map<String,Object> map);
    //根据用户ID查询所有评论
    public List<ProScore> getAllByUserId(@Param("scoreSearch") ScoreSearch scoreSearch,@Param("userId") int userId);















}
