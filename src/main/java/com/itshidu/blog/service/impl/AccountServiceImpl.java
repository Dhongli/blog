package com.itshidu.blog.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itshidu.blog.dao.ArticleDao;
import com.itshidu.blog.dao.FavorDao;
import com.itshidu.blog.dao.FollowDao;
import com.itshidu.blog.dao.NotifyDao;
import com.itshidu.blog.dao.UserDao;
import com.itshidu.blog.entity.Article;
import com.itshidu.blog.entity.Favor;
import com.itshidu.blog.entity.Follow;
import com.itshidu.blog.entity.Notify;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.AccountService;
import com.itshidu.blog.util.DigestHelper;
import com.itshidu.blog.util.LoginUtil;
import com.itshidu.blog.vo.Result;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired UserDao userDao;
	@Autowired FavorDao favorDao;
	@Autowired FollowDao followDao;
	@Autowired ArticleDao articleDao;
	@Autowired NotifyDao notifyDao;
	
	@Value("${STORE_ROOT_PATH}")
	String StoreRootPath; //存储根目录

	@Override
	public Result updatePassword(String oldPassword, String newPassword) {
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");
		
		User user = userDao.getOne(loginUser.getId());
		String m = oldPassword;		//明文密码
		String s = user.getSalt(); 	//密码盐值
		String r = md5( sha512(m)+md5(s)+sha512(m+s) );
		
		if(r.equals(user.getPassword())) {
			user.setSalt(UUID.randomUUID().toString());//改个新的盐，更加安全，不改也可以
			String m1 = newPassword;
			String s1 = user.getSalt();
			String r1 = md5( sha512(m1)+md5(s1)+sha512(m1+s1) );
			user.setPassword(r1);
			userDao.save(user);
			return Result.of(200);
		}else {
			return Result.of(300);
		}
		
		
	}

	private String md5(String text) {
		return DigestHelper.md5(text);
	}
	private String sha512(String text) {
		return DigestHelper.sha512(text);
	}

	@Override
	public Result updateProfile(String nickname, String sign) {
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");
		
		User user = userDao.getOne(loginUser.getId());
		user.setNickname(nickname);
		user.setSign(sign);
		userDao.save(user);
		session.setAttribute("loginInfo", user);
		return null;
	}

	@Override
	public Result updateAvatar(int x, int y, int width, int height, String path, HttpServletRequest request) {
		Date date = new Date();
		String a = "/store/avatar/"
						+new SimpleDateFormat("yyyy").format(date)+"/"
						+new SimpleDateFormat("MM").format(date)+"/"
						+new SimpleDateFormat("dd").format(date)+"/"
						+UUID.randomUUID().toString()+".jpg";
		File local=new File(StoreRootPath, a);
		File dir = local.getParentFile();
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File file = new File(StoreRootPath,path);
		try {
			Thumbnails.of(file)
			.sourceRegion(x, y, width, height)
			.size(width, height)
			.outputFormat("jpg")
			.toFile(local);
			
			User loginUser = (User) request.getSession().getAttribute("loginInfo");
			if(loginUser==null) {
				return Result.of(1); //1代表未登录
			}
			
			User user = userDao.getOne(loginUser.getId());
			user.setAvatar(a);
			userDao.save(user);
			request.getSession().setAttribute("loginInfo", user);
			return Result.of(2); //2代表修改成功

		} catch (Exception e) {
			e.printStackTrace();
			return Result.of(3,e.toString());//3代表异常
		}
		
		
	}

	@Override
	public Result saveFavor(long articleId, HttpServletRequest request) {
		User loginUser = getLoginUser();
		if(loginUser==null) {
			return Result.of(0,"未登录");
		}
		
		Article article=articleDao.getOne(articleId);
		
		if(favorDao.find(loginUser.getId(), articleId)!=null) {
			return Result.of(1,"不能重复喜欢");
		}
		
		Favor favor = new Favor();
		favor.setArticle(article);
		favor.setCreated(new Date());
		favor.setUser(loginUser);
		favorDao.save(favor);
		
		//给文章作者发通知
		Notify notify = new Notify();
		notify.setAvatar(loginUser.getAvatar());
		notify.setCreated(new Date());
		notify.setTitle(loginUser.getNickname());
		notify.setUser(article.getUser());
		notify.setUrl("/ta/"+loginUser.getId());
		String s2 = String.format("喜欢了你的文章 - <a href=\"/view/%s.html\">%s</a>", article.getId(),article.getTitle());
		notify.setContent(s2);
		notifyDao.save(notify);
		
		return Result.of(2,"喜欢成功");
	}
	
	private User getLoginUser() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");
		return loginUser;
	}

	@Override
	public Result saveFollow(long userId) {
		User loginUser = getLoginUser();
		if(loginUser==null) {
			return Result.of(0,"未登录");
		}
		
		if(followDao.find(loginUser.getId(), userId)!=null) {
			return Result.of(3,"已经关注，无需重复");
		}
		
		Follow follow = new Follow();
		follow.setCreated(new Date());
		follow.setSource(loginUser);
		User target=new User();
		target.setId(userId);
		follow.setTarget(target);
		followDao.save(follow);
		
		//给被关注的人发通知
		Notify notify = new Notify();
		notify.setAvatar(loginUser.getAvatar());
		notify.setCreated(new Date());
		notify.setTitle(loginUser.getNickname());
		notify.setUser(target);
		notify.setUrl("/ta/"+loginUser.getId());
		notify.setContent("关注了你, 你的粉丝+1");
		notifyDao.save(notify);
		
		return Result.of(1,"关注成功");
	}

	@Override
	public Result followCheck(long userId) {
		User loginUser = getLoginUser();
		if(loginUser==null) {
			return Result.of(0,"未登录");
		}
		Follow follow = followDao.find(loginUser.getId(), userId);
		if(follow==null) {
			return Result.of(1,"未关注");
		}
		return Result.of(2,"已关注");
	}

	@Override
	@Transactional
	public Result unfollow(long id) {
		User loginUser = LoginUtil.getLoginUser();
		if(loginUser==null) {
			return Result.of(0,"未登录");
		}
		Follow follow = followDao.find(loginUser.getId(), id);
		followDao.delete(follow);
		return Result.of(1,"取消关注成功");
	}
}
