<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<jsp:include page="/include/userIncHead.jsp" />
	<jsp:include page="/include/userIncTop.jsp" />
	<jsp:useBean id="noticeDto" scope="request"
		class="jbsm.user.notice.dto.NoticeDto" />

	<h1>공지 수정</h1>
	<form action='./modify' method='post'>
		<input type='hidden' name='noticeNo' value='${noticeDto.noticeNo}'>

		제목: <input type='text' name='noticeTitle'
			value='${noticeDto.noticeTitle}' style='width: 300px;'><br> 
		내용: <input type='text' name='noticeContent' 
			value='${noticeDto.noticeContent}' style='width: 700px; height: 200px;'><br>

		<input type='submit' value='정보 수정'> <input type='button'
			value='삭제' onclick='pageMoveDeleteFnc(${noticeDto.noticeNo})'>
		<input type='button' value='취소' onclick='pageMoveListFnc();'>
	</form>

	<jsp:include page="/include/userIncFooter.jsp"/>
	<jsp:include page="/include/userIncClose.jsp"/>
