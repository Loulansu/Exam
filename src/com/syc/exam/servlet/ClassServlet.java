package com.syc.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.exam.biz.IClassBiz;
import com.syc.exam.biz.impl.ClassBizImpl;

@WebServlet("/class")
public class ClassServlet extends BasicServlet{
	private static final long serialVersionUID = -4412090489145276255L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("findAll".equals(op)) { //查找所有班级
			findAll(request, response);
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IClassBiz classBiz = new ClassBizImpl();
		this.send(response, classBiz.findAll());
	}

}
