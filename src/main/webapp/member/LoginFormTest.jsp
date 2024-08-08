<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/include/userIncHead.jsp"/>
<jsp:include page="/include/userIncTop.jsp"/>

<%
	String loginCheck = request.getParameter("loginCheck");
%>
	
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>
 	
	<div class='loginDiv'>
		<h2>사용자 로그인</h2>
		<form action="./login" method="post" onsubmit="return loginCheckFnc()">
			<div class="mb-3 mt-3">
	      		<label for="email">Email:</label>
		      	<input type="email" class="form-control" id="memberEmail" placeholder="ex:hong@test.com" name="memberEmail">
		    </div>
		    <div class="mb-3">
		      	<label for="pwd">Password:</label>
		      	<input type="password" class="form-control" id="memberPw" placeholder="Enter password" name="memberPw">
				<input type='hidden' name='securePw' id='securePw' value=''>
		    </div>
			<br>
			<input type="submit" value="로그인">
		</form>
		<button onclick="memberAddFnc()" value="회원가입">
			회원가입
		</button>
		<form>
			<input type='hidden' id='loginCheck' value='<%=loginCheck %>'>
		</form>
	</div>
	
<jsp:include page="/include/userIncFooter.jsp"/>
<jsp:include page="/include/userIncClose.jsp"/>