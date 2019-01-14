package com.cssl.tiantian.service.proScore;

import com.cssl.tiantian.dao.proScore.ProScoreMapper;
import com.cssl.tiantian.pojo.ProScore;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProScoreServiceImpl implements ProScoreService {

    @Autowired
    private ProScoreMapper proScoreMapper;

    @Override
    public PageInfo<ProScore> findAllByProId(Integer proId,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProScore> list = proScoreMapper.getAllByProId(proId);
        return new PageInfo<ProScore>(list);
    }
}
