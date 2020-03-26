package com.itshidu.blog.vo;

import com.itshidu.blog.entity.Article;

public class ArticleVO extends Article{
	private long xihuan;		//多少人喜欢
	private long pinglun;		//多少条评论
	public long getXihuan() {
		return xihuan;
	}
	public void setXihuan(long xihuan) {
		this.xihuan = xihuan;
	}
	public long getPinglun() {
		return pinglun;
	}
	public void setPinglun(long pinglun) {
		this.pinglun = pinglun;
	}
	
}
