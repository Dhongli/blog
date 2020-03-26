package com.itshidu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itshidu.blog.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired CommentService commentService;

	@ResponseBody
	@RequestMapping("/comment/submit")
	public Object submit(Long toId,Long pid,String text) {
		//toId=评论的文章，pid=针对的评论，text=内容
		
		return commentService.save(toId, pid, text);
	}
	@ResponseBody
	@RequestMapping("/comment/list/{articleId}")
	public Object list(@PathVariable Long articleId,int pageSize,int pn) {
		return commentService.list(articleId,pageSize,pn).get("data");
	}
}
