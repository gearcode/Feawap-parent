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
		<header>
			<a class="left ui-icon ui-icon-abc"></a>
			<h1>填写报名信息</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<form class="ui-form" method="post">
			<div class="ui-form-row">
				<label>
					<span class="major">报名课程</span>
					<span class="minor">Registration number</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" class="ui-input-has-left" value="${item.title }" readonly="readonly"/>
					<span class="ui-input-left ui-icon ui-icon-books"></span>
				</div>
			</div>
			<div class="confirm-bar">
				<p>
					<button type="submit" name="submit" value=""><span class="ui-icon ui-icon-newspaper"></span>确认信息</button>
				</p>
				<p>此课程限定人数<span class="c-red">${item.peoples}</span>人,已经报名<span class="c-red">12</span>人,剩余<span class="c-red">18</span>人</p>
			</div>
		</form>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
		<script type="text/javascript">
			$(".confirm-bar").before(Form.create([
				{"name":"peoples","label":["确认报名人数","todo"],"icon":"books","type":"number","min":1,"value":1}
				,{"name":"company","label":["单位名称","Company"],"icon":"building","type":"text"}
				,{"name":"company_type","label":["单位类型","todo"],"icon":"tags","type":"select","options":["私营","国营","合资","外企"]}
				,{"name":"industry","label":["所属行业","Industry"],"icon":"grid8","type":"text"}
				,{"name":"work_address","label":["工作地点","Address"],"icon":"geo","type":"text"}
				,{"name":"department","label":["所在部门","Dept"],"icon":"contacts","type":"text"}
				,{"name":"work_position","label":["职位","Post"],"icon":"bag","type":"text"}
				,{"name":"research_target","label":["研究方向","Target"],"icon":"pie","type":"text"}
				,{"name":"software","label":["使用软件","software"],"icon":"cd","type":"text"}
				,{"name":"concern","label":["关注领域","todo"],"icon":"mushrooms","type":"text"}
			]));
		</script>
	</body>
</html>
