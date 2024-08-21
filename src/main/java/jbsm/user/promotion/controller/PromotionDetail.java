package jbsm.user.promotion.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jbsm.user.event.dao.EventDao;
import jbsm.user.event.dto.EventDto;


@WebServlet(urlPatterns = {"/promotion/detail"})
public class PromotionDetail extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      Connection conn = null;//연결
      
      try {
         int eventNo = Integer.parseInt(request.getParameter("eventNo"));
         
         ServletContext sc = this.getServletContext();

         conn = (Connection)sc.getAttribute("conn");         
         
         EventDao eventDao = new EventDao();
         eventDao.setConnection(conn);
         
         EventDto eventDto = eventDao.eventSelectOne(eventNo);
         
         request.setAttribute("eventDto", eventDto);
         RequestDispatcher rd = 
               request.getRequestDispatcher("./EventDetail.jsp");
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
            
   }
   
}
