<%@page import="com.bit.servlet.dao.EmailDao"%>
<%@page import="com.bit.servlet.dao.EmailDaoOrclImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // 요청 파라미터 받기 parameter는 string 만
Long no = Long.valueOf(request.getParameter("no"));// converting


// VO 객체 
EmailDao dao = new EmailDaoOrclImpl();
dao.delete(no); 

// 리스트 페이지로 돌려보내기: 302 -> REDIRECT
response.sendRedirect(request.getContextPath() + "/emaillist/");
%>