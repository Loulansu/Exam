package com.syc.exam.biz;

import java.util.List;

import com.syc.exam.entity.QuestionType;

public interface IQuestionTypeBiz {
	/**
	 * 查找所有题目类型
	 * @return
	 */
	public List<QuestionType> findAll();
}
