package jbsm.user.event.controller;

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
import jbsm.user.member.dao.MemberDao;
import jbsm.user.member.dto.MemberDto;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/event/modify"})
public class EventModify extends HttpServlet {

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
					request.getRequestDispatcher("./EventModify.jsp");
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
		
		EventDto eventDto = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			int eventNo = Integer.parseInt(request.getParameter("eventNo"));
			String eventName = request.getParameter("eventName");
			String eventTimg = request.getParameter("eventTimg");
			String eventDimg = request.getParameter("eventDimg");
			String eventSdate = request.getParameter("eventSdate");
			String eventEdate = request.getParameter("eventEdate");
			
			
			eventDto = new EventDto();
			
			eventDto.setEventNo(eventNo);
			eventDto.setEventName(eventName);
			eventDto.setEventTimg(eventTimg);
			eventDto.setEventDimg(eventDimg);
			eventDto.setEventSdate(eventSdate);
			eventDto.setEventEdate(eventEdate);
			
			conn = (Connection)sc.getAttribute("conn");
			
			EventDao eventDao = new EventDao();
			eventDao.setConnection(conn);
			
			int result = eventDao.eventUpdate(eventDto);
			
			if(result == 0) {
				System.out.println("이벤트 조회가 실패하였습니다.");
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
