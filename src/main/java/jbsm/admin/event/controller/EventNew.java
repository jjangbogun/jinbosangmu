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
import jbsm.common.FileUpload;
import jbsm.user.event.dao.EventDao;
import jbsm.user.event.dto.EventDto;

@WebServlet(value = "/admin/event/new")
@MultipartConfig
public class EventNew extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("./EventNew.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {	
			
			Part filePart1;
			Part filePart2;
			filePart1 = request.getPart("eventTimg");
			filePart2 = request.getPart("eventDimg");
			
			FileUpload fileUpload = new FileUpload();
			String eventTimg = fileUpload.FileUpload(filePart1);
			String eventDimg = fileUpload.FileUpload(filePart2);
			
			String eventName = request.getParameter("eventName");
			String eventSdate = request.getParameter("eventSdate");
			String eventEdate = request.getParameter("eventEdate");
			
			EventDto eventDto = new EventDto();
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
			
			result = eventDao.eventInsert(eventDto);
			
//			0이면 추가한 회원이 없다는 의미
//			1이면 추가한 회원이 한명 있다는 의미
			if(result == 0) {
				System.out.println("이벤트 등록 실패");
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
