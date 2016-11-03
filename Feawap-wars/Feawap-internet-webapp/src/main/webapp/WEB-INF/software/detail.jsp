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
		<title>${item.name }</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-exit"></a>
			<h1>${item.name }</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<section class="m10">
			<ul class="ui-tabs ui-tabs-default p15 swiper-nav">
				<li><a href="#">行业应用</a></li>
				<li><a href="#">案例分析</a></li>
			</ul>
			<div class="swiper-content">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<div class="content">
						${item.application }
						</div>
					</div>
					<div class="swiper-slide">
						<div class="content">
						${item.caseAnalysis }
						</div>
					</div>
				</div>
			</div>
		</section>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
	</body>
</html>