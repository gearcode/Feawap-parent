<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	String path = request.getContextPath();
%>
<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=path%>/plugin/ace/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=path%>/plugin/ace/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script src="<%=path%>/plugin/ace/js/bootstrap.min.js"></script>
<!-- auto complete -->
<script src="<%=path%>/plugin/ace/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->
<script src="<%=path %>/plugin/ace/js/jquery-ui-1.10.3.full.min.js"></script>
<script src="<%=path %>/plugin/ace/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript">
	//override dialog's title function to allow for HTML titles
	$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
		_title: function(title) {
			var $title = this.options.title || '&nbsp;'
			if( ("title_html" in this.options) && this.options.title_html == true )
				title.html($title);
			else title.text($title);
		}
	}));
</script>

<!-- ace scripts -->
<script src="<%=path%>/plugin/ace/js/ace-elements.min.js"></script>
<script src="<%=path%>/plugin/ace/js/ace.min.js"></script>

<!-- page js -->
<c:out value="${javascript}" escapeXml="false"></c:out>