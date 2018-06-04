<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>联系人列表</title>
</head>
<body>
<%--@elvariable id="lxrList" type="java.util.List"--%>
<c:forEach var="i" begin="1" end="3" step="1">
<h1>分组${i}</h1>
<table border="1">
    <tr>
        <th>lxrname</th>
        <th>lxrtel</th>
    </tr>
    <c:if test="${lxrList!=null}">
    <c:forEach items="${lxrList}" var="lxrList" >
        <c:if test="${lxrList.status==i}">
        <tr>
            <td>${lxrList.lxrname}</td>
            <td>${lxrList.lxrtel}</td>
        </tr>
        </c:if>
    </c:forEach>
    </c:if>
</table>
</c:forEach>
<a href="modifylxr.jsp">修改</a><br>
<a href="dellxr.jsp">删除</a><br>
</body>
</html>
