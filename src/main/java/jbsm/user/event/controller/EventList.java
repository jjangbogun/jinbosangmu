package jbsm.user.event.controller;

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
import jbsm.user.event.dao.EventDao;
import jbsm.user.event.dto.EventDto;

/**
 * ALT + SHIFT + J : API 주석 회원 목록 조회 구현
 * 	
 */
@WebServlet(value = "/event/list")
public class EventList extends HttpServlet {

   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

//         DB 객체 준비
      Connection conn = null;// 연결

      try {
         ServletContext sc = this.getServletContext();

//            미리 준비된 DB 객체 불러오기
         conn = (Connection) sc.getAttribute("conn");

         EventDao eventDao = new EventDao();
         
         eventDao.setConnection(conn);

         ArrayList<EventDto> eventList = (ArrayList<EventDto>) eventDao.eventList();

         request.setAttribute("eventList", eventList);

         RequestDispatcher dispatcher = 
               request.getRequestDispatcher("/event/EventList.jsp");
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
