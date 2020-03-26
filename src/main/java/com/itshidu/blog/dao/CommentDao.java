package com.itshidu.blog.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itshidu.blog.entity.Comment;

public interface CommentDao extends JpaRepository<Comment,Long>{
	/**
	 * 通过文章ID查询评论分页
	 * @param articleId
	 * @param pageable
	 * @return
	 */
	@Query("from Comment c where c.article.id=?1")
	Page<Comment> findByArticleId(Long articleId,Pageable pageable);
	
	/**
	 * 通过文章ID查询评论数量
	 * @param articleId
	 * @param pageable
	 * @return
	 */
	@Query("select count(*) from Comment c where c.article.id=?1")
	int countByArticleId(Long articleId);
	
	/**
	 * 查询用户发表的评论数
	 * @param userId
	 * @return
	 */
	@Query("select count(id) from Comment c where c.author.id=?1")
	int countByUser(Long userId);

}
