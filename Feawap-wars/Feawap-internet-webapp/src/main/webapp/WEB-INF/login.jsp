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
		<title>用户登录</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-heart"></a>
			<h1>用户登录</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<form class="ui-form" method="post">
			<div class="ui-form-row">
				<label for="f_username">
					<span class="major">用户名</span>
					<span class="minor">Username</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="username" id="f_username" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-user"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_password">
					<span class="major">登录密码</span>
					<span class="minor">Password</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="password" name="password" id="f_password" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-lock"></span>
				</div>
			</div>
			<div>
				<button type="submit" class="ui-btn ui-btn-full mt65" name="submit">登录账户</button>
				<a href="<%=path %>/action/reg?return=${returnUrl}" class="ui-btn ui-btn-blue ui-btn-full mt10 mb40">注册账户</a>
			</div>
		</form>
		<script src="<%=path %>/js/jquery.min.js"></script>
		<script src="<%=path %>/js/main.js"></script>
	</body>
</html>
