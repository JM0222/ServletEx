<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 다른페이지 파일 포함 -->
<%@ include file="/WEB-INF/includes/header.jsp" %>
<body>
	<h1 id ="top">Hello world(나눔누리폰트)</h1>
	<hr/>
	<ul>
		<li><a href="<%= request.getContextPath() %>/users?a=joinform">회원가입</a></li>
	</ul>
	<p> 정적 HTML로 작성된 페이지입니다. (단락지정p태그) </p>
	<a href = "hello.jsp?name=Servlet" target="_blank">GO JSP(GET method)</a>
	<p>
		<a href="hs?name=Servlet">Servlet 호출(GET 방식)</a>
	</p>
	<p> <del>동적</del> <mark>정적</mark> <ins>HTML</ins> 연속공백은<q>"&nbsp;"</q> </p>
	<pre>
		작성된 그대로 표시되는 pre태그
		var myArray = [];
		console.log(myArray.length); // 0
	</pre>
	<table border="1">
      <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Score</th>
      </tr>
      <tr>
        <td colspan=2>Jill(colspan)</td>
        <td>50</td>
      </tr>
      <tr>
        <td>Eve</td>
        <td>Jackson</td>
        <td>94</td>
      </tr>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>80</td>
      </tr>
    </table>
	<p>
		<a href="life">라이프사이클 로그 확인</a>
	</p>
	<p>
		<a href="emaillist/index.jsp">emaillist</a>
	</p>
	<p>
		<a href="el">MVC패턴연습</a>
	</p>
	<blockquote>
		This is a blockquote<br/>
		target attribute 
			- 1 target = "_blank" -> 새로운 윈도우
			- 2 target = "_self"  ->  현재 윈도우
 	</blockquote>
 	<form action="hs" method="post">
 		<label for = "id">id1</label>
 		<input type = "text" id = "id" name="id">
 		<br/>
 		<label for = "id2">id2</label>
 		<input type = "text" id = "id2" name="id2">
 		<br/>
 		<input type="submit" value = "submit">
 	</form>
 	<p>
	 	<img src ="images/img.png" alt = "유이"/>
	 	<br/>
		<a href="#top">GO TO TOP</a>
	</p>
<%@ include file="/WEB-INF/includes/footer.jsp" %>