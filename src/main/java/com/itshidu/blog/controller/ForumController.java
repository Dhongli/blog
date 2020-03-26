package com.itshidu.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itshidu.blog.entity.Article;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.ForumService;
import com.itshidu.blog.service.RegisterService;
import com.itshidu.blog.vo.Result;

@Controller
public class ForumController {
	
	@Autowired ForumService forumService;
	
	//访问版块
	@RequestMapping("/forum/{code}")
	public Object forum(@PathVariable String code,String ord,@RequestParam(defaultValue="1") int page,HttpServletRequest request) {
		//版块的code
		ModelAndView mv = new ModelAndView("forum");
		forumService.findForumArticles(code,ord,page,mv);
		return mv;
	}
	//首页应急方案
	@RequestMapping("/")
	public Object index() {
		return "redirect:/forum/blog";
	}
}
