<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门管理</title>
</head>
<body>

<form id="search" action="search" method="post">
    <input type="text" name="number" placeholder="编号" value="${c.number}"/>
    <input type="text" name="name" placeholder="名称" value="${c.name}"/>
    <button type="submit">搜索</button>
    <button type="reset">重置</button>
</form>

<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${depList}" var="dep">
        <tr>
            <td>${dep.number}</td>
            <td>${dep.name}</td>
            <td>
                <a href="mod?id=${dep.id}">修改</a>
                <a href="del?id=${dep.id}">删除</a>
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