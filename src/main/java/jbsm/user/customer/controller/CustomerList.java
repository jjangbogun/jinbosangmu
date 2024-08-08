package jbsm.user.customer.controller;

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
import jakarta.servlet.http.HttpSession;
import jbsm.user.customer.dao.CustomerDao;
import jbsm.user.customer.dto.CustomerDto;

/**
 * ALT + SHIFT + J : API 주석 회원 목록 조회 구현
 * 
 */
@WebServlet(value = "/customer/list")
public class CustomerList extends HttpServlet {

   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

//         DB 객체 준비
      Connection conn = null;// 연결

      
      HttpSession session = request.getSession();

      String ssoMemberEmail = (String) session.getAttribute("memberEmail");
      
      if(ssoMemberEmail == null) {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("../member/login");
            dispatcher.forward(request, response);
            
            return;
        
      }
      
      
      try {
         ServletContext sc = this.getServletContext();

//            미리 준비된 DB 객체 불러오기
         conn = (Connection) sc.getAttribute("conn");

         CustomerDao customerDao = new CustomerDao();
         
         customerDao.setConnection(conn);
         
         int memberNo = (int) session.getAttribute("memberNo");
         
         ArrayList<CustomerDto> customerList = (ArrayList<CustomerDto>) customerDao.customerList(memberNo);

         request.setAttribute("customerList", customerList);

         RequestDispatcher dispatcher = 
               request.getRequestDispatcher("/customer/CustomerList.jsp");
         dispatcher.include(request, response);
      } catch (Exception e) {
         e.printStackTrace();

//               throw new ServletException(e);
         request.setAttribute("error", e);
         request.setAttribute("caseByCase", "상황에 맞는 처리 부탁");

         RequestDispatcher dispatcher = request.getRequestDispatcher("/common/Error.jsp");
         dispatcher.forward(request, response);
      }

   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse res) 
         throws ServletException, IOException {
   }

}
