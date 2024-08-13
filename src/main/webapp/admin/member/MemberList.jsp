<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/incAdminHead.jsp"></jsp:include>

<jsp:include page="/include/incAdminTop.jsp"></jsp:include>

<!-- Content Row -->

<div class="row">

	<div class="col-xl-12 col-lg-12">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary font_size_20">회원
					리스트</h6>
				<div class="dropdown no-arrow"></div>
			</div>

			<div class="mt-3">
				<form method="post" name="search"
					class="row justify-content-md-center">
					<div class="col-auto">
						<select class="form-control" name="searchField" id="searchField">
							<option value="MEMBER_NAME">이름</option>
							<option value="MEMBER_EMAIL">이메일</option>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" class="form-control" id="searchText"
							name="searchText" placeholder="검색어 입력">
					</div>
					<div class="col-auto">
						<button type="button" class="btn btn-secondary mb-3"
							onclick='memberSearch();'>검색</button>
					</div>
				</form>
			</div>

			<!-- Card Body -->
			<div class="card-body">
				<div class='card mb-4'>

					<table class="table">
						<thead>
							<tr style='background: #f6f6f6;'>
								<th class='w-25' scope="col">번호</th>
								<th class='w-25' scope="col">회원명</th>
								<th class='w-25' scope="col">이메일</th>
								<th class='w-25' scope="col">비고</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="memberDto" items="${memberList}" varStatus="i">

								<tr>
									<th scope="row">${pageDto.total - (pageDto.pageNum-1) * pageDto.pageSize - i.index}</th>
									<td>
										<a href="#" onclick='memberModify(${memberDto.memberNo});'>
											${memberDto.memberName}
										</a>
									</td>
									<td>${memberDto.memberEmail}</td>
									<td>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-danger btn-sm"
												onclick='memberDelete(${memberDto.memberNo});'>삭제</button>
										</div>
									</td>
								</tr>

							</c:forEach>

						</tbody>
					</table>

				</div>

				<div class="mb-4">
					<nav aria-label="Page navigation">
						<ul class="pagination justify-content-center">
							<c:if test="${pageDto.prev }">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/admin/member/list?pageNum=${pageDto.startPage-1}&pageSize=${pageDto.pageSize}">Previous</a></li>
							</c:if>
							<c:forEach var="num" begin="${pageDto.startPage}"
								end="${pageDto.endPage}">
								<li
									class="page-item <c:if test="${pageDto.pageNum == num}">active</c:if>"><a
									class="page-link"
									href="${pageContext.request.contextPath}/admin/member/list?pageNum=${num}&pageSize=${pageDto.pageSize}">${num}</a></li>
							</c:forEach>
							<c:if test="${pageDto.next }">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/admin/member/list?pageNum=${pageDto.endPage+1}&pageSize=${pageDto.pageSize}">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>

</div>

<form action='${pageContext.request.contextPath}/admin/member/delete'
	name='deleteForm' id='deleteForm' method='post'
	onSubmit='return false;'>
	<input type='hidden' id='deleteNo' name='deleteNo' value=''>
</form>

<jsp:include page="/include/incAdminFooter.jsp"></jsp:include>

<jsp:include page="/include/incAdminClose.jsp"></jsp:include>