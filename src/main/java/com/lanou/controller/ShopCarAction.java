package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.ShopCar;
import com.lanou.service.ShopServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/3.
 */
@Controller
@RequestMapping("/shop")
public class ShopCarAction {
    @Autowired
    private ShopServer shopServer;

  //通过userID 展示用户商品
    @RequestMapping("/shopview")

    public void SelectShopCarDao(int userId , HttpServletResponse response){
        System.out.println("nihao："+userId);
        List<ShopCar> shopCars = shopServer.SelectShopCarDao(userId);
        Map<String,Object> maps = new HashMap();
        maps.put("shopcars",shopCars);
        maps.put("msg","success");
        System.out.println(maps);
        String json = JSON.toJSONString(maps);
        try {
            response.getWriter().append(json);
        }
        catch (Exception e){
           e.printStackTrace();
        }
 

    }

    // 通过userId 来 添加 商品 到 购物车
    @RequestMapping("/addview")
    public void addShopCarDao(int productId, int userId, int productNumber, HttpServletResponse response) {

        System.out.println("userId" + userId);
        Map<String, Object> maps = new HashMap();
        List<ShopCar> shopCars = shopServer.SelectShopCarDao(userId);

        Iterator<ShopCar> iterator = shopCars.iterator();
        while (iterator.hasNext()) {

            ShopCar shopCar = (ShopCar) iterator.next();
            int productStatus = shopCar.getProductStatus();
//            int i = shopCar.getProductStatus();
            System.out.println(shopCar);

            if (productId == shopCar.getProductId() ) {
                System.out.println("数量:" + shopCar.getProductNumber());
                int point = productNumber + shopCar.getProductNumber();

                boolean ls = shopServer.updateCarDao(productId, userId, point);
                if (ls == true) {
                    maps.put("errcode:", 0);
                    maps.put("msg", "success");
                    System.out.println(maps);
                    String json = JSON.toJSONString(maps);
                    try {
                        response.getWriter().append(json);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            } else {
                boolean ls = shopServer.addShopCarDao(userId, productId, productNumber);


                if (ls == true) {
                    maps.put("errcode:", 0);
                    maps.put("msg", "success");
                    System.out.println(maps);
                    String json = JSON.toJSONString(maps);
                    try {
                        response.getWriter().append(json);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }
        }
    }




    //通过 userId productId 来 删除 购物车 里 的 商品
    @RequestMapping("/deleteview")
   public void deleteShopCarDao(int userId,int  productId ,HttpServletResponse response){

        System.out.println("productId:"+productId);
        boolean ls = shopServer.deleteCarDao(productId,userId);

        Map<String,Object> maps = new HashMap();
        if (ls == true)
        {
            maps.put("errcode:",0);
            maps.put("msg","success");
            System.out.println(maps);
            String json = JSON.toJSONString(maps);
            try {
                response.getWriter().append(json);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    // 通过 userId productId 来 修改 购物车 里 商品的数量
    @RequestMapping("/updateview")
    public void updateCarDao(int userId, int  productId , int productNumber, HttpServletResponse response){

        System.out.println("productId:"+productId);
        boolean ls = shopServer.updateCarDao(productId, userId, productNumber);

        Map<String,Object> maps = new HashMap();
        if (ls == true)
        {
            maps.put("errcode:",0);
            maps.put("msg","success");
            System.out.println(maps);
            String json = JSON.toJSONString(maps);
            try {
                response.getWriter().append(json);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    //通过 userId 来修改 个人购物车里改变状态栏
    @RequestMapping("updatestatusview")
    public void updateStatus(int userId,HttpServletResponse response){

        System.out.println("userId:"+userId);
        boolean ls = shopServer.updateStatus(userId);
        Map<String,Object> maps = new HashMap();
        if (ls == true)
        {
            maps.put("errcode:",0);
            maps.put("msg","success");
            String json = JSON.toJSONString(maps);
            try {
                response.getWriter().append(json);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    //通过 userId来 查询 个人之前购买过的商品

}
