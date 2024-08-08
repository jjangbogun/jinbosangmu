<%@page import="jbsm.user.member.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>회원 등록</title>
<%-- sha256 --%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>

<script type="text/javascript">
	
</script>
</head>
<body>

	<jsp:include page="/Header.jsp"/>
	
	<h1>회원등록</h1>
	<form action='new' method='post' onsubmit="return addMemberCheckFnc()">
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
		<input type='hidden' name='securePw' id='securePw' value=''>
		<input type='submit' value='추가'>
		<input type='reset' value='취소'>
	</form>
	
	
	<jsp:include page="/Tail.jsp"/>
</body>
<script type="text/javascript">
	function addMemberCheckFnc(){
		let memberEmail = document.getElementById('memberEmail').value;
		let memberName = document.getElementById('memberName').value;
		let memberPw = document.getElementById('memberPw').value;
		let memberPwc = document.getElementById('memberPwc').value;
		let phoneNum2 = document.getElementById('phoneNum2').value;
		let phoneNum3 = document.getElementById('phoneNum3').value;
		
		let securePw = null;
		securePw = sha256(memberPw);
		document.getElementById('securePw').value = securePw;
		
// 		if(securePw != null){
			
// 			return false;
// 		}
		
		
		if(memberEmail.length < 1){
			alert("이메일을 입력하세요");
			return false;
		}
		
		if(memberName.length < 1){
			alert("이름 입력하세요");
			return false;
		}
		
		if(memberPw.length < 1){
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		if(memberPwc.length < 1){
			alert("비밀번호 확인을 입력하세요");
			return false;
		}
		
		if(phoneNum2.length <= 3 || phoneNum3.length <= 3){
			alert("전화번호를 입력하세요");
			return false;
		}
		
		if(memberPw != memberPwc){
			alert("비밀번호가 서로 일치하지 않습니다");
			return false;
		}
		
		return;
	}
</script>
</html>