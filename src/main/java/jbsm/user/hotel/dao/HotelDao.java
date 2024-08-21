package jbsm.user.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jbsm.user.hotel.dto.HotelDto;

public class HotelDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public List<HotelDto> hotelList(int pageNum, int pageSize, String searchField, String searchText) throws Exception {

		PreparedStatement pstmt = null;// 상태
		ResultSet rs = null;// 요청

		try {
			String sql = "";

			if (searchText == null) {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM HOTEL ORDER BY HOTEL_NO DESC) TA) ";
				sql += "WHERE RN > ? AND RN <= ?";

			} else {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM HOTEL WHERE " + searchField.trim() + " LIKE '%" + searchText.trim()
						+ "%' ORDER BY HOTEL_NO DESC) TA) ";
				sql += "WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%' AND RN > ? AND RN <= ?";

			}

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, (pageNum - 1) * pageSize);
			pstmt.setInt(2, pageNum * pageSize);

			rs = pstmt.executeQuery();

			int hotelNo = 0;
			String hotelName = "";
			int hotelClass = 0;
			String hotelPhone = "";
			String hotelAddr = "";

			ArrayList<HotelDto> hotelList = new ArrayList<HotelDto>();

			HotelDto hotelDto = null;

			while (rs.next()) {
				hotelNo = rs.getInt("HOTEL_NO");
				hotelName = rs.getString("HOTEL_NAME");
				hotelClass = rs.getInt("HOTEL_CLASS");
				hotelPhone = rs.getString("HOTEL_PHONE");
				hotelAddr = rs.getString("HOTEL_ADDR");

				hotelDto = new HotelDto(hotelNo, hotelName, hotelClass, hotelPhone, hotelAddr);

				hotelList.add(hotelDto);
			}

			return hotelList;
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

	public List<HotelDto> hotelList2() throws Exception {

		PreparedStatement pstmt = null;// 상태
		ResultSet rs = null;// 요청

		try {
			String sql = "";

			sql += "SELECT *";
			sql += " FROM HOTEL";
			sql += " ORDER BY HOTEL_NAME ASC";

			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			int hotelNo = 0;
			String hotelName = "";
			int hotelClass = 0;
			String hotelPhone = "";
			String hotelAddr = "";

			ArrayList<HotelDto> hotelList = new ArrayList<HotelDto>();

			HotelDto hotelDto = null;

			while (rs.next()) {
				hotelNo = rs.getInt("HOTEL_NO");
				hotelName = rs.getString("HOTEL_NAME");
				hotelClass = rs.getInt("HOTEL_CLASS");
				hotelPhone = rs.getString("HOTEL_PHONE");
				hotelAddr = rs.getString("HOTEL_ADDR");

				hotelDto = new HotelDto(hotelNo, hotelName, hotelClass, hotelPhone, hotelAddr);

				hotelList.add(hotelDto);
			}

			return hotelList;
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

	public int hotelInsert(HotelDto hotelDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {

			String hotelName = hotelDto.getHotelName();
			int hotelClass = hotelDto.getHotelClass();
			String hotelPhone = hotelDto.getHotelPhone();
			String hotelAddr = hotelDto.getHotelAddr();

			String sql = "";

			sql += "INSERT INTO HOTEL";
			sql += " (HOTEL_NO, HOTEL_NAME, HOTEL_CLASS, HOTEL_PHONE, HOTEL_ADDR)";
			sql += " VALUES(NOTICE_NO_SEQ.NEXTVAL, ?, ?, ?, ?)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, hotelName);
			pstmt.setInt(2, hotelClass);
			pstmt.setString(3, hotelPhone);
			pstmt.setString(4, hotelAddr);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("hotelDao hotelInsert() 예외 발생");
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

	// 회원 상세 정보 조회
	public HotelDto hotelSelectOne(int hotelNo) throws Exception {
		HotelDto hotelDto = new HotelDto();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT HOTEL_NO, HOTEL_NAME, HOTEL_CLASS, HOTEL_PHONE, HOTEL_ADDR";
		sql += " FROM HOTEL";
		sql += " WHERE HOTEL_NO = ?";

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, hotelNo);

			rs = pstmt.executeQuery();

			String hotelName = "";
			int hotelClass = 0;
			String hotelPhone = "";
			String hotelAddr = "";

			if (rs.next()) {
				hotelNo = rs.getInt("HOTEL_NO");
				hotelName = rs.getString("HOTEL_NAME");
				hotelClass = rs.getInt("HOTEL_CLASS");
				hotelPhone = rs.getString("HOTEL_PHONE");
				hotelAddr = rs.getString("HOTEL_ADDR");

				hotelDto = new HotelDto(hotelNo, hotelName, hotelClass, hotelPhone, hotelAddr);
			} else {
				throw new Exception("해당 번호의 호텔을 찾을 수 없습니다.");
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

		return hotelDto;
	}

	// 회원 정보 변경
	public int hotelUpdate(HotelDto hotelDto) {
		int result = 0;

		PreparedStatement pstmt = null;// 상태

		try {
			String sql = "";

			sql += "UPDATE HOTEL";
			sql += " SET HOTEL_NAME = ?, HOTEL_CLASS = ?, HOTEL_PHONE = ?, HOTEL_ADDR = ?";
			sql += " WHERE HOTEL_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, hotelDto.getHotelName());
			pstmt.setInt(2, hotelDto.getHotelClass());
			pstmt.setString(3, hotelDto.getHotelPhone());
			pstmt.setString(4, hotelDto.getHotelAddr());
			pstmt.setInt(5, hotelDto.getHotelNo());

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

//	전체 호텔 숫자
	public int getTotal(String searchField, String searchText) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "";

			if (searchText == null || searchText == "") {

				sql = "SELECT COUNT(*) AS TOTAL FROM HOTEL";

			} else {

				sql = "SELECT COUNT(*) AS TOTAL FROM HOTEL WHERE " + searchField.trim() + " LIKE '%" + searchText.trim()
						+ "%'";

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