package com.syc.exam.dao.impl;

import java.util.List;

import com.syc.exam.dao.DBHelper;
import com.syc.exam.dao.ICourseDao;
import com.syc.exam.entity.Course;

public class CourseDaoImpl implements ICourseDao{

	@Override
	public List<Course> findAll() {
		DBHelper dbHelper = new DBHelper();
		String sql = "select coid,cname from course order by coid desc";
		return dbHelper.finds(sql, Course.class);
	}
	
}
