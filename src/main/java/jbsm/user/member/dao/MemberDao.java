package jbsm.user.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jbsm.user.member.dto.MemberDto;

public class MemberDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	// 전체회원 리스트
	public List<MemberDto> selectList(int pageNum, int pageSize, String searchField, String searchText)
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
				sql += "FROM MEMBER ORDER BY MEMBER_NO DESC) TA) ";
				sql += "WHERE RN > ? AND RN <= ?";

			} else {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM MEMBER WHERE " + searchField.trim() + " LIKE '%" + searchText.trim()
						+ "%' ORDER BY MEMBER_NO DESC) TA) ";
				sql += "WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%' AND RN > ? AND RN <= ?";

			}
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, (pageNum - 1) * pageSize);
			pstmt.setInt(2, pageNum * pageSize);

			rs = pstmt.executeQuery();

			int memberNo = 0;
			String memberEmail = "";
			String memberPw = "";
			String memberName = "";
			String memberPhone = "";
			String memberZip = "";
			String memberAddr1 = "";
			String memberAddr2 = "";
			Date memberCdate = null;

			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();

			MemberDto memberDto = null;

			while (rs.next()) {
				memberNo = rs.getInt("MEMBER_NO");
				memberEmail = rs.getString("MEMBER_EMAIL");
				memberPw = rs.getString("MEMBER_PW");
				memberName = rs.getString("MEMBER_NAME");
				memberPhone = rs.getString("MEMBER_PHONE");
				memberZip = rs.getString("MEMBER_ZIP");
				memberAddr1 = rs.getString("MEMBER_ADDR1");
				memberAddr2 = rs.getString("MEMBER_ADDR2");
				memberCdate = rs.getDate("MEMBER_CDATE");

				memberDto = new MemberDto(memberNo, memberEmail, memberPw, memberName, memberPhone, memberZip,
						memberAddr1, memberAddr2, memberCdate);

				memberList.add(memberDto);
			}

			return memberList;
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

	// 회원등록
	public int memberInsert(MemberDto memberDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			int memberNo = memberDto.getMemberNo();
			String memberEmail = memberDto.getMemberEmail();
			String memberPw = memberDto.getMemberPw();
			String memberName = memberDto.getMemberName();
			String memberPhone = memberDto.getMemberPhone();
			String memberZip = memberDto.getMemberZip();
			String memberAddr1 = memberDto.getMemberAddr1();
			String memberAddr2 = memberDto.getMemberAddr2();
			Date memberCdate = memberDto.getMemberCdate();

			String sql = "";

			sql += "INSERT INTO MEMBER";
			sql += " (MEMBER_NO, MEMBER_EMAIL, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE,";
			sql += " MEMBER_ZIP, MEMBER_ADDR1, MEMBER_ADDR2, MEMBER_CDATE)";
			sql += " VALUES(MEMBER_NO_SEQ.NEXTVAL, ?, ?, ?, ?,";
			sql += " ?, ?, ?, SYSDATE)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, memberEmail);
			pstmt.setString(2, memberPw);
			pstmt.setString(3, memberName);
			pstmt.setString(4, memberPhone);
			pstmt.setString(5, memberZip);
			pstmt.setString(6, memberAddr1);
			pstmt.setString(7, memberAddr2);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("memberDao memberInsert() 예외 발생");
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

	// 회원 삭제
	public int memberDelete(int memberNo) {
		int result = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = "";

			sql = "DELETE FROM MEMBER";
			sql += " WHERE MEMBER_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, memberNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
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

		} // finally end

		return result;
	}

	// 회원 상세 정보 조회
	public MemberDto memberSelectOne(int memberNo) throws Exception {
		MemberDto memberDto = new MemberDto();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE,";
		sql += " MEMBER_ZIP, MEMBER_ADDR1, MEMBER_ADDR2, MEMBER_CDATE";
		sql += " FROM MEMBER";
		sql += " WHERE MEMBER_NO = ?";

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			String memberEmail = "";
			String memberPw = "";
			String memberName = "";
			String memberPhone = "";
			String memberZip = "";
			String memberAddr1 = "";
			String memberAddr2 = "";
			Date memberCredate = null;

			if (rs.next()) {
				memberNo = rs.getInt("MEMBER_NO");
				memberEmail = rs.getString("MEMBER_EMAIL");
				memberPw = rs.getString("MEMBER_PW");
				memberName = rs.getString("MEMBER_NAME");
				memberPhone = rs.getString("MEMBER_PHONE");
				memberZip = rs.getString("MEMBER_ZIP");
				memberAddr1 = rs.getString("MEMBER_ADDR1");
				memberAddr2 = rs.getString("MEMBER_ADDR2");
				memberCredate = rs.getDate("MEMBER_CDATE");

				memberDto = new MemberDto(memberNo, memberEmail, memberPw, memberName, memberPhone, memberZip,
						memberAddr1, memberAddr2, memberCredate);
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
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

		return memberDto;
	}

	// 회원 정보 변경
	public int memberUpdate(MemberDto memberDto) {
		int result = 0;

		PreparedStatement pstmt = null;// 상태

		try {
			String sql = "";

			sql += "UPDATE MEMBER";
			sql += " SET MEMBER_NAME = ?, MEMBER_PHONE = ?, MEMBER_ZIP = ?, MEMBER_ADDR1 = ?, MEMBER_ADDR2 = ?";
			sql += " WHERE MEMBER_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, memberDto.getMemberName());
			pstmt.setString(2, memberDto.getMemberPhone());
			pstmt.setString(3, memberDto.getMemberZip());
			pstmt.setString(4, memberDto.getMemberAddr1());
			pstmt.setString(5, memberDto.getMemberAddr2());
			pstmt.setInt(6, memberDto.getMemberNo());

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

	// 사용자 존재 유무 / 없으면 null 리턴
	public MemberDto memberExist(String memberEmail, String memberPw) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_PW, MEMBER_NAME";
		sql += " FROM MEMBER";
		sql += " WHERE MEMBER_EMAIL = ? AND MEMBER_PW = ?";

		String memberName = "";
		int memberNo = 0;

		try {
			pstmt = connection.prepareStatement(sql);

			int colIndex = 1;

			pstmt.setString(colIndex++, memberEmail);
			pstmt.setString(colIndex, memberPw);

			rs = pstmt.executeQuery();

			MemberDto memberDto = new MemberDto();

			if (rs.next()) {
				memberNo = rs.getInt("MEMBER_NO");
				memberEmail = rs.getString("MEMBER_EMAIL");
				memberName = rs.getString("MEMBER_NAME");

				memberDto.setMemberNo(memberNo);
				memberDto.setMemberEmail(memberEmail);
				memberDto.setMemberName(memberName);

				return memberDto;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
//         db 객체 메모리 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} // finally 종료

		return null;

	}

//	전체 글 수
	public int getTotal(String searchField, String searchText) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "";

			if (searchText == null || searchText == "") {

				sql = "SELECT COUNT(*) AS TOTAL FROM MEMBER";

			} else {

				sql = "SELECT COUNT(*) AS TOTAL FROM MEMBER WHERE " + searchField.trim() + " LIKE '%"
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
	
	public int memberMailCheck(String emaildup) throws Exception {
	      int result = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      String sql = "";

	      sql += "SELECT MEMBER_NO";
	      sql += " FROM MEMBER";
	      sql += " WHERE MEMBER_EMAIL= ?";

	      try {
	         pstmt = connection.prepareStatement(sql);

	         pstmt.setString(1, emaildup);

	         rs = pstmt.executeQuery();


	         if (rs.next()) {
	            result = 1;
	         } else {
	            result = 0;
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

	      return result;
	   }
}
