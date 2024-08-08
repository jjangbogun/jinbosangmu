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
					<h2>서브페이지 타이틀</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>여기에 서브페이지의 설명 멘트가 들어 갑니다!</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub" style='height: 400px'>

				<table class="table table-bordered">
					<tr>
						<td>번호</td>
						<td>질문</td>
						<td>질문날짜</td>
						<td>답변유무</td>
					</tr>	
            
               <c:forEach var="CustomerDto" items="${customerList}" varStatus="status">
                  <tr>
                     <td>
                        ${status.count}
                     </td>
                     
                     <td>
                        <a href='./detail?noticeNo=${CustomerDto.customerNo}'>
                           ${CustomerDto.customerQue}
                        </a>       
                     </td>
                     
                     <td>
                        ${CustomerDto.customerQdate}
                     </td>
                     
                     <td>
                        ${NoticeDto.noticeCdate}
                     </td>
                  </tr>
               </c:forEach>
            </table>


            </div>
        </section>
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>