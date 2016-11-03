<%@page import="com.gearcode.feawap.domain.News"%>
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
</c:set>
<c:set var="breadcrumbs" scope="request">
	<li>
		<i class="icon-home home-icon"></i>
		<a href="<%=path%>">首页</a>
	</li>
	<li class="active">
		<a href="<%=path%>/action/train/news">培训动态</a>
	</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-book"></i> 培训动态管理
		</h1>
	</div><!-- /.page-header -->

	<form id="form" class="form-horizontal" role="form" action="<%=path%>/action/train/news/save" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-title">新闻标题</label>
			<div class="col-sm-9">
				<input type="text" name="title" value="${record.title }" id="form-field-title" class="col-xs-10 col-sm-5"/>
			</div>
		</div>
		
		<div class="space-4"></div>

		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="editor">新闻内容</label>
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
				<c:if test="${empty record }">
					<span id="lastUpdate" class="hidden">
						&nbsp;&nbsp;&nbsp;
						<i class="icon-time green bigger-110"></i>
						上次修改时间: <span class="time"></span>
					</span>
				</c:if>
				<c:if test="${not empty record }">
					<span id="lastUpdate">
						&nbsp;&nbsp;&nbsp;
						<i class="icon-time green bigger-110"></i>
						上次修改时间: <span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${record.updateTime}"/></span>
					</span>
				</c:if>
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
    	UEDITOR_CONFIG.serverUrl = "<%=path%>/action/ueUpload?folder=train/news";
    </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>
    
	<script type="text/javascript" src="<%=path%>/plugin/jquery/jquery.form.js"></script>
	
	<!-- page js -->
	<script type="text/javascript">
		jQuery(function($) {
			//初始化编辑器
			var ue = UE.getEditor('editor', {
			});
			
			$("#form").on("submit", function(e) {
				$(this).ajaxSubmit({
					success: function(response, status, xhr, $form) {
						if(response.result == "success") {
							//更新时间
							$("#lastUpdate").removeClass("hidden").children(".time").html(response.updateTime);
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
											location.href = "<%=path%>/action/train/news";
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
	<jsp:param value="CAE培训管理 - 培训动态" name="title"/>
	<jsp:param value="4_2" name="current"/>
</jsp:include>