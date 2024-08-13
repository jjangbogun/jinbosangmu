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

@WebServlet(value = "/admin/delete")
public class AdminDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;

		try {
			
			int adminNo = Integer.parseInt(request.getParameter("deleteNo"));
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			AdminDao adminDao = new AdminDao();
			adminDao.setConnection(conn);
			
			int result;
			
			result = adminDao.adminDelete(adminNo);
			
			if (result == 0) {
				System.out.println("관리자 정보 삭제 실패");
			}
			
			response.sendRedirect("./list");
			

		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
				
		} finally {
			

			
		}
	}
}
