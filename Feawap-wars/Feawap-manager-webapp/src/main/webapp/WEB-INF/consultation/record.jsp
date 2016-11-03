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
	<link rel="stylesheet" href="<%=path %>/plugin/ace/css/colorpicker.css" />
</c:set>
<c:set var="breadcrumbs" scope="request">
	<li>
		<i class="icon-home home-icon"></i>
		<a href="<%=path%>">首页</a>
	</li>
	<li class="active">CAE咨询管理</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-cubes"></i> CAE咨询管理
			<small>
				<i class="icon-double-angle-right"></i>
				编辑咨询
			</small>
		</h1>
	</div><!-- /.page-header -->
	
	<c:choose>
		<c:when test="${empty record }">
			<div class="alert alert-danger">
				<i class="icon-frown"></i>
				没有找到该咨询，请与管理员联系！
			</div>
		</c:when>
		<c:otherwise>
			<form id="form" class="form-horizontal" role="form" action="<%=path%>/action/consultation/save" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-name">咨询名称</label>
					<div class="col-sm-9">
						<input type="text" name="name" value="${record.name }" id="form-field-name" class="col-xs-10 col-sm-5" readonly="true" />
						<span class="help-inline col-sm-7">
							<label class="middle">
								<input class="ace" name="check-name" type="checkbox" id="id-disable-check-recordname" />
								<span class="lbl">&nbsp;修改此项</span>
							</label>
						</span>
					</div>
				</div>
				
				<div class="space-4"></div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="form-field-icon">咨询图标</label>
					<div class="col-sm-9">
						<div class="fileinput fileinput-new" data-provides="fileinput">
							<div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 100px; height: 100px;">
								<c:choose>
									<c:when test="${empty record.icon }">点击上传</c:when>
									<c:otherwise>
										<img src="<%=CustomizedPropertyPlaceholderConfigurer.getPropertyValue("upload.preview") %>${record.icon}" />
									</c:otherwise>
								</c:choose>
							</div>
							<div>
								<span class="btn btn-default btn-file"><span class="fileinput-new">选择图片</span><span class="fileinput-exists">替换</span>
								<input name="icon" type="file" id="id-input-file-1" /></span>
								<a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">删除</a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="colorpicker1">背景颜色</label>
					<div class="col-sm-9">
						<div class="bootstrap-colorpicker">
							<input id="colorpicker1" name="color" value="${record.color }" type="text" class="input-small" />
						</div>
					</div>
				</div>
				
				<div class="space-4"></div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="editor">咨询正文</label>
					<div class="col-sm-9">
						<script id="editor" name="content" type="text/plain">${record.content}</script>
					</div>
				</div>
				
				<div class="clearfix form-actions">
					<div class="col-md-offset-3 col-md-9">
						<input type="hidden" name="id" value="${record.id }" />
						<button class="btn btn-info" type="submit">
							<i class="icon-ok bigger-110"></i>
							保存
						</button>
						&nbsp;&nbsp;&nbsp;
						<i class="icon-time green bigger-110"></i>
						上次修改时间: <span id="lastUpdate"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${record.updateTime}"/></span>
					</div>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
	
	<!-- dialog -->
	<div id="dialog-message" class="hide">
		<p class="center hr-10 bigger-130 bolder"><i class="icon-ok-sign green"></i>&nbsp;保存成功！</p>
	</div><!-- #dialog-message -->
</c:set>
<c:set var="javascript" scope="request">

	<!-- ueditor -->
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/ueditor.config.js"></script>
    <script type="text/javascript">
    	UEDITOR_CONFIG.serverUrl = "<%=path%>/action/ueUpload?folder=consultation/images";
    </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>
    
	<script type="text/javascript" src="<%=path%>/plugin/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/plugin/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/plugin/ace/js/bootstrap-colorpicker.min.js"></script>
	
	<script type="text/javascript">
		jQuery(function($) {
			//初始化上传图片组件
			$("#form .fileinput").fileinput({
				name: "icon"
			});

			//初始化颜色选择组件
			$('#colorpicker1').colorpicker();
			
			//初始化编辑器
			var ue = UE.getEditor('editor', {
			});
			
			$("#id-disable-check-recordname").click(function(){
				var check = $(this), input = check.parent().parent().prev();
				console.log(input);
				if(check.prop("checked")) {
					input.prop("readonly", false);
				} else {
					input.prop("readonly", true);
				}
			});
			
			$("#form").on("submit", function(e) {
				$(this).ajaxSubmit({
					success: function(response, status, xhr, $form) {
						if(response.result == "success") {
							//更新时间
							$("#lastUpdate").html(response.updateTime);
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
	<jsp:param value="CAE咨询管理" name="title"/>
</jsp:include>