<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/userIncHead.jsp"/>
<jsp:include page="/include/userIncTop.jsp"/>
	
	<jsp:useBean id="noticeDto"
   	scope="request"
  	class="jbsm.user.notice.dto.NoticeDto"/>
	
	<div class="card">
		<div class="card-header" style='font-weight: bold;'>
			${noticeDto.noticeTitle}
		</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">${noticeDto.noticeCdate}</li>
			<li class="list-group-item">${noticeDto.noticeContent}</li>
		</ul>
	</div>
	
	
<jsp:include page="/include/userIncFooter.jsp"/>
<jsp:include page="/include/userIncClose.jsp"/>