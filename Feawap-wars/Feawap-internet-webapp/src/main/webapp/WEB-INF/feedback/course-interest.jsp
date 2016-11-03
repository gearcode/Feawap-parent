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
			<li><a href="<%=path %>/action/feedback/course-interest" class="orange active"><span class="ui-icon ui-icon-newspaper"></span><span>感兴趣的课程</span></a></li>
			<li><a href="<%=path %>/action/feedback/course-opinion" class="green"><span class="ui-icon ui-icon-note"></span><span>课程意见与反馈</span></a></li>
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
			$(".confirm-bar").before(Form.create([
				{"name":"name","label":["真实姓名","Realname"],"type":"text"}
				,{"name":"cellphone","label":["手机","Phone"],"type":"text"}
				,{"name":"email","label":["电子邮箱","Mailbox"],"type":"text"}
				,{"name":"company","label":["单位名称","Company"],"type":"text"}
				,{"name":"address","label":["工作地点","Address"],"type":"text"}
				,{"name":"department","label":["所在部门","Dept"],"type":"text"}
				,{"name":"position","label":["职位","Post"],"type":"text"}
				,{"name":"target","label":["研究方向","Target"],"type":"text"}
				,{"name":"software","label":["使用软件","Software"],"type":"text"}
			]));
		</script>
	</body>
</html>
