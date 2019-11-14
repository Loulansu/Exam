package com.syc.exam.dao.impl;

import java.util.List;

import com.syc.exam.dao.DBHelper;
import com.syc.exam.dao.IQuestionTypeDao;
import com.syc.exam.entity.QuestionType;

public class QuestionTypeDaoImpl implements IQuestionTypeDao{

	@Override
	public List<QuestionType> findAll() {
		DBHelper dbHelper = new DBHelper();
		String sql = "select tid,tname from quetype order by tid desc";
		return dbHelper.finds(sql, QuestionType.class);
	}

}
