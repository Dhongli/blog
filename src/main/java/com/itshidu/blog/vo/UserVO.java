package com.itshidu.blog.vo;

import com.itshidu.blog.entity.User;

public class UserVO extends User{
	private int articleCount;	//该用户发表的文章数
	private int commentCount;	//该用户发表的评论数
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
}
