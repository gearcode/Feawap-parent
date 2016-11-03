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
		<title>联系我们</title>
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
				<li><a href="<%= path %>/action/job/" class="orange"><span class="ui-icon ui-icon-tag-add"></span><span>加入我们</span></a></li>
				<li><a href="<%= path %>/action/about/contact" class="green active"><span class="ui-icon ui-icon-tel"></span><span>联系我们</span></a></li>
				<li><a href="<%= path %>/action/about/company" class="plum"><span class="ui-icon ui-icon-building"></span><span>公司介绍</span></a></li>
			</ul>
			<!-- tab结束 -->
			<div>
				<div class="contact c7">
					<h3 class="title">全国总线</h3>
					<div class="info">
						<p><span class="ui-icon ui-icon-house"></span>：北京海淀上地三街9号嘉华大厦D座806室</p>
						<p><span class="ui-icon ui-icon-man"></span>：100085</p>
						<p><span class="ui-icon ui-icon-tel"></span>：4006396688&nbsp;&nbsp;&nbsp;&nbsp;010—62971792/3</p>
						<p><span class="ui-icon ui-icon-tel2"></span>：010—62972839</p>
						<p><span class="ui-icon ui-icon-mail"></span>：info@FEAonline.com.cn</p>
						<p><span class="ui-icon ui-icon-mushrooms"></span>：http://www.feaonlinebbs.cn/forum.php</p>
						<p><span class="ui-icon ui-icon-talk"></span> 订阅号：FEAonline_CAE</p>
						<p><span class="ui-icon ui-icon-talk"></span> 服务号：FEAonlineBJ</p>
					</div>
					<div class="link">
						<a href="#"><span class="ui-icon ui-icon-tel-fill"></span>联系我们</a>
						<a href="#"><span class="ui-icon ui-icon-sina-weibo"></span>官方微博</a>
						<a href="mailto:10000@qq.com"><span class="ui-icon ui-icon-mail"></span>发送邮件</a>
						<a href="#"><span class="ui-icon ui-icon-paperplane"></span>详细地图</a>
					</div>
				</div>
				<div class="contact c8">
					<h3 class="title">北京总部</h3>
					<div class="info">
						<p><span class="ui-icon ui-icon-house"></span>：北京海淀上地三街9号嘉华大厦D座806室</p>
						<p><span class="ui-icon ui-icon-man"></span>：100085</p>
						<p><span class="ui-icon ui-icon-tel"></span>：4006396688&nbsp;&nbsp;&nbsp;&nbsp;010—62971792/3</p>
						<p><span class="ui-icon ui-icon-tel2"></span>：010—62972839</p>
						<p><span class="ui-icon ui-icon-mail"></span>：info@FEAonline.com.cn</p>
						<p><span class="ui-icon ui-icon-mushrooms"></span>：http://www.feaonlinebbs.cn/forum.php</p>
						<p><span class="ui-icon ui-icon-talk"></span> 订阅号：FEAonline_CAE</p>
						<p><span class="ui-icon ui-icon-talk"></span> 服务号：FEAonlineBJ</p>
					</div>
					<div class="link">
						<a href="#"><span class="ui-icon ui-icon-tel-fill"></span>联系我们</a>
						<a href="#"><span class="ui-icon ui-icon-sina-weibo"></span>官方微博</a>
						<a href="mailto:10000@qq.com"><span class="ui-icon ui-icon-mail"></span>发送邮件</a>
						<a href="#"><span class="ui-icon ui-icon-paperplane"></span>详细地图</a>
					</div>
				</div>
				<div class="contact c9">
					<h3 class="title">上海分公司</h3>
					<div class="info">
						<p>公司地址：北京海淀上地三街9号嘉华大厦D座806室</p>
						<p>邮编：100085</p>
						<p>电话：4006396688&nbsp;&nbsp;&nbsp;&nbsp;010—62971792/3</p>
						<p>传真：010—62972839</p>
						<p>Email：info@FEAonline.com.cn</p>
						<p>有限元在线论坛：http://www.feaonlinebbs.cn/forum.php</p>
						<p>微信平台-订阅号：FEAonline_CAE</p>
						<p>微信平台-服务号：FEAonlineBJ</p>
					</div>
					<div class="link">
						<a href="#"><span class="ui-icon ui-icon-tel-fill"></span>联系我们</a>
						<a href="#"><span class="ui-icon ui-icon-sina-weibo"></span>官方微博</a>
						<a href="mailto:10000@qq.com"><span class="ui-icon ui-icon-mail"></span>发送邮件</a>
						<a href="#"><span class="ui-icon ui-icon-paperplane"></span>详细地图</a>
					</div>
				</div>
				<div class="contact c10">
					<h3 class="title">西安分公司</h3>
					<div class="info">
						<p>公司地址：北京海淀上地三街9号嘉华大厦D座806室</p>
						<p>邮编：100085</p>
						<p>电话：4006396688&nbsp;&nbsp;&nbsp;&nbsp;010—62971792/3</p>
						<p>传真：010—62972839</p>
						<p>Email：info@FEAonline.com.cn</p>
						<p>有限元在线论坛：http://www.feaonlinebbs.cn/forum.php</p>
						<p>微信平台-订阅号：FEAonline_CAE</p>
						<p>微信平台-服务号：FEAonlineBJ</p>
					</div>
					<div class="link">
						<a href="#"><span class="ui-icon ui-icon-tel-fill"></span>联系我们</a>
						<a href="#"><span class="ui-icon ui-icon-sina-weibo"></span>官方微博</a>
						<a href="mailto:10000@qq.com"><span class="ui-icon ui-icon-mail"></span>发送邮件</a>
						<a href="#"><span class="ui-icon ui-icon-paperplane"></span>详细地图</a>
					</div>
				</div>
				<div class="contact c11">
					<h3 class="title">武汉分公司</h3>
					<div class="info">
						<p>公司地址：北京海淀上地三街9号嘉华大厦D座806室</p>
						<p>邮编：100085</p>
						<p>电话：4006396688&nbsp;&nbsp;&nbsp;&nbsp;010—62971792/3</p>
						<p>传真：010—62972839</p>
						<p>Email：info@FEAonline.com.cn</p>
						<p>有限元在线论坛：http://www.feaonlinebbs.cn/forum.php</p>
						<p>微信平台-订阅号：FEAonline_CAE</p>
						<p>微信平台-服务号：FEAonlineBJ</p>
					</div>
					<div class="link">
						<a href="#"><span class="ui-icon ui-icon-tel-fill"></span>联系我们</a>
						<a href="#"><span class="ui-icon ui-icon-sina-weibo"></span>官方微博</a>
						<a href="mailto:10000@qq.com"><span class="ui-icon ui-icon-mail"></span>发送邮件</a>
						<a href="#"><span class="ui-icon ui-icon-paperplane"></span>详细地图</a>
					</div>
				</div>
				<div class="contact c12">
					<h3 class="title">沈阳分公司</h3>
					<div class="info">
						<p>公司地址：北京海淀上地三街9号嘉华大厦D座806室</p>
						<p>邮编：100085</p>
						<p>电话：4006396688&nbsp;&nbsp;&nbsp;&nbsp;010-62971792/3</p>
						<p>传真：010—62972839</p>
						<p>Email：info@FEAonline.com.cn</p>
						<p>有限元在线论坛：http://www.feaonlinebbs.cn/forum.php</p>
						<p>微信平台-订阅号：FEAonline_CAE</p>
						<p>微信平台-服务号：FEAonlineBJ</p>
					</div>
					<div class="link">
						<a href="#"><span class="ui-icon ui-icon-tel-fill"></span>联系我们</a>
						<a href="#"><span class="ui-icon ui-icon-sina-weibo"></span>官方微博</a>
						<a href="mailto:10000@qq.com"><span class="ui-icon ui-icon-mail"></span>发送邮件</a>
						<a href="#"><span class="ui-icon ui-icon-paperplane"></span>详细地图</a>
					</div>
				</div>
			</div>
		</section>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
