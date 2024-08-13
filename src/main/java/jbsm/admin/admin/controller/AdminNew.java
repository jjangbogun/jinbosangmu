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
import jbsm.admin.admin.dao.AdminDao;
import jbsm.admin.admin.dto.AdminDto;

@WebServlet(value = "/admin/new")
public class AdminNew extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		response.sendRedirect("./admin/AdminNew.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Connection conn = null;

		try {
			
			String adminEmail 	= request.getParameter("adminEmail");
			String adminPw 		= request.getParameter("adminPwS");
			String adminName 	= request.getParameter("adminName");
			
			AdminDto adminDto = new AdminDto();
			adminDto.setAdminEmail(adminEmail);
			adminDto.setAdminPw(adminPw);
			adminDto.setAdminName(adminName);
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			AdminDao adminDao = new AdminDao();
			adminDao.setConnection(conn);
			
			int result;
			
			result = adminDao.adminInsert(adminDto);
			
			if (result == 0) {
				System.out.println("관리자 등록 실패");
			}
			
			response.sendRedirect("./list");
			

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
