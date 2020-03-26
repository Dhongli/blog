package com.itshidu.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.dao.ArticleDao;
import com.itshidu.blog.dao.UserDao;
import com.itshidu.blog.entity.Article;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.TaService;
import com.itshidu.blog.vo.Result;

@Service
public class TaServiceImpl implements TaService{

	@Autowired UserDao userDao;
	@Autowired ArticleDao articleDao;
	
	@Override
	public void findData(long userId, int page,ModelAndView mav) {
		
		User user = userDao.getOne(userId);
		mav.addObject("user", user);
		
		Sort sort=new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(page, 10, sort);
		Page<Article> data=articleDao.findByUserId(userId, pageable);
		mav.addObject("data",data);
		
	}

}
