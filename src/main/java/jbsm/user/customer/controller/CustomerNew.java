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
import jakarta.servlet.http.HttpSession;
import jbsm.user.customer.dao.CustomerDao;
import jbsm.user.customer.dto.CustomerDto;
import jbsm.user.member.dao.MemberDao;
import jbsm.user.member.dto.MemberDto;

@WebServlet(value = "/customer/new")
public class CustomerNew extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

	      String ssoMemberEmail = (String) session.getAttribute("memberEmail");
	      
	      if(ssoMemberEmail == null) {
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("../member/login");
	            dispatcher.forward(request, response);
	            
	            return;
	        
	      }
	      
		response.sendRedirect("./CustomerNew.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		
		try {
			int customerMno = Integer.parseInt(request.getParameter("customerMno"));
			String customerQue = request.getParameter("customerQue");
			
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerMno(customerMno);
			customerDto.setCustomerQue(customerQue);
			
			ServletContext sc = this.getServletContext();	
			conn = (Connection)sc.getAttribute("conn");
			
			CustomerDao customerDao = new CustomerDao();
			customerDao.setConnection(conn);
			
			int result;
			
			result = customerDao.customerInsert(customerDto);
			
			if(result == 0) {
				System.out.println("질문등록 실패");
				System.out.println("실패에 관련된 로직 처리해야 함");
			}		
			
			response.sendRedirect("./list");
			
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
