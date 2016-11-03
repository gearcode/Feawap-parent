<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
		<title>CAE咨询</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<!-- 幻灯开始 -->
		<c:import url="../common/carousel.jsp"></c:import>
		<!-- 幻灯结束 -->
		
		<div class="software-list">
			<c:forEach var="item" items="${list }">
			<a href="<%= path %>/action/software/detail?id=${item.id }" class="item">
				<div class="logo"><img width="100%" height="100%" src="${preview }${item.icon }"></div>
				<div class="title">${item.name }</div>
			</a>
			</c:forEach>
		</div>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
