<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核</title>
</head>
<body>
<form action="/users/modify">
    修改的用户名：<input type="text" name="uname"><br>
    <select name="select">
        <option value="0">暂停</option>
        <option value="1">通过</option>
    </select><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
