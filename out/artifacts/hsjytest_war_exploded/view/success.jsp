<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: XX
  Date: 2018/4/13
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="http://localhost:8080/hsjytest/test/selectid" method="post">

    <select id="selecw" name="selecw" class="required input-medium">
        <c:forEach items="${list}" var="dict">
            <option value="${dict.username}">${dict.username}</option>
        </c:forEach>
    </select>

    <input type="submit" value="测试提交按钮"/>

</form>

<br>
<a>如果你成功的话后面就返回一条数据 ${itest}</a>
<br>
<a>我会在你的model里面去哪一条数据的谢谢你${reults}</a>

<a>我的时间是这样的${da}</a>


<select id="selectid" name="selectid" class="required input-medium">
    <c:forEach items="${listf}" var="dict">
        <option value="${dict.useranme}"><fmt:formatDate value="${dict.birthday}" type="both"/></option>
    </c:forEach>
</select>

</body>
</html>
