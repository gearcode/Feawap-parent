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
		<title>公司介绍</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<!-- 幻灯开始 -->
		<c:import url="../common/carousel.jsp">
			<c:param name="nav" value="full"/>
		</c:import>
		<!-- 幻灯结束 -->
		<section class="m10">
			<!-- tab开始 -->
			<ul class="ui-tabs ui-tabs-news">
				<li><a href="<%= path %>/action/job/" class="orange"><span class="ui-icon ui-icon-tag-add"></span><span>加入我们</span></a></li>
				<li><a href="<%= path %>/action/about/contact" class="green"><span class="ui-icon ui-icon-tel"></span><span>联系我们</span></a></li>
				<li><a href="<%= path %>/action/about/company" class="plum active"><span class="ui-icon ui-icon-building"></span><span>公司介绍</span></a></li>
			</ul>
			<!-- tab结束 -->
			<div class="content">
				<h2>【公司介绍】</h2>
				${item.content }
			</div>
		</section>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
