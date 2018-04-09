package com.lanou.service;

import com.lanou.entity.ShopCar;

import java.util.List;

/**
 * Created by lanou on 2018/4/3.
 */
public interface ShopServer {
    //根据个人 展示 购物车
    public List<ShopCar> SelectShopCarDao(int userId);
    //加入个人购物车
    public boolean addShopCarDao(int userId, int productId, int productNumber);
    //删除个人购物车 里面 的 个人商品
    public boolean deleteCarDao(int productId, int userId);
    //修改个人购物车 里面 的 个人商品的数量
    public boolean updateCarDao(int productId, int userId, int productNumber);
    //购买完商品后修改购物车的状态栏
    public boolean updateStatus(int userId);
    //查看个人以前购买过的商品
    public List<ShopCar> selectUserBefor(int userId);
}
