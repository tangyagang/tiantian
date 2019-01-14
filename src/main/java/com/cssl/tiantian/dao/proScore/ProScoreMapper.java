package com.cssl.tiantian.dao.proScore;

import com.cssl.tiantian.pojo.ProScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProScoreMapper {

    //根据商品ID查询所有评论，ID为空则查询所有
    public List<ProScore> getAllByProId(@Param("proId")Integer proId);
}
