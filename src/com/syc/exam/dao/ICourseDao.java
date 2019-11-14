package com.syc.exam.dao;

import java.util.List;

import com.syc.exam.entity.Course;

public interface ICourseDao {
	/**
	 * 查找所有课程
	 * @return
	 */
	public List<Course> findAll();
}
