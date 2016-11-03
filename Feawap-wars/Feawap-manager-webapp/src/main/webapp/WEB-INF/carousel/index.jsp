<%@page import="com.gearcode.feawap.util.CustomizedPropertyPlaceholderConfigurer"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
%>
<c:set var="head" scope="request">
	<!-- page specific plugin styles -->
	<style type="text/css">
		table.table img {
			max-width: 100%;
		}
	</style>
</c:set>
<c:set var="breadcrumbs" scope="request">
	<li>
		<i class="icon-home home-icon"></i>
		<a href="<%=path%>">首页</a>
	</li>
	<li class="active">轮播广告管理</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-picture"></i> 轮播广告管理
			<small>
				<i class="icon-double-angle-right"></i>
				广告列表
			</small>
		</h1>
	</div><!-- /.page-header -->
	
	<c:choose>
		<c:when test="${empty list}">
			<div class="alert alert-info">
				<button type="button" class="close" data-dismiss="alert">
					<i class="icon-remove"></i>
				</button>
				还没有添加任何轮播广告！请点击
				<a href="<%=path %>/action/carousel/record" class="btn btn-xs btn-primary"><i class="icon-plus"></i> 添加</a>
				新增轮播广告
			</div>
		</c:when>
		<c:otherwise>
			<h3>
				<a href="<%=path %>/action/carousel/record" class="btn btn-xs btn-primary"><i class="icon-plus"></i> 添加</a>
			</h3>
			<div>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>广告标题</th>
							<th>点击链接</th>
							<th style="width: 200px;">广告图片</th>
							<th>创建时间</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="carousel" items="${list}">
							<tr>
								<td>${carousel.id }</td>
								<td>${carousel.title }</td>
								<td><a target="_blank" href="${carousel.url }">${carousel.url }</a></td>
								<td><img src="<%=CustomizedPropertyPlaceholderConfigurer.getPropertyValue("upload.preview") %>${carousel.pic }"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${carousel.created}"/></td>
								<td>
									<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
										<a href="<%=path %>/action/carousel/record?id=${carousel.id}" class="btn btn-xs btn-info">
											<i class="icon-edit bigger-120"></i>
										</a>
										<a href="javascript: remove(${carousel.id})" class="btn btn-xs btn-danger">
											<i class="icon-trash bigger-120"></i>
										</a>
									</div>
									<div class="visible-xs visible-sm hidden-md hidden-lg">
										<div class="inline position-relative">
											<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
												<i class="icon-cog icon-only bigger-110"></i>
											</button>
											<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
												<li>
													<a href="<%=path %>/action/carousel/record?id=${carousel.id}" class="tooltip-success" data-rel="tooltip" title="" data-original-title="Edit">
														<span class="green">
															<i class="icon-edit bigger-120"></i>
														</span>
													</a>
												</li>
												<li>
													<a href="javascript: remove(${carousel.id})" class="tooltip-error" data-rel="tooltip" title="" data-original-title="Delete">
														<span class="red">
															<i class="icon-trash bigger-120"></i>
														</span>
													</a>
												</li>
											</ul>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:otherwise>
	</c:choose>

	<!-- confirm delete -->
	<div id="dialog-confirm" class="hide">
		<div class="alert alert-info bigger-110">
			确认删除吗？删除后不可恢复！
		</div>
		<p class="bigger-110 bolder center grey">
			<i class="icon-hand-right blue bigger-120"></i>
			确认删除？
		</p>
	</div><!-- #dialog-confirm -->
</c:set>
<c:set var="javascript" scope="request">
	<script type="text/javascript">
		function remove(id) {
			$( "#dialog-confirm" ).removeClass('hide').dialog({
				resizable: false,
				modal: true,
				title: "<div class='widget-header'><h4 class='smaller'><i class='icon-warning-sign red'></i>确认删除？</h4></div>",
				title_html: true,
				buttons: [
					{
						html: "<i class='icon-trash bigger-110'></i>&nbsp;删除",
						"class" : "btn btn-danger btn-xs",
						click: function() {
							window.location.href = "<%=path %>/action/carousel/delete?id=" + id;
						}
					}
					,
					{
						html: "<i class='icon-remove bigger-110'></i>&nbsp;取消",
						"class" : "btn btn-xs",
						click: function() {
							$( this ).dialog( "close" );
						}
					}
				]
			});
		}
	</script>
</c:set>
<jsp:include page="/WEB-INF/common/main.jsp">
	<jsp:param value="轮播广告管理" name="title"/>
	<jsp:param value="1" name="current"/>
</jsp:include>