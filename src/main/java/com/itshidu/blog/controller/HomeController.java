package com.itshidu.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.HomeService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired HomeService homeService;

	@RequestMapping(value= {"","/","/index"})
	public Object index(HttpServletRequest request) {
		
		//如果未登录，跳转到登录页面
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginInfo");
		if(user==null) {
			return "redirect:/login.html";
		}
		
		ModelAndView mv = new ModelAndView("home/index");
		//mv.addObject("servletPath",request.getServletPath());
		return mv;
	}
	
	@RequestMapping(value= {"/follows"})
	public Object follows(@RequestParam(defaultValue="1")Integer page,HttpServletRequest request) {
		
		//如果未登录，跳转到登录页面
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginInfo");
		if(user==null) {
			return "redirect:/login.html";
		}
		
		ModelAndView mv = new ModelAndView("home/follows");
		homeService.follows(page,mv);
		return mv;
	}
	
	@RequestMapping(value= {"/fans"})
	public Object fans(@RequestParam(defaultValue="1")Integer page,HttpServletRequest request) {
		
		//如果未登录，跳转到登录页面
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginInfo");
		if(user==null) {
			return "redirect:/login.html";
		}
		
		ModelAndView mv = new ModelAndView("home/fans");
		homeService.fans(page,mv);
		return mv;
	}
	
	@RequestMapping(value= {"/notifies"})
	public Object notifies(@RequestParam(defaultValue="1")Integer page,HttpServletRequest request) {
		
		//如果未登录，跳转到登录页面
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginInfo");
		if(user==null) {
			return "redirect:/login.html";
		}
		
		ModelAndView mv = new ModelAndView("home/notifies");
		homeService.notifies(page,mv);
		return mv;
	}
	
}
