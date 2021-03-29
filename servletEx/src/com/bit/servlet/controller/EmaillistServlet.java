package com.bit.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.servlet.dao.EmailDao;
import com.bit.servlet.dao.EmailDaoOrclImpl;
import com.bit.servlet.dao.EmailVo;


//@WebServlet("/el") // 현재 클래스를 /el url 패턴에 반응하는 서블릿으로 등록
@WebServlet(name="Emaillist", urlPatterns="/el") // web.xml에 서블릿, 서블릿매핑 등록과 같은 의미
public class EmaillistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String action = req.getParameter("a"); // a 파라미터 확인
		
		if ("form".equals(action)) { // a = form 이면
		// View 처리를 위한 RequestDispatcher 를 확인
		// 자신이 처리하는 요청, 응답 객체를 서블릿 or jsp 로넘겨주기
		RequestDispatcher rd = 
				getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
		rd.forward(req, resp);
		} else if ("delete".equals(action)) {
			Long no = Long.valueOf(req.getParameter("no"));
			
			EmailDao dao = new EmailDaoOrclImpl();
			dao.delete(no);
			
			resp.sendRedirect(req.getContextPath() + "/el");
		}else {
			// 리스트를 불러와 req에 attribute로 추가
			EmailDao dao = new EmailDaoOrclImpl();
			// 전달해줄 객체
			List<EmailVo> list = dao.getList();
			// 요청 객체에 속성으로 추가
			//                 이름   객체
			req.setAttribute("list", list); // 전달받은 서블릿은 요청으로 부터 이 속성 이용가능
			// Dispatcher
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if ("insert".equals(action)) { // action이 insert -> 삽입
			String lastName = req.getParameter("last_name");
			String firstName = req.getParameter("first_name");
			String email = req.getParameter("email");
			
			EmailVo vo = new EmailVo();
			vo.setLastName(lastName);
			vo.setFirstName(firstName);
			vo.setEmail(email);
			
			EmailDao dao = new EmailDaoOrclImpl();
			
			dao.insert(vo);
			// 리스트페이지 리다이렉트
			resp.sendRedirect(req.getContextPath() + "/el");
			
		} else {
			doGet(req, resp);
		}
	}
	
	

}
