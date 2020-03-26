package com.itshidu.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.dao.UserDao;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired UserDao userDao;
	
	@Override
	public void list(ModelAndView mav, int pn, String key) {
		Pageable pageable=new PageRequest(pn-1,10);
		Page<User> data=userDao.findByUsernameLike("%"+key+"%",pageable);
		mav.addObject("data", data);
		//data.isLast()
		//data.hasNext()
	}
	
}
