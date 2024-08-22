package jbsm.user.member.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jbsm.user.member.dao.MemberDao;
import jbsm.user.member.dto.MemberDto;

@WebServlet(value = "/member/emailcheck")
public class MemberDup extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
      // TODO Auto-generated method stub
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      Connection conn = null;//연결
      
      try {
         
         String emaildup = request.getParameter("memberEmail").trim();    
         
         ServletContext sc = this.getServletContext();   
         conn = (Connection)sc.getAttribute("conn");
         
         MemberDao memberDao = new MemberDao();
         memberDao.setConnection(conn);
         
         int result;
         
         result = memberDao.memberMailCheck(emaildup);
         
         System.out.println(result);
         
//         0이면 추가한 회원이 없다는 의미
//         1이면 추가한 회원이 한명 있다는 의미
         if (result == 0) {
             
             response.getWriter().print("ok$$");
             return;
          } else {
             
             response.getWriter().print("error$$입력하신 이메일은 이미 등록된 이메일 입니다.$$"+emaildup);
             return;
          }
         
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
