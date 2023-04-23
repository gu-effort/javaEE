
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工管理-新增员工</title>
</head>
<body>

<h1>新增员工</h1>

<form action="add" method="post">
    <div>
        <label>编号
            <input type="text" name="number" placeholder="编号">
        </label>
    </div>
    <div>
        <label>姓名
            <input type="text" name="name" placeholder="姓名">
        </label>
    </div>
    <div>
        <label>性别
            <input type="radio" value="男" name="gender">男
            <input type="radio" value="女" name="gender">女
        </label>
    </div>
    <div>
        <label>年龄
            <input type="text" name="age" placeholder="年龄">
        </label>
    </div>
    <div>
        <label>部门
            <select name="dep.id">
                <c:forEach items="${depList}" var="dep">
                    <option value="${dep.id}">${dep.name}</option>
                </c:forEach>
            </select>
        </label>
    </div>
    <div>
        <button type="submit">保存</button>
    </div>
</form>


</body>
</html>