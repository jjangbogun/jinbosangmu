package jbsm.admin.reserve.controller;

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
import jbsm.user.hotel.dto.HotelDto;
import jbsm.user.promotion.dao.PromotionDao;
import jbsm.user.promotion.dto.PromotionDto;
import jbsm.user.reserve.dao.ReserveDao;
import jbsm.user.reserve.dto.ReserveDto;

@WebServlet(urlPatterns = {"/admin/reserve/detail"})
public class ReserveDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {
			int reserveNo = Integer.parseInt(request.getParameter("reserveNo"));
			int promotionNo = Integer.parseInt(request.getParameter("promotionNo"));
			
			ServletContext sc = this.getServletContext();

			conn = (Connection)sc.getAttribute("conn");	
			
			PromotionDao promotionDao = new PromotionDao();
			promotionDao.setConnection(conn);

			PromotionDto promotionDto = promotionDao.promotionSelectOne(promotionNo);

			request.setAttribute("promotionDto", promotionDto);
			
			ReserveDao reserveDao = new ReserveDao();
			reserveDao.setConnection(conn);
			
			ReserveDto reserveDto = reserveDao.reserveSelectOne(reserveNo);
			
			request.setAttribute("reserveDto", reserveDto);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/admin/reserve/ReserveDetail.jsp");
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
				
	}
	
}
