package com.itshidu.blog.service;

import java.util.Map;

import com.itshidu.blog.entity.User;
import com.itshidu.blog.vo.Result;

public interface RegisterService {

	Map<String, Object> register(User formUser);
	
	Result login(String username,String password);

	Result active(long userid, String code);
	
}
