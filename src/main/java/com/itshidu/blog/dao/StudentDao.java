package com.itshidu.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itshidu.blog.entity.Student;

public interface StudentDao extends JpaRepository<Student,Long> {
	
}
