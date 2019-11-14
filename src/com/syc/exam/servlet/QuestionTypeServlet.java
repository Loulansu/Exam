package com.syc.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.exam.biz.IQuestionTypeBiz;
import com.syc.exam.biz.impl.QuestionTypeBizImpl;

@WebServlet("/questionType")
public class QuestionTypeServlet extends BasicServlet{
	private static final long serialVersionUID = 8616825731607362486L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("findAll".equals(op)) { //查询所有题目类型
			findAll(request, response);
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IQuestionTypeBiz questionTypeBiz = new QuestionTypeBizImpl();
		this.send(response, questionTypeBiz.findAll());
	}
}
