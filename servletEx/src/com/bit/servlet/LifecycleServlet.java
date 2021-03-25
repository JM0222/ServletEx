package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// 첫 호출시 init 수행: Servlet 초기화 담당

		System.out.println("Lifecycle: init()");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청이 들어올 때 호출, 요청 방식에 따라 doGet or doPost

		System.out.println("Lifecycle: service()");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청이 GET 메서드일경우
		System.out.println("Lifecycle: do get()");
		// 컨텍스트 파라미터 불러오기
		ServletContext context = getServletContext();
		String dburl = context.getInitParameter("dburl");
		String dbuser = context.getInitParameter("dbuser");
		String dbpass = context.getInitParameter("dbpass");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>doGet call</h1>");
		out.println("<h3>Context Init Params</h3>");
		out.println("<ul>");
		out.println("<li>dburl:" + dburl + "</li>");
		out.println("<li>dbuser:" + dbuser + "</li>");
		out.println("<li>dbpass:" + dbpass + "</li>");
		out.println("</ul>");
	}

	@Override
	public void destroy() {
		// 서버 중단, 오랜 시간 서블릿 요청없을경우 -> 서블릿 자원정리

		System.out.println("Lifecyfcle: destroy()");
	}
	
}
