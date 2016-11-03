<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	request.setCharacterEncoding("UTF-8");
	String navClass = request.getParameter("nav");
	if(navClass!=null&&!navClass.isEmpty()){
		navClass = " ui-slide-nav-"+navClass;
	}
	else {
		navClass = "";
	}
%>
<div class="ui-slide h170">
	<div class="ui-slide-border">
		<div class="ui-slide-wrapper">
			<c:forEach var="record" items="${carouselList}">
			<div class="ui-slide-item">
				<a href="${record.url}">
					<img src="${preview}${record.pic }" alt="${record.title }">
				</a>
			</div>
			</c:forEach>
		</div>
	</div>
	<div class="ui-slide-nav<%= navClass %>"></div>
</div>