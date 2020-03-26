package com.itshidu.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.service.AdminUserService;

@Controller
@RequestMapping("/admin/users")
public class UserController {
	
	@Autowired AdminUserService adminUserService;

	@RequestMapping("/list")
	public Object list(ModelAndView mav,@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="")String key) {
		mav.setViewName("admin/users/list");
		adminUserService.list(mav,pn,key);
		return mav;
	}
}
