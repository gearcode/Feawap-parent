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
		<title>个人信息</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-pen"></a>
			<h1>个人信息</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<form class="ui-form" method="post">
			<div class="ui-form-row">
				<label for="f_oldpassword">
					<span class="major">登录密码</span>
					<span class="minor">Old password</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="password" name="oldpassword" id="f_oldpassword" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-shield"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_password">
					<span class="major">修改密码</span>
					<span class="minor">New password</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="password" name="password" id="f_password" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-shield-error"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_repassword">
					<span class="major">确认密码</span>
					<span class="minor">Re-password</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="password" name="repassword" id="f_repassword" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-shield-success"></span>
				</div>
			</div>
			<div class="confirm-bar">
				<p>
					<button type="submit" name="submit"><span class="ui-icon ui-icon-newspaper"></span>修改信息</button>
				</p>
				<p>如有修改请点击此处修改</p>
			</div>
		</form>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
		<script type="text/javascript">
		$("form").submit(function(){
			if($("#f_password").val()!=$("#f_repassword").val()){
				alert("两次密码不一致");
				return false;
			}
		});
		</script>
	</body>
</html>
