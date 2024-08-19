package jbsm.admin.event.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jbsm.user.event.dao.EventDao;
import jbsm.user.event.dto.EventDto;
import jbsm.common.FileUpload;

@WebServlet(value = "/admin/event/modify")
@MultipartConfig
public class EventModify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Connection conn = null;

		try {
			
			int eventNo = Integer.parseInt(request.getParameter("eventNo"));
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			EventDao eventDao = new EventDao();
			eventDao.setConnection(conn);
			
			EventDto eventDto = eventDao.eventSelectOne(eventNo);
			
			if (eventDto == null) {
				System.out.println("이벤트 정보 조회 실패");
			}
			
			request.setAttribute("eventDto", eventDto);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("./EventModify.jsp");
			dispatcher.forward(request, response);
			

		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
				
		}finally {
			

			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		Connection conn = null;

		try {
			
			Part filePart1;
			Part filePart2;
			filePart1 = request.getPart("eventTimg");
			filePart2 = request.getPart("eventDimg");
			
			String fileName1 = filePart1.getSubmittedFileName();
			String fileName2 = filePart2.getSubmittedFileName();
			
			String eventTimg = null;
			String eventDimg = null;
			
			FileUpload fileUpload = new FileUpload();
			if (!fileName1.isEmpty()) {
				eventTimg = fileUpload.FileUpload(filePart1);
			}
			if (!fileName2.isEmpty()) {
				eventDimg = fileUpload.FileUpload(filePart2);
			}
			
			int eventNo 		= Integer.parseInt(request.getParameter("eventNo"));
			String eventName 	= request.getParameter("eventName");
			String eventSdate 	= request.getParameter("eventSdate");
			String eventEdate 	= request.getParameter("eventEdate");
			
			EventDto eventDto = new EventDto();
			eventDto.setEventNo(eventNo);
			eventDto.setEventName(eventName);
			eventDto.setEventTimg(eventTimg);
			eventDto.setEventDimg(eventDimg);
			eventDto.setEventSdate(eventSdate);
			eventDto.setEventEdate(eventEdate);
			
			ServletContext sc = this.getServletContext();
			conn = (Connection)sc.getAttribute("conn");
			
			EventDao eventDao = new EventDao();
			eventDao.setConnection(conn);
			
			int result;
			
			result = eventDao.eventUpdate(eventDto);
			
			if (result == 0) {
				System.out.println("이벤트 정보 수정 실패");
			}
			
			response.sendRedirect("./modify?eventNo=" + eventNo);
			

		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
				
		}finally {
			

			
		}
		
	}
}
