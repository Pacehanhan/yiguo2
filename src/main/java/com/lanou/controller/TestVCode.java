package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.util.VerifyCodeUtil;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestVCode {
    private VerifyCodeUtil verifyCodeUtil;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @RequestMapping("/getv")
    public void getv(HttpServletResponse response) throws IOException{
        // 生成一个验证码对象
        verifyCodeUtil = new VerifyCodeUtil();
        // 调用createImage方法生成带验证码的图片
        BufferedImage bi = verifyCodeUtil.createImage();
        // 获取流
        OutputStream outputStream = response.getOutputStream();
        // 调用output方法
        VerifyCodeUtil.output(bi,outputStream);
        // 获取验证码的字符串
        code = verifyCodeUtil.getText();
        System.out.println(code);
    }
    
    @RequestMapping("/checkv")
    // 当验证框栏失去焦点的时候,发送一个请求,验证是否验证码正确
        public  void  checkv(String code,HttpServletResponse response) throws IOException {
        Map map = new HashMap();
        if (code.equalsIgnoreCase(this.code)){
            map.put("errorcode",0);
            map.put("msg","验证码匹配正确");
            
        }else {
            map.put("errorcode",1);
            map.put("msg","验证码错误");
        }
        String res = JSON.toJSONString(map);
        response.getWriter().append(res);
    }
}
