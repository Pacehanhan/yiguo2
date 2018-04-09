package com.lanou.test;

import com.lanou.dao.UserDao;
import com.lanou.entity.Product;
import com.lanou.service.ProductService;
import com.lanou.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by han on 2018/4/3.
 */
public class productTest {


    @Test
    // 测试查询商品(无条件 select * from yiguo_product)
    public  void  test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        ProductService productService = (ProductService) ac.getBean("productService");
        System.out.println(productService.findAllProducts());
    }
    @Test
    //测试 通过商品ID 查询商品所有信息 ,返回一个product
    public void  testproduct(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        ProductService productService = (ProductService) ac.getBean("productService");
        Product map  = productService.findProductsByProductId(1);
        productService.findProductsByProductId(1);
        System.out.println(map);


    }
    @Test
    // 模糊查询 首页的 大搜索功能
    public  void testLikeSearch(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        ProductService productService = (ProductService) ac.getBean("productService");
        List<Product> products = productService.findProductsLike("蓝");

       System.out.println(products.get(0));
    }

    

}
