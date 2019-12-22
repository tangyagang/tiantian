package com.cssl.tiantian.service.recAddress;

import com.cssl.tiantian.dao.recAddress.RecAddressMapper;
import com.cssl.tiantian.pojo.RecAddress;
import com.cssl.tiantian.pojo.vo.RecAddressAddVo;
import com.cssl.tiantian.tools.PojoTransformationMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RecAddressServiceImp implements RecAddressService {

    @Resource
    private RecAddressMapper recAddressMapper;

    @Override
    public List<RecAddress> findAll(int userId) {
        return recAddressMapper.getAll(userId);
    }

    @Override
    public int findCountByUserId(int userId) {
        return recAddressMapper.getCountByUserId(userId);
    }

    @Override
    public int addRecAddress(RecAddressAddVo recAddressAdd) {
        Map<String,Object> map = PojoTransformationMap.objectMap(recAddressAdd);
        return recAddressMapper.saveRecAddress(map);
    }

    @Override
    public int modifyNotDefault(int userId) {
        return recAddressMapper.updateNotDefault(userId);
    }

    @Override
    public int updateIsDefault(int userId,int recAddressId) {
        if (recAddressMapper.updateNotDefault(userId) > 0){
            return recAddressMapper.updateIsDefault(recAddressId);
        }
        return 0;
    }

    @Override
    public RecAddress findRecAddressById(int recAddressId) {
        return recAddressMapper.getRecAddressById(recAddressId);
    }

    @Override
    public int modifyRecAddress(RecAddressAddVo recAddressAdd) {
        return recAddressMapper.updateRecAddress(PojoTransformationMap.objectMap(recAddressAdd));
    }

    @Override
    public int delRecAddressById(int recAddressId) {
        return recAddressMapper.delRecAddressById(recAddressId);
    }
}
