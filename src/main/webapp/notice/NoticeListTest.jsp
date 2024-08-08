<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/userIncHead.jsp"/>
<jsp:include page="/include/userIncTop.jsp"/>

   <h1>공지사항</h1>
   
   <button onclick="noticeAddFnc()" value="공지사항 추가">
   공지 추가
   </button>
   
   <table id="ntTable">
      	<tr id="ntFirstTr">
			<td class="ntTitleTd">제목</td>
			<td class="ntContentTd">내용</td>
			<td class="ntCreDateTd">작성일</td>
      	</tr>
   
		<c:forEach var="NoticeDto" items="${noticeList}">
      		<tr id="ntSecondTr">
				<td class="ntTitleTd">
					<a href='./modify?noticeNo=${NoticeDto.noticeNo}'>
						${NoticeDto.noticeTitle}
					</a>       
				</td>
				
				<td class="ntContentTd">
				    <a href='./detail?noticeNo=${NoticeDto.noticeNo}'>
						${NoticeDto.noticeContent}
					</a>
				</td>
				
				<td class="ntCreDateTd">
					${NoticeDto.noticeCdate}
				</td>
			</tr>
		</c:forEach>
	</table>

<jsp:include page="/include/userIncFooter.jsp"/>
<jsp:include page="/include/userIncClose.jsp"/>