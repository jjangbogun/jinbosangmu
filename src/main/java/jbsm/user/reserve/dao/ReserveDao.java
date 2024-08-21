package jbsm.user.reserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jbsm.user.hotel.dto.HotelDto;
import jbsm.user.promotion.dto.PromotionDto;
import jbsm.user.reserve.dto.ReserveDto;

public class ReserveDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public List<ReserveDto> reserveList(int pageNum, int pageSize, String searchField, String searchText) throws Exception {

		PreparedStatement pstmt = null;// 상태
		ResultSet rs = null;// 요청

		try {
			String sql = "";

			if (searchText == null) {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM RESERVE ORDER BY RESERVE_NO DESC) TA) ";
				sql += "WHERE RN > ? AND RN <= ?";

			} else {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM RESERVE WHERE " + searchField.trim() + " LIKE '%" + searchText.trim()
						+ "%' ORDER BY RESERVE_NO DESC) TA) ";
				sql += "WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%' AND RN > ? AND RN <= ?";

			}

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, (pageNum - 1) * pageSize);
			pstmt.setInt(2, pageNum * pageSize);

			rs = pstmt.executeQuery();

			int reserveNo = 0;
			int reservePno = 0;
			int reserveMno = 0;
			int reserveStat = 0;
			String reserveCode = "";
			String reserveName = "";
			String reservePhone = "";
			int reserveFea = 0;
			int reserveFee = 0;
			int reserveBea = 0;
			int reserveBcost = 0;
			int reserveSum = 0;
			String reserveSdate = "";
			String reserveEdate = "";
			String reserveAdd = "";
			Date reserveRdate = null;

			ArrayList<ReserveDto> reserveList = new ArrayList<ReserveDto>();

			ReserveDto reserveDto = null;

			while (rs.next()) {
				reserveNo = rs.getInt("RESERVE_NO");
				reservePno = rs.getInt("RESERVE_PNO");
				reserveMno = rs.getInt("RESERVE_MNO");
				reserveStat = rs.getInt("RESERVE_STAT");
				reserveCode = rs.getString("RESERVE_CODE");
				reserveName = rs.getString("RESERVE_NAME");
				reservePhone = rs.getString("RESERVE_PHONE");
				reserveFea = rs.getInt("RESERVE_FEA");
				reserveFee = rs.getInt("RESERVE_FEE");
				reserveBea = rs.getInt("RESERVE_BEA");
				reserveBcost = rs.getInt("RESERVE_BCOST");
				reserveSum = rs.getInt("RESERVE_SUM");
				reserveSdate = rs.getString("RESERVE_SDATE");
				reserveEdate = rs.getString("RESERVE_EDATE");
				reserveAdd = rs.getString("RESERVE_ADD");
				reserveRdate = rs.getDate("RESERVE_RDATE");

				reserveDto = new ReserveDto(reserveNo, reservePno, reserveMno, reserveStat, reserveCode, reserveName
						, reservePhone, reserveFea, reserveFee, reserveBea, reserveBcost, reserveSum, reserveSdate
						, reserveEdate, reserveAdd, reserveRdate);

				reserveList.add(reserveDto);
			}

			return reserveList;
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


	public int reserveInsert(ReserveDto reserveDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {

			int reservePno = reserveDto.getReservePno();
			int reserveMno = reserveDto.getReserveMno();
			int reserveStat = reserveDto.getReserveStat();
			String reserveCode = reserveDto.getReserveCode();
			String reserveName = reserveDto.getReserveName();
			String reservePhone = reserveDto.getReservePhone();
			int reserveFea = reserveDto.getReserveFea();
			int reserveFee = reserveDto.getReserveFee();
			int reserveBea = reserveDto.getReserveBea();
			int reserveBcost = reserveDto.getReserveBcost();
			int reserveSum = reserveDto.getReserveSum();
			String reserveSdate = reserveDto.getReserveSdate();
			String reserveEdate = reserveDto.getReserveEdate();
			String reserveAdd = reserveDto.getReserveAdd();
			
			String sql = "";
			
			sql += "INSERT INTO RESERVE";
			sql += " (RESERVE_NO, RESERVE_PNO, RESERVE_MNO, RESERVE_STAT, RESERVE_CODE, RESERVE_NAME, RESERVE_PHONE";
			sql += " , RESERVE_FEA, RESERVE_FEE, RESERVE_BEA, RESERVE_BCOST, RESERVE_SUM, RESERVE_SDATE";
			sql += " , RESERVE_EDATE, RESERVE_ADD, RESERVE_RDATE)";
			sql += " VALUES(RESERVE_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, reservePno);
			pstmt.setInt(2, reserveMno);
			pstmt.setInt(3, reserveStat);
			pstmt.setString(4, reserveCode);
			pstmt.setString(5, reserveName);
			pstmt.setString(6, reservePhone);
			pstmt.setInt(7, reserveFea);
			pstmt.setInt(8, reserveFee);
			pstmt.setInt(9, reserveBea);
			pstmt.setInt(10, reserveBcost);
			pstmt.setInt(11, reserveSum);
			pstmt.setString(12, reserveSdate);
			pstmt.setString(13, reserveEdate);
			pstmt.setString(14, reserveAdd);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("ReserveDao reserveInsert() 예외 발생");
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
		public ReserveDto reserveSelectOne(int reserveNo) throws Exception {
			ReserveDto reserveDto = new ReserveDto();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "";

			sql += "SELECT RESERVE_NO, RESERVE_PNO, RESERVE_MNO, RESERVE_STAT, RESERVE_CODE, RESERVE_NAME,";
			sql += " RESERVE_PHONE, RESERVE_FEA, RESERVE_FEE, RESERVE_BEA, RESERVE_BCOST, RESERVE_SUM,";
			sql += " RESERVE_SDATE, RESERVE_EDATE, RESERVE_ADD, RESERVE_RDATE";			
			sql += " FROM RESERVE";
			sql += " WHERE RESERVE_NO = ?";

			try {
				pstmt = connection.prepareStatement(sql);

				pstmt.setInt(1, reserveNo);

				rs = pstmt.executeQuery();

				int reservePno = 0;
				int reserveMno = 0;
				int reserveStat = 0;
				String reserveCode = "";
				String reserveName = "";
				String reservePhone = "";
				int reserveFea = 0;
				int reserveFee = 0;
				int reserveBea = 0;
				int reserveBcost = 0;
				int reserveSum = 0;
				String reserveSdate = "";
				String reserveEdate = "";
				String reserveAdd = "";
				Date reserveRdate;

				if (rs.next()) {
					reserveNo = rs.getInt("RESERVE_NO");
					reservePno = rs.getInt("RESERVE_PNO");
					reserveMno = rs.getInt("RESERVE_MNO");
					reserveStat = rs.getInt("RESERVE_STAT");
					reserveCode = rs.getString("RESERVE_CODE");
					reserveName = rs.getString("RESERVE_NAME");
					reservePhone = rs.getString("RESERVE_PHONE");
					reserveFea = rs.getInt("RESERVE_FEA");
					reserveFee = rs.getInt("RESERVE_FEE");
					reserveBea = rs.getInt("RESERVE_BEA");
					reserveBcost = rs.getInt("RESERVE_BCOST");
					reserveSum = rs.getInt("RESERVE_SUM");
					reserveSdate = rs.getString("RESERVE_SDATE");
					reserveEdate = rs.getString("RESERVE_EDATE");
					reserveAdd = rs.getString("RESERVE_ADD");
					reserveRdate = rs.getDate("RESERVE_RDATE");
					

					reserveDto = new ReserveDto(reserveNo, reservePno, reserveMno, reserveStat, reserveCode,
							reserveName, reservePhone, reserveFea, reserveFee, reserveBea, reserveBcost, reserveSum, 
							reserveSdate, reserveEdate, reserveAdd, reserveRdate);
				} else {
					throw new Exception("해당 번호의 예약을 찾을 수 없습니다.");
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

			return reserveDto;
		}
	
//	전체 패키지 숫자
	public int getTotal(String searchField, String searchText) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "";

			if (searchText == null || searchText == "") {

				sql = "SELECT COUNT(*) AS TOTAL FROM RESERVE";

			} else {

				sql = "SELECT COUNT(*) AS TOTAL FROM RESERVE WHERE " + searchField.trim() + " LIKE '%"
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