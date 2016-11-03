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
		<title>${item.title }</title>
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
				<li><a href="<%=path %>/action/news/?category=1" class="orange<c:if test="${item.category==1}"> active</c:if>"><span class="ui-icon ui-icon-newspaper"></span><span>企业新闻</span></a></li>
				<li><a href="<%=path %>/action/news/?category=2" class="green<c:if test="${item.category==2}"> active</c:if>"><span class="ui-icon ui-icon-note"></span><span>培训新闻</span></a></li>
				<li><a href="<%=path %>/action/news/?category=3" class="plum<c:if test="${item.category==3}"> active</c:if>"><span class="ui-icon"></span><span>产品新闻</span></a></li>
			</ul>
			<!-- tab结束 -->
			<div class="content">
				<h2>${item.title }</h2>
				${item.content }
			</div>
		</section>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>