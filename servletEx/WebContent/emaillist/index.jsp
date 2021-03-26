<%@page import="com.bit.servlet.dao.EmailVo"%>
<%@page import="java.util.List"%>
<%@page import="com.bit.servlet.dao.EmailDaoOrclImpl"%>
<%@page import="com.bit.servlet.dao.EmailDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일링 리스트 확인</title>
<style type="text/css">
 a:link { color: red; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: Orange; text-decoration: none;}
</style>
</head>
<body>
	<h1>메일링 리스트</h1>
	<%
	EmailDao dao = new EmailDaoOrclImpl();
	List<EmailVo> list = dao.getList();
	for (EmailVo vo : list){
		 %>
		<!-- 정보 테이블 -->
	<table border=1>
		<tr>
			<th>성</th>
			<td><%= vo.getLastName() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= vo.getFirstName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= vo.getEmail() %></td>
		</tr>
		<tr>
			<td colspan = "2">
				<form action = "delete.jsp">
					<input type="hidden" name = "no" value="<%=vo.getNo() %>"/>
					<input type="submit" value = "DELETE"/>
				</form>
			</tr>
	</table>			
		 <%
	}
	%>	
	<p>
		<a href = "form.jsp">메일링 리스트 가입</a>
	</p>
</body>
</html>