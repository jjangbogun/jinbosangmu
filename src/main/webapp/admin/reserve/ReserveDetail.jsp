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
					예약 상세보기
				</h6>
				<div class="dropdown no-arrow"></div>
			</div>

			        <div class="mt-3">
			
		</div>                                 
                                
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class='card mb-4'>
                                                          
                                                          
                                                          
		<table class='table'>
			<tr>
				<td style='width: 10%; background: #f3f3f3'>예약번호</td>
				<td>${reserveDto.reserveCode}</td>
			</tr>
			
			<tr>
				<td style='background: #f3f3f3'>패키지이름</td>
				<td>${promotionDto.promotionName}</td>
			</tr>
			
			<tr>
				<td style='width: 10%; background: #f3f3f3'>예약자명</td>
				<td>${reserveDto.reserveName}</td>
			</tr>
			
			<tr>
				<td style='background: #f3f3f3'>전화번호</td>
				<td>${reserveDto.reservePhone}</td>
			</tr>
			
			<tr>
				<td style='width: 10%; background: #f3f3f3'>숙박기간</td>
				<td>${reserveDto.reserveFea}</td>
			</tr>
			
			<tr>
				<td style='background: #f3f3f3'>숙박요금</td>
				<td>${reserveDto.reserveFee}</td>
			</tr>
			
			<tr>
				<td style='width: 10%; background: #f3f3f3'>조식갯수</td>
				<td>${reserveDto.reserveBea}</td>
			</tr>
			
			<tr>
				<td style='background: #f3f3f3'>조식요금</td>
				<td>${reserveDto.reserveBcost}</td>
			</tr>
			
			<tr>
				<td style='background: #f3f3f3'>전체요금</td>
				<td>${reserveDto.reserveSum}</td>
			</tr>
			
			<tr>
				<td style='width: 10%; background: #f3f3f3'>입실일</td>
				<td>${reserveDto.reserveSdate}</td>
			</tr>
			
			<tr>
				<td style='background: #f3f3f3'>퇴실일</td>
				<td>${reserveDto.reserveEdate}</td>
			</tr>
			
			<tr>
				<td style='width: 10%; background: #f3f3f3'>추가요청</td>
				<td>${reserveDto.reserveAdd}</td>
			</tr>
			
			<tr>
				<td style='background: #f3f3f3'>결제일</td>
				<td>${reserveDto.reserveRdate}</td>
			</tr>
			
		</table>      	                                   
                                                          
				</div>
				
				<div class='text-center mt-5'>
		        	<button onclick='reserveList()' class='btn btn-secondary'>목록</button>
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