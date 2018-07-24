<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${ctx==null }">
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String socketPath = request.getServerName()+":"+request.getServerPort()+path;
	%>
	<c:set var="ctx" value="<%=basePath %>"/>
	<c:set var="socketPath" value="<%=socketPath %>"/>
</c:if>
<script src="${ctx}/static/js/jquery-1.9.1.js"></script>
<script src="${ctx}/static/js/jquery.form.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-table.css" />
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/static/js/layer/skin/layer.css" />
<script src="${ctx}/static/js/bootstrap/js/bootstrap.js"></script>
<script src="${ctx}/static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/bootstrap/js/bootstrap-table.js"></script>
<script src="${ctx}/static/js/common.js"></script>
<script src="${ctx}/static/js/layer/layer.js"></script>
