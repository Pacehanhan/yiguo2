package com.lanou.controller;

import com.lanou.util.VerifyCodeUtil;
import com.alibaba.fastjson.JSON;
import com.lanou.entity.User;
import com.lanou.util.StringUtil;
import com.lanou.util.VerifyCodeUtil;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanou.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserController {
	@Autowired
	private UserService userService;


//	@RequestMapping("/list")
//	public String name(Model model) {
//		model.addAttribute("user", userService.findUsers());
//	}

	private User user = new User();
	private TestVCode testVCode;

	@RequestMapping("/userReg")
	public void userReg(String userPhone, String userPassword, String checkPassword, HttpServletResponse response) {
		// 将用户名和密码放入user中
		user.setUserPhone(userPhone);
		user.setUserPassword(userPassword);
		//生成md5 加密密码
		String MD5Password = StringUtil.getMdf(userPassword);
//		user.setMD5Password(MD5Password);
		response.setHeader("Access-Control-Allow-Origin", "*");

		Map<String,Object> maps = new HashMap();

		// 如果用户名的长度不为0 且 两次密码输入相等
 		if (userPhone.length() != 0 && userPassword.equals(checkPassword)) {
 			// 调用userService方法进行将user添加到数据库操作
				int i = userService.findUsePhoneUnique(userPhone);
				if (i==0){
					boolean result = userService.userReg(user);
					if (result) {
						maps.put("errorcode", 0);
						maps.put("msg", "注册成功");

					}
					
				}else {
					maps.put("errorcode",1);
					maps.put("msg","用户手机号存在,注册失败");
				}
//				//数据库user 表设置唯一键约束
//				boolean result = userService.userReg(user);
//				
//				if (result) {
//					maps.put("errorcode", 0);
//					maps.put("msg", "注册成功");
//
//				}


			// 如果用户名的长度为0 且 两次密码输入不相等 或其他情况均不添加到数据库中
		}else{
			maps.put("errorcode",1);
			maps.put("msg","注册失败,2次密码不能为空且须相同");
		}

		// 定义一个json字符串
		String json = JSON.toJSONString(maps);

		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/userLogin")
	public void userLogin(String userPhone, String userPassword, HttpServletResponse response, HttpServletRequest request) {
		// 将用户名和密码放入user中
		user.setUserPhone(userPhone);
		user.setUserPassword(userPassword);
		// 调用userService方法 查询有没有这个user
		User user1 = userService.userLogin(user);

		Map<String,Object> maps = new HashMap();

		// 当user不为空时 说明查询到这个user了 可以登录
		if (user1 != null) {
			maps.put("errorcode",0);
			maps.put("msg","登录成功");
		// 当user为空时 说明没有查到这个用户
		}else{
			maps.put("errorcode",1);
			maps.put("msg","登录失败");
		}

		String json = JSON.toJSONString(maps);

		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(json);
		} catch (IOException e) {
			e.printStackTrace();

		}
		//把登录的用户存入session
		HttpSession session = request.getSession();
        session.setAttribute("user",user);

	}

	//修改用户密码,旧密码 oldPassword 新密码 newPassword 确认密码:confirmPassword
    //注:此处不处理 确认密码,只在前端处理.
    @RequestMapping("/modifyUserPassword")
	public void modifyUserPassword(HttpServletRequest request,HttpServletResponse response,String oldPassword,String newPassword,String confirmPassword) throws IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int uid = u.getUserId();
        Map<String,Object> map = new HashMap();
        map.put("uId",uid);
        map.put("opwd",oldPassword);
        map.put("npwd",newPassword);
        boolean result =  userService.moidfyPassWord(map);
        Map<String,Object> res = new HashMap();
        if (result){
            res.put("errorcode",0);
            res.put("msg","密码修改成功");
            String json = JSON.toJSONString(res);
            response.getWriter().append(json);
        }else {
            res.put("errorcode",1);
            res.put("msg","密码修改失败,请重新尝试");
            String json = JSON.toJSONString(res);
            response.getWriter().append(json);
        }

	}


}
