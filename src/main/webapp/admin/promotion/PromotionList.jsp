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
					패키지 
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
					<th class='col-auto' scope="col">패키지제목</th>
					<th class='col-auto' scope="col">예약기간</th>
					<th class='col-auto' scope="col">투숙기간</th>
					<th class='col-auto' scope="col">문의전화번호</th>
					<th class='col-auto' scope="col">패키지요금</th>
					<th class='col-auto' scope="col">비고</th>
<!-- 					<th class='w-25' scope="col">호텔번호</th> -->
<!-- 					<th class='w-25' scope="col">패키지설명</th> -->
<!-- 					<th class='w-25' scope="col">패키지구성</th> -->
<!-- 					<th class='w-25' scope="col">기타세부사항</th> -->
<!-- 					<th class='w-25' scope="col">유의사항</th> -->
<!-- 					<th class='w-25' scope="col">패키지이미지</th> -->
<!-- 					<th class='w-25' scope="col">패키지조식요금</th> -->
				</tr>
			</thead>
			<tbody >
			
				<c:forEach var="PromotionDto" items="${promotionList}" varStatus="i">
					<tr id="ntSecondTr">
						<td>${pageDto.total - (pageDto.pageNum-1) * pageDto.pageSize - i.index}</td>
						<td class="ntCreDateTd">${PromotionDto.promotionName}</td>
						<td class="ntCreDateTd">${PromotionDto.promotionBdate}</td>
						<td class="ntCreDateTd">${PromotionDto.promotionPhone}</td>
						<td class="ntCreDateTd">${PromotionDto.promotionSdate}</td>
						<td class="ntCreDateTd">${PromotionDto.promotionFee}</td>
<%-- 						<td class="ntCreDateTd">${PromotionDto.promotionHno}</td> --%>
<%-- 						<td class="ntCreDateTd">${PromotionDto.promotionCopy}</td> --%>
<%-- 						<td class="ntCreDateTd">${PromotionDto.promotionDetail}</td>--%>
<%-- 						<td class="ntCreDateTd">${PromotionDto.promotionForm}</td> --%>
<%-- 						<td class="ntCreDateTd">${PromotionDto.promotionNotice}</td> --%>
<%-- 						<td class="ntCreDateTd">${PromotionDto.promotionImg}</td> --%>
<%-- 						<td class="ntCreDateTd">${PromotionDto.promotionBCost}</td> --%>
						
						<td>
							<div class="btn-group" role="group">
								<button type="button" class="btn btn-secondary btn-sm" 
								onclick='promotionModify(${PromotionDto.promotionNo});'>변경</button>
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
			<input type='button' value='신규등록' class='btn btn-secondary' onclick='promotionNew();'>
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