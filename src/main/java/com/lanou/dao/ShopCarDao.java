package com.lanou.dao;

import com.lanou.entity.ShopCar;

import java.util.List;

/**
 * Created by lanou on 2018/4/3.
 */

public interface ShopCarDao {
    //通过用户名查询id
    public List<ShopCar> SelectShopCarDao(int userId);
   // 加入个人购物车
    public int addShopCarDao(ShopCar shopCar);
    //删除个人购物车里的商品
    public int deleteCarDao(int productId, int userId);
    //修改个人购物车里商品 里 的 数量
    public int updateCarDao(ShopCar shopCar);
    //购买完东西后改变购物车的状态
    public int updateStatus(ShopCar shopCar);
    //查询以前购买过的商品
    public List<ShopCar> selectUserBefor(int userId);


}
