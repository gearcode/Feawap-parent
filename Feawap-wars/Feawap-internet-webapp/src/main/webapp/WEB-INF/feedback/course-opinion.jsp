<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>填写报名信息</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<!-- 幻灯开始 -->
		<c:import url="../common/carousel.jsp"></c:import>
		<!-- 幻灯结束 -->
		<!-- tab开始 -->
		<ul class="ui-tabs ui-tabs-news m10">
			<li><a href="<%=path %>/action/feedback/course-interest" class="orange"><span class="ui-icon ui-icon-newspaper"></span><span>感兴趣的课程</span></a></li>
			<li><a href="<%=path %>/action/feedback/course-opinion" class="green active"><span class="ui-icon ui-icon-note"></span><span>课程意见与反馈</span></a></li>
		</ul>
		<!-- tab结束 -->
		<form class="ui-form" method="post">
			<div class="confirm-bar">
				<p>
					<button type="submit" name="submit" value=""><span class="ui-icon ui-icon-newspaper"></span>确认信息</button>
				</p>
				<p>请认真填写您的个人信息</p>
			</div>
		</form>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
		<script type="text/javascript">
		$(".ui-form").prepend(Form.create([
			{"name":"content","label":["培训内容设计","The training content"],"type":"radio","options":[["优秀",4],["良好",3],["一般",2],["很差",1]],"wrapperClass":"cols"}
			,{"name":"explicit","label":["目标明确程度","Training Purpose"],"type":"radio","options":[["优秀",4],["良好",3],["一般",2],["很差",1]],"wrapperClass":"cols"}
			,{"name":"interesting","label":["培训时间安排您更喜欢","Importance"]}
			,{"type":"line"}
			,{"name":"lecturer_plan_evaluation","label":["培训师安排的总体评价","Training time"]}
			,{"name":"communication","label":["培训师与学员的沟通","Train"],"type":"radio","options":[["优秀",4],["良好",3],["一般",2],["很差",1]],"wrapperClass":"cols"}
			,{"name":"prepare","label":["培训准备工作","Evaluation"],"type":"radio","options":[["优秀",4],["良好",3],["一般",2],["很差",1]],"wrapperClass":"cols"}
			,{"name":"attitude","label":["培训师工作态度","Lecture method"],"type":"radio","options":[["优秀",4],["良好",3],["一般",2],["很差",1]],"wrapperClass":"cols"}
			,{"name":"lecturer_evaluation","label":["对讲师的总体评价","Training time"]}
			,{"name":"course_plan_evaluation","label":["培训师安排的总体评价","This evaluation"]}
			,{"name":"attend","label":["是否还想参加这方面培训","Enthusiasm"]}
		]));
		$(".ui-form").submit(function(){
			if(!$("[name=content]:checked").length){
				alert("请为“培训内容设计”打分");
			} else if(!$("[name=explicit]:checked").length){
				alert("请为“目标明确程度”打分");
			} else if(!$("[name=communication]:checked").length){
				alert("请为“培训师与学员的沟通”打分");
			} else if(!$("[name=prepare]:checked").length){
				alert("请为“培训准备工作”打分");
			} else if(!$("[name=attitude]:checked").length){
				alert("请为“培训师工作态度”打分");
			}
			else {
				return true;
			}
			return false;
		});
		</script>
	</body>
</html>
