package com.syc.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void send(HttpServletResponse response, int result) throws IOException {
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}
	
	protected void send(HttpServletResponse response, String str) throws IOException {
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
	}
	
	/**
	 * 以json格式返回
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	protected void send(HttpServletResponse response, Object obj) throws IOException {
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().serializeNulls().create();
		out.print(gson.toJson(obj));
		out.flush();
	}
}
