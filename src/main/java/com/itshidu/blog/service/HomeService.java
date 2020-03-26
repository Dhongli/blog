package com.itshidu.blog.service;

import org.springframework.web.servlet.ModelAndView;

public interface HomeService {

	void follows(Integer page,ModelAndView mv);

	void fans(Integer page, ModelAndView mv);

	void notifies(Integer page, ModelAndView mv);

}
