package jbsm.user.main;

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


@WebServlet(value = "/main")
public class JBSM_Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;// 연결
		try {
			ServletContext sc = this.getServletContext();

//	      미리 준비된 DB 객체 불러오기
			conn = (Connection) sc.getAttribute("conn");
			
			EventDao eventDao = new EventDao();
			   
			eventDao.setConnection(conn);
			
			ArrayList<EventDto> eventList = (ArrayList<EventDto>) eventDao.eventList();
			
			request.setAttribute("eventList", eventList);
			
			RequestDispatcher dispatcher = 
		               request.getRequestDispatcher("./main/Main.jsp");
		    dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

//          throw new ServletException(e);
		    request.setAttribute("error", e);
		    request.setAttribute("caseByCase", "상황에 맞는 처리 부탁");
		
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/common/Error.jsp");
		    dispatcher.forward(request, response);
		}
		
		
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	
}
