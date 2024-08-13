package jbsm.admin.customer.controller;

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
import jbsm.user.customer.dao.CustomerDao;
import jbsm.user.customer.dto.CustomerDto;
import jbsm.user.event.dao.EventDao;
import jbsm.user.event.dto.EventDto;

@WebServlet(value = "/admin/customer/list")
public class CustomerList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

//      DB 객체 준비
   Connection conn = null;// 연결

   try {
      ServletContext sc = this.getServletContext();

//         미리 준비된 DB 객체 불러오기
      conn = (Connection) sc.getAttribute("conn");

      CustomerDao customerDao = new CustomerDao();
      
      customerDao.setConnection(conn);

      ArrayList<CustomerDto> customerList = (ArrayList<CustomerDto>) customerDao.customerAdList();

      request.setAttribute("customerList", customerList);

      RequestDispatcher dispatcher = 
            request.getRequestDispatcher("/admin/customer/CustomerList.jsp");
      dispatcher.include(request, response);
   } catch (Exception e) {
      e.printStackTrace();

//            throw new ServletException(e);
      request.setAttribute("error", e);
      request.setAttribute("caseByCase", "상황에 맞는 처리 부탁");

      RequestDispatcher dispatcher = request.getRequestDispatcher("/common/Error.jsp");
      dispatcher.forward(request, response);
   }
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		super.doPost(request, response);
	}
}
