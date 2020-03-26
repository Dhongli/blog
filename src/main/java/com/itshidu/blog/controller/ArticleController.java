package com.itshidu.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itshidu.blog.entity.Article;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.ArticleService;
import com.itshidu.blog.service.ForumService;
import com.itshidu.blog.service.RegisterService;
import com.itshidu.blog.vo.Result;

@Controller
public class ArticleController {
	
	@Autowired ArticleService articleService;
	

	@RequestMapping(value="/article/create",method=RequestMethod.GET)
	public Object create(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");
		if(loginUser==null) {
			return "redirect:/login.html";
		}
		ModelAndView mv = new ModelAndView("article/create");
		return mv;
	}
	@RequestMapping(value="/article/create",method=RequestMethod.POST)
	public Object create(String title,long group,String content,HttpServletRequest request) {
		//需要防止XSS攻击
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");
		if(loginUser==null) {
			return "redirect:/login.html";
		}
		
		articleService.save(title, group, content, request);
		return "redirect:/home";
	}
	
	@RequestMapping("/view/{articleId}.html")
	public Object view(@PathVariable long articleId,HttpServletRequest request,ModelAndView mv) {
		mv.setViewName("article/view");
		articleService.view(articleId,mv);
		return mv;
	}
	
}
