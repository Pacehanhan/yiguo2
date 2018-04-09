package com.lanou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.UserDao;
import com.lanou.entity.User;
import com.lanou.service.UserService;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	// 用户注册reg
	public boolean userReg(User user) {
		return userDao.userReg(user);
	}



	// 用户登录login
	public User userLogin(User user) {
		return userDao.userLogin(user);
	}
	//修改密码
	public boolean moidfyPassWord(Map map) {
		return userDao.moidfyPassWord(map);
	}
	//查询用户手机是否唯一
	public int findUsePhoneUnique(String userPhone){return userDao.findUsePhoneUnique(userPhone);}
}
