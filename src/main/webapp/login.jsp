<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="icon" href="${pageContext.request.contextPath}/icon.png">
</head>
<body>
	<h1>登录</h1>
	<p>${sessionScope.msg}</p>
	<%
		session.invalidate();//销毁会话
	%>
	<form action="${pageContext.request.contextPath}/dologin" method="post">
		<input type="text" name="username" placeholder="用户名" /> <br /> <input
			type="password" name="password" placeholder="密码" /> <br /> <input
			type="submit" value="登录" />
	</form>
	<p>
		<a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
	</p>
</body>
</html>