package jbsm.admin.admin.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/admin")
public class AdminMain extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		String ssoAdminEmail = (String) session.getAttribute("ssoAdminEmail");
		String pageForward = "";
		
		if(ssoAdminEmail == null) {
			pageForward = "/admin/admin/LoginForm.jsp";
		}else {
			pageForward = "/admin/admin/AdminMain.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(pageForward);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		

	}
}
