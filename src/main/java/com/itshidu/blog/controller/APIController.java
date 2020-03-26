package com.itshidu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itshidu.blog.service.APIService;

@RestController //相当于Controller和ResponseBody的合体
@RequestMapping("/api")
public class APIController {
	
	@Autowired APIService apiService;
	
	//粉丝最多的用户（目前未做粉丝功能，先用最新用户代替）
	@RequestMapping("/hotusers.json")
	public Object f1(int maxResults) {
		return apiService.hotusers(maxResults);
	}
	//最新发布的文章
	@RequestMapping("/latests.json")
	public Object f2(int maxResults) {
		return apiService.latests(maxResults);
	}
	//点击量最高的文章
	@RequestMapping("/hots.json")
	public Object f3(int maxResults) {
		return apiService.hots(maxResults);
	}
}
