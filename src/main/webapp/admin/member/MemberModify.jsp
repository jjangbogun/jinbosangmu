<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/incAdminHead.jsp"></jsp:include>

<jsp:include page="/include/incAdminTop.jsp"></jsp:include>

<!-- Content Row -->

<div class="row">

	<jsp:useBean id="memberDto" scope="request"
		class="jbsm.user.member.dto.MemberDto" />

	<div class="col-xl-12 col-lg-12">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div
				class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
				<h6 class="m-0 font-weight-bold text-primary font_size_20">
					회원 정보변경</h6>
				<div class="dropdown no-arrow"></div>
			</div>

			<!-- Card Body -->
			<div class="card-body">
<!-- 				<div class='card mb-4'> -->
				
					<form action='./modify' method='post'>
					<input type='hidden' name='memberNo' class='form-control' value='${memberDto.memberNo}'>
				
					<div class="row">
						<div class="col-md-12">
							<label>이름</label> 
							<input type='text' name='memberName' class='form-control' value='${memberDto.memberName}'>
						</div>
						<div class="col-md-12">
							<label>전화번호</label> 

							<select name='phoneNum1' id='phoneNum1' class='form-select text-center' style="width: 100px">
								<option value='010'>010</option>
								<option value='011'>011</option>
							</select><input type='text' name='phoneNum2' id='phoneNum2' value='' style='width: 150px;' maxlength="4" class='form-control'>

							<input type='text' name='phoneNum3' id='phoneNum3' value='' style='width: 150px;' maxlength="4" class='form-control'>

						</div>
						<div class="col-md-12">
							<label>우편번호</label> 
							<input type='text' name='memberZip' class='form-control' value='${memberDto.memberZip}' style='width: 150px;'>
							<label>주소</label>
							<input type='text' name='memberAddr1' class='form-control' value='${memberDto.memberAddr1}'> 
							<label>상세주소</label> 
							<input type='text' name='memberAddr2' class='form-control' value='${memberDto.memberAddr2}'>
						</div>
					</div>



										<input type='submit' value='정보 수정' class='btn btn-secondary mb-3'> 
										<input type='reset' value='취소' class='btn btn-secondary mb-3'>
					</form>

					<!-- Content Section -->


<!-- 				</div> -->

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