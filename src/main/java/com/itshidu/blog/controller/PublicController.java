package com.itshidu.blog.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.RegisterService;

@Controller
public class PublicController {
	
	@Autowired RegisterService _regService;
	
	@RequestMapping("/register.html")
	public Object register(ModelAndView mv) {
		mv.setViewName("register");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/public/register")
	public Object register(User formUser) {
		Map<String, Object> result=_regService.register(formUser);
		return result;
	}
	@RequestMapping("/public/active")
	public Object active(long userid,String code) {
		return _regService.active(userid,code);
	}
	@ResponseBody
	@RequestMapping("/public/login")
	public Object login(String username,String password) {
		return _regService.login(username,password);
	}

	@RequestMapping("/public/logout")
	public Object logout(HttpServletRequest request) {
		//request.getSession().removeAttribute("loginInfo");
		//request.getSession().setMaxInactiveInterval(1); //1秒超时
		request.getSession().invalidate(); //废弃现有session
		return "redirect:/login.html";
	}
	
	
	
	
	
}
