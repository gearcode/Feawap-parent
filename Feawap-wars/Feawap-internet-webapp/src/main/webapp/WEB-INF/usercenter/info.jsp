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
				<label for="f_realname">
					<span class="major">真实姓名</span>
					<span class="minor">Realname</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="realname" id="f_realname" class="ui-input-has-left" value="${item.name }"/>
					<span class="ui-input-left ui-icon ui-icon-user"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_mobile">
					<span class="major">手机</span>
					<span class="minor">Phone</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="mobile" id="f_mobile" class="ui-input-has-left ui-input-has-right" value="${item.cellphone }"/>
					<span class="ui-input-left ui-icon ui-icon-phone"></span>
					<span class="ui-input-right ui-icon ui-icon-plus"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_email">
					<span class="major">电子邮箱</span>
					<span class="minor">Mailbox</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="email" id="f_email" class="ui-input-has-left ui-input-has-right" value="${item.email }"/>
					<span class="ui-input-left ui-icon ui-icon-mail"></span>
					<span class="ui-input-right ui-icon ui-icon-plus"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_company">
					<span class="major">单位名称</span>
					<span class="minor">Company</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="company" id="f_company" class="ui-input-has-left" value="${item.company }"/>
					<span class="ui-input-left ui-icon ui-icon-building"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_company_type">
					<span class="major">单位类型</span>
					<span class="minor">Company</span>
				</label>
				<div class="ui-input-wrapper">
					<select name="company_type" id="f_company_type" class="ui-input-has-left ui-input-has-right">
						<option value="0"<c:if test="${item.companyType==0}">selected="selected"</c:if>>—  私营  —</option>
						<option value="1"<c:if test="${item.companyType==1}">selected="selected"</c:if>>—  国营  —</option>
						<option value="2"<c:if test="${item.companyType==2}">selected="selected"</c:if>>—  事业单位  —</option>
						<option value="3"<c:if test="${item.companyType==3}">selected="selected"</c:if>>—  外企  —</option>
					</select>
					<span class="ui-input-left ui-icon ui-icon-tags"></span>
					<span class="ui-input-right ui-icon ui-icon-triangle"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_industry">
					<span class="major">所属行业</span>
					<span class="minor">mailbox</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="industry" id="f_industry" class="ui-input-has-left" value="${item.industry }"/>
					<span class="ui-input-left ui-icon ui-icon-grid8"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_work_address">
					<span class="major">工作地点</span>
					<span class="minor">Address</span>
				</label>
				<div class="ui-input-wrapper">
					<select name="work_address" id="f_work_address" class="ui-input-has-left ui-input-has-right" value="${item.area }">
						<option value="北京市"<c:if test='${item.workAddress=="北京市"}'>selected="selected"</c:if>>北京市</option>
						<option value="上海市"<c:if test='${item.workAddress=="上海市"}'>selected="selected"</c:if>>上海市</option>
						<option value="天津市"<c:if test='${item.workAddress=="天津市"}'>selected="selected"</c:if>>天津市</option>
						<option value="重庆市"<c:if test='${item.workAddress=="重庆市"}'>selected="selected"</c:if>>重庆市</option>
						<option value="黑龙江省"<c:if test='${item.workAddress=="黑龙江省"}'>selected="selected"</c:if>>黑龙江省</option>
						<option value="辽宁省"<c:if test='${item.workAddress=="辽宁省"}'>selected="selected"</c:if>>辽宁省</option>
						<option value="吉林省"<c:if test='${item.workAddress=="吉林省"}'>selected="selected"</c:if>>吉林省</option>
						<option value="河北省"<c:if test='${item.workAddress=="河北省"}'>selected="selected"</c:if>>河北省</option>
						<option value="河南省"<c:if test='${item.workAddress=="河南省"}'>selected="selected"</c:if>>河南省</option>
						<option value="湖北省"<c:if test='${item.workAddress=="湖北省"}'>selected="selected"</c:if>>湖北省</option>
						<option value="湖南省"<c:if test='${item.workAddress=="湖南省"}'>selected="selected"</c:if>>湖南省</option>
						<option value="山东省"<c:if test='${item.workAddress=="山东省"}'>selected="selected"</c:if>>山东省</option>
						<option value="山西省"<c:if test='${item.workAddress=="山西省"}'>selected="selected"</c:if>>山西省</option>
						<option value="陕西省"<c:if test='${item.workAddress=="陕西省"}'>selected="selected"</c:if>>陕西省</option>
						<option value="安徽省"<c:if test='${item.workAddress=="安徽省"}'>selected="selected"</c:if>>安徽省</option>
						<option value="浙江省"<c:if test='${item.workAddress=="浙江省"}'>selected="selected"</c:if>>浙江省</option>
						<option value="江苏省"<c:if test='${item.workAddress=="江苏省"}'>selected="selected"</c:if>>江苏省</option>
						<option value="福建省"<c:if test='${item.workAddress=="福建省"}'>selected="selected"</c:if>>福建省</option>
						<option value="广东省"<c:if test='${item.workAddress=="广东省"}'>selected="selected"</c:if>>广东省</option>
						<option value="海南省"<c:if test='${item.workAddress=="海南省"}'>selected="selected"</c:if>>海南省</option>
						<option value="四川省"<c:if test='${item.workAddress=="四川省"}'>selected="selected"</c:if>>四川省</option>
						<option value="云南省"<c:if test='${item.workAddress=="云南省"}'>selected="selected"</c:if>>云南省</option>
						<option value="贵州省"<c:if test='${item.workAddress=="贵州省"}'>selected="selected"</c:if>>贵州省</option>
						<option value="青海省"<c:if test='${item.workAddress=="青海省"}'>selected="selected"</c:if>>青海省</option>
						<option value="甘肃省"<c:if test='${item.workAddress=="甘肃省"}'>selected="selected"</c:if>>甘肃省</option>
						<option value="江西省"<c:if test='${item.workAddress=="江西省"}'>selected="selected"</c:if>>江西省</option>
						<option value="台湾省"<c:if test='${item.workAddress=="台湾省"}'>selected="selected"</c:if>>台湾省</option>
						<option value="内蒙古自治区"<c:if test='${item.workAddress=="内蒙古自治区"}'>selected="selected"</c:if>>内蒙古自治区</option>
						<option value="宁夏回族自治区"<c:if test='${item.workAddress=="宁夏回族自治区"}'>selected="selected"</c:if>>宁夏回族自治区</option>
						<option value="新疆维吾尔自治区"<c:if test='${item.workAddress=="新疆维吾尔自治区"}'>selected="selected"</c:if>>新疆维吾尔自治区</option>
						<option value="西藏自治区"<c:if test='${item.workAddress=="西藏自治区"}'>selected="selected"</c:if>>西藏自治区</option>
						<option value="广西壮族自治区"<c:if test='${item.workAddress=="广西壮族自治区"}'>selected="selected"</c:if>>广西壮族自治区</option>
						<option value="香港特别行政区"<c:if test='${item.workAddress=="香港特别行政区"}'>selected="selected"</c:if>>香港特别行政区</option>
						<option value="澳门特别行政区"<c:if test='${item.workAddress=="澳门特别行政区"}'>selected="selected"</c:if>>澳门特别行政区</option>
					</select>
					<span class="ui-input-left ui-icon ui-icon-geo"></span>
					<span class="ui-input-right ui-icon ui-icon-triangle"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_department">
					<span class="major">所在部门</span>
					<span class="minor">Dept</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="department" id="f_department" class="ui-input-has-left" value="${item.department }"/>
					<span class="ui-input-left ui-icon ui-icon-contacts"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_post">
					<span class="major">职位</span>
					<span class="minor">Post</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="post" id="f_post" class="ui-input-has-left" value="${item.post }"/>
					<span class="ui-input-left ui-icon ui-icon-bag"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_target">
					<span class="major">研究方向</span>
					<span class="minor">Target</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="target" id="f_target" class="ui-input-has-left" value="${item.target }"/>
					<span class="ui-input-left ui-icon ui-icon-pie"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_software">
					<span class="major">使用软件</span>
					<span class="minor">Software</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="software" id="f_software" class="ui-input-has-left" value="${item.software }"/>
					<span class="ui-input-left ui-icon ui-icon-cd"></span>
				</div>
			</div>
			<div class="ui-form-row">
				<label for="f_area">
					<span class="major">关注领域</span>
					<span class="minor">mailbox</span>
				</label>
				<div class="ui-input-wrapper">
					<input type="text" name="area" id="f_area" class="ui-input-has-left" value="${item.area }"/>
					<span class="ui-input-left ui-icon ui-icon-mushrooms"></span>
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
	</body>
</html>
