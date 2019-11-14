package com.syc.exam.biz.impl;

import java.util.List;

import com.syc.exam.biz.ICourseBiz;
import com.syc.exam.dao.ICourseDao;
import com.syc.exam.dao.impl.CourseDaoImpl;
import com.syc.exam.entity.Course;

public class CourseBizImpl implements ICourseBiz{

	@Override
	public List<Course> findAll() {
		ICourseDao courseDao = new CourseDaoImpl();
		return courseDao.findAll();
	}

}
