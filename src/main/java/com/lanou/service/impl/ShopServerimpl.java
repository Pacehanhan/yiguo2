package com.lanou.service.impl;

import com.lanou.dao.ShopCarDao;
import com.lanou.entity.ShopCar;
import com.lanou.service.ShopServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanou on 2018/4/3.
 */
@Service("shopServer")
public class ShopServerimpl implements ShopServer {

    @Autowired
    private ShopCarDao shopCarDao;

    //根据userId 用户ID 来 展示 购物车 列表
    public List<ShopCar> SelectShopCarDao(int userId) {


        return shopCarDao.SelectShopCarDao(userId);
    }

    //根据userId 用户ID 来添加 商品 到 购物车
    public boolean addShopCarDao(int userId, int productId, int productNumber) {

        boolean ls = false;
        List<ShopCar> shopCars = new ArrayList<ShopCar>();
        ShopCar shopCar = new ShopCar();
        shopCar.setUserId(userId);
        shopCar.setProductId(productId);
        shopCar.setProductNumber(productNumber);
        int count = shopCarDao.addShopCarDao(shopCar);
        if (count == 1) {
            shopCars.add(shopCar);
            ls = true;
        }
        return ls;
    }

    //根据 userId 用户Id  productId 商品Id 来 删除 个人购物车 li 商品
    public boolean deleteCarDao(int productId, int userId) {
        boolean ls = false;

        int i = shopCarDao.deleteCarDao(productId, userId);
        System.out.println("i:" + i);
        if (i > 0) {
            ls = true;
        }

        return ls;
    }

    //根据 userId 用户Id  productId商品Id 来 修改 个人购物车里的 商品数量
    public boolean updateCarDao(int productId, int userId, int productNumber) {
        boolean la = false;
        ShopCar shopCar = new ShopCar();
        shopCar.setProductId(productId);
        shopCar.setUserId(userId);
        shopCar.setProductNumber(productNumber);
        int i = shopCarDao.updateCarDao(shopCar);
        System.out.println("i:" + i);
        if (i > 0) {
            la = true;
        }

        return la;
    }

    //根据userId 用户Id 来修改个人购物车 的 个人购物车状态
    public boolean updateStatus(int userId) {
        boolean ls = false;
        ShopCar shopCar = new ShopCar();
        shopCar.setUserId(userId);
        int i = shopCarDao.updateStatus(shopCar);
        System.out.println("i:" + i);
        if (i >= 0) {
            ls = true;
        }
        return ls;
    }

    //根据userId 用户Id查看个人以前购买过的商品
    public List<ShopCar> selectUserBefor(int userId) {

        return shopCarDao.selectUserBefor(userId);
    }

}
