package jbsm.admin.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jbsm.admin.admin.dto.AdminDto;

public class AdminDao {
	
	private Connection connection;
	
	public void setConnection(Connection conn) {
		
		this.connection = conn;
	}
	
	public int adminSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int result = 0;
		
		try {
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(3600);
			String ssoAdminEmail = (String) session.getAttribute("ssoAdminEmail");
			String pageForward = "";
			if(ssoAdminEmail == null) {
				result = 0;
			}else {
				result = 1;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("adminInsert 예외 발생");
				
		}finally {
			

			
		}

		return result;
	}	
	
	public List<AdminDto> selectList(int pageNum, int pageSize, String searchField, String searchText) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "";

//			sql += "SELECT ADMIN_NO, ADMIN_EMAIL, ADMIN_PW, ADMIN_NAME";
//			sql += " FROM ADMIN";
//			sql += " ORDER BY ADMIN_NO DESC";
			
			if (searchText == null) {
			
				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM ADMIN ORDER BY ADMIN_NO DESC) TA) ";
				sql += "WHERE RN > ? AND RN <= ?";
				
			} else {
				
				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM ADMIN WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%' ORDER BY ADMIN_NO DESC) TA) ";
				sql += "WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%' AND RN > ? AND RN <= ?";
				
			}	

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, (pageNum - 1) * pageSize);
			pstmt.setInt(2, pageNum * pageSize);

			rs = pstmt.executeQuery();

			int adminNo = 0;
			String adminEmail = "";
			String adminPw = "";
			String adminName = "";

			ArrayList<AdminDto> adminList = new ArrayList<AdminDto>();

			AdminDto adminDto = null;

			while (rs.next()) {
				
				adminNo 		= rs.getInt("ADMIN_NO");
				adminEmail 		= rs.getString("ADMIN_EMAIL");
				adminPw 		= rs.getString("ADMIN_PW");
				adminName 		= rs.getString("ADMIN_NAME");

				adminDto = new AdminDto(adminNo, adminEmail, adminPw, adminName);

				adminList.add(adminDto);
				
			}
			
			return adminList;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;

		} finally {

			try {
				if(rs != null) {
					rs.close();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(pstmt != null) {
					pstmt.close();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} 			
	}
	
	public int adminInsert(AdminDto adminDto) throws Exception {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			
			String adminEmail 	= adminDto.getAdminEmail();
			String adminPw 		= adminDto.getAdminPw();
			String adminName 	= adminDto.getAdminName();

			String sql = "";

			sql = "INSERT INTO ADMIN";
			sql += "(ADMIN_NO, ADMIN_EMAIL, ADMIN_PW, ADMIN_NAME)";
			sql += "VALUES(ADMIN_NO_SEQ.NEXTVAL, ?, ?, ?)";

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, adminEmail);
			pstmt.setString(2, adminPw);
			pstmt.setString(3, adminName);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("adminInsert 예외 발생");
				
		}finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

		return result;
	}
	
	//관리자 상세정보 조회
	public AdminDto adminModify(int no) throws Exception {
		
		AdminDto adminDto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			String sql = "";
			
			sql = "SELECT ADMIN_NO, ADMIN_EMAIL, ADMIN_PW, ADMIN_NAME";
			sql += " FROM ADMIN";
			sql += " WHERE ADMIN_NO = ?";
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			int adminNo 		= 0;
			String adminEmail 	= "";
			String adminPw 		= "";
			String adminName 	= "";
			
			adminDto = new AdminDto();
			
			if (rs.next()) {
				
				adminNo 		= rs.getInt("ADMIN_NO");
				adminEmail 		= rs.getString("ADMIN_EMAIL");
				adminPw 		= rs.getString("ADMIN_PW");
				adminName 		= rs.getString("ADMIN_NAME");
				
				adminDto.setAdminNo(adminNo);
				adminDto.setAdminEmail(adminEmail);
				adminDto.setAdminPw(adminPw);
				adminDto.setAdminName(adminName);
				
			}else {
				
				throw new Exception("해당 번호의 관리자 정보를 찾을 수 없습니다");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("adminUForm 예외 발생");
				
		}finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return adminDto;
	}
	
	//관리자 정보 변경
	public int adminUpdate(AdminDto adminDto) throws Exception {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			
			int adminNo 		= adminDto.getAdminNo();
			String adminName 	= adminDto.getAdminName();

			String sql = "";

			sql += "UPDATE ADMIN SET ADMIN_NAME=?";
			sql += " WHERE ADMIN_NO=?";

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, adminName);
			pstmt.setInt(2, adminNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("adminUpdate 예외 발생");
				
		}finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

		return result;
	}
	
	//관리자 정보 삭제
	public int adminDelete(int no) throws Exception {
	
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {

			String sql = "";

			sql += "DELETE FROM ADMIN";
			sql += " WHERE ADMIN_NO=?";

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("adminDelete 예외 발생");
				
		}finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

		return result;
	}

	//관리자 로그인
	public AdminDto adminLogin(AdminDto adminDto) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			int adminNo 		= adminDto.getAdminNo();
			String loginEmail 	= adminDto.getAdminEmail();
			String loginPass	= adminDto.getAdminPw();
			
			String adminEmail 	= "";
			String adminName 	= "";

			String sql = "";

			sql += "SELECT ADMIN_NO, ADMIN_EMAIL, ADMIN_NAME";
			sql += " FROM ADMIN";
			sql += " WHERE ADMIN_EMAIL = ? AND ADMIN_PW = ?";

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, loginEmail);
			pstmt.setString(2, loginPass);
			
			rs = pstmt.executeQuery();
			
			adminDto = new AdminDto();
			
			if(rs.next()) {
				
				adminNo 		= rs.getInt("ADMIN_NO");
				adminEmail 		= rs.getString("ADMIN_EMAIL");
				adminName 		= rs.getString("ADMIN_NAME");
				
				adminDto.setAdminNo(adminNo);
				adminDto.setAdminEmail(adminEmail);
				adminDto.setAdminName(adminName);
				
			} else {
				
				adminDto = null;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("memebrLogin 예외 발생");
				
		}finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

		return adminDto;
	}
	
	// 전체 게시글 수
	public int getTotal(String searchField, String searchText) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "";
			
			if (searchText == null || searchText == "") {
				
				sql = "SELECT COUNT(*) AS TOTAL FROM ADMIN";
			
			} else {
				
				sql = "SELECT COUNT(*) AS TOTAL FROM ADMIN WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%'";
				
			}
			
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("TOTAL");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
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
