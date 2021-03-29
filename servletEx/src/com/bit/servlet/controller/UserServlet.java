package com.bit.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.servlet.dao.UserDao;
import com.bit.servlet.dao.UserDaoOrclImpl;
import com.bit.servlet.dao.UserVo;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 사용자 요청 파마리터 처리
		String action = req.getParameter("a");
		
		if ("joinform".equals(action)) {
			RequestDispatcher rd = 
					req.getRequestDispatcher("/WEB-INF/users/joinform.jsp");
			rd.forward(req, resp);
		} else if ("joinsuccess".equals(action)) {
			RequestDispatcher rd =
					req.getRequestDispatcher("/WEB-INF/users/joinsuccess.jsp");
			rd.forward(req, resp);
		} else {
			// 처리할수없는 요청일 경우 -> 404 에러
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 사용자 요청 파라미터 처리
		String action = req.getParameter("a");
		if ("join".equals(action)) {
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			
			// 사용자 객체 생성
			UserVo vo = new UserVo(name,password,email,gender);
			
			UserDao dao = new UserDaoOrclImpl();
			int insertCnt = dao.insert(vo);
			if (insertCnt == 1) {
				resp.sendRedirect(req.getContextPath()+"/users?a=joinsuccess");
				
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/users/joinform.jsp");
				rd.forward(req,resp);
			}
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
}
