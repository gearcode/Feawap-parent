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
		<title>会员专区</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-personal"></a>
			<h1>会员专区</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<section class="m10">
			<ul class="ui-listview ui-listview-usercenter">
				<li>
					<a href="<%=path%>/action/usercenter/info">
						<span class="ui-icon ui-icon-man"></span><span class="title">个人信息</span>
						<span class="arrow"></span>
					</a>
				</li>
				<li>
					<a href="<%=path%>/action/usercenter/password">
						<span class="ui-icon ui-icon-shield-warning"></span><span class="title">修改密码</span>
						<span class="arrow"></span>
					</a>
				</li>
				<li>
					<a href="<%=path%>/action/usercenter/favor">
						<span class="ui-icon ui-icon-folder"></span><span class="title">我的课程收藏夹</span>
						<span class="arrow"></span>
					</a>
				</li>
				<li>
					<a href="<%=path%>/action/usercenter/course">
						<span class="ui-icon ui-icon-folder-open"></span><span class="title">我的报名课程</span>
						<span class="arrow"></span>
					</a>
				</li>
				<li>
					<a href="<%=path%>/action/usercenter/cert">
						<span class="ui-icon ui-icon-contacts"></span><span class="title">我的培训证书</span>
						<span class="arrow"></span>
					</a>
				</li>
				<li>
					<a href="<%=path%>/action/logout">
						<span class="ui-icon ui-icon-error"></span><span class="title">退出登录</span>
						<span class="arrow"></span>
					</a>
				</li>
			</ul>
		</section>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
