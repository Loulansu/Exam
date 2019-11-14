package com.syc.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.exam.biz.IDifficultBiz;
import com.syc.exam.biz.impl.DifficultBizImpl;

@WebServlet("/difficult")
public class DifficultServlet extends BasicServlet{
	private static final long serialVersionUID = 1771763135492465505L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("findAll".equals(op)) { //查找所有难度
			findAll(request, response);
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IDifficultBiz difficultBiz = new DifficultBizImpl();
		this.send(response, difficultBiz.findAll());
	}

}
