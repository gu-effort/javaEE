<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工管理</title>
</head>
<body>

<form id="search" action="search" method="post">
    <input type="text" name="number" placeholder="编号" value="${c.number}">
    <input type="text" name="name" placeholder="姓名" value="${c.name}">
    <select name="gender">
        <option value="">性别</option>
        <option value="男" ${c.gender=="男"?"selected":""}>男</option>
        <option value="女" ${c.gender=="女"?"selected":""}>女</option>
    </select>
    <input type="text" name="age" placeholder="年龄" value="${c.age}">
    <select name="dep.id">
        <option value="">部门</option>
        <c:forEach items="${depList}" var="dep">
            <option value="${dep.id}" ${c.dep.id==dep.id?"selected":""}>${dep.name}</option>
        </c:forEach>
    </select>
    <button type="submit">搜索</button>
    <button type="reset">重置</button>
</form>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>部门</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${empList}" var="emp">
        <tr>
            <td>${emp.number}</td>
            <td>${emp.name}</td>
            <td>${emp.gender}</td>
            <td>${emp.age}</td>
            <td>${emp.dep.name}</td>
            <td>
                <a href="mod?id=${emp.id}">修改</a>
                <a href="del?id=${emp.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${pageInfo.hasPreviousPage}">
    <a href="?pageNo=${pageInfo.prePage}">上一页</a>
</c:if>
<c:if test="${pageInfo.hasNextPage}">
    <a href="?pageNo=${pageInfo.nextPage}">下一页</a>
</c:if>
<hr>
<a href="add">新增</a>
<button type="button" id="add">新增</button>

</body>
</html>