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

<jsp:include page="../include/incHead.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/assets/incUser.css" rel="stylesheet">

<body>

<script type="text/javascript">
<!--



//-->
</script>
  
<jsp:include page="../include/incTop.jsp"></jsp:include>

	<link href="/S2.User/inc/inc-sub.css" rel="stylesheet">

	<!-- CONTENT --------------------------------------------------------------------------------->

		<section class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70' data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
			<div class='container'>
				<div class='row title'>
					<h2>패키지 상품</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>진보상무의 진행중인 패키지입니다</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub" >
			   
<!-- 				<button onclick="eventAddFnc()" value="이벤트추가"> -->
<!-- 					이벤트 추가 -->
<!-- 			    </button> -->
			    
			    <div class="row mt-5">
			    	<c:forEach var="promotionDto" items="${promotionList}">
				    	<div class="col-md-6 text-center mb-5">
					    	<p>
					    		<img alt="${promotionDto.promotionName}" class="etImg"				    		
					             src="${pageContext.request.contextPath}/upload/${promotionDto.promotionImg}">
					        </p>
							<p class="etPTag">${promotionDto.promotionName}</p>
							<p class="etPTag">${promotionDto.promotionCopy}</p>								
							<p class="etPTag">${promotionDto.promotionPhone}</p>								
				            <p class="etPTag">${promotionDto.promotionFee}</p>
				            <button class="btn btn-brown" onclick="reserveNew(${promotionDto.promotionNo});">예약하기</button>		            				            
				    	</div>
					</c:forEach>
			    </div>		   		    

            </div>
        </section>
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>