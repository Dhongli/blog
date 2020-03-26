package com.itshidu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.service.APIService;
import com.itshidu.blog.service.TaService;
import com.itshidu.blog.vo.Result;

@Controller
public class TaController {
	
	@Autowired TaService taService;
	
	@RequestMapping("/ta/{userId}")
	public Object f1(@PathVariable long userId,@RequestParam(defaultValue="1")Integer pn) {
		ModelAndView mav = new ModelAndView("ta/index");
		taService.findData(userId, pn,mav);
		return mav;
	}
	
}
