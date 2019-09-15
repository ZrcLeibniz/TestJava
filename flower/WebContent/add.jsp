<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="InsertServlet" method="post">
<table border="1">
	<tr>
		<td colspan="2" style="text-align:center;font-size:30px;font-weight:bold;">
			花卉信息
		</td>
	</tr>
	<tr>
		<td>花卉名称：</b></td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>花卉价格：</b></td>
		<td><input type="text" name="price"/></td>
	</tr>
	<tr>
		<td>花卉原产地：</b></td>
		<td><input type="text" name="production"/></td>
	</tr>
	<tr>
		<td colspan="2" ali="center">
			<input type="submit" value="提交"/><input type="reset" value=重置>
		</td>
	</tr>
</table>
</form>
</body>
</html>