<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String loginCheck = request.getParameter("loginCheck");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>로그인</title>
<%-- sha256 --%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>

<style type="text/css">

</style>

<script type="text/javascript">
function memberAddFnc() {
	location.href = "./add";
}

</script>

</head>

<body>

	<jsp:include page="/Header.jsp"/>
	
	<h2>사용자 로그인</h2>
	<form action="./login" method="post" onsubmit="return loginCheckFnc()">
		<label>이메일</label>
		<input type="text" name="memberEmail" id="memberEmail" placeholder="ex:hong@test.com" value="">
		<br>
		<label>암호</label><input type="password" name="memberPw" id="memberPw" value="">
		<input type='hidden' name='securePw' id='securePw' value=''>
		<br>
		<input type="submit" value="로그인">
	</form>
	<button onclick="memberAddFnc()" value="회원가입">
		회원가입
	</button>
	<form>
		<input type='hidden' id='loginCheck' value='<%=loginCheck %>'>
	</form>
	
	<jsp:include page="/Tail.jsp"/>
</body>

<script>

	var loginCheck = document.getElementById("loginCheck").value;

// 	if(loginCheck == 'fail'){
// 		alert("로그인 정보를 다시 입력해 주세요");
// 	}

	function loginCheckFnc() {
		let memberEmail = document.getElementById('memberEmail').value;
		let memberPw = document.getElementById('memberPw').value;
		
		let securePw = null;
		securePw = sha256(memberPw);
		document.getElementById('securePw').value = securePw;
		
		if(memberEmail.length < 1){
			alert("이메일을 입력하세요");
			return false;
		}
		
		if(memberPw.length < 1){
			alert("비밀번호를 입력하세요");
			return false;
		}

	}
</script>
</html>