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
		<title>${title }列表</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<header>
			<a class="left ui-icon ui-icon-abc"></a>
			<h1>${title }</h1>
			<a class="right ui-icon ui-icon-arrow-left"></a>
		</header>
		<section class="m5">
			<div class="train-list">
				<c:forEach items="${monthMap }" var="month">
				<c:choose>
					<c:when test="${month.key<currentMonth }">
						<c:set var="css" value="month-close month-disabled" />
					</c:when>
					<c:when test="${month.key>currentMonth }">
						<c:set var="css" value="month-close" />
					</c:when>
					<c:otherwise>
						<c:set var="css" value="month-open" />
					</c:otherwise>
				</c:choose>
				<div class="month ${css }">
					<div class="month-label">${month.key }月</div>
					<c:forEach items="${month.value }" var="day">
					<div class="day">
						<div class="day-label">${day.key }日</div>
						<c:forEach items="${day.value }" var="item">
						<div class="item">
							<div class="contact m0 c4">
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
								<a class="more" href="<%=path %>/action/train/detail?id=${item.id }">了解详情</a>
							</div>
						</div>
						</c:forEach>
					</div>
					</c:forEach>
				</div>
				</c:forEach>
			</div>
		</section>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
		<script>(function(){
			var $month = $(".month");
			$month.find(".month-label").click(function(){
				var $p = $(this).parent();
				$p.siblings().removeClass("month-open").addClass("month-close");
				if($p.hasClass("month-close")){
					$p.removeClass("month-close").addClass("month-open");
				}
				else{
					$p.removeClass("month-open").addClass("month-close");
				}
			});
		})();</script>
	</body>
</html>
