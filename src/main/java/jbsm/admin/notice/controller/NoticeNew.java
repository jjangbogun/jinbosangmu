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
import jbsm.user.notice.dao.NoticeDao;
import jbsm.user.notice.dto.NoticeDto;

@WebServlet(value = "/admin/notice/new")
public class NoticeNew extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.sendRedirect("./NoticeNew.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {	
			
			String noticeTitle = request.getParameter("noticeTitle");
			String noticeContent = request.getParameter("noticeContent");
			
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setNoticeTitle(noticeTitle);
			noticeDto.setNoticeContent(noticeContent);
			
			
			ServletContext sc = this.getServletContext();	
			conn = (Connection)sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			int result;
			
			result = noticeDao.noticeInsert(noticeDto);
			
//			0이면 추가한 회원이 없다는 의미
//			1이면 추가한 회원이 한명 있다는 의미
			if(result == 0) {
				System.out.println("공지등록 실패");
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
