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

<%--  <jsp:useBean id="customerDto" --%>
<%--    	scope="request" --%>
<%--   	class="jbsm.user.customer.dto.CustomerDto"/> --%>

<body>

<script type="text/javascript">
<!--



//-->
</script>
  
<jsp:include page="../include/incTop.jsp"></jsp:include>


	<!-- CONTENT --------------------------------------------------------------------------------->

		<section class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70' data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
			<div class='container'>
				<div class='row title'>
					<h2>고객센터</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>진보상무의 고객센터입니다!</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub" style='height: 400px'>

				<div class="card">
<!-- 					<div class="card-header" style='font-weight: bold;'> -->
<%-- 						${customerDto.noticeTitle} --%>
<!-- 					</div> -->
					<ul class="list-group list-group-flush">
						<div class="card-header" style='font-weight: bold;'>
							질문
						</div>
						<li class="list-group-item">${customerDto.customerQdate}</li>
						<li class="list-group-item">${customerDto.customerQue}</li>
						<div class="card-header" style='font-weight: bold;'>
							답변
						</div>
						<li class="list-group-item">${customerDto.customerAdate}</li>
						<li class="list-group-item">${customerDto.customerAns}</li>
					</ul>
				</div>
				
				<div class='text-center mt-5'>
		        	<button onclick='noticeListFnc()' class='btn btn-brown'>목록</button>
				</div>
				
            </div>
        </section>
        
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>