package jbsm.admin.hotel.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jbsm.user.hotel.dao.HotelDao;
import jbsm.user.hotel.dto.HotelDto;
import jbsm.user.notice.dao.NoticeDao;
import jbsm.user.notice.dto.NoticeDto;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/hotel/modify"})
public class HotelModify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {
			int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
			
			ServletContext sc = this.getServletContext();

			conn = (Connection)sc.getAttribute("conn");			
			
			HotelDao hotelDao = new HotelDao();
			hotelDao.setConnection(conn);
			
			HotelDto hotelDto = hotelDao.hotelSelectOne(hotelNo);
			
			request.setAttribute("hotelDto", hotelDto);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/admin/hotel/HotelModify.jsp");
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
		
		HotelDto hotelDto = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			int hotelNo = Integer.parseInt(request.getParameter("hotelNo"));
			String hotelName = request.getParameter("hotelName");
			int hotelClass = Integer.parseInt(request.getParameter("hotelClass"));		
			String hotelPhone = request.getParameter("hotelPhone");			
			String hotelAddr = request.getParameter("hotelAddr");			
			
			hotelDto = new HotelDto();
			
			hotelDto.setHotelName(hotelName);
			hotelDto.setHotelClass(hotelClass);
			hotelDto.setHotelPhone(hotelPhone);
			hotelDto.setHotelAddr(hotelAddr);
			hotelDto.setHotelNo(hotelNo);
			
			conn = (Connection)sc.getAttribute("conn");
			
			HotelDao hotelDao = new HotelDao();
			hotelDao.setConnection(conn);
			
			int result = hotelDao.hotelUpdate(hotelDto);
			
			if(result == 0) {
				System.out.println("호텔 조회가 실패했습니다.");
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
