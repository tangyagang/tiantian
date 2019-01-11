package com.cssl.tiantian.dao.order;

import com.cssl.tiantian.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    //根据用户ID查询用户订单
    public List<Order> getAllByUserId(@Param("userId")int userId);
}
