package com.syc.exam.biz.impl;

import java.util.List;

import com.syc.exam.biz.IClassBiz;
import com.syc.exam.dao.IClassDao;
import com.syc.exam.dao.impl.ClassDaoImpl;
import com.syc.exam.entity.Classes;

public class ClassBizImpl implements IClassBiz{

	@Override
	public List<Classes> findAll() {
		IClassDao classDao = new ClassDaoImpl();
		return classDao.findAll();
	}

}
