package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.entity.User;

public interface UserService {
	// 用户注册reg
	public boolean userReg(User user);

	// 用户登录login
	public User userLogin(User user);
	//修改用户密码
	public boolean moidfyPassWord(Map map);
	//查询用户是否唯一
	public int findUsePhoneUnique(String userPhone);
	
}
