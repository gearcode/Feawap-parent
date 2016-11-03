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
	<link rel="stylesheet" href="<%=path%>/plugin/ace/css/datepicker.css" />
	<link rel="stylesheet" href="<%=path%>/plugin/ace/css/daterangepicker.css" />
</c:set>
<c:set var="breadcrumbs" scope="request">
	<li>
		<i class="icon-home home-icon"></i>
		<a href="<%=path%>">首页</a>
	</li>
	<li>
		<a href="<%=path%>/action/recuitment">招聘信息</a>
	</li>
	<li class="active">发布招聘信息</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-group"></i> 招聘信息管理
			<small>
				<i class="icon-double-angle-right"></i>
				<a href="<%=path%>/action/recuitment">招聘信息</a>
				<i class="icon-double-angle-right"></i>
				发布招聘信息
			</small>
		</h1>
	</div><!-- /.page-header -->

	<form id="form" class="form-horizontal" role="form" action="<%=path%>/action/recuitment/save" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-title">职位名称</label>
			<div class="col-sm-9">
				<input type="text" name="title" value="${record.title }" id="form-field-title" class="col-xs-10 col-sm-5"/>
			</div>
		</div>
		
		<div class="space-4"></div>

		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-count">招聘人数</label>
			<div class="col-sm-9">
				<input type="text" name="count" value="${record.count }" id="form-field-count" class="input-mini" />
			</div>
		</div>
		
		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-daterange">招聘时间</label>
			<div class="col-sm-9">
				<div class="input-group" style="width: 280px;">
					<input type="text" name="daterange" id="form-field-daterange" value="<c:if test='${not empty record.start && not empty record.end }' ><fmt:formatDate pattern="yyyy年MM月dd日" value="${record.start }"/> - <fmt:formatDate pattern="yyyy年MM月dd日" value="${record.end }"/></c:if>" class="form-control" readonly="" style="cursor: pointer;" />
					<span class="input-group-addon">
						<i class="icon-calendar bigger-110"></i>
					</span>
				</div>
				
			</div>
		</div>
		
		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-address">入职地点</label>
			<div class="col-sm-9">
				<input type="text" name="address" value="${record.address }" id="form-field-address" class="col-xs-10 col-sm-5"/>
			</div>
		</div>
		
		<div class="space-4"></div>	
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="editor">详细信息</label>
			<div class="col-sm-9">
				<script id="editor" name="description" type="text/plain">${record.description}</script>
			</div>
		</div>
		
		<div class="clearfix form-actions">
			<div class="col-md-offset-3 col-md-9">
				<input type="hidden" name="id" value="${record.id }" />
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
    	UEDITOR_CONFIG.serverUrl = "<%=path%>/action/ueUpload?folder=recuitment";
    </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>
    
	<script type="text/javascript" src="<%=path%>/plugin/jquery/jquery.form.js"></script>
	
	<!-- page js -->
	<script src="<%=path%>/plugin/ace/js/fuelux/fuelux.spinner.min.js"></script>
	<script src="<%=path%>/plugin/ace/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="<%=path%>/plugin/ace/js/date-time/moment.min.js"></script>
	<script src="<%=path%>/plugin/ace/js/date-time/daterangepicker.min.js"></script>
	
	<script type="text/javascript">
		jQuery(function($) {
			var recuitmentCount = parseInt(${record.count });
			if(isNaN(recuitmentCount)) {
				recuitmentCount = 0;
			}
			
			//初始化spinner
			$('#form-field-count').ace_spinner({
				value: recuitmentCount,
				min: 0,
				max: 10000,
				step: 1,
				on_sides: true,
				icon_up:'icon-plus smaller-75',
				icon_down:'icon-minus smaller-75',
				btn_up_class:'btn-success',
				btn_down_class:'btn-danger'
			});
			
			//初始化日期选择
			$("#form-field-daterange").daterangepicker({
				format: 'YYYY年MM月DD日',
				locale: {
					applyLabel: '确定',
					cancelLabel: '取消',
					fromLabel: '起始',
					toLabel: '结束',
					customRangeLabel: '自定义',
					daysOfWeek: ['日', '一', '二', '三', '四', '五','六'],
					monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
					firstDay: 1
				}
			}, function(start, end, label) {
				//alert('A date range was chosen: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
			}).next().on(ace.click_event, function(){
				$(this).prev().focus();
			});
			
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
											location.href = "<%=path%>/action/recuitment";
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
	<jsp:param value="发布招聘信息" name="title"/>
	<jsp:param value="6_1" name="current"/>
</jsp:include>