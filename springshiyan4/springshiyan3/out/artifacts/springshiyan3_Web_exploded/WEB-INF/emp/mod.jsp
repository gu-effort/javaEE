

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    5 <title>员工管理-修改员工信息</title>
    6
</head>
<body>

<h1>修改员工信息</h1>

<form action="mod" method="post">
    <input type="hidden" name="id" value="${emp.id}"/>
    <div>
        <label>编号</label>
        <input type="text" name="number" value="${emp.number}"/>
    </div>
    <div>
        <label>姓名</label>
        <input type="text" name="name" value="${emp.name}"/>
    </div>
    <div>
        <label>性别</label>
        <input type="radio" value="男" name="gender" ${emp.gender=="男"?"checked":""} />男
        <input type="radio" value="女" name="gender"${emp.gender=="女"?"checked":""} />女
    </div>
    <div>
        <label>年龄</label>
        <input type="text" name="age" value="${emp.age}"/>
    </div>
    <div>
        <label>部门</label>
        <select name="dep.id">
            <c:forEach items="${depList}" var="dep">
                <option value="${dep.id}" ${emp.dep.id==dep.id?"selected":""}>${dep.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button type="submit">保存</button>
    </div>
</form>


</body>
</html>