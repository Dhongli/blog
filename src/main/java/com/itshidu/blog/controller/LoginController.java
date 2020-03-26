package com.itshidu.blog.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.service.LoginService;
import com.itshidu.blog.util.EhcacheUtil;

@Controller
public class LoginController {
	
	@Autowired LoginService loginService;
	
	//跳转到QQ互联进行登录
	@RequestMapping("/login/qq")
	public Object qqConnect() {
		String state=UUID.randomUUID().toString().replaceAll("-", "");
		String url="https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101340964&redirect_uri=http://www.shiduketang.com/login/bind/qq/callback&state=";

		EhcacheUtil.put("mytest", "qqState:"+state,state,300,300);
		System.out.println("state已经存入session："+state);
		return "redirect:"+url+state;
	}
	
	//QQ登录成功回调这里
	@RequestMapping("/login/bind/qq/callback")
	public Object qqCallback(String code,String state,ModelAndView mav) {
		System.out.println("得到AuthrizationCode:"+code);
		System.out.println("获取state："+state);

		String state2 = EhcacheUtil.get("mytest", "qqState:"+state);
		if(state2==null) {//说明就没去腾讯登录
			System.out.println("说明就没去腾讯登录");
			return "redirect:/login/qq";
		}
		if(!state2.equals(state)) {
			System.out.println("state不一致");
			return "redirect:/login/qq";
		}
		EhcacheUtil.remove("mytest", "qqState:"+state);
		try {
			loginService.qqLogin(code,state,mav);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@RequestMapping("/bind")
	public Object bind(ModelAndView mav) {
		mav.setViewName("bind");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/bind/qq/user")
	public Object bindUser(String username,String password) {
		return loginService.bindUser(username, password);
	}
	@ResponseBody
	@RequestMapping("/bind/qq/create")
	public Object bindCreate(String username,String password) {
		return loginService.bindCreate(username, password);
	}
}
