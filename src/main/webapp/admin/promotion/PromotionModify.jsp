<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/incAdminHead.jsp"></jsp:include>

<jsp:include page="/include/incAdminTop.jsp"></jsp:include>

<!-- Content Row -->
<jsp:useBean id="noticeDto" scope="request"
	class="jbsm.user.notice.dto.NoticeDto" />

<div class="row">

	<div class="col-xl-12 col-lg-12">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary font_size_20">패키지
					변경</h6>
				<div class="dropdown no-arrow"></div>
			</div>

			<div class="mt-3"></div>

			<!-- Card Body -->
			<div class="card-body">
				<div class='card mb-4'>

					<form action='modify' method='post'>
						<input type='hidden' name='promotionNo' id='promotionNo'
							value='${promotionDto.promotionNo}'>
						<table class="table">
							<tbody>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">호텔 선택</th>
								</tr>

								<tr id="ntSecondTr">
									<th>
										<select class="form-control" name="promotionHno"
											id="promotionHno">
												<c:forEach var="hotelDto" items="${hotelList}" varStatus="i">
													<option value="${hotelDto.hotelNo}" <c:if test="${hotelDto.hotelNo == promotionDto.promotionHno}">selected</c:if>>${hotelDto.hotelName}</option>
												</c:forEach>
										</select>
									</th>
								</tr>


								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">패키지 명</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionName'
										id='promotionName'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">패키지 설명</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionCopy'
										id='promotionCopy'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">예약 기간</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionBdate'
										id='promotionBdate'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">투숙 기간</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionSdate'
										id='promotionSdate'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">문의 전화번호</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionPhone'
										id='promotionPhone'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">패키지 구성</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionForm'
										id='promotionForm'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">기타 세부사항</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionDetail'
										id='promotionDetail'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">유의사항</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionNotice'
										id='promotionNotice'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">패키지 이미지</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='file' name='promotionImg'
										id='promotionImg'></td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">패키지 요금</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionFee' id='hotelClass'>
									</td>
								</tr>

								<tr style='background: #f6f6f6;'>
									<th class='w-25' scope="col">패키지 조식요금</th>
								</tr>

								<tr id="ntSecondTr">
									<td><input type='text' name='promotionBCost'
										id='promotionBCosst'></td>
								</tr>

							</tbody>
						</table>

						<div class='text-center'>
							<input type='submit' class='btn btn-secondary' value='변경'>
							<input type='reset' class='btn btn-secondary' value='취소'>
						</div>

					</form>
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