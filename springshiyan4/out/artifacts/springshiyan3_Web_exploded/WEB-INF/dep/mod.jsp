<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门管理-修改部门信息</title>
</head>
<body>

<h1>修改部门信息</h1>

<form action="mod" method="post">
    <input type="hidden" name="id" value="${dep.id}"/>
    <div>
        <label>编号</label>
        <input type="text" name="number" value="${dep.number}"/>
    </div>
    <div>
        <label>名称</label>
        <input type="text" name="name" value="${dep.name}"/>
    </div>
    <div>
        <button type="submit">保存</button>
    </div>
</form>


</body>
</html>

