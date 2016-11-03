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
		<title>加入我们</title>
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
				<li><a href="<%= path %>/action/job/" class="orange active"><span class="ui-icon ui-icon-tag-add"></span><span>加入我们</span></a></li>
				<li><a href="<%= path %>/action/about/contact" class="green"><span class="ui-icon ui-icon-tel"></span><span>联系我们</span></a></li>
				<li><a href="<%= path %>/action/about/company" class="plum"><span class="ui-icon ui-icon-building"></span><span>公司介绍</span></a></li>
			</ul>
			<!-- tab结束 -->
			<ul class="ui-listview ui-listview-white">
				<li>职位名称：${item.title}</li>
				<li>招聘人数：${item.count }人</li>
				<li>招聘时间：<fmt:formatDate value="${item.start }" pattern="yyyy年M月d日"/>——<fmt:formatDate value="${item.end }" pattern="yyyy年M月d日"/></li>
				<li>入职地点：北京 西安 武汉 沈阳</li>
			</ul>
			<div class="content no-indent">
				<h3 class="c-orange">【职位描述 / 要求】</h3>
				${item.description }
			</div>
		</section>
		<div class="confirm-bar">
			<p>
				<a class="button" href="<%=path%>/action/job/join?id=${item.id}"><span class="ui-icon ui-icon-newspaper"></span>立即申请</a>
			</p>
			<p>请认真查阅职位信息</p>
		</div>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
