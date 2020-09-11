<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>订单号</th>
			<th>转账账号</th>
			<th>收款账号</th>
		</tr>
		<c:forEach items="${list }" var="log">
			<tr>
			<td>${log.id }</td>
			<td>${log.accIn }</td>
			<td>${log.accOut }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>