<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'studentlist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
	<a href="addstudent.jsp">添加学生</a>
		<table border="1">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${students}" var="item" varStatus="status">
				<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td><a
					href="${pageContext.request.contextPath}/student?method=edit1&id=${item.id}">修改
				</a> <a
					href="${pageContext.request.contextPath}/student?method=delete&id=${item.id}">删除
				</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
