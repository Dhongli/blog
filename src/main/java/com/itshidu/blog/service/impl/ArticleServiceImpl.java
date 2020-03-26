package com.itshidu.blog.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.blog.dao.ArticleDao;
import com.itshidu.blog.dao.FavorDao;
import com.itshidu.blog.dao.ForumDao;
import com.itshidu.blog.dao.UserDao;
import com.itshidu.blog.entity.Article;
import com.itshidu.blog.entity.Forum;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.ArticleService;
import com.itshidu.blog.util.EhcacheUtil;
import com.itshidu.blog.vo.ArticleVO;
import com.itshidu.blog.vo.Result;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired UserDao userDao;
	@Autowired ForumDao forumDao;
	@Autowired ArticleDao articleDao;
	@Autowired FavorDao favorDao;

	@Override
	public Result save(String title, long group, String content, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");

		
		User user = userDao.getOne(loginUser.getId());
		Forum forum = forumDao.getOne(group);
		
		Article article = new Article();
		article.setContent(content);
		article.setCreateTime(new Date());
		article.setForum(forum);
		article.setHits(0L);
		article.setTitle(title);
		article.setUser(user);
		articleDao.save(article);
		
		return null;
	}

	@Override
	public void view(long articleId,ModelAndView mav) {
		Article a = articleDao.getOne(articleId);
		ArticleVO vo = new ArticleVO();
		BeanUtils.copyProperties(a, vo);
		
		//查询喜欢数，设置10秒缓存
		String key2 = "wzxh_"+a.getId();
		Integer favorCount = EhcacheUtil.get("mytest", key2);
		if(favorCount==null) {
			favorCount = favorDao.countByArticle(a.getId());
			EhcacheUtil.put("mytest", key2, favorCount,10,10);
		}	
		vo.setXihuan(favorCount);
		
		mav.addObject("articleInfo", vo);
	}

	@Override
	public Article getArticleById(long articleId) {
		return articleDao.getOne(articleId);
	}
	
}
