<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String setLogin = request.getParameter("setLogin");
%>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<link href="${pageContext.request.contextPath}/assets/css/inc-style.css" rel="stylesheet">
	<script type='text/javascript' src='${pageContext.request.contextPath}/assets/adminCheck.js'></script>

</head>
<body>

	<!-- Section: Design Block -->
	<section class="text-center text-lg-start">
	  <style>
	    .cascading-right {
	      margin-right: -50px;
	    }
	
	    @media (max-width: 991.98px) {
	      .cascading-right {
	        margin-right: 0;
	      }
	    }
	  </style>
	
	  <!-- Jumbotron -->
	  <div class="container py-4">
	    <div class="row g-0 align-items-center">
	    
	      <div class="col-lg-4 mb-5 mb-lg-0">
	        <div class="card cascading-right bg-body-tertiary" style="
	            backdrop-filter: blur(30px);
	            ">
	          <div class="card-body p-5 shadow-5 text-center">
	            <h2 class="fw-bold mb-5"><span class='text-danger'>JINBOSANGMOO</span><br>관리자 로그인</h2>
	            <form action='${pageContext.request.contextPath}/admin/login' method='post' onsubmit='return adminLoginCheck()'>
	            	<input type="hidden" id='loginPassS' name='loginPassS' value="" />
	            
	              <!-- Email input -->
	              <div data-mdb-input-init class="form-outline mb-4">
	                <input type="email" id='loginEmail' name='loginEmail' class="form-control" />
	                <label class="form-label small" for="form3Example3">관리자 이메일을 입력 하세요!</label>
	              </div>
	
	              <!-- Password input -->
	              <div data-mdb-input-init class="form-outline mb-4">
	                <input type="password" id='loginPass' name='loginPass' class="form-control" />
	                <label class="form-label small" for="form3Example4">관리자 비밀번호를 입력 하세요!</label>
	              </div>
	
	              <!-- Submit button -->
	              <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block mb-4">
	                관리자 로그인
	              </button>
	
	              <!-- Register buttons -->
	              <div class="text-center">

	              </div>
	            </form>
	          </div>
	        </div>
	      </div>
	
	      <div class="col-lg-8 mb-5 mb-lg-0">
	        <img src="${pageContext.request.contextPath}/images/adminLoginBg.jpg" class="w-100 rounded-4 shadow-4" alt="" />
	      </div>
	    </div>
	  </div>
	  <!-- Jumbotron -->
	</section>
	<!-- Section: Design Block -->
	
<form method='post' onSubmit='return false;'>
	<input type='hidden' id='setLogin' name='setLogin' value='<%=setLogin%>'>
</form>
	
<script type="text/javascript">

	window.onload = function() {
		
		let setLogin = document.getElementById('setLogin').value;
		if (setLogin == 'fail') {
			alert('로그인 정보를 정확히 입력하세요!');
		}
	}

</script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.js"></script>

</body>
</html>