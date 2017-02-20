<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>控制台</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/icon.png">
</head>
<body>
	<h1>控制台</h1>
	<p>欢迎你，${sessionScope.user.username}</p>
	<p>
		<a href="${pageContext.request.contextPath}/dashboard/usermanage">用户管理</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/login.jsp">注销</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
	</p>
</body>
</html>