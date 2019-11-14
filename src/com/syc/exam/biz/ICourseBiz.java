package com.syc.exam.biz;

import java.util.List;

import com.syc.exam.entity.Course;

public interface ICourseBiz {
	/**
	 * 查找所有课程
	 * @return
	 */
	public List<Course> findAll();
}
