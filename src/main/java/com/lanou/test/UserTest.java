package com.lanou.test;

import com.lanou.entity.User;
import com.lanou.service.ProductService;
import com.lanou.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by han on 2018/4/8.
 */
public class UserTest {
    @Test
    public  void  modifyPassword(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) ac.getBean("userService");
        Map map = new HashMap();
        map.put("uId",1);
        map.put("opwd","sada");
        map.put("npwd","aaaa");
        System.out.println(userService.moidfyPassWord(map));

    }
}
