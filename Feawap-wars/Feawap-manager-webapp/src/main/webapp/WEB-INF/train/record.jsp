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
	<li>CAE培训管理</li>
	<li>培训&amp;专题研讨会</li>
</c:set>
<c:set var="content" scope="request">
	<div class="page-header">
		<h1>
			<i class="icon-book"></i> CAE培训管理
			<small>
				<i class="icon-double-angle-right"></i>
				<a href="<%=path%>/action/train">培训&amp;专题研讨会</a>
				<i class="icon-double-angle-right"></i>
				新建/编辑
			</small>
		</h1>
	</div><!-- /.page-header -->

	<form id="form" class="form-horizontal" role="form" action="<%=path%>/action/train/save" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-title">培训标题</label>
			<div class="col-sm-9">
				<input type="text" name="title" value="${record.title }" id="form-field-title" class="col-xs-10 col-sm-5"/>
			</div>
		</div>
		
		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-type"></label>
			<div class="col-sm-9">
				<label>
					<input name="type_check" type="checkbox" class="ace" value="1" <c:if test="${record.type==1 }">checked="checked"</c:if> />
					<span class="lbl"> 线上培训</span>
				</label>
				&nbsp;
				<label>
					<input name="type_check" type="checkbox" class="ace" value="2" <c:if test="${record.type==2 }">checked="checked"</c:if> />
					<span class="lbl"> 线下培训</span>
				</label>
				&nbsp;
				<label>
					<input name="type_check" type="checkbox" class="ace" value="3" <c:if test="${record.type==3 }">checked="checked"</c:if> />
					<span class="lbl"> 专题研讨会</span>
				</label>
			</div>
		</div>
		
		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-daterange">培训时间</label>
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
			<label class="col-sm-2 control-label no-padding-right" for="form-field-peoples">培训人数</label>
			<div class="col-sm-9">
				<input type="text" name="peoples" value="${record.peoples }" id="form-field-peoples" class="input-mini" />
			</div>
		</div>
		
		<div class="space-4"></div>

		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-cost">培训费用</label>
			<div class="col-sm-9">
				<input type="text" name="cost" value="${record.cost }" id="form-field-cost" class="input-mini" />
			</div>
		</div>
		
		<div class="space-4"></div>

		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-place">培训地点</label>
			<div class="col-sm-9">
				<input type="text" name="place" value="${record.place }" id="form-field-place" class="col-xs-10 col-sm-5" />
			</div>
		</div>
		
		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-address">详细地址</label>
			<div class="col-sm-9">
				<input type="text" name="address" value="${record.address }" id="form-field-address" class="col-xs-10 col-sm-5"/>
			</div>
		</div>
		
		<div class="space-4"></div>	
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="editor">培训详情</label>
			<div class="col-sm-9">
				<script id="editor" name="description" type="text/plain">${record.description}</script>
			</div>
		</div>
		
		<div class="space-4"></div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right" for="form-field-hotels">酒店列表</label>
			<div class="col-sm-9">
				<p>
					<button id="form-hotels-add" class="btn btn-xs btn-primary" type="button">
						<i class="icon-plus"></i>
						增加
					</button>
				</p>
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
    	UEDITOR_CONFIG.serverUrl = "<%=path%>/action/ueUpload?folder=train";
    </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>
    
	<script type="text/javascript" src="<%=path%>/plugin/jquery/jquery.form.js"></script>
	
	<!-- page js -->
	<script src="<%=path%>/plugin/ace/js/fuelux/fuelux.spinner.min.js"></script>
	<script src="<%=path%>/plugin/ace/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="<%=path%>/plugin/ace/js/date-time/moment.min.js"></script>
	<script src="<%=path%>/plugin/ace/js/date-time/daterangepicker.min.js"></script>
	<script src="<%=path%>/plugin/json/json2.js"></script>
	
	<script type="text/javascript">
		jQuery(function($) {
			var trainPeoples = parseInt(${record.peoples });
			if(isNaN(trainPeoples)) {
				trainPeoples = 0;
			}

			var trainCost = parseInt(${record.cost });
			if(isNaN(trainCost)) {
				trainCost = 0;
			}
			
			//初始化checkbox
			$("#form input[name='type_check']").change(function() {
				var s = $(this).prop("checked");
				$("#form input[name='type_check']").prop("checked", false);
				$(this).prop("checked", s);
			});
			
			//初始化spinner
			$('#form-field-peoples').ace_spinner({
				value: trainPeoples,
				min: 0,
				max: 10000,
				step: 1,
				on_sides: true,
				icon_up:'icon-plus smaller-75',
				icon_down:'icon-minus smaller-75',
				btn_up_class:'btn-success',
				btn_down_class:'btn-danger'
			});

			$('#form-field-cost').ace_spinner({
				value: trainCost,
				min: 0,
				max: 100000000,
				step: 100,
				touch_spinner: true,
				icon_up:'icon-caret-up',
				icon_down:'icon-caret-down',
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
			
			//初始化酒店列表
			var hotels = [];
			<c:if test="${not empty record.hotels}">
			hotels = ${record.hotels};
			</c:if>
			
			$.each(hotels, function(i, v) {
				$("#form-hotels-add").parent().before(
					$("<p>").append(
						$("<input type='text' name='hotels'/>").val(v)
					).append(
						$("<button class='btn btn-xs btn-link'><i class='icon-trash'></i>删除</button>").click(function(){
							$(this).parent().remove();
						})
					)
				);
			});

			$("#form-hotels-add").click(function(){
				$(this).parent().before(
					$("<p>").append(
						$("<input type='text' name='hotels'/>")
					).append(
						$("<button class='btn btn-xs btn-link'><i class='icon-trash'></i>删除</button>").click(function(){
							$(this).parent().remove();
						})
					)
				);
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
											location.href = "<%=path%>/action/train";
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
	<jsp:param value="CAE培训管理 - 培训&amp;专题研讨会" name="title"/>
	<jsp:param value="4_1" name="current"/>
</jsp:include>