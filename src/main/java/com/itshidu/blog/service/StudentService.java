package com.itshidu.blog.service;

import org.springframework.data.domain.Page;

import com.itshidu.blog.entity.Student;
import com.itshidu.blog.vo.Result;

public interface StudentService {

	Result list(int page, int rows);

	void delete(long id);

	void update(Student stu);

	void save(Student stu);
	
}
