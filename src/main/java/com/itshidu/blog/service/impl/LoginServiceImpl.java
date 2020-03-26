package com.itshidu.blog.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.itshidu.blog.dao.UserDao;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.LoginService;
import com.itshidu.blog.util.QQConnectUtil;
import com.itshidu.blog.util.DigestHelper;
import com.itshidu.blog.util.LoginUtil;
import com.itshidu.blog.vo.Result;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired UserDao userDao;

	@Override
	public void qqLogin(String code, String state,ModelAndView mav) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		
		String token = QQConnectUtil.getAccessToken(code);
		String openid = QQConnectUtil.getOpenid(token);
		JsonNode node = QQConnectUtil.getUserInfo(openid, token);
		//如果是老用户，则直接通过OpenID查询用户信息，登录成功（通过）
		//如果是新用户，可以创建新账号，也可以绑定已有账号（通过）
		
		User user = userDao.findByQqOpenid(openid);
		if(user==null) { //新用户
			session.setAttribute("qqInfo",node);
			session.setAttribute("qqOpenid",openid);
			mav.setViewName("redirect:/bind");
			return;
		}else { //老用户
			session.setAttribute("loginInfo", user);
			mav.setViewName("redirect:/home");
			return;
		}
		
		
		//System.out.println("OPENID:"+openid);
		//JsonNode user=QQConnectUtil.getUserInfo(openid, token);
		//System.out.println(user);
		
	}

	@Override
	public Result bindUser(String username, String password) {
		HttpSession session = LoginUtil.getSession();
		JsonNode qqInfo = (JsonNode) session.getAttribute("qqInfo");
		String openid = (String) session.getAttribute("qqOpenid");
		if(qqInfo==null) {
			return Result.of(0, "QQ登录信息不存在");
		}
		User user = userDao.findByUsername(username);
		if(user==null) {
			return Result.of(1, "用户名不存在");
		}
		
		String m = password;		//明文密码
		String s = user.getSalt(); 	//密码盐值
		String r = md5( sha512(m)+md5(s)+sha512(m+s) );
		
		if(r.equals(user.getPassword())) {
			user.setQqOpenid(openid);
			userDao.save(user);
			session.setAttribute("loginInfo", user);
			return Result.of(3, "QQ用户成功绑定了已有账号");
		}
		return Result.of(2, "绑定失败：密码不正确");
	}

	
	private String md5(String text) {
		return DigestHelper.md5(text);
	}
	private String sha512(String text) {
		return DigestHelper.sha512(text);
	}

	@Override
	public Result bindCreate(String username, String password) {
		HttpSession session = LoginUtil.getSession();
		JsonNode qqInfo = (JsonNode) session.getAttribute("qqInfo");
		String openid = (String) session.getAttribute("qqOpenid");
		if(qqInfo==null) {
			return Result.of(0, "QQ登录信息不存在");
		}
		
		User t = userDao.findByUsername(username);
		if(t!=null) {
			return Result.of(1,"用户名已经存在，请更换");
		}

		User user = new User();
		user.setUsername(username);
		user.setAvatar(qqInfo.get("figureurl_qq_1").asText());
		user.setCreateTime(new Date());
		user.setNickname(qqInfo.get("nickname").asText());
		//对明文密码进行加密
		user.setSalt(UUID.randomUUID().toString());
		String m = password;
		String s = user.getSalt();
		String r = md5( sha512(m)+md5(s)+sha512(m+s) );
		user.setPassword(r);
		user.setQqOpenid(openid);
		user.setSex(qqInfo.get("gender").asText());
		user.setStatus(1);
		userDao.save(user);
		
		session.setAttribute("loginInfo", user);
		
		return Result.of(200,"新用户创建成功");
	}
}
