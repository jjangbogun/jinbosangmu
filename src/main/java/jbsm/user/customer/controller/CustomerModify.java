package jbsm.user.customer.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jbsm.user.customer.dao.CustomerDao;
import jbsm.user.customer.dto.CustomerDto;
import jbsm.user.event.dao.EventDao;
import jbsm.user.event.dto.EventDto;
import jbsm.user.member.dao.MemberDao;
import jbsm.user.member.dto.MemberDto;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/customer/modify"})
public class CustomerModify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {
			int customerNo = Integer.parseInt(request.getParameter("customerNo"));
			
			ServletContext sc = this.getServletContext();

			conn = (Connection)sc.getAttribute("conn");			
			
			CustomerDao customerDao = new CustomerDao();
			customerDao.setConnection(conn);
			
			CustomerDto customerDto = customerDao.customerSelectOne(customerNo);
			
			request.setAttribute("customerDto", customerDto);
			RequestDispatcher rd = 
					request.getRequestDispatcher("./CustomerModify.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/common/Error.jsp");
			
			dispatcher.forward(request, response);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		CustomerDto customerDto = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			int customerNo = Integer.parseInt(request.getParameter("customerNo"));
			String customerQue = request.getParameter("customerQue");
			String customerAns = request.getParameter("customerAns");			
			
			customerDto = new CustomerDto();
			
			customerDto.setCustomerNo(customerNo);
			customerDto.setCustomerQue(customerQue);
			customerDto.setCustomerAns(customerAns);
			
			conn = (Connection)sc.getAttribute("conn");
			
			CustomerDao customerDao = new CustomerDao();
			customerDao.setConnection(conn);
			
			int result = customerDao.customerUpdate(customerDto);
			
			if(result == 0) {
				System.out.println("Q&A 조회가 실패하였습니다.");
			}
			
			response.sendRedirect("list");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/common/Error.jsp");
			
			dispatcher.forward(request, response);
		} 
				
	}
	
}
