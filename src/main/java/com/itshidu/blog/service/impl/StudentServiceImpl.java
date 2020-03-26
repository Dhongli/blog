package com.itshidu.blog.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itshidu.blog.dao.StudentDao;
import com.itshidu.blog.entity.Student;
import com.itshidu.blog.service.StudentService;
import com.itshidu.blog.vo.Result;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired StudentDao studentDao;
	
	@Override
	public Result list(int page, int rows) {

		Pageable arg0 = new PageRequest(page-1, rows);//DataJPA分页页码从0开始
		Page<Student> data = studentDao.findAll(arg0);
		
		Result er = Result.of(200);
		er.put("total", data.getTotalElements());
		er.put("rows", data.getContent());
		
		return er;
	}

	@Override
	public void delete(long id) {
		studentDao.delete(id);
	}

	@Override
	public void update(Student stu) {
		Student target = studentDao.getOne(stu.getId());
		BeanUtils.copyProperties(stu, target, "createTime","updateTime");
		target.setUpdateTime(new Date());
		studentDao.save(target);
	}

	@Override
	public void save(Student stu) {
		stu.setCreateTime(new Date());
		stu.setUpdateTime(new Date());
		studentDao.save(stu);
	}

}
