
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%-- sha256 --%>

<jsp:include page="../include/incHead.jsp"></jsp:include>

<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/assets/incUser.css"
	rel="stylesheet">

<body>

	<script type="text/javascript">
		
	</script>

	<jsp:include page="../include/incTop.jsp"></jsp:include>

	<!--    <link href="/S2.User/inc/inc-sub.css" rel="stylesheet"> -->

	<!-- CONTENT --------------------------------------------------------------------------------->

	<section
		class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70'
		data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
		<div class='container'>
			<div class='row title'>
				<h2>패키지 예약</h2>
				<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
				<div class='page-breadcrumb'>
					<span>패키지 예약 페이지 입니다</span>
				</div>
			</div>
		</div>
	</section>

	<!-- Content Section -->
	<section class="ptb ptb-sm-40" style='background: #fcfcfc;'>
		<div class="container">

			<div class='row mb20'>
				<div class='col-md-6 col-sm-12'>

					<img src="${pageContext.request.contextPath}/upload/${promotionDto.promotionImg}"
						class="img-fluid" alt=${promotionDto.promotionName}>

				</div>
			</div>

			<div class='col-md-6 col-sm-12'>

				<div>
					<p class='font_size_24 text-w-500'>${promotionDto.promotionName}</p>
					<p class='font_size_18 text-w-400 text-info'>${promotionDto.promotionCopy}</p>
					<p class='font_size_14'>예약 기간 : ${promotionDto.promotionBdate}</p>
					<p class='font_size_14'>투숙 기간 : ${promotionDto.promotionSdate}</p>
					<p class='font_size_14'>${promotionDto.promotionForm}</p>
				</div>

			</div>
		</div>

		<div class='card g-brd-black-opacity-0_4 rounded-0 mb30'>
			<span class='font_size_18 text-info card-header rounded-0'> 예약
				옵션 </span>

			<div class='card-block'>

				<div class='row'>
					<div class='col-md-6 col-sm-12'>
						<p>
							<span class='font_size_16 text-w-500'>체크인</span>
						</p>
						<div>
							<input type="text" id='checkSdate' name='checkSdate'
								class='input-sm form-full' value='' onchange='checkSdate(this);' readonly />
						</div>
						<p>
							<span class='font_size_16 text-w-500'>체크아웃</span>
						</p>
						<div>
							<input type="text" id='checkEdate' name='checkEdate'
								class='input-sm form-full' value='' readonly />
						</div>
						<hr class='mb20'>
						<p>
							<span class='font_size_16 text-w-500'>조식신청</span>
						</p>
						<div>
							<input type='number' id='checkBea' name='checkBea' value='0'
								min='0' max='2' step='1' class='input-sm form-full'
								onchange='checkBea(this);' />
						</div>
						<hr class='mt20 mb20'>
						<p>
							<span class='font_size_16 text-w-500'>추가요청</span>
						</p>
						<textarea class="input-sm form-full" id='checkAdd' name='checkAdd'
							rows="3"></textarea>
					</div>
					<div class='col-md-6 col-sm-12'>
						<div style='background: #f3f3f3;' class='row m-2 p-4'>
							<div class='col-12 pt-3 font_size_16 text-info text-w-500'>
								객실 요금 (
								<fmt:formatNumber value="${promotionDto.promotionFee}"
									pattern="#,###" />
								원 )
							</div>
							<div class='col-6 pb-3' id='innerFea'></div>
							<div class='col-6 text-right pb-3 font_size_18 text-w-500'
								id='innerFee'></div>
							<div class='col-12 pt-3 font_size_16 text-info text-w-500'>
								조식 신청 (
								<fmt:formatNumber value="${promotionDto.promotionBCost}"
									pattern="#,###" />
								원 )
							</div>
							<div class='col-6 pb-3' id='innerBea'></div>
							<div class='col-6 text-right pb-3 font_size_18 text-w-500'
								id='innerBcost'></div>
							<div class='col-12 mt20 mb20'
								style='border-top: 1px solid #e3e3e3;'></div>
							<div class='col-6 py-3 font_size_16 text-black text-w-500'>총
								결제 금액</div>
							<div class='col-6 text-right py-3 font_size_21 text-w-600'
								id='innerSum'></div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<hr class='mt40 mb40'>

		<p>
			<span class='font_size_18 text-w-500'>요금정책</span>
		</p>

		<div class='row'>

			<div class='col-12 font_size_14'>
				${promotionDto.promotionDetail}</div>

		</div>

		<hr class='mt40 mb40'>

		<p>
			<span class='font_size_18 text-w-500'>유의사항</span>
		</p>

		<div class='row'>

			<div class='col-12 font_size_14'>
				${promotionDto.promotionNotice}</div>

		</div>

		<hr class='mt40 mb40'>

		<div class='row'>
		
			<form action='new' id='reserveIForm' name='reserveIForm' method='post' onSubmit='newCheck();'>
				<input type='hidden' id='reservePno' name='reservePno' value='${promotionDto.promotionNo}'> 
				<input type='hidden' id='reserveMno' name='reserveMno' value='${memberDto.memberNo}'>
				<input type='hidden' id='reserveStat' name='reserveStat' value='0'>
				<input type='hidden' id='reserveCode' name='reserveCode' value=''>
				<input type='hidden' id='reserveName' name='reserveName' value='${memberDto.memberName}'> 
				<input type='hidden' id='reservePhone' name='reservePhone' value='${memberDto.memberPhone}'> 
				<input type='hidden' id='reserveFea' name='reserveFea' value='1'> 
				<input type='hidden' id='reserveFee' name='reserveFee' value='${promotionDto.promotionFee}'> 
				<input type='hidden' id='reserveBea' name='reserveBea' value='0'> 
				<input type='hidden' id='reserveBcost' name='reserveBcost' value='${promotionDto.promotionBCost}'> 
				<input type='hidden' id='reserveSum' name='reserveSum' value='0'> 
				<input type='hidden' id='reserveSdate' name='reserveSdate' value=''>
				<input type='hidden' id='reserveEdate' name='reserveEdate' value=''>
				<input type='hidden' id='reserveAdd' name='reserveAdd' value=''>

				<div class='col-12 text-center'>
					<button id='btnReserveInsert' type='submit' class='btn btn-danger btn-lg'>예약하기</button> 
					<a type='button' class='btn btn-secondary btn-lg' onclick='promotionList();'>돌아가기</a>
				</div>
			
			</form>


		</div>
	</section>
	<!-- End Login Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->

	<!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.js"></script>

	<jsp:include page="../include/incFooter.jsp"></jsp:include>

	<jsp:include page="../include/incClose.jsp"></jsp:include>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	
	<script>
	   $(function(){
	        $('#checkSdate').datepicker({
	          format: 'yyyy-mm-dd',
	          autoclose: true
	      });
	        $('#checkSdate').val(getDateStr(0));
	        $('#checkEdate').val(getDateStr(1));
	        
	        $('#reserveSdate').val(getDateStr(0));
	        $('#reserveEdate').val(getDateStr(1));
	   });
	</script>