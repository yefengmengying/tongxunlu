<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<c:if test="${myUser != null}">
    <h1> ${myUser.uname},您好：</h1>

    <ol>
        <li><a href="addlxr.jsp">添加联系人</a></li>
        <li><a href="/lxrs/search">查看联系人</a></li>
    </ol>

</c:if>
<c:if test="${myUser == null}">
    <c:redirect url="login.jsp"/>
</c:if>
</body>
</html>
