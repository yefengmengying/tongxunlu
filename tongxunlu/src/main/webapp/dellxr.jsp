<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除联系人</title>
</head>
<body>
<form action="/lxrs/del">
    <select name="select">
        <option value="lxrname">联系人姓名</option>
        <option value="lxrtel">联系人电话</option>
    </select>
    请输入：<input type="text" name="text"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
