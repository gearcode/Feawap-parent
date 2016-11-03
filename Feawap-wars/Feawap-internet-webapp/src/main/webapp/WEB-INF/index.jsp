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
		<title>首页</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<!-- 幻灯开始 -->
		<c:import url="./common/carousel.jsp">
			<c:param name="nav" value="full"/>
		</c:import>
		<!-- 幻灯结束 -->
		<ul class="ui-listview ui-listview-gray">
			<li>
				<a href="<%=path %>/action/consultation/">
					<span class="preview"></span>
					<h3 class="title">
						<span class="major">CAE咨询</span>
						<span class="minor">因为专业，所以卓越</span>
					</h3>
					<span class="right"></span>
				</a>
			</li>
			<li>
				<a href="<%=path %>/action/software/">
					<span class="preview"></span>
					<h3 class="title">
						<span class="major">CAE软件</span>
						<span class="minor">最佳的完美CAE解决方案</span>
					</h3>
					<span class="right"></span>
				</a>
			</li>
			<li>
				<a href="<%=path %>/action/train/">
					<span class="preview"></span>
					<h3 class="title">
						<span class="major">CAE培训</span>
						<span class="minor">有限元在线铸就卓越CAE工程师</span>
					</h3>
					<span class="right"></span>
				</a>
			</li>
			<li>
				<a href="<%=path %>/action/news/">
					<span class="preview"></span>
					<h3 class="title">
						<span class="major">公司新闻</span>
						<span class="minor">企业新闻 + 市场新闻</span>
					</h3>
					<span class="right"></span>
				</a>
			</li>
			<li>
				<a href="<%=path %>/action/about/">
					<span class="preview"></span>
					<h3 class="title">
						<span class="major">关于我们</span>
						<span class="minor">我们是雄鹰，展翅高翔于层云之巅</span>
					</h3>
					<span class="right"></span>
				</a>
			</li>
			<li>
				<span class="preview"></span>
				<h3 class="title">
					<span class="major">有限元论坛</span>
					<span class="minor">有限元在线应用技术讨论区</span>
				</h3>
				<span class="right"></span>
			</li>
			<li>
				<a href="<%=path %>/action/usercenter/">
					<span class="preview"></span>
					<h3 class="title">
						<span class="major">会员专区</span>
						<span class="minor">成为会员，您将会获得多项会员专享权限</span>
					</h3>
					<span class="right"></span>
				</a>
			</li>
			<li>
				<a href="<%= path %>/action/train/technology">
					<span class="preview"></span>
					<h3 class="title">
						<span class="major">在线咨询</span>
						<span class="minor">在线咨询，在线咨询在线咨询在线咨询</span>
					</h3>
					<span class="right"></span>
				</a>
			</li>
		</ul>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>
