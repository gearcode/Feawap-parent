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
		<title>${item.title }</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-exit"></a>
			<h1>${item.title }</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<section class="m10">
			<div class="content">
				${item.description }
			</div>
		</section>
		<div class="confirm-bar">
			<p>
				<a class="button" href="<%=path %>/action/train/sign?id=${item.id }"><span class="ui-icon ui-icon-newspaper"></span>确认听课</a>
			</p>
			<p>请认真查阅培训内容</p>
		</div>
		<!-- <div class="m5">//TODO:此处插入地图</div> -->
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
