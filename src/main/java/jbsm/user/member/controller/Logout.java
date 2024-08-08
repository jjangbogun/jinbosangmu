package jbsm.user.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/member/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		response.sendRedirect("../main");
		
	}
	
}
