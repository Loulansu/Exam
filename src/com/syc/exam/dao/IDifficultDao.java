package com.syc.exam.dao;

import java.util.List;

import com.syc.exam.entity.Difficult;

public interface IDifficultDao {
	/**
	 * 查询所有难度
	 * @return
	 */
	public List<Difficult> findAll();
}
