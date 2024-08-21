package jbsm.user.promotion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jbsm.user.hotel.dto.HotelDto;
import jbsm.user.promotion.dto.PromotionDto;

public class PromotionDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public List<PromotionDto> promotionList(int pageNum, int pageSize, String searchField, String searchText)
			throws Exception {

		PreparedStatement pstmt = null;// 상태
		ResultSet rs = null;// 요청

		try {
			String sql = "";

			if (searchText == null) {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM PROMOTION ORDER BY PROMOTION_NO DESC) TA) ";
				sql += "WHERE RN > ? AND RN <= ?";

			} else {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM PROMOTION WHERE " + searchField.trim() + " LIKE '%" + searchText.trim()
						+ "%' ORDER BY PROMOTION_NO DESC) TA) ";
				sql += "WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%' AND RN > ? AND RN <= ?";

			}

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, (pageNum - 1) * pageSize);
			pstmt.setInt(2, pageNum * pageSize);

			rs = pstmt.executeQuery();

			int promotionNo = 0;
			int promotionHno = 0;
			String promotionName = "";
			String promotionCopy = "";
			String promotionBdate = "";
			String promotionSdate = "";
			String promotionPhone = "";
			String promotionForm = "";
			String promotionDetail = "";
			String promotionNotice = "";
			String promotionImg = "";
			int promotionFee = 0;
			int promotionBCost = 0;

			ArrayList<PromotionDto> promotionList = new ArrayList<PromotionDto>();

			PromotionDto promotionDto = null;

			while (rs.next()) {
				promotionNo = rs.getInt("PROMOTION_NO");
				promotionHno = rs.getInt("PROMOTION_HNO");
				promotionName = rs.getString("PROMOTION_NAME");
				promotionCopy = rs.getString("PROMOTION_COPY");
				promotionBdate = rs.getString("PROMOTION_BDATE");
				promotionSdate = rs.getString("PROMOTION_SDATE");
				promotionPhone = rs.getString("PROMOTION_PHONE");
				promotionForm = rs.getString("PROMOTION_FORM");
				promotionDetail = rs.getString("PROMOTION_DETAIL");
				promotionNotice = rs.getString("PROMOTION_NOTICE");
				promotionImg = rs.getString("PROMOTION_IMG");
				promotionFee = rs.getInt("PROMOTION_FEE");
				promotionBCost = rs.getInt("PROMOTION_BCOST");

				promotionDto = new PromotionDto(promotionNo, promotionHno, promotionName, promotionCopy, promotionBdate,
						promotionSdate, promotionPhone, promotionForm, promotionDetail, promotionNotice, promotionImg,
						promotionFee, promotionBCost);

				promotionList.add(promotionDto);
			}

			return promotionList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
//         db 객체 메모리 해제
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally 종료

	}
	
	public List<PromotionDto> promotionList2() throws Exception {

		PreparedStatement pstmt = null;// 상태
		ResultSet rs = null;// 요청

		try {
			String sql = "";

			sql += "SELECT *";
			sql += " FROM PROMOTION";
			sql += " ORDER BY PROMOTION_NAME ASC";

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			int promotionNo = 0;
			int promotionHno = 0;
			String promotionName = "";
			String promotionCopy = "";
			String promotionBdate = "";
			String promotionSdate = "";
			String promotionPhone = "";
			String promotionForm = "";
			String promotionDetail = "";
			String promotionNotice = "";
			String promotionImg = "";
			int promotionFee = 0;
			int promotionBCost = 0;

			ArrayList<PromotionDto> promotionList = new ArrayList<PromotionDto>();

			PromotionDto promotionDto = null;

			while (rs.next()) {
				promotionNo = rs.getInt("PROMOTION_NO");
				promotionHno = rs.getInt("PROMOTION_HNO");
				promotionName = rs.getString("PROMOTION_NAME");
				promotionCopy = rs.getString("PROMOTION_COPY");
				promotionBdate = rs.getString("PROMOTION_BDATE");
				promotionSdate = rs.getString("PROMOTION_SDATE");
				promotionPhone = rs.getString("PROMOTION_PHONE");
				promotionForm = rs.getString("PROMOTION_FORM");
				promotionDetail = rs.getString("PROMOTION_DETAIL");
				promotionNotice = rs.getString("PROMOTION_NOTICE");
				promotionImg = rs.getString("PROMOTION_IMG");
				promotionFee = rs.getInt("PROMOTION_FEE");
				promotionBCost = rs.getInt("PROMOTION_BCOST");

				promotionDto = new PromotionDto(promotionNo, promotionHno, promotionName, promotionCopy, promotionBdate, 
						promotionSdate, promotionPhone, promotionForm, promotionDetail, promotionNotice, 
						promotionImg, promotionFee, promotionBCost);

				promotionList.add(promotionDto);
			}

			return promotionList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
//         db 객체 메모리 해제
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // finally 종료

	}

	public int promotionInsert(PromotionDto promotionDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {

			int promotionHno = promotionDto.getPromotionHno();
			String promotionName = promotionDto.getPromotionName();
			String promotionCopy = promotionDto.getPromotionCopy();
			String promotionBdate = promotionDto.getPromotionBdate();
			String promotionSdate = promotionDto.getPromotionSdate();
			String promotionPhone = promotionDto.getPromotionPhone();
			String promotionForm = promotionDto.getPromotionForm();
			String promotionDetail = promotionDto.getPromotionDetail();
			String promotionNotice = promotionDto.getPromotionNotice();
			String promotionImg = promotionDto.getPromotionImg();
			int promotionFee = promotionDto.getPromotionFee();
			int promotionBCost = promotionDto.getPromotionBCost();
			
			System.out.println(promotionHno);

			String sql = "";

			sql += "INSERT INTO PROMOTION";
			sql += " (PROMOTION_NO, PROMOTION_HNO, PROMOTION_NAME, PROMOTION_COPY, PROMOTION_BDATE, PROMOTION_SDATE, "
					+ "PROMOTION_PHONE, PROMOTION_FORM, PROMOTION_DETAIL, PROMOTION_NOTICE, PROMOTION_IMG, PROMOTION_FEE, PROMOTION_BCOST)";
			sql += " VALUES(NOTICE_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, promotionHno);
			pstmt.setString(2, promotionName);
			pstmt.setString(3, promotionCopy);
			pstmt.setString(4, promotionBdate);
			pstmt.setString(5, promotionSdate);
			pstmt.setString(6, promotionPhone);
			pstmt.setString(7, promotionForm);
			pstmt.setString(8, promotionDetail);
			pstmt.setString(9, promotionNotice);
			pstmt.setString(10, promotionImg);
			pstmt.setInt(11, promotionFee);
			pstmt.setInt(12, promotionBCost);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("promotionDao promotionInsert() 예외 발생");
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	// 패키지 상세 정보 조회
	public PromotionDto promotionSelectOne(int promotionNo) throws Exception {
		PromotionDto promotionDto = new PromotionDto();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT PROMOTION_NO, PROMOTION_HNO, PROMOTION_NAME, PROMOTION_COPY, PROMOTION_BDATE, PROMOTION_SDATE, "
				+ "PROMOTION_PHONE, PROMOTION_FORM, PROMOTION_DETAIL, PROMOTION_NOTICE, PROMOTION_IMG, PROMOTION_FEE, PROMOTION_BCOST";
		sql += " FROM PROMOTION";
		sql += " WHERE PROMOTION_NO = ?";

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, promotionNo);

			rs = pstmt.executeQuery();

			int promotionHno = 0;
			String promotionName = "";
			String promotionCopy = "";
			String promotionBdate = "";
			String promotionSdate = "";
			String promotionPhone = "";
			String promotionForm = "";
			String promotionDetail = "";
			String promotionNotice = "";
			String promotionImg = "";
			int promotionFee = 0;
			int promotionBCost = 0;

			if (rs.next()) {
				promotionNo = rs.getInt("PROMOTION_NO");
				promotionHno = rs.getInt("PROMOTION_HNO");
				promotionName = rs.getString("PROMOTION_NAME");
				promotionCopy = rs.getString("PROMOTION_COPY");
				promotionBdate = rs.getString("PROMOTION_BDATE");
				promotionSdate = rs.getString("PROMOTION_SDATE");
				promotionPhone = rs.getString("PROMOTION_PHONE");
				promotionForm = rs.getString("PROMOTION_FORM");
				promotionDetail = rs.getString("PROMOTION_DETAIL");
				promotionNotice = rs.getString("PROMOTION_NOTICE");
				promotionImg = rs.getString("PROMOTION_IMG");
				promotionFee = rs.getInt("PROMOTION_FEE");
				promotionBCost = rs.getInt("PROMOTION_BCOST");

				promotionDto = new PromotionDto(promotionNo, promotionHno, promotionName, promotionCopy, promotionBdate,
						promotionSdate, promotionPhone, promotionForm, promotionDetail, promotionNotice, promotionImg,
						promotionFee, promotionBCost);
			} else {
				throw new Exception("해당 번호의 패키지를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally 종료

		return promotionDto;
	}

	// 패키지 정보 변경
	public int promotionUpdate(PromotionDto promotionDto) {
		int result = 0;

		PreparedStatement pstmt = null;// 상태

		try {
			String sql = "";

			sql += "UPDATE PROMOTION";
			sql += " SET PROMOTION_HNO = ?, PROMOTION_NAME = ?, PROMOTION_COPY = ?, PROMOTION_BDATE = ?, "
					+ "PROMOTION_SDATE = ?, PROMOTION_PHONE = ?, PROMOTION_FORM = ?, PROMOTION_DETAIL = ?, "
					+ "PROMOTION_NOTICE = ?, PROMOTION_IMG = ?, PROMOTION_FEE = ?, PROMOTION_BCOST = ?";
			sql += " WHERE PROMOTION_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, promotionDto.getPromotionHno());
			pstmt.setString(2, promotionDto.getPromotionName());
			pstmt.setString(3, promotionDto.getPromotionCopy());
			pstmt.setString(4, promotionDto.getPromotionBdate());
			pstmt.setString(5, promotionDto.getPromotionSdate());
			pstmt.setString(6, promotionDto.getPromotionPhone());
			pstmt.setString(7, promotionDto.getPromotionForm());
			pstmt.setString(8, promotionDto.getPromotionDetail());
			pstmt.setString(9, promotionDto.getPromotionNotice());
			pstmt.setString(10, promotionDto.getPromotionImg());
			pstmt.setInt(11, promotionDto.getPromotionFee());
			pstmt.setInt(12, promotionDto.getPromotionBCost());
			pstmt.setInt(13, promotionDto.getPromotionNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} // finally 종료

		return result;
	}

//	전체 패키지 숫자
	public int getTotal(String searchField, String searchText) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "";

			if (searchText == null || searchText == "") {

				sql = "SELECT COUNT(*) AS TOTAL FROM PROMOTION";

			} else {

				sql = "SELECT COUNT(*) AS TOTAL FROM PROMOTION WHERE " + searchField.trim() + " LIKE '%"
						+ searchText.trim() + "%'";

			}

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("TOTAL");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

}