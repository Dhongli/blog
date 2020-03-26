package com.itshidu.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itshidu.blog.entity.Forum;

public interface ForumDao extends JpaRepository<Forum,Long> {
	
	List<Forum> findByStatus(boolean status);
	
}
