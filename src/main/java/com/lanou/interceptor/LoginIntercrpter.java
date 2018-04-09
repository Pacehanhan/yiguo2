package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanou.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercrpter implements HandlerInterceptor{


	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		
//		modelAndView.setViewName("ajaxUpLoad");
	}


	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器生效");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("user:"+user);
		//如果为空,则跳转登录页面,(需要修改,不是登录请求,是登录页面)
		if (user == null){
			request.getRequestDispatcher("/user/userLogin").forward(request,response);
			System.out.println("拦截器执行跳转请求");
		}
		return true;
	}
}
