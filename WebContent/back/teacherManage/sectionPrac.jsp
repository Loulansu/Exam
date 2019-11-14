<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>长江题库</title>
<link rel="stylesheet" href="../../css/background/style.css">
<link rel="stylesheet" href="../../css/background/demo.css">
<link rel="stylesheet" href="../../css/function/sectionPrac.css">
<link rel="stylesheet" href="../../css/jsMind/jsmind.css" type="text/css">
<script type="text/javascript" src="../../js/jsmind.js"></script>
<script type="text/javascript" src="../../js/jsmind.draggable.js"></script>

<div id="large-header" class="large-header" style="background-image: url('../../css/background/demo-1-bg.jpg'); background-repeat: repeat;">
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
	<div id="jsmind_container" style="width:100%; margin-top: 70px;"></div>
</div>

<script type="text/javascript">
		var mind = {
			"meta" : {"name" : "course-tree",
					  "author":"2285455059@qq.com",
		        	  "version":"0.2"}, 
		     "format":"node_tree", //数据格式声明
			//数据内容
			"data" : {"id":"root","topic":"java程序设计","children":[
			    {"id":"basic","topic":"编程基础","direction":"right","expanded":"true","children":[
			         {"id":"basic1","topic":"标识符与注释"},                                                 
			         {"id":"basic2","topic":"基本数据类型"},                                                 
			         {"id":"basic3","topic":"流程控制","children":[
						{"id":"control1","topic":"选择结构","children":[
							{"id":"option1","topic":"if...else语句"},                                       
							{"id":"option2","topic":"switch...case语句"}                                       
						 ]},                                     
						{"id":"control2","topic":"循环结构","children":[
							{"id":"cycle1","topic":"while循环"},                                       
							{"id":"cycle2","topic":"do...while循环"},                                       
							{"id":"cycle3","topic":"for循环"}                                        
						]}
			         ]}                                                
			    ]},
			    {"id":"object","topic":"面向对象","direction":"right","expanded":"true","children":[
			         {"id":"object1","topic":"封装","children":[
						{"id":"package1","topic":"成员变量与成员方法"},                                    
						{"id":"package2","topic":"this关键字"},                                    
			         ]},                                                  
			         {"id":"object2","topic":"继承","children":[
						  {"id":"inherit1","topic":"super关键字"},                                  
						  {"id":"inherit2","topic":"方法的重写"},                                  
						  {"id":"inherit3","topic":"final关键字"}                                  
			         ]},                                                  
			         {"id":"object3","topic":"多态","children":[
						  {"id":"kinds","topic":"方法的重载"}                                   
			         ]}                                                
			    ]}, 
			]},
		}
		var options = {
			container:'jsmind_container',
			editable:true,               
			theme:'orange',
			view:{
				line_color:'white'   // 思维导图线条的颜色
			}
		}
		var jm = new jsMind(options);
		jm.show(mind);
		jm.expand_all();//展开全部节点
		jm.get_selected_node(); //获取当前选中的节点
		node.children; //子节点集合
	</script>