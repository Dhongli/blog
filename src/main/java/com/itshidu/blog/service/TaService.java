package com.itshidu.blog.service;

import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.vo.Result;

public interface TaService {
	/**
	 * user基本信息，user的文章分页
	 * @param userId
	 * @param page
	 * @return {user,Page<Article>}
	 */
	void findData(long userId,int page,ModelAndView mav);
}
