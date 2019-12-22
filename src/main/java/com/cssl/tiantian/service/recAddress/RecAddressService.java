package com.cssl.tiantian.service.recAddress;


import com.cssl.tiantian.pojo.RecAddress;
import com.cssl.tiantian.pojo.vo.RecAddressAddVo;

import java.util.List;

public interface RecAddressService {

    //根据用户ID查询所有收货地址
    public List<RecAddress> findAll(int userId);
    //根据用户ID查询收货地址数量
    public int findCountByUserId(int userId);
    //增加收货地址
    public int addRecAddress(RecAddressAddVo recAddressAdd);
    //修改为非默认地址
    public int modifyNotDefault(int userId);
    //根据ID修改为默认地址
    public int updateIsDefault(int userId,int recAddressId);
    //根据ID查询收货地址
    public RecAddress findRecAddressById(int recAddressId);
    //根据ID修改收货地址
    public int modifyRecAddress(RecAddressAddVo recAddressAdd);
    //根据ID删除地址
    public int delRecAddressById(int recAddressId);













}
