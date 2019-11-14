package com.syc.exam.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.syc.exam.biz.IQuestionBiz;
import com.syc.exam.biz.impl.QuestionBizImpl;
import com.syc.exam.util.FileUploadUtil;


@WebServlet("/questions")
public class QuestionServlet extends BasicServlet{
	private static final long serialVersionUID = 8511950858079257042L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("add".equals(op)) { //添加题目
			add(request, response);
		}else if("uploadPic".contentEquals(op)) { //上传题目内容中的图片
			uploadPic(request, response);
		}
	}

	private void uploadPic(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUploadUtil fileUploadUtil = new FileUploadUtil();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		Map<String, String> map = fileUploadUtil.upload(pageContext);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String path = map.get("upload"); //取出图片保存的路径
		
		resultMap.put("fileName", path.substring(path.lastIndexOf("/") + 1));
		resultMap.put("uploaded", 1);
		resultMap.put("url", "../../" + path);
		
		this.send(response, resultMap);
	}

	/**
	 * 添加题目
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUploadUtil fileUpload = new FileUploadUtil();
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		Map<String, String> map = fileUpload.upload(pageContext);
		IQuestionBiz questionBiz = new QuestionBizImpl();
		this.send(response, questionBiz.add(map));
	}
}
;