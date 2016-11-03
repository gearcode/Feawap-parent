<%@ page language="java" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String current = request.getParameter("current");
	if(current == null) current = "";
%>
<div class="sidebar" id="sidebar">
	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>

			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>
	
			<span class="btn btn-info"></span>
	
			<span class="btn btn-warning"></span>
	
			<span class="btn btn-danger"></span>
		</div>
	</div><!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li<%=current.equals("1")?" class='active'":"" %>>
			<a href="<%=path%>/action/carousel">
				<i class="icon-picture"></i>
				<span class="menu-text">轮播广告管理</span>
			</a>
		</li>

		<li<%=current.startsWith("2")?" class='active open'":"" %>>
			<a href="javascript:void(0)" class="dropdown-toggle">
				<i class="icon-cubes"></i>
				<span class="menu-text">CAE咨询管理</span>
				
				<b class="arrow icon-angle-down"></b>
			</a>
			
			<ul class="submenu">
				<li<%=current.startsWith("2_1")?" class='active open'":"" %>>
					<a href="#" class="dropdown-toggle">
						<i class="icon-double-angle-right"></i>
						<i class="icon-plane"></i>
						按行业分类
						<b class="arrow icon-angle-down"></b>
					</a>

					<ul class="submenu">
						<li<%=current.equals("2_1_1")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=tmjz&current=2_1_1">土木建筑</a></li>
						<li<%=current.equals("2_1_2")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=fnfd&current=2_1_2">风能风电</a></li>
						<li<%=current.equals("2_1_3")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=dzdq&current=2_1_3">电子电器</a></li>
						<li<%=current.equals("2_1_4")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=cbhg&current=2_1_4">船舶海工</a></li>
						<li<%=current.equals("2_1_5")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qccl&current=2_1_5">汽车车辆</a></li>
						<li<%=current.equals("2_1_6")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=hthk&current=2_1_6">航天航空</a></li>
						<li<%=current.equals("2_1_7")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=sysh&current=2_1_7">石油石化</a></li>
						<li<%=current.equals("2_1_8")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=nyzb&current=2_1_8">能源装备</a></li>
						<li<%=current.equals("2_1_9")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=djsj&current=2_1_9">电机设计</a></li>
						<li<%=current.equals("2_1_10")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=swyl&current=2_1_10">生物医疗</a></li>
					</ul>
				</li>
				
				<li<%=current.startsWith("2_2")?" class='active open'":"" %>>
					<a href="#" class="dropdown-toggle">
						<i class="icon-double-angle-right"></i>
						<i class="icon-beaker"></i>
						按学科分类
						<b class="arrow icon-angle-down"></b>
					</a>

					<ul class="submenu">
						<li<%=current.equals("2_2_1")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_1">前处理</a></li>
						<li<%=current.equals("2_2_2")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_2">后处理</a></li>
						<li<%=current.equals("2_2_3")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_3">电机电磁分析</a></li>
						<li<%=current.equals("2_2_4")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_4">CFD分析</a></li>
						<li<%=current.equals("2_2_5")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_5">FEA分析</a></li>
						<li<%=current.equals("2_2_6")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_6">CAE优化分析</a></li>
						<li<%=current.equals("2_2_7")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_7">多体动力学分析</a></li>
						<li<%=current.equals("2_2_8")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_8">注塑分析</a></li>
						<li<%=current.equals("2_2_9")?" class='active'":"" %>><a href="<%=path %>/action/consultation?tag=qcl&current=2_2_9">疲劳分析</a></li>
					</ul>
				</li>
			</ul>
		</li>

		<li<%=current.startsWith("3")?" class='active'":"" %>>
			<a href="<%=path%>/action/software">
				<i class="icon-windows"></i>
				<span class="menu-text">CAE软件管理</span>
			</a>
		</li>

		<li<%=current.startsWith("4")?" class='active open'":"" %>>
			<a href="javascript:void(0)" class="dropdown-toggle">
				<i class="icon-book"></i>
				<span class="menu-text">CAE培训管理</span>
				<b class="arrow icon-angle-down"></b>
			</a>
			
			<ul class="submenu">
				<li<%=current.equals("4_1")?" class='active'":"" %>>
					<a href="<%=path%>/action/train">
						<i class="icon-double-angle-right"></i>
						培训/专题研讨会
					</a>
				</li>
				<li<%=current.equals("4_2")?" class='active'":"" %>>
					<a href="<%=path%>/action/train/news">
						<i class="icon-double-angle-right"></i>
						培训动态
					</a>
				</li>
				<li<%=current.equals("4_3")?" class='active'":"" %>>
					<a href="<%=path%>/action/survey">
						<i class="icon-double-angle-right"></i>
						在线提交
					</a>
				</li>
				<li<%=current.equals("4_5")?" class='active'":"" %>>
					<a href="<%=path%>/action/train/feedback">
						<i class="icon-double-angle-right"></i>
						意见与反馈
					</a>
				</li>
			</ul>
		</li>

		<li<%=current.startsWith("5")?" class='active open'":"" %>>
			<a href="javascript:void(0)" class="dropdown-toggle">
				<i class="icon-rss-sign"></i>
				<span class="menu-text">公司新闻管理</span>
				<b class="arrow icon-angle-down"></b>
			</a>
			
			<ul class="submenu">
				<li<%=current.equals("5_1")?" class='active'":"" %>>
					<a href="<%=path%>/action/news?category=1&current=5_1">
						<i class="icon-double-angle-right"></i>
						企业新闻
					</a>
				</li>
				<li<%=current.equals("5_2")?" class='active'":"" %>>
					<a href="<%=path%>/action/news?category=2&current=5_2">
						<i class="icon-double-angle-right"></i>
						培训新闻
					</a>
				</li>
				<li<%=current.equals("5_3")?" class='active'":"" %>>
					<a href="<%=path%>/action/news?category=3&current=5_3">
						<i class="icon-double-angle-right"></i>
						产品新闻
					</a>
				</li>
			</ul>
		</li>

		<li<%=current.startsWith("6")?" class='active open'":"" %>>
			<a href="javascript:void(0)" class="dropdown-toggle">
				<i class="icon-group"></i>
				<span class="menu-text">招聘信息管理</span>
				<b class="arrow icon-angle-down"></b>
			</a>
			
			<ul class="submenu">
				<li<%=current.equals("6_1")?" class='active'":"" %>>
					<a href="<%=path%>/action/recuitment/">
						<i class="icon-double-angle-right"></i>
						发布招聘信息
					</a>
				</li>
				<li<%=current.equals("6_2")?" class='active'":"" %>>
					<a href="<%=path%>/action/applicant/">
						<i class="icon-double-angle-right"></i>
						查看应聘简历
					</a>
				</li>
			</ul>
		</li>


		<li<%=current.startsWith("7")?" class='active'":"" %>>
			<a href="<%=path%>/action/company">
				<i class="icon-windows"></i>
				<span class="menu-text">公司信息设置</span>
			</a>
		</li>
		
<%-- 		<li<%=current.startsWith("7")?" class='active open'":"" %>> --%>
<!-- 			<a href="javascript:void(0)" class="dropdown-toggle"> -->
<!-- 				<i class="icon-info-sign"></i> -->
<!-- 				<span class="menu-text">公司信息设置</span> -->
<!-- 				<b class="arrow icon-angle-down"></b> -->
<!-- 			</a> -->
			
<!-- 			<ul class="submenu"> -->
<%-- 				<li<%=current.equals("7_1")?" class='active'":"" %>> --%>
<!-- 					<a href="#"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						编辑公司介绍 -->
<!-- 					</a> -->
<!-- 				</li> -->
<%-- 				<li<%=current.equals("7_2")?" class='active'":"" %>> --%>
<!-- 					<a href="#"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						设置联系地址 -->
<!-- 					</a> -->
<!-- 				</li> -->
<%-- 				<li<%=current.equals("7_3")?" class='active'":"" %>> --%>
<!-- 					<a href="#"> -->
<!-- 						<i class="icon-double-angle-right"></i> -->
<!-- 						设置联系电话 -->
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 			</ul> -->
<!-- 		</li> -->

		<li<%=current.startsWith("8")?" class='active'":"" %>>
			<a href="<%=path%>/action/user">
				<i class="icon-user"></i>
				<span class="menu-text">网站会员管理</span>
			</a>
		</li>

	</ul><!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>
</div>