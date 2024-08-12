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
import jakarta.servlet.http.HttpSession;
import jbsm.user.member.dao.MemberDao;
import jbsm.user.member.dto.MemberDto;

@WebServlet(value = "/member/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("./Login.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
				
		try {
			ServletContext sc = this.getServletContext();
			
			conn = (Connection)sc.getAttribute("conn");
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			String memberEmail = request.getParameter("memberEmail");
			String memberPw = request.getParameter("securePw");
			
			MemberDto memberDto;
			
			memberDto = memberDao.memberExist(memberEmail, memberPw);
			
			// 회원이 없다면 로그인 실패 페이지로 이동
			if(memberDto == null) {				
				System.out.println("로그인실패");
				response.sendRedirect("Login.jsp?loginCheck=fail");
				
				return;	
			}
			
			HttpSession session = request.getSession();
			
			session.setAttribute("memberNo", memberDto.getMemberNo());
			session.setAttribute("memberEmail", memberDto.getMemberEmail());
			session.setAttribute("memberName", memberDto.getMemberName());
			
//			EncryptorPwd encryptorPwd = request.getAttribute(memberPw);
			
			response.sendRedirect("../main");
		
		} catch (Exception e) {
	         e.printStackTrace();
	         
	         request.setAttribute("error", e);
	         request.setAttribute("caseByCase", "상황에 맞는 처리 부탁");
	         
	         RequestDispatcher dispatcher =
	        		 request.getRequestDispatcher("/Error.jsp");
	         dispatcher.forward(request, response);
		} 
		
	}
	
}
