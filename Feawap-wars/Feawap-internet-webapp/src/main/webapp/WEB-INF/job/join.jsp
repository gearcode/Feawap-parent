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
		<title>职位应聘表单</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-pen"></a>
			<h1>职位应聘表单</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<form class="ui-form" method="post" enctype="multipart/form-data">
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
					<span class="major">个人手机</span>
					<span class="minor">Personal mobile phone</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="mobile" id="f_mobile" class="ui-input-has-left ui-input-has-right" />
					<span class="ui-input-left ui-icon ui-icon-phone"></span>
					<span class="ui-input-right ui-icon ui-icon-plus"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_email">
					<span class="major">个人邮箱</span>
					<span class="minor">Personal mailbox</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="email" id="f_email" class="ui-input-has-left ui-input-has-right"/>
					<span class="ui-input-left ui-icon ui-icon-mail"></span>
					<span class="ui-input-right ui-icon ui-icon-plus"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_biyeshijian">
					<span class="major">毕业时间</span>
					<span class="minor">Graduation time</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="biyeshijian" id="f_biyeshijian" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-clock"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_biyexuexiao">
					<span class="major">毕业院校</span>
					<span class="minor">Graduate institutions</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="mailbox" id="f_biyexuexiao" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-hotel"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_xueli">
					<span class="major">最高学历</span>
					<span class="minor">The highest degree</span>
				</label>
				<div class="ui-input-wrapper">
					<select name="xueli" id="f_xueli" class="ui-input-has-left ui-input-has-right">
						<option selected="selected" disabled="disabled"></option>
						<option value="1">中专</option>
						<option value="2">大专</option>
						<option value="3">本科</option>
						<option value="4">硕士</option>
						<option value="5">博士</option>
					</select>
					<span class="ui-input-left ui-icon ui-icon-graduation"></span>
					<span class="ui-input-right ui-icon ui-icon-triangle"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_zhuanye">
					<span class="major">专业</span>
					<span class="minor">Professional</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="zhuanye" id="f_zhuanye" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-grid4"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_gongzuonianxian">
					<span class="major">工作年限</span>
					<span class="minor">Work experience</span>
				</label>
				<div class="ui-input-wrapper">
					<select name="gongzuonianxian" id="f_gongzuonianxian" class="ui-input-has-left ui-input-has-right">
						<option selected="selected" disabled="disabled"></option>
						<option value="0">1年以下</option>
						<option value="1">1年</option>
						<option value="2">2年</option>
						<option value="3">3年</option>
						<option value="4">4年</option>
						<option value="5">5年以上</option>
						<option value="10">10年以上</option>
					</select>
					<span class="ui-input-left ui-icon ui-icon-contacts"></span>
					<span class="ui-input-right ui-icon ui-icon-triangle"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_chengshi">
					<span class="major">所在城市</span>
					<span class="minor">In the city</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="chengshi" id="f_chengshi" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-house"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_daogangshijian">
					<span class="major">到岗时间</span>
					<span class="minor">Time</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="date" name="daogangshijian" id="f_daogangshijian" class="ui-input-has-left"/>
					<span class="ui-input-left ui-icon ui-icon-alarm"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<button class="ui-btn ui-btn-full ui-btn-g-gray" type="button" onclick="$('#file').click()">拍照上传简历</button>
				<input type="file" accept="image/*" id="file" style="visibility:hidden;height:0;overflow:hidden;position:absolute" />
			</div>
			<!-- 
			<div class="ui-form-row">
				<button class="ui-btn ui-btn-full ui-btn-g-gray" type="button" onclick="$('#file').click()">从本地选择图片</button>
			</div>
			 -->
			<div class="confirm-bar">
				<p>
					<button type="submit" name="submit"><span class="ui-icon ui-icon-newspaper"></span>确认信息</button>
				</p>
				<p>请认真填写您的个人信息</p>
			</div>
		</form>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
