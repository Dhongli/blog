package com.itshidu.blog.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itshidu.blog.dao.UserDao;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.RegisterService;
import com.itshidu.blog.util.DigestHelper;
import com.itshidu.blog.util.EhcacheUtil;
import com.itshidu.blog.vo.Result;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired UserDao _userDao;

	@Override
	public Map<String, Object> register(User user) {

		User t = _userDao.findByUsername(user.getUsername());
		if(t!=null) {
			return Result.of(100,"用户名已经存在，请更换");
		}
		if(_userDao.findByEmail(user.getEmail())!=null) {
			return Result.of(101,"邮箱已经存在，请更换");
		}

		user.setAvatar("default.jpg");
		user.setCreateTime(new Date());
		user.setStatus(0); //设置状态为未激活
		
		//对明文密码进行加密
		user.setSalt(UUID.randomUUID().toString());
		String m = user.getPassword();
		String s = user.getSalt();
		String r = md5( sha512(m)+md5(s)+sha512(m+s) );
		user.setPassword(r);

		_userDao.save(user);
		
		//发送激活信息
		try {
			String activeCode=UUID.randomUUID().toString().replaceAll("-", "");
			String url = basepath()+"public/active?userid="+user.getId()+"&code="+activeCode;
			EhcacheUtil.put("mytest", "activeCode_"+user.getId(), activeCode,1800,1800);
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setPort(25);
			sender.setHost("smtp.163.com");
			sender.setUsername("wushuangcat@163.com");
			sender.setPassword("gogogo");
		    MimeMessage msg = sender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		    helper.setFrom(sender.getUsername());
		    helper.setTo(user.getEmail());
		    helper.setSubject("博客系统新用户激活");
		    helper.setText("首先，恭喜您注册成功，接下来请您激活账号：<a href='"+url+"'>点击此处激活账号</a>",true);
		    sender.send(msg);
		    System.out.println("发送成功");
		} catch (Exception e) {
			Result.of(800).put("msg", "邮件发送失败");
		}
		
		
		return Result.of(200).put("msg", "注册成功");
	}
	
	private String md5(String text) {
		return DigestHelper.md5(text);
	}
	private String sha512(String text) {
		return DigestHelper.sha512(text);
	}
	protected String basepath() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String path = request.getContextPath();
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	}

	@Override
	public Result login(String username, String password) {
		User user = _userDao.findByUsername(username);
		if(user==null) {
			return Result.of(100, "用户名不存在");
		}
		if(user.getStatus()==0) {
			return Result.of(101, "账号未激活，请在邮箱中激活账号");
		}
		if(user.getStatus()==2) {
			return Result.of(102, "账号被封禁，请联系工作人员");
		}
		
		String m = password;		//明文密码
		String s = user.getSalt(); 	//密码盐值
		String r = md5( sha512(m)+md5(s)+sha512(m+s) );
		
		if(r.equals(user.getPassword())) {
			
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", user);
			
			return Result.of(200, "登录成功");
		}
		
		return Result.of(103, "密码不正确");
	}

	@Override
	public Result active(long userid, String code) {
		String actCode=EhcacheUtil.get("mytest", "activeCode_"+userid);
		EhcacheUtil.remove("mytest", "activeCode_"+userid);
		if(actCode==null) {
			System.out.println(101);
			return Result.of(101, "验证失败，可能已经超时");
		}else {
			if(actCode.equals(code)) {
				
				User user=_userDao.getOne(userid);
				if(user!=null) {
					user.setStatus(1);
					_userDao.save(user);
					return Result.of(200, "用户激活成功");
				}else {
					return Result.of(102, "用户信息不存在，激活失败");
				}
				
			}else {
				return Result.of(103, "验证失败，激活码不正确");
			}
		}
	}
	
	
}
