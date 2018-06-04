<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加联系人</title>
</head>
<body>
<form action="/lxrs/addlxr" method="post">
    <p><label>联系人：</label><input type="text" name="lxrname"></p>
    <p><label>联系人电话：</label><input type="text" name="lxrtel"></p>
    <p><label>联系人分组：</label><input type="text" name="status"></p>
    <input type="submit" value="添加">
</form>
</body>
</html>