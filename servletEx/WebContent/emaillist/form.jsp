<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일리스트 가입폼</title>
</head>
<body>
	<h1>메일링 리스트 가입</h1>
	<p> 가입하려면 아래 항목을 기입하고 <br/>
		버튼을 눌러주세요 ^*^
	</p>
	<form action ="insert.jsp" method ="post">
		<label for = "last_name">성(Last_name)</label>
		<input type = "text" name = "last_name" id = "last_name" />
		<br/>
		<label for = "first_name">이름(first_name)</label>
		<input type = "text" name = "first_name" id = "first_name" />
		<br/>
		<label for = "email">이메일(Email)</label>
		<input type = "text" name = "email" id = "email" />
		<br/>
		<input type = "submit" value = "등록!"/>
	</form>
	<p>
		<a href = "index.jsp">LIST</a>
	</p>
</body>
</html>