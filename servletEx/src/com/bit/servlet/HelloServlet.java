package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet 은 HttpServlet 을 상속 받아 필요한 메서드 Override 한다
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET 요청을 처리하는 메서드
		// 클라이언트에서 name 파라미터를 전송 받아서 환영 메세지 출력
		// JSP에서는 사용자 요청을 자동으로 REQUEST라는 이름으로 전달
		String name = req.getParameter("name");
		if (name == null) {
			name = "Null";
		}
		// 출력 
		// 응답 객체에서 Writer 를 얻어온다
		PrintWriter out =  resp.getWriter();
		out.println("<h1>hello, servlet</h1>");
		out.println("<p>HELLO," + name + "</p>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST 요청을 처리하는 메서드
		// 파라미터 받아오기
		// FORM 내의 input 태그의 name 속성 
		// FORM 의 입력 데이터 인코딩
//		req.setCharacterEncoding("UTF-8");  -> 필터처리
		
		String id = req.getParameter("id");
		String id2 = req.getParameter("id2");
		
		// 출력
		// 응답되는 데이터가 text/html 임을 브라우저에게 알림
//		resp.setContentType("text/html;charset=UTF-8"); -> 필터에서 처리-
		PrintWriter out = resp.getWriter();
		out.println("<h1>This is id: " + id + "</h1>");
		out.println("<small>This is id2: " + id2 + "</small>");
	}
	
}
