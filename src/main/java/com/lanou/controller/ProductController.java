package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Product;
import com.lanou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by han on 2018/4/3.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    private int errcode =0;
    private  String msg = "成功";
    @Autowired
    private ProductService productService;
    // 展示主页所有商品
    @RequestMapping("/show")
    public  void showProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Product> products  = productService.findAllProducts();
//        response.setCharacterEncoding("utf-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
        if (products == null){
            errcode = 1;
            msg =  "失败";
        }
        Map<String,Object> map = new HashMap();
        map.put("errorcode",errcode);
        map.put("msg",msg);
        map.put("products",products);
        String json = JSON.toJSONString(map);
        response.getWriter().append(json);
    }

    //模糊查询, 通过商品信息的一部分,查询所有有关商品
    @RequestMapping("/likeSearch")
    public  void  likeSearchProducts(HttpServletRequest request,HttpServletResponse response,String productMsg) throws IOException {


        System.out.println(productMsg);
        List<Product> products = productService.findProductsLike(productMsg);
        int count = productService.findProductsLikeCount(productMsg);
        Map<String,Object> map = new HashMap();
        map.put("errorcode",errcode);
        map.put("msg",msg);
        map.put("products",products);
        map.put("count",count);
        String json = JSON.toJSONString(map);
        response.getWriter().append(json);

    }
    //商品详情页面(ajax 异步获取数据,类似主页展示商品)
    @RequestMapping("/showProductById")
    public void  showProductById(HttpServletRequest request,HttpServletResponse response,int productId) throws IOException {
        Product product = productService.findProductsByProductId(productId);
        Map<String,Object> map = new HashMap();
        map.put("errorcode",errcode);
        map.put("msg",msg);
        map.put("product",product);
        String json = JSON.toJSONString(map);
        response.getWriter().append(json);
        
    }
    //展示商品通过商品种类
    @RequestMapping("/showProductByKind")
    public void  showProductByKind(int kindId,HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Product> products = productService.findProductByKind(kindId);
        Map<String,Object> map = new HashMap();
        map.put("errorcode",errcode);
        map.put("msg",msg);
        map.put("products",products);
        String json = JSON.toJSONString(map);
        response.getWriter().append(json);
        
    }
}
