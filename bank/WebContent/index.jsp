<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ts" method="post">
转账账号：<input type="text" name="accOutAccNo">
密码：<input type="password"  name="accOutPassword">
金额：<input type="text" name="accOutBalance">
收款账号：<input type="text" name="accInAccNo">
收款姓名：<input type="text" name="accInName">
<input type="submit" value="转账">
</form>
</body>
</html>