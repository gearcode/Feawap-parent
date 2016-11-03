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
		<title>操作失败</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<section class="m10" style="margin:4em 1em 5em!important;text-align:center;">
			<c:choose>
				<c:when test="${title==null }">
					<h2>操作失败</h2>
				</c:when>
				<c:otherwise>
					<h2>${title }</h2>
				</c:otherwise>
			</c:choose>
			<c:if test="${message!=null }">
				<p>${message }</p>
			</c:if>
		</section>
		<div class="confirm-bar">
			<p>
				<c:choose>
					<c:when test="${url!=null }">
						<button type="button" onclick="location.href='<%=path %>${url}'">确定</button>
					</c:when>
					<c:otherwise>
						<button type="button" onclick="history.back()">确定</button>
					</c:otherwise>
				</c:choose>
			</p>
		</div>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
		<script type="text/javascript">
		setTimeout(function(){
			$(".confirm-bar button").click();
		},3000);
		</script>
	</body>
</html>
