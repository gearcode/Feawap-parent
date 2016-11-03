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
		<title>培训</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<!-- 幻灯开始 -->
		<c:import url="../common/carousel.jsp">
			<c:param name="nav" value="full"/>
		</c:import>
		<!-- 幻灯结束 -->
		<!-- 蓝色列表开始 -->
		<ul class="ui-listview ui-listview-usercenter-white">
			<li>
				<a href="<%= path %>/action/train/list?type=1">
					<span class="ui-icon ui-icon-display" style="color:#5ebbe7"></span>
					<span class="title">线上培训</span>
					<!-- <span class="count">24</span> -->
				</a>
			</li>
			<li>
				<a href="<%= path %>/action/train/list?type=2">
					<span class="ui-icon ui-icon-abc-fill" style="color:#3faf75"></span>
					<span class="title">线下培训</span>
				</a>
			</li>
			<li>
				<a href="<%= path %>/action/train/news-list">
					<span class="ui-icon ui-icon-talk" style="color:#d09cde"></span>
					<span class="title">培训动态</span>
					<!-- <span class="count">5</span> -->
				</a>
			</li>
			<%-- <li>
				<a href="<%= path %>/action/zxtj/technology">
					<span class="ui-icon ui-icon-talk" style="color:#fd9967"></span>
					<span class="title">在线提交</span>
				</a>
			</li> --%>
			<li>
				<a href="<%= path %>/action/train/list?type=3">
					<span class="ui-icon ui-icon-talk" style="color:#ff6879"></span>
					<span class="title">专题研讨会</span>
				</a>
			</li>
			<li>
				<a href="<%= path %>/action/feedback/course-opinion">
					<span class="ui-icon ui-icon-mail" style="color:#3faf75"></span>
					<span class="title">意见与反馈</span>
				</a>
			</li>
		</ul>
		<!-- 蓝色列表结束 -->
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
