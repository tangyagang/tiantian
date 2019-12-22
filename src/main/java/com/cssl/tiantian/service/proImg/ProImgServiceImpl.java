package com.cssl.tiantian.service.proImg;

import com.cssl.tiantian.dao.proImg.ProImgMapper;
import com.cssl.tiantian.pojo.ProImg;
import com.cssl.tiantian.pojo.vo.ProImgVo;
import com.cssl.tiantian.tools.PojoTransformationMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProImgServiceImpl implements ProImgService {

    @Resource
    private ProImgMapper proImgMapper;

    @Override
    public int addProImg(ProImgVo proImgVo) {
        return proImgMapper.saveProImg(PojoTransformationMap.objectMap(proImgVo));
    }

    @Override
    public List<ProImg> findProImgByProId(int proId) {
        return proImgMapper.getProImgByProId(proId);
    }

    @Override
    public int modifyProImgById(ProImgVo proImgVo) {
        return proImgMapper.updateProImgById(PojoTransformationMap.objectMap(proImgVo));
    }
}
