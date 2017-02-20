<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/icon.png">
</head>
<body>
	<h1>主页</h1>
	<c:choose>
		<c:when test="${empty user}">
			<p>
				<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<a href="${pageContext.request.contextPath}/dashboard">控制台</a>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/login.jsp">注销</a>
			</p>
		</c:otherwise>
	</c:choose>

</body>
</html>