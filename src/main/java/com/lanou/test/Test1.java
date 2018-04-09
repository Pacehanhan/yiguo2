package com.lanou.test;

import com.lanou.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.service.UserService;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		UserService userService = (UserService) ac.getBean("userService");
		User user = new User();
		user.setUserPhone("18815536537");
		user.setUserPassword("654321");
		System.out.println(userService.userReg(user));
	}
}
