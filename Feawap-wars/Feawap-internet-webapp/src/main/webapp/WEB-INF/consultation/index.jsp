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
		<title>CAE咨询</title>
		<link rel="stylesheet" href="<%= path %>/css/all.css" />
		<script type="text/javascript">var site_url="<%= path %>"</script>
	</head>

	<body>
		<!-- 幻灯开始 -->
		<c:import url="../common/carousel.jsp"></c:import>
		<!-- 幻灯结束 -->
		<ul class="ui-tabs swiper-nav fn-hide">
			<li class="current"><span>行业</span></li>
			<li><span>学科</span></li>
		</ul>
		<div class="swiper-content">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<div class="ui-grid">
						<div class="cols">
							<a data-tan="66" data-col="4" style="background-color:${hangyeList[0].color }" class="item col4" href="<%= path %>/action/consultation/detail?id=${hangyeList[0].id}">
								<img class="icon" src="${preview}${hangyeList[0].icon }" />
								<span class="text">${hangyeList[0].name }</span>
							</a>
							<a data-tan="66" data-col="4" style="background-color:${hangyeList[1].color };" class="item col4" href="<%= path %>/action/consultation/detail?id=${hangyeList[1].id}">
								<img class="icon" src="${preview}${hangyeList[1].icon }" />
								<span class="text">${hangyeList[1].name }</span>
							</a>
							<a data-tan="66" data-col="4" style="background-color:${hangyeList[2].color }" class="item col4" href="<%= path %>/action/consultation/detail?id=${hangyeList[2].id}">
								<img class="icon" src="${preview}${hangyeList[2].icon }" />
								<span class="text">${hangyeList[2].name }</span>
							</a>
						</div>
						<div class="cols">
							<a data-tan="61" data-col="6" style="background-color:${hangyeList[3].color }" class="item col6" href="<%= path %>/action/consultation/detail?id=${hangyeList[3].id}">
								<img class="icon" src="${preview}${hangyeList[3].icon }" />
								<span class="text">${hangyeList[3].name }</span>
							</a>
							<a data-tan="61" data-col="6" style="background-color:${hangyeList[4].color }" class="item col6" href="<%= path %>/action/consultation/detail?id=${hangyeList[4].id}">
								<img class="icon" src="${preview}${hangyeList[4].icon }" />
								<span class="text">${hangyeList[4].name }</span>
							</a>
						</div>
						<div class="cols">
							<a data-col="6" style="background-color:${hangyeList[5].color }" class="item col6" href="<%= path %>/action/consultation/detail?id=${hangyeList[5].id}">
								<img class="icon" src="${preview}${hangyeList[5].icon }" />
								<span class="text">${hangyeList[5].name }</span>
							</a>
							<div class="col6 rows">
								<div class="cols">
									<a data-col="3" style="background-color:${hangyeList[6].color }" class="item col3" href="<%= path %>/action/consultation/detail?id=${hangyeList[6].id}">
										<img class="icon" src="${preview}${hangyeList[6].icon }" />
										<span class="text">${hangyeList[6].name }</span>
									</a>
									<a data-col="3" style="background-color:${hangyeList[7].color }" class="item col3" href="<%= path %>/action/consultation/detail?id=${hangyeList[7].id}">
										<img class="icon" src="${preview}${hangyeList[7].icon }" />
										<span class="text">${hangyeList[7].name }</span>
									</a>
								</div>
								<div class="cols">
									<a data-col="3" style="background-color:${hangyeList[8].color }" class="item col3" href="<%= path %>/action/consultation/detail?id=${hangyeList[8].id}">
										<img class="icon" src="${preview}${hangyeList[8].icon }" />
										<span class="text">${hangyeList[8].name }</span>
									</a>
									<a data-col="3" style="background-color:${hangyeList[9].color }" class="item col3" href="<%= path %>/action/consultation/detail?id=${hangyeList[9].id}">
										<img class="icon" src="${preview}${hangyeList[9].icon }" />
										<span class="text">${hangyeList[9].name }</span>
									</a>
								</div>
							</div>
						</div>
					</div>
		      	</div>
				<div class="swiper-slide">
					<div class="ui-grid">
						<div class="cols">
							<a data-tan="66" data-col="4" style="background-color:${xuekeList[0].color }" class="item col4" href="<%= path %>/action/consultation/detail?id=${xuekeList[0].id}">
								<img class="icon" src="${preview}${xuekeList[0].icon }" />
								<span class="text">${xuekeList[0].name }</span>
							</a>
							<a data-tan="66" data-col="4" style="background-color:${xuekeList[1].color };" class="item col4" href="<%= path %>/action/consultation/detail?id=${xuekeList[1].id}">
								<img class="icon" src="${preview}${xuekeList[1].icon }" />
								<span class="text">${xuekeList[1].name }</span>
							</a>
							<a data-tan="66" data-col="4" style="background-color:${xuekeList[2].color }" class="item col4" href="<%= path %>/action/consultation/detail?id=${xuekeList[2].id}">
								<img class="icon" src="${preview}${xuekeList[2].icon }" />
								<span class="text">${xuekeList[2].name }</span>
							</a>
						</div>
						<div class="cols">
							<a data-tan="61" data-col="6" style="background-color:${xuekeList[3].color }" class="item col6" href="<%= path %>/action/consultation/detail?id=${xuekeList[3].id}">
								<img class="icon" src="${preview}${xuekeList[3].icon }" />
								<span class="text">${xuekeList[3].name }</span>
							</a>
							<a data-tan="61" data-col="6" style="background-color:${xuekeList[4].color }" class="item col6" href="<%= path %>/action/consultation/detail?id=${xuekeList[4].id}">
								<img class="icon" src="${preview}${xuekeList[4].icon }" />
								<span class="text">${xuekeList[4].name }</span>
							</a>
						</div>
						<div class="cols">
							<a data-col="6" style="background-color:${xuekeList[5].color }" class="item col6" href="<%= path %>/action/consultation/detail?id=${xuekeList[5].id}">
								<img class="icon" src="${preview}${xuekeList[5].icon }" />
								<span class="text">${xuekeList[5].name }</span>
							</a>
							<div class="col6 rows">
								<div class="cols">
									<a data-col="6" data-tan="50" style="background-color:${xuekeList[6].color }" class="item col3" href="<%= path %>/action/consultation/detail?id=${xuekeList[6].id}">
										<img class="icon" src="${preview}${xuekeList[6].icon }" />
										<span class="text">${xuekeList[6].name }</span>
									</a>
								</div>
								<div class="cols">
									<a data-col="3" style="background-color:${xuekeList[7].color }" class="item col3" href="<%= path %>/action/consultation/detail?id=${xuekeList[7].id}">
										<img class="icon" src="${preview}${xuekeList[7].icon }" />
										<span class="text">${xuekeList[7].name }</span>
									</a>
									<a data-col="3" style="background-color:${xuekeList[8].color }" class="item col3" href="<%= path %>/action/consultation/detail?id=${xuekeList[8].id}">
										<img class="icon" src="${preview}${xuekeList[8].icon }" />
										<span class="text">${xuekeList[8].name }</span>
									</a>
								</div>
							</div>
						</div>
					</div>
		      	</div>
	      	</div>
		</div>
		<script src="<%= path %>/js/jquery.min.js"></script>
		<script src="<%= path %>/js/idangerous.swiper.min.js"></script>
		<script src="<%= path %>/js/main.js"></script>
		<script src="<%= path %>/js/consultation.js"></script>
		<script>new Consultation().init();</script>
	</body>
</html>
