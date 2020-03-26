package com.itshidu.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itshidu.blog.entity.Favor;

public interface FavorDao extends JpaRepository<Favor,Long> {

	@Query("from Favor f where f.user.id=?1 and f.article.id=?2")
	Favor find(long user,long article);
	
	@Query("select count(id) from Favor f where f.article.id=?1")
	int countByArticle(long articleId);
}
