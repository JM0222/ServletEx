<%@page import="com.bit.servlet.dao.EmailDaoOrclImpl"%>
<%@page import="com.bit.servlet.dao.EmailVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // 요청 파라미터 받기
String lastName = request.getParameter("last_name");
String firstName = request.getParameter("first_name");
String email = request.getParameter("email");

// VO 객체 
EmailVo vo = new EmailVo(lastName, firstName, email);
EmailDaoOrclImpl dao = new EmailDaoOrclImpl();

dao.insert(vo); 

// 리스트 페이지로 돌려보내기: 302 -> REDIRECT
response.sendRedirect(request.getContextPath() + "/emaillist/");
%>