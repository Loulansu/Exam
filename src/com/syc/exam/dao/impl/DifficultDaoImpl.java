package com.syc.exam.dao.impl;

import java.util.List;

import com.syc.exam.dao.DBHelper;
import com.syc.exam.dao.IDifficultDao;
import com.syc.exam.entity.Difficult;

public class DifficultDaoImpl implements IDifficultDao{

	@Override
	public List<Difficult> findAll() {
		DBHelper dbHelper = new DBHelper();
		String sql = "select lid,level from difficulty order by lid desc";
		return dbHelper.finds(sql, Difficult.class);
	}

}
