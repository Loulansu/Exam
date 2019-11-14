package com.syc.exam.biz;

import java.util.List;

import com.syc.exam.entity.Difficult;

public interface IDifficultBiz {
	/**
	 * 查询所有难度
	 * @return
	 */
	public List<Difficult> findAll();
}
