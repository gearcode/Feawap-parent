<%@ page language="java" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/common/head.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="/WEB-INF/common/top_nav.jsp"></jsp:include>

		<div class="main-container" id="main-container">

			<div class="main-container-inner">
			
			<jsp:include page="/WEB-INF/common/side_bar.jsp"></jsp:include>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">后台管理系统使用说明</li>
						</ul><!-- .breadcrumb -->

					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<jsp:include page="/WEB-INF/common/js_include.jsp"></jsp:include>
		<!-- inline scripts related to this page -->
	</body>
</html>
