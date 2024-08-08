
<%
//****************************************************************************************
//** FILE NAME   : /sampleSub.jsp
//** DESCRIPTION : 
//** DATABASE    :
//** AUTHOR      : ChoMooYeon
//** DATE        : 2024-08-06
//** HISTORY
//****************************************************************************************
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../include/incHead.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/assets/incUser.css"
	rel="stylesheet">

<body>

	<script type="text/javascript">
	<!--
		
	//-->
	</script>

	<jsp:include page="../include/incTop.jsp"></jsp:include>

	<!-- CONTENT --------------------------------------------------------------------------------->

	<section
		class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70'
		data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
		<div class='container'>
			<div class='row title'>
				<h2>공지사항</h2>
				<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
				<div class='page-breadcrumb'>
					<span>진보상무의 공지사항입니다</span>
				</div>
			</div>
		</div>
	</section>

	<!-- Content Section -->
	<section class="ptb ptb-sm-80">
		<div class="container" id="div_sub">

			<h1>공지사항</h1>

			<div class="mt-3">
				<form method="post" name="search"
					class="row justify-content-md-center" onsubmit='return false'>
					<div class="col-auto">
						<select class="form-control" name="searchField" id="searchField">
							<option value="NOTICE_TITLE">제목</option>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" class="form-control" id="searchText"
							name="searchText" placeholder="검색어 입력" onkeydown='javascript: if (event.keyCode == 13) {noticeSearch();}'>
					</div>
					<div class="col-auto">
						<button type="button" class="btn btn-brown mb-3"
							onclick='noticeSearch();'>검색</button>
					</div>
				</form>
			</div>

			<div>
				<table id="ntTable" class="table table-bordered">
					<tr id="ntFirstTr">
						<td class="ntTitleNo">번호</td>
						<td class="ntTitleTd">제목</td>
						<td class="ntCreDateTd">작성일</td>
					</tr>

					<c:forEach var="NoticeDto" items="${noticeList}" varStatus="i">
						<tr id="ntSecondTr">
							<td>${pageDto.total - (pageDto.pageNum-1) * pageDto.pageSize - i.index}</td>

							<td class="ntTitleTd"><a
								href='./detail?noticeNo=${NoticeDto.noticeNo}'>
									${NoticeDto.noticeTitle} </a></td>

							<td class="ntCreDateTd">${NoticeDto.noticeCdate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<div>
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<c:if test="${pageDto.prev }">
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/notice/list?pageNum=${pageDto.startPage-1}&pageSize=${pageDto.pageSize}">Previous</a></li>
						</c:if>
						<c:forEach var="num" begin="${pageDto.startPage}"
							end="${pageDto.endPage}">
							<li
								class="page-item <c:if test="${pageDto.pageNum == num}">active</c:if>"><a
								class="page-link"
								href="${pageContext.request.contextPath}/notice/list?pageNum=${num}&pageSize=${pageDto.pageSize}">${num}</a></li>
						</c:forEach>
						<c:if test="${pageDto.next }">
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/notice/list?pageNum=${pageDto.endPage+1}&pageSize=${pageDto.pageSize}">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>

		</div>
	</section>
	<!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


	<jsp:include page="../include/incFooter.jsp"></jsp:include>

	<jsp:include page="../include/incClose.jsp"></jsp:include>