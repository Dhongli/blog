package com.itshidu.blog.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itshidu.blog.dao.ArticleDao;
import com.itshidu.blog.dao.CommentDao;
import com.itshidu.blog.dao.NotifyDao;
import com.itshidu.blog.entity.Article;
import com.itshidu.blog.entity.Comment;
import com.itshidu.blog.entity.Notify;
import com.itshidu.blog.entity.User;
import com.itshidu.blog.service.CommentService;
import com.itshidu.blog.vo.Result;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired CommentDao commentDao;
	@Autowired NotifyDao notifyDao;
	@Autowired ArticleDao articleDao;

	@Override
	public Result save(Long articleId, Long targetCommentId, String text) {
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User loginUser=(User) session.getAttribute("loginInfo");
		
		if(loginUser==null) {
			return Result.of(0,"未登录");
		}
		
		
		Comment c = new Comment(); //创建一个新对象，打算保存
		
		Article article=articleDao.getOne(articleId);
		
		
		Comment target=null;
		if(targetCommentId!=0) {
			target=new Comment();
			target.setId(targetCommentId);
		}
		
		
		c.setArticle(article);
		c.setAuthor(loginUser);
		c.setContent(text);
		c.setCreated(new Date());
		c.setTarget(target);
		
		commentDao.save(c);
		
		//给文章作者发通知
		Notify notify = new Notify();
		notify.setAvatar(loginUser.getAvatar());
		notify.setCreated(new Date());
		notify.setTitle(loginUser.getNickname());
		notify.setUser(article.getUser());
		notify.setUrl("/ta/"+loginUser.getId());
		String s2 = String.format("评论了你的文章 - <a href=\"/view/%s.html\">点击查看详情</a>", article.getId());
		notify.setContent(s2);
		notifyDao.save(notify);
		
		return Result.of(1,"发表评论成功");
	}

	@Override
	public Result list(Long articleId, int pageSize, int pn) {
		Sort sort = new Sort(Direction.DESC, "created"); //排序规则：通过created降序
		Pageable pageable = new PageRequest(pn-1, pageSize,sort);
		Page<Comment> data=commentDao.findByArticleId(articleId, pageable);
		return Result.of(1, "OK", data);
	}

}
