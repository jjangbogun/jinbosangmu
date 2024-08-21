/**
 * 
 */
/*헤더 함수*/
function top_user_login(){
	location.href = "../member/login";
}

/*로그인이 필요한 경우 로그인 창으로 이동*/
function sendLoginFnc() {
	alert("로그인이 필요합니다");
	location.href = "../member/login";
}

/*로그인 체크*/
function loginCheckFnc() {
	var loginCheck = document.getElementById("loginCheck").value;
	let memberEmail = document.getElementById('memberEmail').value;
	let memberPw = document.getElementById('memberPw').value;
	
	let securePw = null;
	securePw = CryptoJS.SHA256(memberPw);
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

/*로그인 실패*/
function loginFnc() {		
	location.href = '<%=request.getContextPath()%>/member/LoginForm.jsp';
}

/*로그아웃*/
function top_user_logout() {
	location.href = "../member/logout";
}

/*회원 정보수정 이동*/
function top_user_modify(no) {
	location.href = "../member/modify?memberNo="+no;
}

/*회원가입 체크*/
function memberNewCheckFnc(){
	let memberEmail = document.getElementById('memberEmail').value;
	let memberName = document.getElementById('memberName').value;
	let memberPw = document.getElementById('memberPw').value;
	let memberPwc = document.getElementById('memberPwc').value;
	let phoneNum2 = document.getElementById('phoneNum2').value;
	let phoneNum3 = document.getElementById('phoneNum3').value;
	
	let securePw = null;
	securePw = CryptoJS.SHA256(memberPw);
	document.getElementById('securePw').value = securePw;
	
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

/*공지사항 목록으로 이동*/
function noticeListFnc() {		
	location.href = '../notice/list';
}

/*공지사항 페이지 이동 함수*/
function noticeSearch() {

   let searchField = document.getElementById('searchField').value;
   let searchText = document.getElementById('searchText').value;
   
   location.href = '../notice/list?searchField='+searchField+'&searchText='+searchText;

}

/*회원가입 페이지 이동 함수*/
function memberAddFnc() {
	location.href = "./new";
}

function pageMoveListFnc() {
	location.href="../main";
}

/*문의 하기 이동*/
function customerNewFnc() {
   location.href = "./new";
}

/*이벤트 추가*/
function eventAddFnc() {
   location.href = "./new";
}


function eventListFnc() {
   location.href = "./list";
}

function customerListFnc() {
   location.href = "./list";
}

function reserveNew(no) {
   location.href = "../reserve/new?promotionNo=" + no;
}

/*reserve*/
function getDateStr(setN) {

   if (setN == 0) {
      var setDate = new Date();
   } else if (setN == 1) {
      var today = new Date();
      var setDate = new Date(today.setDate(today.getDate() + 1));
   }

   let year = setDate.getFullYear();
   let month = (setDate.getMonth() + 1).toString().padStart(2, '0');
   let day = setDate.getDate().toString().padStart(2, '0');
   let getDateStr = year + '-' + month + '-' + day;
   return getDateStr;
}

function getDateDiff(d1, d2) {

   const date1 = new Date(d1);
   const date2 = new Date(d2);
   const diffDate = date1.getTime() - date2.getTime();
   return Math.abs(diffDate / (1000 * 60 * 60 * 24));
}

function checkSdate(thisInput) {

   var chkValue = thisInput.value;
   var reserveSdate = chkValue.substring(0, 10);
   var reserveEdate = chkValue.substring(13, 23);
   $('#reserveSdate').val(reserveSdate);
   $('#reserveEdate').val(reserveEdate);
   $('#reserveFea').val(getDateDiff(reserveSdate, reserveEdate));
   totalSum();
}

function checkBea(thisInput) {

   $('#reserveBea').val(thisInput.value);
   totalSum();
}

function totalSum() {

   let totalSum = 0;
   let totalSumF = 0;
   let totalSumB = 0;
   let reserveFea = $('#reserveFea').val();
   let reserveFee = $('#reserveFee').val();
   let reserveBea = $('#reserveBea').val();
   let reserveBcost = $('#reserveBcost').val();

   totalSumF = reserveFea * reserveFee;
   totalSumB = (reserveBea * reserveBcost) * reserveFea
   totalSum = totalSumF + totalSumB

   $('#reserveSum').val(totalSum);

   $('#innerFea').html(reserveFea + ' 박');
   $('#innerBea').html('조식 ' + reserveBea + ' X 박');
   $('#innerFee').html(totalSumF.toLocaleString() + ' 원');
   $('#innerBcost').html(totalSumB.toLocaleString() + ' 원');
   $('#innerSum').html(totalSum.toLocaleString() + ' 원');
}

function promotionList(){
   location.href = "../promotion/list";
}

function checkSdate(date) {
   let d = new Date(date.value);
   d.setDate(d.getDate() + 1);
   
   let year    = d.getFullYear();
   let month   = ('0' + (d.getMonth() +  1 )).slice(-2);
   let day     = ('0' + d.getDate()).slice(-2);
   dt = year+"-"+month+"-"+day;
   $('#checkEdate').val(dt);
}

function newCheck() {
   let checkAdd = $('#checkAdd').val();
   
   $('#reserveAdd').val(checkAdd);
}
