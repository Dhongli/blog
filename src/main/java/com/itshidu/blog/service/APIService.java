package com.itshidu.blog.service;

import java.util.List;

import com.itshidu.blog.entity.Article;
import com.itshidu.blog.entity.User;

public interface APIService {
	/**
	 * 最热用户
	 * @param maxSize
	 * @return
	 */
	List<User> hotusers(int maxSize);
	/**
	 * 最新文章
	 * @param maxSize
	 * @return
	 */
	List<Article> latests(int maxSize);
	/**
	 * 最高点击量的文章
	 * @param maxSize
	 * @return
	 */
	List<Article> hots(int maxSize);
}
