package com.cssl.tiantian.service.buyCar;

import com.cssl.tiantian.dao.buyCar.BuyCarMapper;
import com.cssl.tiantian.pojo.Buycar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyCarServiceImpl implements BuyCarService {

    @Resource
    private BuyCarMapper buyCarMapper;


    @Override
    public int[] findShopIdByGroupShopId(Integer[] buyCarIds, int userId) {
        return buyCarMapper.getShopIdByGroupShopId(buyCarIds, userId);
    }

    @Override
    public List<Buycar> findBuycarByShopId(int shopId, int userId) {
        return buyCarMapper.getBuycarByShopId(shopId, userId);
    }

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
    public List<Buycar> findAllByUserId(int userId) {
        return buyCarMapper.getAllByUserId(userId);
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

    @Override
    public Buycar findBuycarByProIdAndUserId(int proId, int userId) {
        return buyCarMapper.getBuycarByProIdAndUserId(proId, userId);
    }

    @Override
    public boolean deleteBuyCarById(int buyCarId) {
        if (buyCarMapper.delBuyCarById(buyCarId) > 0){
            return true;
        }
        return false;
    }
}
