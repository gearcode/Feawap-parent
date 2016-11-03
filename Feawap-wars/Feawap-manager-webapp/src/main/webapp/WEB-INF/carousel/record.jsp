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
	<link rel="stylesheet" href="<%=path %>/plugin/jasny-bootstrap/css/jasny-bootstrap.min.css" />
</c:set>
<c:set var="breadcrumbs" scope="request">
	<li>
		<i class="icon-home home-icon"></i>
		<a href="<%=path%>">首页</a>
	</li>
	<li>
		<a href="<%=path%>/action/carousel">轮播广告管理</a>
	</li>
	<li class="active">编辑轮播广告</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-picture"></i> 轮播广告管理
			<small>
				<i class="icon-double-angle-right"></i>
				编辑轮播广告
			</small>
		</h1>
	</div><!-- /.page-header -->

	<form id="form" class="form-horizontal" role="form" action="<%=path%>/action/carousel/save" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-field-title">广告标题</label>
			<div class="col-sm-9">
				<input type="text" name="title" value="${record.title }" id="form-field-title" placeholder="广告标题" class="col-xs-10 col-sm-5" />
			</div>
		</div>

		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-field-url">广告链接</label>
			<div class="col-sm-9">
				<input type="text" name="url" value="${record.url }" id="form-field-url" placeholder="广告链接" class="col-xs-10 col-sm-5" />
			</div>
		</div>

		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="form-field-title">广告图片</label>
			<div class="col-sm-9">
				<div class="fileinput fileinput-new" data-provides="fileinput">
					<div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 320px; height: 150px;">
						<c:choose>
							<c:when test="${empty record.pic }">点击上传</c:when>
							<c:otherwise>
								<img src="<%=CustomizedPropertyPlaceholderConfigurer.getPropertyValue("upload.preview") %>${record.pic}" />
							</c:otherwise>
						</c:choose>
					</div>
					<div>
						<span class="btn btn-default btn-file"><span class="fileinput-new">选择图片</span><span class="fileinput-exists">替换</span>
						<input name="pic" type="file" id="id-input-file-1" /></span>
						<a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">删除</a>
					</div>
				</div>
			</div>
		</div>

		<div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
				<c:if test="${!empty record.id}">
					<input type="hidden" name="id" value="${record.id }" />
				</c:if>
				<button class="btn btn-info" type="submit">
					<i class="icon-ok bigger-110"></i>
					保存
				</button>
				&nbsp; &nbsp; &nbsp;
				<button class="btn" type="reset">
					<i class="icon-undo bigger-110"></i>
					重置
				</button>
			</div>
		</div>
	</form>

	<!-- dialog -->
	<div id="dialog-message" class="hide">
		<p class="center hr-10 bigger-130 bolder"><i class="icon-ok-sign green"></i>&nbsp;保存成功！</p>
	</div><!-- #dialog-message -->
</c:set>
<c:set var="javascript" scope="request">

	<script type="text/javascript" src="<%=path%>/plugin/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/plugin/jquery/jquery.form.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			$("#form .fileinput").fileinput({
				name: "pic"
			});
			
			$("#form").on("reset", function(e) {
			}).on("submit", function(e) {
				$(this).ajaxSubmit({
					success: function(responseText, statusText, xhr, $form) {
						if(responseText == "success") {
							
							//弹出窗口
							var dialog = $("#dialog-message").removeClass('hide').dialog({
								modal: true,
								title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>操作成功</h4></div>",
								title_html: true,
								buttons: [ 
									{
										text: "关闭",
										"class" : "btn btn-xs",
										click: function() {
											$( this ).dialog( "close" ); 
										} 
									},
									{
										text: "返回列表",
										"class" : "btn btn-primary btn-xs",
										click: function() {
											location.href = "<%=path%>/action/carousel";
											$( this ).dialog( "close" );
										} 
									}
								]
							});
							
						}
					}
				});
				return false;
			});
		});
	</script>
</c:set>
<jsp:include page="/WEB-INF/common/main.jsp">
	<jsp:param value="轮播广告管理" name="title"/>
	<jsp:param value="1" name="current"/>
</jsp:include>