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

<%-- sha256 --%>

<jsp:include page="../include/incHead.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/assets/incUser.css" rel="stylesheet">

<body>

<script type="text/javascript">





</script>
  
<jsp:include page="../include/incTop.jsp"></jsp:include>

<!--    <link href="/S2.User/inc/inc-sub.css" rel="stylesheet"> -->

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
            <div class="container" id="div_sub" >

            <h1>회원등록</h1>
            <form action='new' method='post' onsubmit="return memberNewCheckFnc();">
               <input type='hidden' name='securePw' id='securePw' value=''>
               이메일: <input type='text' name='memberEmail' id='memberEmail' value=''><br>
               이름: <input type='text' name='memberName' id='memberName' value=''><br>
               암호: <input type='password' name='memberPw' id='memberPw' value=''><br>
               암호 확인: <input type='password' name='memberPwc' id='memberPwc' value=''><br>
               전화번호: <select name='phoneNum1' id='phoneNum1'>
                        <option value='010'>010</option>
                        <option value='011'>011</option>
                     </select>
                     <input type='text' name='phoneNum2' id='phoneNum2' value='' 
                        style='width:100px;' maxlength="4">
                     <input type='text' name='phoneNum3' id='phoneNum3' value='' 
                        style='width:100px;' maxlength="4"><br>
               우편번호: <input type='text' name='memberZip' id='memberZip' value=''><br>
               주소: <input type='text' name='memberAddr1' id='memberAddr1' value=''><br>
               상세주소: <input type='text' name='memberAddr2' id='memberAddr2' value=''><br>
               <input type='submit' value='추가' class='mbBtn'>
               <input type='reset' value='취소' class='mbBtn'>
            </form>

            </div>
        </section>
        <!-- End Content Section -->

   <!-- END CONTENT ---------------------------------------------------------------------------->

   <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.js"></script>

<jsp:include page="../include/incFooter.jsp"></jsp:include>
      
<jsp:include page="../include/incClose.jsp"></jsp:include>