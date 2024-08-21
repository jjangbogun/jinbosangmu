package jbsm.admin.promotion.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

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
import jbsm.user.hotel.dao.HotelDao;
import jbsm.user.hotel.dto.HotelDto;
import jbsm.user.promotion.dao.PromotionDao;
import jbsm.user.promotion.dto.PromotionDto;

@WebServlet(value = "/admin/promotion/new")
@MultipartConfig
public class PromotionNew extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;

		try {

			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");

			HotelDao hotelDao = new HotelDao();
			hotelDao.setConnection(conn);

			ArrayList<HotelDto> hotelList = (ArrayList<HotelDto>) hotelDao.hotelList2();

			request.setAttribute("hotelList", hotelList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("./PromotionNew.jsp");
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
			Part filePart;
			filePart = request.getPart("promotionImg");

			FileUpload fileUpload = new FileUpload();
			String promotionImg = fileUpload.FileUpload(filePart);

			int promotionHno = Integer.parseInt(request.getParameter("promotionHno"));
			String promotionName = request.getParameter("promotionName");
			String promotionCopy = request.getParameter("promotionCopy");
			String promotionBdate = request.getParameter("promotionBdate");
			String promotionSdate = request.getParameter("promotionSdate");
			String promotionPhone = request.getParameter("promotionPhone");
			String promotionForm = request.getParameter("promotionForm");
			String promotionDetail = request.getParameter("promotionDetail");
			String promotionNotice = request.getParameter("promotionNotice");
			int promotionFee = Integer.parseInt(request.getParameter("promotionFee"));
			int promotionBCost = Integer.parseInt(request.getParameter("promotionBCost"));

			PromotionDto promotionDto = new PromotionDto();
			promotionDto.setPromotionHno(promotionHno);
			promotionDto.setPromotionName(promotionName);
			promotionDto.setPromotionCopy(promotionCopy);
			promotionDto.setPromotionBdate(promotionBdate);
			promotionDto.setPromotionSdate(promotionSdate);
			promotionDto.setPromotionPhone(promotionPhone);
			promotionDto.setPromotionForm(promotionForm);
			promotionDto.setPromotionDetail(promotionDetail);
			promotionDto.setPromotionNotice(promotionNotice);
			promotionDto.setPromotionImg(promotionImg);
			promotionDto.setPromotionFee(promotionFee);
			promotionDto.setPromotionBCost(promotionBCost);

			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");

			PromotionDao promotionDao = new PromotionDao();
			promotionDao.setConnection(conn);

			int result;

			result = promotionDao.promotionInsert(promotionDto);

//			0이면 추가한 회원이 없다는 의미
//			1이면 추가한 회원이 한명 있다는 의미
			if (result == 0) {
				System.out.println("패키지 등록 실패");
				System.out.println("실패에 관련된 로직 처리해야 함");
			}

			response.sendRedirect("./list");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/common/Error.jsp");

			dispatcher.forward(request, response);
		}

	}
}
