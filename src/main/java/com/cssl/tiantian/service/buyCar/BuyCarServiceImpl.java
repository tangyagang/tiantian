package com.cssl.tiantian.service.buyCar;

import com.cssl.tiantian.dao.buyCar.BuyCarMapper;
import com.cssl.tiantian.pojo.Buycar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyCarServiceImpl implements BuyCarService {

    @Autowired
    private BuyCarMapper buyCarMapper;

    @Override
    public int addByCar(int userId, int proId, int num) {
        return buyCarMapper.saveByCar(userId,proId,num);
    }

    @Override
    public PageInfo<Buycar> findAllByUserId(int userId,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Buycar> pageInfo = new  PageInfo<Buycar>(buyCarMapper.getAllByUserId(userId));
        return pageInfo;
    }

    @Override
    public boolean modifyBuyCar(int buyCarId, int num) {
        if (buyCarMapper.updateBuyCar(buyCarId,num) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBuyCarById(Integer[] buyCarIds) {
        if (buyCarMapper.deleteBuyCarById(buyCarIds) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Buycar> findAllBuycarById(Integer[] buyCarId) {
        return buyCarMapper.getAllBuycarById(buyCarId);
    }

    @Override
    public Buycar findBuyCarById(int buyCarId) {
        return buyCarMapper.getBuyCarById(buyCarId);
    }
}
