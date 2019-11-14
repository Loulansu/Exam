package com.syc.exam.dao;

import java.util.List;

import com.syc.exam.entity.Classes;

public interface IClassDao {
	/**
	 * 查找所有班级
	 * @return
	 */
	public List<Classes> findAll();
}
