package jbsm.admin.promotion.controller;

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
import jbsm.user.notice.dto.PageDto;
import jbsm.user.promotion.dao.PromotionDao;
import jbsm.user.promotion.dto.PromotionDto;

@WebServlet(value = "/admin/promotion/list")
public class PromotionList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//         DB 객체 준비
		Connection conn = null;// 연결

		try {
			ServletContext sc = this.getServletContext();

//            미리 준비된 DB 객체 불러오기
			conn = (Connection) sc.getAttribute("conn");

			PromotionDao promotionDao = new PromotionDao();

			promotionDao.setConnection(conn);

			String searchField = null;
			String searchText = null;

			if (request.getParameter("searchText") != null) {
				searchField = request.getParameter("searchField");
				searchText = request.getParameter("searchText");
			}

			int pageNum = 1;
			int pageSize = 10;
			int total = promotionDao.getTotal(searchField, searchText); // 전체게시글수

			if (request.getParameter("pageNum") != null && request.getParameter("pageSize") != null) {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			}

			ArrayList<PromotionDto> promotionList = (ArrayList<PromotionDto>) promotionDao.promotionList(pageNum, pageSize,
					searchField, searchText);

			PageDto pageDto = new PageDto(pageNum, pageSize, total);

			request.setAttribute("promotionList", promotionList);
			request.setAttribute("pageDto", pageDto);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/promotion/PromotionList.jsp");

			dispatcher.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();

//               throw new ServletException(e);
			request.setAttribute("error", e);
			request.setAttribute("caseByCase", "상황에 맞는 처리 부탁");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/common/Error.jsp");
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

}
