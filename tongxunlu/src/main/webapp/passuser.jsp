<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>已审核用户</title>
</head>
<body>

<table border="1">
    <tr>
        <th>ID</th>
        <th>username</th>
        <th>authority</th>
    </tr>
    <%--@elvariable id="usersList" type="java.util.List"--%>
    <c:forEach items="${usersList}" var="usersList" >

        <tr>
            <td>${usersList.uid}</td>
            <td>${usersList.uname}</td>
            <td>${usersList.authority}</td>
        </tr>
    </c:forEach>
</table>
<a href="modifyauthority.jsp">修改</a>

</body>
</html>
