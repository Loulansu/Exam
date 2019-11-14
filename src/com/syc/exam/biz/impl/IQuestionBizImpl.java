package com.syc.exam.biz.impl;

import java.util.Map;

import com.syc.exam.biz.IQuestionBiz;
import com.syc.exam.dao.IQuestionDao;
import com.syc.exam.dao.impl.IQuestionDaoImpl;
import com.syc.exam.util.StringUtil;

public class IQuestionBizImpl implements IQuestionBiz{

	@Override
	public int add(Map<String, String> map) {
		if(StringUtil.checkNull(map.get("tid"), map.get("content"),
				map.get("answer"),map.get("lid"),map.get("coid"))) {
			return -1;
		}
		IQuestionDao qDao = new IQuestionDaoImpl();
		return qDao.add(map);
	}

}
