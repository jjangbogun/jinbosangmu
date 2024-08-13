package jbsm.admin.notice.controller;

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
import jbsm.user.notice.dao.NoticeDao;

@WebServlet(value = "/admin/notice/delete")
public class NoticeDelete extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      Connection conn = null;
      
      try {
    	 ServletContext sc = this.getServletContext();
          
         int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
         
         conn = (Connection)sc.getAttribute("conn");
         
         NoticeDao noticeDao = new NoticeDao();
         noticeDao.setConnection(conn);
         
         int result = noticeDao.noticeDelete(noticeNo);
         
         if(result == 0) {
        	 System.out.println("공지 삭제가 정상처리 되지 않았습니다.");
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
   
   @Override
   protected void doPost(HttpServletRequest requset, HttpServletResponse response) 
      throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      
      
   }
   
}
