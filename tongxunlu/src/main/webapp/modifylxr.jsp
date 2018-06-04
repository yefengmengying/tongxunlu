<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改联系人</title>
</head>
<body>
<form action="/lxrs/modify">
    <select name="select">
        <option value="lxrname">联系人姓名</option>
        <option value="lxrtel">联系人电话</option>
    </select>
    请输入：<input type="text" name="text"><br>
    修改为：<input type="text" name="modify"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
