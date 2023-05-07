<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门管理-新增部门</title>
</head>
<body>

<h1>新增部门</h1>

<form action="add" method="post">
    <div>
        <label>编号
            <input type="text" name="number" placeholder="编号">
        </label>
    </div>
    <div>
        <label>名称
            <input type="text" name="name" placeholder="姓名">
        </label>
    </div>
    <div>
        <button type="submit">保存</button>
    </div>
</form>


</body>
</html>
