<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1'>
	<tr>
		<td>花卉编号</td>
		<td>花卉名称</td>
		<td>花卉价格</td>
		<td>花卉原产地</td>
	</tr>
	<c:forEach items="${list}" var="flower">
	<tr>
		<td>${flower.id}</td>
		<td>${flower.name}</td>
		<td>${flower.price}</td>
		<td>${flower.production}</td>
	</tr>
	</c:forEach>
</table>
<a href="add.jsp">添加花卉信息</a>
</body>
</html>