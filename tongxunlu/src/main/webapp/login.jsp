<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="users/login" method="post">
        <input type="text" name="uname"><br>
        <input type="password" name="upwd"><br>
        <input type="submit" value="登陆"><br>
        <a href="register.jsp">注册</a>
    </form>
</body>
</html>
