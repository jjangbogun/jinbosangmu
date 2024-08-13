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

@WebServlet(value = "/admin/modify")
public class AdminModify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Connection conn = null;

		try {
			
			int adminNo = Integer.parseInt(request.getParameter("adminNo"));
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			AdminDao adminDao = new AdminDao();
			adminDao.setConnection(conn);
			
			AdminDto adminDto = adminDao.adminModify(adminNo);
			
			if (adminDto == null) {
				System.out.println("관리자 정보 조회 실패");
			}
			
			request.setAttribute("adminDto", adminDto);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("./admin/AdminModify.jsp");
			dispatcher.forward(request, response);
			

		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
				
		}finally {
			

			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Connection conn = null;

		try {
			
			int adminNo 		= Integer.parseInt(request.getParameter("adminNo"));
			String adminName 	= request.getParameter("adminName");
			
			AdminDto adminDto = new AdminDto();
			adminDto.setAdminNo(adminNo);
			adminDto.setAdminName(adminName);
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			AdminDao adminDao = new AdminDao();
			adminDao.setConnection(conn);
			
			int result;
			
			result = adminDao.adminUpdate(adminDto);
			
			if (result == 0) {
				System.out.println("관리자 정보 수정 실패");
			}
			
			response.sendRedirect("./modify?adminNo=" + adminNo);
			

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
