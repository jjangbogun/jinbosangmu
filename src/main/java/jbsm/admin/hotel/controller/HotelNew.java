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

@WebServlet(value = "/admin/hotel/new")
public class HotelNew extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.sendRedirect("./HotelNew.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {	
			
			String hotelName = request.getParameter("hotelName");
			int hotelClass = Integer.parseInt(request.getParameter("hotelClass"));
			String hotelPhone = request.getParameter("hotelPhone");
			String hotelAddr = request.getParameter("hotelAddr");
			
			
			HotelDto hotelDto = new HotelDto();
			hotelDto.setHotelName(hotelName);
			hotelDto.setHotelClass(hotelClass);
			hotelDto.setHotelPhone(hotelPhone);
			hotelDto.setHotelAddr(hotelAddr);
			
			
			ServletContext sc = this.getServletContext();	
			conn = (Connection)sc.getAttribute("conn");
			
			HotelDao hotelDao = new HotelDao();
			hotelDao.setConnection(conn);
			
			int result;
			
			result = hotelDao.hotelInsert(hotelDto);
			
//			0이면 추가한 회원이 없다는 의미
//			1이면 추가한 회원이 한명 있다는 의미
			if(result == 0) {
				System.out.println("호텔 등록 실패");
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
