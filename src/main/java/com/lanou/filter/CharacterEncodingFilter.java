package com.lanou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CharacterEncodingFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println(request.getParameter("productMsg"));
		// TODO Auto-generated method stub
		HttpServletResponse response1 = (HttpServletResponse) response;
		response1.setHeader("Access-Control-Allow-Origin", "*");
		response1.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}


	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		
	}

}
