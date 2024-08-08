///**
// * 
// */
///*회원가입*/
//function memberAddFnc() {
//	location.href = "./new";
//}
//
///*공지사항 추가*/
//function noticeAddFnc() {
//	location.href = "./new";
//}
//
///*로그인*/
//function loginCheckFnc() {
//	var loginCheck = document.getElementById("loginCheck").value;
//	let memberEmail = document.getElementById('memberEmail').value;
//	let memberPw = document.getElementById('memberPw').value;
//	
//	let securePw = null;
//	securePw = sha256(memberPw);
//	document.getElementById('securePw').value = securePw;
//	
//	if(memberEmail.length < 1){
//		alert("이메일을 입력하세요");
//		return false;
//	}
//	
//	if(memberPw.length < 1){
//		alert("비밀번호를 입력하세요");
//		return false;
//	}
//
//}
//
//function loginFnc() {
//	location.href = '<%=request.getContextPath()%>/member/LoginForm.jsp';
//}
//
//function pageMoveListFnc() {
//	location.href="./list";
//}
//	
//function pageMoveDeleteFnc(no) {
//	var url = "./delete?noticeNo=" + no;
//	location.href = url;
//}