package jbsm.user.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jbsm.user.event.dto.EventDto;


public class EventDao {

   private Connection connection;

   public void setConnection(Connection conn) {
      this.connection = conn;
   }

   public List<EventDto> eventList() throws Exception {

      PreparedStatement pstmt = null;// 상태
      ResultSet rs = null;// 요청

      try {
         String sql = "";

         sql += "SELECT EVENT_NO, EVENT_NAME, EVENT_TIMG, EVENT_DIMG, EVENT_SDATE, EVENT_EDATE";
         sql += " FROM EVENT";

      
         pstmt = connection.prepareStatement(sql);

         rs = pstmt.executeQuery(sql);

         
         int eventNo = 0;     
         String eventName = "";
         String eventTimg = "";
         String eventDimg = "";
         String eventSdate = "";
         String eventEdate = "";

         ArrayList<EventDto> eventList = new ArrayList<EventDto>();

         EventDto eventDto = null;

         while (rs.next()) {
        	eventNo = rs.getInt("EVENT_NO");
        	eventName = rs.getString("EVENT_NAME");
        	eventTimg = rs.getString("EVENT_TIMG");
        	eventDimg = rs.getString("EVENT_DIMG");
        	eventSdate = rs.getString("EVENT_SDATE");
        	eventEdate = rs.getString("EVENT_EDATE");
        	          

            eventDto = new EventDto(eventNo, eventName, eventTimg, eventDimg, eventSdate, eventEdate);

            eventList.add(eventDto);
         }

         return eventList;
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

   public int eventInsert(EventDto eventDto) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
		
			String eventName = eventDto.getEventName();	
			String eventTimg = eventDto.getEventTimg();	
			String eventDimg = eventDto.getEventDimg();	
			String eventSdate = eventDto.getEventSdate();	
			String eventEdate = eventDto.getEventEdate();	

			String sql = "";

			sql += "INSERT INTO EVENT";
			sql += " (EVENT_NO, EVENT_NAME, EVENT_TIMG, EVENT_DIMG, EVENT_SDATE, EVENT_EDATE)";
			sql += " VALUES(NOTICE_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, eventName);
			pstmt.setString(2, eventTimg);
			pstmt.setString(3, eventDimg);
			pstmt.setString(4, eventSdate);
			pstmt.setString(5, eventEdate);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("eventDao eventInsert() 예외 발생");
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
	public int eventDelete(int eventNo) {
		int result = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = "";

			sql = "DELETE FROM EVENT";
			sql += " WHERE EVENT_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, eventNo);

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
	public EventDto eventSelectOne(int eventNo) throws Exception {
		EventDto eventDto = new EventDto();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT EVENT_NO, EVENT_NAME, EVENT_TIMG, EVENT_DIMG, EVENT_SDATE, EVENT_EDATE";
		sql += " FROM EVENT";
		sql += " WHERE EVENT_NO = ?";

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, eventNo);

			rs = pstmt.executeQuery();

			String eventName = "";
			String eventTimg = "";
			String eventDimg = "";
			String eventSdate = "";
			String eventEdate = "";


			if (rs.next()) {
				eventNo = rs.getInt("EVENT_NO");
				eventName = rs.getString("EVENT_NAME");
				eventTimg = rs.getString("EVENT_TIMG");
				eventDimg = rs.getString("EVENT_DIMG");
				eventSdate = rs.getString("EVENT_SDATE");
				eventEdate = rs.getString("EVENT_EDATE");

				eventDto = new EventDto(eventNo, eventName, eventTimg, eventDimg, 
						eventSdate, eventEdate);
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

		return eventDto;
	}



	// 회원 정보 변경
	public int eventUpdate(EventDto eventDto) {
		int result = 0;

		PreparedStatement pstmt = null;// 상태

		try {
			String sql = "";

			sql += "UPDATE EVENT";
			sql += " SET EVENT_NAME = ?, EVENT_TIMG = ?, EVENT_DIMG = ?, EVENT_SDATE = ?, EVENT_EDATE = ?";
			sql += " WHERE EVENT_NO = ?";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, eventDto.getEventName());
			pstmt.setString(2, eventDto.getEventTimg());
			pstmt.setString(3, eventDto.getEventDimg());
			pstmt.setString(4, eventDto.getEventSdate());
			pstmt.setString(5, eventDto.getEventEdate());
			pstmt.setInt(6, eventDto.getEventNo());

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
   
}