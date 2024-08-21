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
				<h6 class="m-0 font-weight-bold text-primary font_size_20">
					호텔
				</h6>
				<div class="dropdown no-arrow"></div>
			</div>

			        <div class="mt-3">
			
		</div>                                 
                                
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class='card mb-4'>
                                                          
		<table class="table">
			<thead>
				<tr style='background: #f6f6f6;'>
					<th class='col-auto' scope="col">번호</th>
					<th class='col-auto' scope="col">호텔이름</th>
					<th class='col-auto' scope="col">호텔등급</th>
					<th class='col-auto' scope="col">전화번호</th>
					<th class='col-auto' scope="col">주소</th>
					<th class='col-auto' scope="col">비고</th>
				</tr>
			</thead>
			<tbody >
			
				<c:forEach var="HotelDto" items="${hotelList}" varStatus="i">
					<tr id="ntSecondTr">
						<td>${pageDto.total - (pageDto.pageNum-1) * pageDto.pageSize - i.index}</td>
		
<!-- 						<td class="ntTitleTd"> -->
<%-- 							<a href='./detail?noticeNo=${NoticeDto.noticeNo}'> --%>
<%-- 								${NoticeDto.noticeTitle}  --%>
<!-- 							</a> -->
<!-- 						</td> -->

						<td class="ntCreDateTd">${HotelDto.hotelName}</td>
						<td class="ntCreDateTd">${HotelDto.hotelClass}</td>
						<td class="ntCreDateTd">${HotelDto.hotelPhone}</td>
						<td class="ntCreDateTd">${HotelDto.hotelAddr}</td>
						<td>
							<div class="btn-group" role="group">
								<button type="button" class="btn btn-secondary btn-sm" 
								onclick='hotelModify(${HotelDto.hotelNo});'>변경</button>
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
			    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/list?pageNum=${pageDto.startPage-1}&pageSize=${pageDto.pageSize}">Previous</a></li>
			  </c:if>
			  <c:forEach var="num" begin="${pageDto.startPage}" end="${pageDto.endPage}">
			    <li class="page-item <c:if test="${pageDto.pageNum == num}">active</c:if>"><a class="page-link" href="${pageContext.request.contextPath}/admin/list?pageNum=${num}&pageSize=${pageDto.pageSize}">${num}</a></li>
			  </c:forEach>
			  <c:if test="${pageDto.next }">
			    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin/list?pageNum=${pageDto.endPage+1}&pageSize=${pageDto.pageSize}">Next</a></li>
			  </c:if>
			  </ul>
			</nav>		
		</div>                            
		<div class='text-center'>
			<input type='button' value='신규등록' class='btn btn-secondary' onclick='hotelNew();'>
		</div>                                    
                               
			</div>
		</div>
	</div>

</div>

<form action='${pageContext.request.contextPath}/admin/delete'
	name='deleteForm' id='deleteForm' method='post'
	onSubmit='return false;'>
	<input type='hidden' id='deleteNo' name='deleteNo' value=''>
</form>

<jsp:include page="/include/incAdminFooter.jsp"></jsp:include>

<jsp:include page="/include/incAdminClose.jsp"></jsp:include>