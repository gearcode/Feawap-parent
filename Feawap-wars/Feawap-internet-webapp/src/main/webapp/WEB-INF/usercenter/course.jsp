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
		<title>我的课程</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-folder-open"></a>
			<h1>我的课程</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<section class="m10">
			<!-- tab开始 -->
			<ul class="ui-tabs ui-tabs-news">
				<li><a href="#" class="orange active"><span class="ui-icon ui-icon-checked" style="position:relative;top:-1px"></span><span>已参加</span></a></li>
				<li><a href="#" class="green"><span class="ui-icon ui-icon-edit"></span><span>未开始</span></a></li>
				<li><a href="#" class="plum"><span class="ui-icon ui-icon-close"></span><span>未参加</span></a></li>
			</ul>
			<!-- tab结束 -->
			<div>
			<c:forEach items="${trainList }" var="item">
				<div class="contact c6">
					<h3 class="title">
						<span class="ui-icon ui-icon-files"></span><span>${item.title }</span>
						<!-- <img src="../images/tmp/train-list-logo.png" class="logo"> -->
					</h3>
					<div class="info">
						<p>培训时间：<fmt:formatDate value="${item.start }" pattern="yyyy年M月d日"/>—<fmt:formatDate value="${item.end }" pattern="M月d日"/></p>
						<p><span class="fn-left w50p">时长：${item.days }天</span><span>人数：${item.peoples }人</span></p>                 
						<p>
							<span class="fn-left w50p">培训费用：
							<c:choose>
								<c:when test="${item.cost==0 }">免费</c:when>
								<c:otherwise>${item.cost }元</c:otherwise>
							</c:choose>
							</span>
							<span>培训地点：${item.place }</span>
						</p>
						<p>详细地址 : ${item.address }</p> 
					</div>
					<div class="link">
						<a href="#"><span class="ui-icon ui-icon-tel-fill"></span>联系我们</a>
						<a href="<%=path %>/action/train/sign?id=${item.id }"><span class="ui-icon ui-icon-checked"></span>点击报名</a>
						<a href="#"><span class="ui-icon ui-icon-paperplane"></span>详细地图</a>
						<!-- <a href="#"><span class="ui-icon ui-icon-share"></span>分享课程</a> -->
					</div>
					<%-- <a class="more" href="<%=path %>/action/train/detail?id=${item.id }">了解详情</a> --%>
				</div>
			</c:forEach>
			</div>
		</section>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
