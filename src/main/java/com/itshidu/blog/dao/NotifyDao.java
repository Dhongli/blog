package com.itshidu.blog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itshidu.blog.entity.Notify;

public interface NotifyDao extends JpaRepository<Notify,Long> {

	@Query("from Notify n where n.user.id=?1")
	Page<Notify> findByUser(long userid,Pageable pageable);
}
