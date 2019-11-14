package com.syc.exam.dao;

import java.util.List;

import com.syc.exam.entity.QuestionType;

public interface IQuestionTypeDao {
	/**
	 * 查找所有题目类型
	 * @return
	 */
	public List<QuestionType> findAll();
}
