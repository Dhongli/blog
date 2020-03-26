package com.itshidu.blog.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itshidu.blog.entity.User;

public class LoginUtil {
	
	public static String key = "loginInfo";
	
	public static User getLoginUser() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute(key);
		return loginUser;
	}
	
	public static HttpSession getSession() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getSession();
	}
}
