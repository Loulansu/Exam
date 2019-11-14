package com.syc.exam.biz;

import java.util.List;

import com.syc.exam.entity.Classes;

public interface IClassBiz {
	/**
	 * 查找所有班级
	 * @return
	 */
	public List<Classes> findAll();
}
