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

@WebServlet(value = "/member/new")
public class MemberNew extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
      // TODO Auto-generated method stub

      response.sendRedirect("./MemberNew.jsp");
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      Connection conn = null;//연결
      
      try {
         
         String memberEmail = request.getParameter("memberEmail");
         String memberPw = request.getParameter("securePw");
         String memberName = request.getParameter("memberName");
         String phoneNum1 = request.getParameter("phoneNum1");
         String phoneNum2 = request.getParameter("phoneNum2");
         String phoneNum3 = request.getParameter("phoneNum3");
         String memberZip = request.getParameter("memberZip");
         String memberAddr1 = request.getParameter("memberAddr1");
         String memberAddr2 = request.getParameter("memberAddr2");
         
         String memberPhone = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
         
         MemberDto memberDto = new MemberDto();
         memberDto.setMemberEmail(memberEmail);
         memberDto.setMemberPw(memberPw);
         memberDto.setMemberName(memberName);
         memberDto.setMemberPhone(memberPhone);
         memberDto.setMemberZip(memberZip);
         memberDto.setMemberAddr1(memberAddr1);
         memberDto.setMemberAddr2(memberAddr2);
         
         ServletContext sc = this.getServletContext();   
         conn = (Connection)sc.getAttribute("conn");
         
         MemberDao memberDao = new MemberDao();
         memberDao.setConnection(conn);
         
         int result;
         
         result = memberDao.memberInsert(memberDto);
         
//         0이면 추가한 회원이 없다는 의미
//         1이면 추가한 회원이 한명 있다는 의미
         if(result == 0) {
            System.out.println("회원가입 실패");
            System.out.println("실패에 관련된 로직 처리해야 함");
         }
         
         
         
         response.sendRedirect("./login");
         
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
