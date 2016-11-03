<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	String path = request.getContextPath();
	String title = request.getParameter("title");
	if(title != null && title.length() > 0) title = title + " - 有限元在线";
	else title = "有限元在线";
%>
<meta charset="utf-8" />
<title><%=title %></title>

<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->
<link href="<%=path %>/plugin/ace/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>/plugin/ace/css/font-awesome.min.css" />

<!--[if IE 7]>
  <link rel="stylesheet" href="<%=path %>/plugin/ace/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- page specific plugin styles -->
<link rel="stylesheet" href="<%=path %>/plugin/ace/css/jquery-ui-1.10.3.full.min.css" />

<!-- fonts -->
<link rel="stylesheet" href="<%=path %>/plugin/ace/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=path %>/plugin/ace/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>/plugin/ace/css/ace-skins.min.css" />

<!--[if lte IE 8]>
  <link rel="stylesheet" href="<%=path %>/plugin/ace/css/ace-ie.min.css" />
<![endif]-->

<!-- ace settings handler -->
<script src="<%=path %>/plugin/ace/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="<%=path %>/plugin/ace/js/html5shiv.js"></script>
<![endif]-->
		
<!-- head -->
<style type="text/css">
	.fileinput-preview {
		color: #d5d5d5;
		font-size: 14px;
	}
	
	.fileinput-preview .icon-cloud-upload {
		font-size: 46px;
	}
</style>
<c:out value="${head }" escapeXml="false"></c:out>