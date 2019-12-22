package com.cssl.tiantian.dao.recAddress;


import com.cssl.tiantian.pojo.RecAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RecAddressMapper {

    //查询所有地址
    public List<RecAddress> getAll(int userId);
    //根据用户ID查询收货地址数量
    public int getCountByUserId(@Param("userId")int userId);
    //增加收货地址
    public int saveRecAddress(@Param("params")Map<String,Object> map);
    //修改为非默认地址
    public int updateNotDefault(@Param("userId")int userId);
    //根据ID修改为默认地址
    public int updateIsDefault(@Param("recAddressId")int recAddressId);
    //根据ID查询收货地址
    public RecAddress getRecAddressById(@Param("recAddressId")int recAddressId);
    //根据ID修改收货地址
    public int updateRecAddress(@Param("params") Map<String,Object> map);
    //根据ID删除地址
    public int delRecAddressById(@Param("recAddressId")int recAddressId);





}
