<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>添加题目</title>
<link rel="stylesheet" href="../../css/background/style.css">
<link rel="stylesheet" href="../../css/background/demo.css">
<link rel="stylesheet" href="../../css/function/addItem.css">
<div id="large-header" class="large-header" style="height: 600px; background-image: url('../../css/background/demo-1-bg.jpg'); background-repeat: repeat;">
	<div class="head">
		<img src="../../images/icon/logo.png" class="icon">
		<ul>
			<li>
				<a href="">修改个人信息</a>
			</li>
			<li>
				<a href="a.html">首页</a>
			</li>
			<li>
				<div class="teacherInfo">
			    	<p id="welcom">XXX老师</p>
				</div>
			</li>
		</ul>
	</div>
	<div class="bottom">
		<form id="add_question_form">
			<ul>
		        <li>
		        	<label>题目类型：</label>
		            <select id="add_question_type" class="ipt"></select>
		        </li>
		        <li>
		        	<label>题目难度：</label>
		            <select id="add_question_level" class="ipt"></select>
		        </li>
		        <li>
		        	<label>课程类型：</label>
		            <select id="add_course_type" class="ipt"></select>
		        </li>
		        <li>
		        	<label for="add_question_answer">题目答案：</label>
		            <input type="text" name="answer" id="add_question_answer" class="ipt">
		        </li>
		        <li>
		        	<label for="add_question_optionA">题目选项A：</label>
		            <textarea  name="option" id="add_question_optionA" rows="2" cols="50"></textarea>
		        </li>
		        <li>
		        	<label for="add_question_optionB">题目选项B：</label>
		            <textarea  name="option" id="add_question_optionB" rows="2" cols="50"></textarea>
		        </li>
		        <li>
		        	<label for="add_question_optionC">题目选项C：</label>
		            <textarea  name="option" id="add_question_optionC" rows="2" cols="50"></textarea>
		        </li>
		        <li>
		        	<label for="add_question_optionD">题目选项D：</label>
		            <textarea  name="option" id="add_question_optionD" rows="2" cols="50"></textarea>
		        </li>
		        <li style="width: 100%;">
		        	<label for="add_question_explain">题目解释：</label>
		            <textarea  name="explain" id="add_question_explain" rows="2" cols="125"></textarea>
		        </li>
		      
		        <li style="width: 100%;">
		        	<label for="add_question_context">题目内容：</label>
		            <textarea name="context" id="add_question_context" rows="4" cols="125"></textarea>
		        </li>
		        <li style="width:100%">
					<a href="" class="mybtn" onclick="addQuestion()">添加     
	 						<img src="../../images/icon/arrow.png" height="20"/>
					</a> 
				</li>
		    </ul>
		</form>
	</div>
</div>
<script>
	CKEDITOR.replace("add_question_context");
	function addQuestion() {
		
	}
</script>