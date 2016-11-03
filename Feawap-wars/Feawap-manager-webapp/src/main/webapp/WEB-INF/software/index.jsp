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
	<li class="active">CAE软件管理</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-windows"></i> CAE软件管理
			<small>
				<i class="icon-double-angle-right"></i>
				软件列表
			</small>
		</h1>
	</div><!-- /.page-header -->
	
	<c:choose>
		<c:when test="${empty list}">
			<div class="alert alert-info">
				<button type="button" class="close" data-dismiss="alert">
					<i class="icon-remove"></i>
				</button>
				还没有添加任何软件！请点击
				<a href="<%=path %>/action/software/record" class="btn btn-xs btn-primary"><i class="icon-plus"></i> 添加</a>
				新增软件
			</div>
		</c:when>
		<c:otherwise>
			<h3>
				<a href="<%=path %>/action/software/record" class="btn btn-xs btn-primary"><i class="icon-plus"></i> 添加</a>
			</h3>
			<div>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>软件标题</th>
							<th>软件名称</th>
							<th>背景色</th>
							<th>修改时间</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${list}">
							<tr>
								<td>${record.id }</td>
								<td>${record.title }</td>
								<td>${record.name }</td>
								<td>
									<span class="label" style="background-color: ${record.color} !important">
										<i class="icon-tag"></i>
										${record.color }
									</span>
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${record.updateTime}"/>
								</td>
								<td>
									<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
										<a href="<%=path %>/action/software/record?id=${record.id}" class="btn btn-xs btn-info">
											<i class="icon-edit bigger-120"></i>
										</a>
										<a href="javascript: remove(${record.id})" class="btn btn-xs btn-danger">
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
													<a href="<%=path %>/action/software/record?id=${record.id}" class="tooltip-success" data-rel="tooltip" title="" data-original-title="Edit">
														<span class="green">
															<i class="icon-edit bigger-120"></i>
														</span>
													</a>
												</li>
												<li>
													<a href="javascript: remove(${record.id})" class="tooltip-error" data-rel="tooltip" title="" data-original-title="Delete">
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
							window.location.href = "<%=path %>/action/software/delete?id=" + id;
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
	<jsp:param value="CAE软件管理" name="title"/>
	<jsp:param value="3" name="current"/>
</jsp:include>