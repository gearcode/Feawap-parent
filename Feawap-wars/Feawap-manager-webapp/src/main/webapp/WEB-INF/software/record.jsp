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
	<li>
		<a href="<%=path%>/action/software">CAE软件管理</a>
	</li>
	<li class="active">编辑软件信息</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-windows"></i> CAE软件管理
			<small>
				<i class="icon-double-angle-right"></i>
				编辑软件信息
			</small>
		</h1>
	</div><!-- /.page-header -->

	<form id="form" class="form-horizontal" role="form" action="<%=path%>/action/software/save" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-title">软件标题</label>
			<div class="col-sm-9">
				<input type="text" name="title" value="${record.title }" id="form-field-title" placeholder="软件标题" class="col-xs-10 col-sm-5" />
			</div>
		</div>

		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-name">软件名称</label>
			<div class="col-sm-9">
				<input type="text" name="name" value="${record.name }" id="form-field-name" placeholder="软件名称" class="col-xs-10 col-sm-5" />
			</div>
		</div>

		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="id-input-file-1">软件图标</label>
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
			<label class="col-sm-2 control-label no-padding-right"></label>
			<div class="col-sm-9">
				<div class="tabbable">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active">
							<a data-toggle="tab" href="#tab_description">
								软件介绍
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#tab_application">
								行业应用
							</a>
						</li>
						<li>
							<a data-toggle="tab" href="#tab_case_analysis">
								案例分析
							</a>
						</li>
					</ul>

					<div class="tab-content">
						<div id="tab_description" class="tab-pane in active">
							<script id="editor_description" name="description" type="text/plain">${record.description}</script>
						</div>
						<div id="tab_application" class="tab-pane">
							<script id="editor_application" name="application" type="text/plain">${record.application}</script>
						</div>
						<div id="tab_case_analysis" class="tab-pane">
							<script id="editor_case_analysis" name="case_analysis" type="text/plain">${record.caseAnalysis}</script>
						</div>
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

	<!-- ueditor -->
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/ueditor.config.js"></script>
    <script type="text/javascript">
    	UEDITOR_CONFIG.serverUrl = "<%=path%>/action/ueUpload?folder=software/images";
    </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>

	<!-- jquery 图片预览组件 -->    
	<script type="text/javascript" src="<%=path%>/plugin/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>
	<!-- jquery ajax表单组件 -->
	<script type="text/javascript" src="<%=path%>/plugin/jquery/jquery.form.js"></script>
	<!-- boostrap 颜色选择组件 -->
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
			var ue_desc = UE.getEditor('editor_description', {
			});

			var ue_app = UE.getEditor('editor_application', {
			});

			var ue_app = UE.getEditor('editor_case_analysis', {
			});
			
			$("#form").on("reset", function(e) {
			}).on("submit", function(e) {
				$(this).ajaxSubmit({
					success: function(response, statusText, xhr, $form) {
						if(response.result == "success") {
							
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
											location.href = "<%=path%>/action/software";
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
	<jsp:param value="CAE软件管理" name="title"/>
	<jsp:param value="3" name="current"/>
</jsp:include>