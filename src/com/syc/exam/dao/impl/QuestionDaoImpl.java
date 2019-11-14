package com.syc.exam.dao.impl;

import java.util.Map;

import com.syc.exam.dao.DBHelper;
import com.syc.exam.dao.IQuestionDao;

public class QuestionDaoImpl implements IQuestionDao{

	@Override
	public int add(Map<String, String> map) {
		DBHelper dbHelper = new DBHelper();
		String sql = "insert into question values(0, ?, ?, ?, 0, 0, ?, ?, ?, ?, ?, ?, ?)";
		return dbHelper.update(sql, map.get("tid"), map.get("content"),map.get("answer"),map.get("lid"),
				map.get("option1"),map.get("option2"),map.get("option3"),map.get("option4"),map.get("expression"),map.get("coid"));
	}

}
