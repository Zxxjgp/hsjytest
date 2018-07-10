<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body style="margin: 1px">
<script type="text/javascript">
    function openreturn(){
        window.history.go(-1);
    }
</script>
<table id="dg" title="招募查询结果页面" class="easyui-datagrid" >
    <thead>
    <tr>
        <th field="id" width="32" align="center">编号</th>
        <th field="hospitalName" width="200" align="center">招募标题</th>
    </tr>

        <c:forEach var="diseasetype" items="${hospitallist}">
            <tr>
                    <th width="32" align="center">${diseasetype.id}</th>
                    <th width="200" align="center">${diseasetype.recruitTitle}</th>
            </tr>
        </c:forEach>

    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openreturn()" class="easyui-linkbutton" iconCls="icon-return" plain="true">返回</a>
    </div>
</div>

</body>
</html>