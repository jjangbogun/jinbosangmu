package jbsm.user.notice.controller;

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
import jbsm.user.notice.dao.NoticeDao;
import jbsm.user.notice.dto.NoticeDto;

@WebServlet(urlPatterns = {"/notice/modify"})
public class NoticeModify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			
			ServletContext sc = this.getServletContext();

			conn = (Connection)sc.getAttribute("conn");			
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			NoticeDto noticeDto = noticeDao.noticeSelectOne(noticeNo);
			
			request.setAttribute("noticeDto", noticeDto);
			RequestDispatcher rd = 
					request.getRequestDispatcher("./NoticeModify.jsp");
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
		
		NoticeDto noticeDto = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			String noticeTitle = request.getParameter("noticeTitle");
			String noticeContent = request.getParameter("noticeContent");
			
			
			noticeDto = new NoticeDto();
			
			noticeDto.setNoticeNo(noticeNo);
			noticeDto.setNoticeTitle(noticeTitle);
			noticeDto.setNoticeContent(noticeContent);
			
			conn = (Connection)sc.getAttribute("conn");
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			int result = noticeDao.noticeUpdate(noticeDto);
			
			if(result == 0) {
				System.out.println("회원 정보 조회가 실패하였습니다.");
			}
			
			response.sendRedirect("list");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Error.jsp");
			
			dispatcher.forward(request, response);
		} 
				
	}
	
}
