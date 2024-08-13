package jbsm.admin.admin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jbsm.admin.admin.dao.AdminDao;
import jbsm.admin.admin.dto.AdminDto;
import jbsm.admin.admin.dto.PageDto;

@WebServlet(value = "/admin/list")
public class AdminList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		Connection conn = null;
		
		try {
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			AdminDao adminDao = new AdminDao();
			adminDao.setConnection(conn);
			
			int sessionCheck = (int) adminDao.adminSession(request, response);
			
			if (sessionCheck == 0) {
				response.sendRedirect("./login");
			}
			
			String searchField = null;
			String searchText = null;
			
			if(request.getParameter("searchText") != null) {
				searchField 	= request.getParameter("searchField");
				searchText 		= request.getParameter("searchText");
			}			
			
			int pageNum = 1;
			int pageSize = 5;
			int total = adminDao.getTotal(searchField,searchText); // 전체게시글수
			
			if(request.getParameter("pageNum") != null && request.getParameter("pageSize") != null) {
				pageNum 	= Integer.parseInt(request.getParameter("pageNum"));
				pageSize 	= Integer.parseInt(request.getParameter("pageSize"));
			}

			ArrayList<AdminDto> adminList = (ArrayList<AdminDto>) adminDao.selectList(pageNum,pageSize,searchField,searchText);
			
			PageDto pageDto = new PageDto(pageNum, pageSize, total);

			request.setAttribute("adminList", adminList);
			request.setAttribute("pageDto", pageDto);
			
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/admin/admin/AdminList.jsp");
			
			dispatcher.include(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("error", e);
			request.setAttribute("caseByCase", "상황에 맞는 처리 부탁");
			
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
			
		} 
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		super.doPost(request, response);
	}
}
