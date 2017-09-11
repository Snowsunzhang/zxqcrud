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

<title>My JSP 'addstudent.jsp' starting page</title>

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
	<form action="${pageContext.request.contextPath}/student?method=edit" method="post">
	<table>
	<tr>
	<td>编号：</td>
	<td><input name="id" id="id" value="${student.id}"/></td>
	</tr>
	<tr>
	<td>姓名：</td>
	<td><input name="name" id="name" value="${student.name}"/></td>
	</tr>
	
	</table>
	<input type="submit" value="确认修改">
	</form>
</body>
</html>
