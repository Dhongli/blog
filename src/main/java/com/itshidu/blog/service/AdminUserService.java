package com.itshidu.blog.service;

import org.springframework.web.servlet.ModelAndView;

public interface AdminUserService {

	void list(ModelAndView mav, int pn, String key);
	
}
