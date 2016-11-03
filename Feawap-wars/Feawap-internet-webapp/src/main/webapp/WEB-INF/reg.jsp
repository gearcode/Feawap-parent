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
		<title>注册<</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-heart"></a>
			<h1>填写报名信息</h1>
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
					<span class="ui-input-left ui-icon ui-icon-shield"></span>
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
			<div class="ui-form-row">
				<label for="f_realname">
					<span class="major">真实姓名</span>
					<span class="minor">Realname</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="realname" id="f_realname" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-tag"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_gender">
					<span class="major">性别</span>
					<span class="minor">Gender</span>
				</label>
				<div class="ui-input-wrapper">
					<select name="gender" id="f_gender" class="ui-input-has-left ui-input-has-right">
						<option selected="selected" disabled="disabled"></option>
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
					<span class="ui-input-left ui-icon ui-icon-man"></span>
					<span class="ui-input-right ui-icon ui-icon-triangle"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_mobile">
					<span class="major">手机</span>
					<span class="minor">Phone</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="mobile" id="f_mobile" class="ui-input-has-left ui-input-has-right" />
					<span class="ui-input-left ui-icon ui-icon-phone"></span>
					<span class="ui-input-right ui-icon ui-icon-plus"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_mobileVerify">
					<span class="major">手机验证</span>
					<span class="minor">Mobile verify</span>
				</label>
				<div>
					<div class="input-verify ui-input-wrapper">
						<input type="text" name="mobileVerify" id="f_mobileVerify" class="ui-input-has-left"/>
						<span class="ui-input-left ui-icon ui-icon-sms"></span>
					</div>
					<button type="button" class="send-sms">发送验证码</button>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_email">
					<span class="major">电子邮箱</span>
					<span class="minor">Mailbox</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="email" id="f_email" class="ui-input-has-left ui-input-has-right"/>
					<span class="ui-input-left ui-icon ui-icon-mail"></span>
					<span class="ui-input-right ui-icon ui-icon-plus"></span>
				</div>
			</div>
			<div class="confirm-bar">
				<p>
					<button type="submit" name="submit"><span class="ui-icon ui-icon-newspaper"></span>确认信息</button>
				</p>
				<p>请认真填写您的个人信息</p>
			</div>
		</form>
		<script src="<%=path %>/js/jquery.min.js"></script>
		<script src="<%=path %>/js/main.js"></script>
	</body>
</html>
