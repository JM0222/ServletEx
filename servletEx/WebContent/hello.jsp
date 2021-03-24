<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome JSP</title>
</head>
<body>
	<h1>hello JSP</h1>
	<%
	String name = request.getParameter("name");
	if (name == null) {
		name = "Anonymous";
	}
	%>
	<p>Welcome, <%= name %>!</p>
</body>
</html>