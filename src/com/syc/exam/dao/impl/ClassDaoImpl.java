package com.syc.exam.dao.impl;

import java.util.List;

import com.syc.exam.dao.DBHelper;
import com.syc.exam.dao.IClassDao;
import com.syc.exam.entity.Classes;

public class ClassDaoImpl implements IClassDao{

	@Override
	public List<Classes> findAll() {
		DBHelper dbHelper = new DBHelper();
		String sql = "select cid,name from class order by cid desc";
		return dbHelper.finds(sql, Classes.class);
	}

}
