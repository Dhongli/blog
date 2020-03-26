package com.itshidu.blog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itshidu.blog.entity.Follow;
import com.itshidu.blog.entity.User;

public interface FollowDao extends JpaRepository<Follow,Long> {

	//我关注了谁
	@Query("from Follow f where f.source.id=?1")
	Page<Follow> findFollows(long sourceUserId,Pageable pageable);
	
	//谁关注了我,我的粉丝
	@Query("from Follow f where f.target.id=?1")
	Page<Follow> findFans(long userId,Pageable pageable);
	
	/** 一个人关注了另一个人的记录 */
	@Query("from Follow f where f.source.id=?1 and f.target.id=?2")
	Follow find(long source,long target);

}
