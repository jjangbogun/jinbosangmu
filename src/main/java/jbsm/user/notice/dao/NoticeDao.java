package jbsm.user.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jbsm.user.member.dto.MemberDto;
import jbsm.user.notice.dto.NoticeDto;

public class NoticeDao {

	private Connection connection;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	// 공지사항 리스트
	public List<NoticeDto> noticeList(int pageNum, int pageSize, String searchField, String searchText)
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
				sql += "FROM NOTICE ORDER BY NOTICE_NO DESC) TA) ";
				sql += "WHERE RN > ? AND RN <= ?";

			} else {

				sql += "SELECT * ";
				sql += "FROM (SELECT ROWNUM RN, ";
				sql += "TA.* ";
				sql += "FROM (SELECT * ";
				sql += "FROM NOTICE WHERE " + searchField.trim() + " LIKE '%" + searchText.trim()
						+ "%' ORDER BY NOTICE_NO DESC) TA) ";
				sql += "WHERE " + searchField.trim() + " LIKE '%" + searchText.trim() + "%' AND RN > ? AND RN <= ?";

			}

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, (pageNum - 1) * pageSize);
			pstmt.setInt(2, pageNum * pageSize);

			rs = pstmt.executeQuery();

			int noticeNo = 0;
			String noticeTitle = "";
			String noticeContent = "";
			Date noticeCdate = null;

			ArrayList<NoticeDto> noticeList = new ArrayList<NoticeDto>();

			NoticeDto noticeDto = null;

			while (rs.next()) {
				noticeNo = rs.getInt("NOTICE_NO");
				noticeTitle = rs.getString("NOTICE_TITLE");
				noticeContent = rs.getString("NOTICE_CONTENT");
				noticeCdate = rs.getDate("NOTICE_CDATE");

				noticeDto = new NoticeDto(noticeNo, noticeTitle, noticeContent, noticeCdate);

				noticeList.add(noticeDto);
			}

			return noticeList;
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

	// 공지사항 추가
	public int noticeInsert(NoticeDto noticeDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String noticeTitle = noticeDto.getNoticeTitle();
			String noticeContent = noticeDto.getNoticeContent();

			String sql = "";

			sql += "INSERT INTO NOTICE";
			sql += " (NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_CDATE)";
			sql += " VALUES(NOTICE_NO_SEQ.NEXTVAL, ?, ?, SYSDATE)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, noticeTitle);
			pstmt.setString(2, noticeContent);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("noticeDao noticeInsert() 예외 발생");
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

	// 공지사항 삭제
	public int noticeDelete(int noticeNo) {
		int result = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = "";

			sql = "DELETE FROM NOTICE";
			sql += " WHERE NOTICE_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, noticeNo);

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

	// 공지사항 상세 정보 조회
	public NoticeDto noticeSelectOne(int noticeNo) throws Exception {
		NoticeDto noticeDto = new NoticeDto();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_CDATE";
		sql += " FROM NOTICE";
		sql += " WHERE NOTICE_NO = ?";

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, noticeNo);

			rs = pstmt.executeQuery();

			String noticeTitle = "";
			String noticeContent = "";
			Date noticeCdate = null;

			if (rs.next()) {
				noticeNo = rs.getInt("NOTICE_NO");
				noticeTitle = rs.getString("NOTICE_TITLE");
				noticeContent = rs.getString("NOTICE_CONTENT");
				noticeCdate = rs.getDate("NOTICE_CDATE");

				noticeDto = new NoticeDto(noticeNo, noticeTitle, noticeContent, noticeCdate);
			} else {
				throw new Exception("해당 번호의 공지사항을 찾을 수 없습니다.");
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

		return noticeDto;
	}

	// 공지사항 정보 변경
	public int noticeUpdate(NoticeDto noticeDto) {
		int result = 0;

		PreparedStatement pstmt = null;// 상태

		try {
			String sql = "";

			sql += "UPDATE NOTICE";
			sql += " SET NOTICE_TITLE = ?, NOTICE_CONTENT = ?";
			sql += " WHERE NOTICE_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, noticeDto.getNoticeTitle());
			pstmt.setString(2, noticeDto.getNoticeContent());
			pstmt.setInt(3, noticeDto.getNoticeNo());

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

//	전체 공지사항 글 수
	public int getTotal(String searchField, String searchText) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "";

			if (searchText == null || searchText == "") {

				sql = "SELECT COUNT(*) AS TOTAL FROM NOTICE";

			} else {

				sql = "SELECT COUNT(*) AS TOTAL FROM NOTICE WHERE " + searchField.trim() + " LIKE '%"
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