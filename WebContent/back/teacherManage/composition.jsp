<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>抽题组卷</title>
<link rel="stylesheet" href="../../css/background/style.css">
<link rel="stylesheet" href="../../css/background/demo.css">
<link rel="stylesheet" href="../../css/function/composition.css">
<script type="text/javascript" src="../../js/jquery-1.11.3.min.js"></script>
<div id="large-header" class="large-header"
style="height: 585px; background-image: url('../../css/background/demo-1-bg.jpg'); background-repeat: repeat-x;">
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
		<form id="add_exam_form">
			<ul>
		        <li>
		        	<label for="add_exam_name">考试名称：</label>
		            <input type="text" name="examName" id="add_exam_name" class="ipt" />
		        </li>
		        <li>
		        	<label>考试难度：</label>
		            <select id="add_exam_level" class="ipt"></select>
		        </li>
		        <li>
		        	<label>考试班级：</label>
		            <select id="add_exam_class" class="ipt"></select>
		        </li>
		        <li>
		        	<label for="add_exam_startTime">考试开始时间：</label>
		            <input type="datetime" name="startTime" id="add_exam_startTime" class="ipt" />
		        </li>
		        <li>
		        	<label for="add_exam_persistTime">考试时长：</label>
		            <input type="text" name="persistTime" id="add_exam_persistTime" class="ipt" />分钟
		        </li>
		        <li><span>随机抽题给分策略</span></li>
		        <li style="margin-left: 50px;">
		        	<p>单选题个数</p>
		        	<p>单选题每题分数</p>
		        	<p>多选题个数</p>
		        	<p>多选题每题分数</p>
		        	<p>判断题个数</p>
		        	<p>判断题每题分数</p>
		        </li>
		        <li><hr style="width: 90%;"/></li>
		        <li style="margin-left: 50px;">
		        	<p id="option_num">1</p>
		        	<img src="../../images/icon/plus.png" id="option_plus" onclick="optionplus()"/>
		        	<img src="../../images/icon/sub.png" id="option_sub" onclick="optionsub()"/>
		        	<p id="option_score" style="margin-left: 100px;">0.000</p>
		        	<p id="doubleoption_num" style="margin-left: 150px;">1</p>
		        	<img src="../../images/icon/plus.png" id="doubleoption_plus" onclick="doubleoptionplus()"/>
		        	<img src="../../images/icon/sub.png" id="doubleoption_sub" onclick="doubleoptionsub()"/>
		        	<p id="doubleoption_score" style="margin-left: 120px;">0.000</p>
		        	<p id="judge_num" style="margin-left: 120px;">1</p>
		        	<img src="../../images/icon/plus.png" id="judge_plus" onclick="judgeplus()"/>
		        	<img src="../../images/icon/sub.png" id="judge_sub" onclick="judgesub()"/>
		        	<p id="judge_score" style="margin-left: 100px;">0.000</p>
		        </li>
		        <li style="margin-left: 50px;"><p style="font-size: 14px; margin-left:0px;">总分：100</p></li>
		        <li>
		        	<input id="createExam" type="button" value="创建考试" class="createExam" onclick="createExam()"/>
		        </li>
	        </ul>
		</form>
	</div>
</div>
<script type="text/javascript">
	//获取每种题型的个数
	var optionNum = parseInt($.trim($("#option_num").html())); 
	var doubleoptionNum = parseInt($.trim($("#doubleoption_num").html()));
	var judgeNum = parseInt($.trim($("#judge_num").html()));
	
	$(function(){
		$.post("../../difficult", {op:"findAll"}, function(data){
			var str = "";
			$.each(data, function(index, item){
				str += "<option value='"+item.lid+"'>"+item.level+"</option>";
			});
			$("#add_exam_level").append($(str));
		},"json");
		
		$.post("../../class", {op:"findAll"}, function(data){
			var str = "";
			$.each(data, function(index, item){
				str += "<option value='"+item.cid+"'>"+item.name+"</option>";
			});
			$("#add_exam_class").append($(str));
		},"json");
	})
	
	function getScore(optionNum, doubleoptionNum, judgeNum) {		
		//总题量
		var totalNum = optionNum + doubleoptionNum + judgeNum;
	
		//计算每种题型的分数,按照题型的比例算分数,总共单选题40分，多选题30分，判断题30分
		var optionScore = (40 / optionNum).toFixed(3);//四舍五入保留三位小数
		var doubleoptionScore = (30 / doubleoptionNum).toFixed(3);
		var judgeScore = (30 / judgeNum).toFixed(3);
		
		$("#option_score").html(optionScore);
		$("#doubleoption_score").html(doubleoptionScore);
		$("#judge_score").html(judgeScore);
	}
	
	//单选题加
	function optionplus(){
		optionNum = optionNum + 1;
		$("#option_num").html(optionNum);
		getScore(optionNum, doubleoptionNum, judgeNum);
	}
	
	//单选题减
	function optionsub(){
		if(optionNum > 1) {
			optionNum = optionNum - 1;
			$("#option_num").html(optionNum);
			getScore(optionNum, doubleoptionNum, judgeNum);
		}
	}
	
	//多选题加
	function doubleoptionplus(){
		doubleoptionNum = doubleoptionNum + 1;
		$("#doubleoption_num").html(doubleoptionNum);
		getScore(optionNum, doubleoptionNum, judgeNum);
	}
	
	//多选题减
	function doubleoptionsub(){
		if(doubleoptionNum > 1) {
			doubleoptionNum = doubleoptionNum - 1;
			$("#doubleoption_num").html(doubleoptionNum);
			getScore(optionNum, doubleoptionNum, judgeNum);
		}
	}
	
	//判断题加
	function judgeplus(){
		judgeNum = judgeNum + 1;
		$("#judge_num").html(judgeNum);
		getScore(optionNum, doubleoptionNum, judgeNum);
	}
	
	//判断题减
	function judgesub(){
		if(judgeNum > 1) {
			judgeNum = judgeNum - 1;
			$("#judge_num").html(judgeNum);
			getScore(optionNum, doubleoptionNum, judgeNum);
		}
	}
	
	function createExam(){
		
	}
</script>
