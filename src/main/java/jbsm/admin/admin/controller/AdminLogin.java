package jbsm.admin.admin.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jbsm.admin.admin.dao.AdminDao;
import jbsm.admin.admin.dto.AdminDto;

@WebServlet(value = "/admin/login")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String pageForward = "/admin/admin/LoginForm.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(pageForward);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Connection conn = null;
		
		try {
			
			String loginEmail 		= request.getParameter("loginEmail");
			String loginPass 		= request.getParameter("loginPassS");
			
			System.out.println(loginEmail);
			
			AdminDto adminDto = new AdminDto();
			adminDto.setAdminNo(0);
			adminDto.setAdminEmail(loginEmail);
			adminDto.setAdminPw(loginPass);
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			AdminDao adminDao = new AdminDao();
			adminDao.setConnection(conn);
			
			adminDto = adminDao.adminLogin(adminDto);
			
			if (adminDto == null) {
				
				System.out.println("관리자 로그인 실패!");
				response.sendRedirect("./login?setLogin=fail");
			} else {
				
				System.out.println("관리자 로그인 성공!");
				HttpSession session = request.getSession();
				session.setAttribute("ssoAdminNo", adminDto.getAdminNo());
				session.setAttribute("ssoAdminName", adminDto.getAdminName());
				session.setAttribute("ssoAdminEmail", adminDto.getAdminEmail());
				response.sendRedirect("../admin");
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
				
		}finally {
			

			
		}
	}
}
