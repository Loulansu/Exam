package com.syc.exam.biz.impl;

import java.util.List;

import com.syc.exam.biz.IQuestionTypeBiz;
import com.syc.exam.dao.IQuestionTypeDao;
import com.syc.exam.dao.impl.QuestionTypeDaoImpl;
import com.syc.exam.entity.QuestionType;

public class QuestionTypeBizImpl implements IQuestionTypeBiz{

	@Override
	public List<QuestionType> findAll() {
		IQuestionTypeDao questionTypeDao = new QuestionTypeDaoImpl();
		return questionTypeDao.findAll();
	}

}
