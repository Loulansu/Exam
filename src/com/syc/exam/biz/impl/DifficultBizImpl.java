package com.syc.exam.biz.impl;

import java.util.List;

import com.syc.exam.biz.IDifficultBiz;
import com.syc.exam.dao.IDifficultDao;
import com.syc.exam.dao.impl.DifficultDaoImpl;
import com.syc.exam.entity.Difficult;

public class DifficultBizImpl implements IDifficultBiz{

	@Override
	public List<Difficult> findAll() {
		IDifficultDao dao = new DifficultDaoImpl();
		return dao.findAll();
	}

}
