package com.syc.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.exam.biz.ICourseBiz;
import com.syc.exam.biz.impl.CourseBizImpl;

@WebServlet("/course")
public class CourseServlet extends BasicServlet{
	private static final long serialVersionUID = 5086547233541770763L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("findAll".equals(op)) { //查找所有课程
			findAll(request, response);
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ICourseBiz courseBiz = new CourseBizImpl();
		this.send(response, courseBiz.findAll());
	}

}
