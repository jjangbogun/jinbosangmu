package jbsm.user.reserve.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jbsm.user.member.dao.MemberDao;
import jbsm.user.member.dto.MemberDto;
import jbsm.user.promotion.dao.PromotionDao;
import jbsm.user.promotion.dto.PromotionDto;
import jbsm.user.reserve.dao.ReserveDao;
import jbsm.user.reserve.dto.ReserveDto;

@WebServlet(value = "/reserve/new")
@MultipartConfig
public class ReserveNew extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;

		try {
			HttpSession session = request.getSession();
			Integer memberNo = (Integer) session.getAttribute("memberNo");
			String pageForward = "";
			
			if(memberNo == null) {
				
				pageForward = "/member/Login.jsp";
				
				RequestDispatcher loginPage = request.getRequestDispatcher(pageForward);
				loginPage.forward(request, response);
				
				return;
			}
			
			int promotionNo = Integer.parseInt(request.getParameter("promotionNo"));
			
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			MemberDto memberDto = memberDao.memberSelectOne(memberNo);

			if (memberDto == null) {
				System.out.println("회원 정보 조회 실패");
			}
			
			request.setAttribute("memberDto", memberDto);
			
			PromotionDao promotionDao = new PromotionDao();
			promotionDao.setConnection(conn);

			PromotionDto promotionDto = promotionDao.promotionSelectOne(promotionNo);
			
			if(promotionDto == null) {
				System.out.println("패키지 정보 조회 실패");
			}

			request.setAttribute("promotionDto", promotionDto);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./ReserveNew.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);

		} finally {

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;// 연결

		try {
			
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(System.currentTimeMillis());

			int reservePno			= Integer.parseInt(request.getParameter("reservePno"));
			int reserveMno			= Integer.parseInt(request.getParameter("reserveMno"));
			int reserveStat			= Integer.parseInt(request.getParameter("reserveStat"));
			String reserveCode		= timeStamp;
			String reserveName		= request.getParameter("reserveName");
			String reservePhone		= request.getParameter("reservePhone");
			int reserveFea			= Integer.parseInt(request.getParameter("reserveFea"));
			int reserveFee			= Integer.parseInt(request.getParameter("reserveFee"));
			int reserveBea			= Integer.parseInt(request.getParameter("reserveBea"));
			int reserveBcost		= Integer.parseInt(request.getParameter("reserveBcost"));
			int reserveSum			= Integer.parseInt(request.getParameter("reserveSum"));
			String reserveSdate		= request.getParameter("reserveSdate");
			String reserveEdate		= request.getParameter("reserveEdate");
			String reserveAdd		= request.getParameter("reserveAdd");
			
			System.out.println(reserveSdate);
			System.out.println(reserveEdate);
			
			ReserveDto reserveDto = new ReserveDto();
			
			reserveDto.setReservePno(reservePno);
			reserveDto.setReserveMno(reserveMno);
			reserveDto.setReserveStat(reserveStat);
			reserveDto.setReserveCode(reserveCode);
			reserveDto.setReserveName(reserveName);
			reserveDto.setReservePhone(reservePhone);
			reserveDto.setReserveFea(reserveFea);
			reserveDto.setReserveFee(reserveFee);
			reserveDto.setReserveBea(reserveBea);
			reserveDto.setReserveBcost(reserveBcost);
			reserveDto.setReserveSum(reserveSum);
			reserveDto.setReserveSdate(reserveSdate);
			reserveDto.setReserveEdate(reserveEdate);
			reserveDto.setReserveAdd(reserveAdd);

			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");

			ReserveDao reserveDao = new ReserveDao();
			reserveDao.setConnection(conn);

			int result;

			result = reserveDao.reserveInsert(reserveDto);

//			0이면 추가한 회원이 없다는 의미
//			1이면 추가한 회원이 한명 있다는 의미
			if (result == 0) {
				System.out.println("패키지 예약 실패");
				System.out.println("실패에 관련된 로직 처리해야 함");
			}

			response.sendRedirect("../main");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/common/Error.jsp");

			dispatcher.forward(request, response);
		}

	}
}
