package com.cssl.tiantian.service.proScore;

import com.cssl.tiantian.dao.proScore.ProScoreMapper;
import com.cssl.tiantian.pojo.ProScore;
import com.cssl.tiantian.pojo.vo.ProScoreVo;
import com.cssl.tiantian.pojo.vo.ScoreSearch;
import com.cssl.tiantian.tools.PojoTransformationMap;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProScoreServiceImpl implements ProScoreService {

    @Resource
    private ProScoreMapper proScoreMapper;

    @Override
    public PageInfo<ProScore> findAllByProId(Integer proId,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProScore> list = proScoreMapper.getAllByProId(proId);
        return new PageInfo<ProScore>(list);
    }

    @Override
    public int addProScore(ProScoreVo proScoreVo) {
        Map<String,Object> map = PojoTransformationMap.objectMap(proScoreVo);
        return proScoreMapper.saveProScore(map);
    }

    @Override
    public PageInfo<ProScore> findAllByUserId(ScoreSearch scoreSearch,int userId, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProScore> list = proScoreMapper.getAllByUserId(scoreSearch,userId);
        return new PageInfo<>(list);
    }

    @Override
    public List<ProScore> findAllByUserId(ScoreSearch scoreSearch,int userId) {
        return proScoreMapper.getAllByUserId(scoreSearch,userId);
    }
}
