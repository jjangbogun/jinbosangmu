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

function ajaxValidEmail(chk_n)
{
   let setUrl = document.getElementById('setUrl').value;
   let email = $.trim($('#memberEmail').val()); 
   if (email == 0)
   {
      /* $('#emailChk').html("<div class='alert alert-danger'>아이디(이메일)를 입력해 주세요!</div>");
      $('#memberEmail').select(); */
      alert("이메일을 입력해 주세요!");
      return;
   }
   else
   {
      var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

      if (email.match(regExp) != null) 
      {
//          $('#emailChk').html('');
      }
      else 
      {
//          $('#emailChk').html("<div class='alert alert-danger'>이메일 형식이 잘못되었습니다. 다시 입력해 주세요!</div>");
//          $('#memberEmail').select();
      alert("이메일 형식이 잘못되었습니다. 다시 입력해 주세요!")
         return;
      }
   }
   var form_name = '#memberform';

   var string = $(form_name).serialize();

   $.ajax({
      type: 'POST',
      url: setUrl + '/member/emailcheck',
      data: string,
      beforeSend:function()
      {

      },
      complete:function()
      {

      },
      success: function(data, dataType)
      {
         var returnValue = data.split('$$');
         if (returnValue[0] == 'ok')
         {
//             $('#emailChk').html("<div class='alert alert-success'>등록 가능한 아이디(이메일) 입니다!</div>");
         alert("등록 가능한 이메일 입니다!");
         }
         else if (returnValue[0] == 'error')
         {
            alert(returnValue[1] + returnValue[2]);
         }
         else if (returnValue[0] == 'reset')
         {
            alert(returnValue[0]);
         }
      },
      error: function(XMLHttpRequest, textStatus, errorThrown)
      {
         alert('Error : ' + errorThrown);
      }
   });
    
   return false;
}



</script>
  
<jsp:include page="../include/incTop.jsp"></jsp:include>

<!--    <link href="/S2.User/inc/inc-sub.css" rel="stylesheet"> -->

   <!-- CONTENT --------------------------------------------------------------------------------->

   <section class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70' data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
      <div class='container'>
         <div class='row title'>
            <h2>회원가입</h2>
            <span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
            <div class='page-breadcrumb'><span>회원가입후 진보상무의 혜택을 확인하세요!</span></div>
         </div>
      </div>
   </section>

        <!-- Content Section -->
   <section class="ptb ptb-sm-80">
      <div class="container" id="div_sub" >
   
          <h1>회원가입</h1>
          
          <form action='new' id='memberform' name='memberform' method='post' onsubmit="return memberNewCheckFnc();">
                <input type='hidden' name='securePw' id='securePw' value=''>
                <label>이메일</label>
                <input type='text' name='memberEmail' id='memberEmail' value='' onblur="ajaxValidEmail();" class='form-control col-6'>
              
                <label>이름</label>
                <input type='text' name='memberName' id='memberName' value='' class='form-control col-6'>
              
                <label>비밀번호</label>
                <input type='password' name='memberPw' id='memberPw' value='' class='form-control col-6'>
              
                <label>비밀번호 확인</label>
                <input type='password' name='memberPwc' id='memberPwc' value='' class='form-control col-6'>
             
                <label>전화번호</label>
                <select name='phoneNum1' id='phoneNum1' class='form-select text-center' style="width: 100px">
                   <option value='010'>010</option>
                   <option value='011'>011</option>
            </select>
            <input type='text' name='phoneNum2' id='phoneNum2' value='' 
                  style='width:150px;' maxlength="4" class='form-control'>
            <input type='text' name='phoneNum3' id='phoneNum3' value='' 
                  style='width:150px;' maxlength="4" class='form-control'>
              
                <label>우편번호</label>
                <input type='text' name='memberZip' id='memberZip' value='' 
                   class='form-control' style="width: 400px">
             
                <label>주소</label>
                <input type='text' name='memberAddr1' id='memberAddr1' value='' 
                   class='form-control'>
             
                <label>상세주소</label>
                <input type='text' name='memberAddr2' id='memberAddr2' value='' 
                   class='form-control'>
                <input type='submit' value='가입' class='btn btn-brown'>
                <input type='reset' value='취소' class='btn btn-brown'>
          </form>
          <form action='emailcheck' id='emailcheck' name='emailcheck' method='post' onsubmit="return false;">
             <input type='hidden' id='emaildup' name='emaildup'>
          </form>
   
      </div>
   </section>
        <!-- End Content Section -->

   <!-- END CONTENT ---------------------------------------------------------------------------->

   <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.js"></script>

<jsp:include page="../include/incFooter.jsp"></jsp:include>
      
<jsp:include page="../include/incClose.jsp"></jsp:include>