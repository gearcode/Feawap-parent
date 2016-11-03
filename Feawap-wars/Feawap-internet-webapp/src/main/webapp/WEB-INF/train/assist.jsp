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
			<div class="confirm-bar">
				<p>
					<input type="hidden" name="step" value="2"/>
					<button type="submit" name="submit" value=""><span class="ui-icon ui-icon-newspaper"></span>确认信息</button>
				</p>
				<p>此课程限定人数<span class="c-red">${item.peoples}</span>人,已经报名<span class="c-red">12</span>人,剩余<span class="c-red">18</span>人</p>
			</div>
		</form>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
		<script type="text/javascript">
			$(".confirm-bar").before(Form.create([
				{"name":"vehicle","label":["交通工具","Vehicle"],"icon":"plane","type":"select","options":["飞机","火车","其它"]}
				,{"name":"shift","label":["班次","Shift"],"icon":"clock","type":"text"}
				,{"name":"hotel","label":["酒店名称","Hotel name"],"icon":"hotel","type":"select","options":${item.hotels}}
				,{"name":"star","label":["酒店星级","Strt Hotel"],"icon":"star","type":"select","options":["是","三星","四星","五星"]}
				,{"name":"cellphone","label":["电话回访","Call back"],"icon":"tel2","type":"text"}
			]));
		</script>
	</body>
</html>
