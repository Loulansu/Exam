package com.syc.exam.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getScore")
public class GetScoreServlet extends BasicServlet{
	private static final long serialVersionUID = 4152686694496985778L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("getscore".equals(op)) {
			getScore(request, response);
		}
	}

	/**
	 * 计算每种题型的分数
	 * @param request
	 * @param response
	 * @return
	 */
	private Map<String, String> getScore(HttpServletRequest request, HttpServletResponse response) {
		int optionNum = Integer.parseInt(request.getParameter("optioNnum"));
		int doubleoptionNum = Integer.parseInt(request.getParameter("doubleoptionNum"));
		int judgeNum = Integer.parseInt(request.getParameter("judgeNum"));
		//总题量
		int totalNum = optionNum + doubleoptionNum + judgeNum;
		//计算每种题型的分数,按照题型的比例算分数
		double optionScore = optionNum / totalNum * 100;
		double doubleoptionScore = doubleoptionNum / totalNum * 100;
		double judgeScore = judgeNum / totalNum * 100;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("optionScore", String.valueOf(optionScore));
		map.put("doubleoptionScore", String.valueOf(doubleoptionScore));
		map.put("judgeScore", String.valueOf(judgeScore));
		
		return map;
	}

}
