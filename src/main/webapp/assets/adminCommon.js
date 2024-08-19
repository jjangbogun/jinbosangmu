/**
 * 
 */

//admin

function adminList() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/list';
}

function adminSearch() {

	let searchField = document.getElementById('searchField').value;
	let searchText = document.getElementById('searchText').value;
	let setUrl = document.getElementById('setUrl').value;
	
	location.href = setUrl + '/admin/list?searchField='+searchField+'&searchText='+searchText;
}

function adminNew() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/new';
}

function adminModify(no) {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/modify?adminNo=' + no;
}

function newCheck() {

	let adminName = document.getElementById('adminName');
	let adminEmail = document.getElementById('adminEmail');
	let adminPw = document.getElementById('adminPw');
	let adminPwS = document.getElementById('adminPwS');
	let adminNameValue = adminName.value;
	let adminEmailValue = adminEmail.value;
	let adminPwValue = adminPw.value;

	if (adminNameValue.length < 1) {
		alert('관리자 이름을 입력 하세요!');
		adminName.focus();
		return false;
	}
	else if (adminEmailValue.length < 1) {
		alert('관리자 이메일을 입력 하세요!');
		adminEmail.focus();
		return false;
	}
	else if (adminPwValue.length < 1) {
		alert('관리자 비밀번호를 입력 하세요!');
		adminPw.focus();
		return false;
	}
	else {
		
		adminPwS.value = CryptoJS.SHA256(adminPwValue);
		return;
	}
}

function modifyCheck() {

	let adminNo = document.getElementById('adminNo');
	let adminName = document.getElementById('adminName');
	let adminNoValue = adminNo.value;
	let adminNameValue = adminName.value;

	if (adminNameValue.length < 1) {
		alert('관리자 이름을 입력 하세요!');
		adminName.focus();
		return false;
	}
	else {
		return;
	}
}

function adminDelete(no) {

	if (confirm('선택하신 관리자 정보를 삭제 하시겠습니까?')) {

		let form = document.getElementById('deleteForm');
		let deleteNo = document.getElementById('deleteNo');

		deleteNo.value = no;

		form.submit();
	}
	else {
		alert('삭제가 취소 되었습니다!');
		return;
	}
}

//member

function memberList() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/member/list';
}

function memberSearch() {

	let searchField = document.getElementById('searchField').value;
	let searchText = document.getElementById('searchText').value;
	let setUrl = document.getElementById('setUrl').value;
	
	location.href = setUrl + '/admin/member/list?searchField='+searchField+'&searchText='+searchText;
}

//notice

function noticeList() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/notice/list';
}

function noticeSearch() {

	let searchField = document.getElementById('searchField').value;
	let searchText = document.getElementById('searchText').value;
	let setUrl = document.getElementById('setUrl').value;
	
	location.href = setUrl + '/admin/notice/list?searchField='+searchField+'&searchText='+searchText;
}

//event

function eventList() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/event/list';
}

function eventSearch() {

	let searchField = document.getElementById('searchField').value;
	let searchText = document.getElementById('searchText').value;
	let setUrl = document.getElementById('setUrl').value;
	
	location.href = setUrl + '/admin/event/list?searchField='+searchField+'&searchText='+searchText;
}

function eventNew() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/event/new';
}

function eventModify(no) {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/event/modify?eventNo=' + no;
}

function newEventCheck() {

	let eventName = document.getElementById('eventName');
	let eventSDate = document.getElementById('eventSDate');
	let eventEDate = document.getElementById('eventEDate');
	let eventTImg = document.getElementById('eventTImg');
	let eventDImg = document.getElementById('eventDImg');
	let eventNameValue = eventName.value;
	let eventSDateValue = eventSDate.value;
	let eventEDateValue = eventEDate.value;
	let eventTImgValue = eventTImg.value;
	let eventDImgValue = eventDImg.value;

	if (eventNameValue.length < 1) {
		alert('이벤트 제목을 입력 하세요!');
		eventName.focus();
		return false;
	}
	else if (eventSDateValue.length < 1) {
		alert('이벤트 시작일을 입력 하세요!');
		eventSDate.focus();
		return false;
	}
	else if (eventEDateValue.length < 1) {
		alert('이벤트 종료일을 입력 하세요!');
		eventEDate.focus();
		return false;
	}
	else if (eventTImgValue.length < 1) {
		alert('이벤트 썸네일 이미지를 선택 하세요!');
		eventTImg.focus();
		return false;
	}
	else if (eventDImgValue.length < 1) {
		alert('이벤트 상세 이미지를 선택 하세요!');
		eventDImg.focus();
		return false;
	}
	else {
		
		return;
	}
}

function modifyEventCheck() {

	let eventName = document.getElementById('eventName');
	let eventSDate = document.getElementById('eventSDate');
	let eventEDate = document.getElementById('eventEDate');
	let eventTImg = document.getElementById('eventTImg');
	let eventDImg = document.getElementById('eventDImg');
	let eventNameValue = eventName.value;
	let eventSDateValue = eventSDate.value;
	let eventEDateValue = eventEDate.value;
	let eventTImgValue = eventTImg.value;
	let eventDImgValue = eventDImg.value;

	if (eventNameValue.length < 1) {
		alert('이벤트 제목을 입력 하세요!');
		eventName.focus();
		return false;
	}
	else if (eventSDateValue.length < 1) {
		alert('이벤트 시작일을 입력 하세요!');
		eventSDate.focus();
		return false;
	}
	else if (eventEDateValue.length < 1) {
		alert('이벤트 종료일을 입력 하세요!');
		eventEDate.focus();
		return false;
	}
	else {
		
		return;
	}
}

/*function eventDelete(no) {

	if (confirm('선택하신 이벤트를 삭제 하시겠습니까?')) {

		let form = document.getElementById('deleteForm');
		let deleteNo = document.getElementById('deleteNo');

		deleteNo.value = no;

		form.submit();
	}
	else {
		alert('삭제가 취소 되었습니다!');
		return;
	}
}*/

function eventDelete(no) {

/*	if (confirm('선택하신 이벤트를 삭제 하시겠습니까?')) {*/

		let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/event/delete?eventNo=' + no;
/*	}
	else {
		alert('삭제가 취소 되었습니다!');
		return;
	}*/

}
//customer

function customerList() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/customer/list';
}

function customerSearch() {

	let searchField = document.getElementById('searchField').value;
	let searchText = document.getElementById('searchText').value;
	let setUrl = document.getElementById('setUrl').value;
	
	location.href = setUrl + '/admin/customer/list?searchField='+searchField+'&searchText='+searchText;
}

function noticeNew() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/notice/new';
}

function noticeModify(no) {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/notice/modify?noticeNo=' + no;
}

function noticeDelete(no) {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/notice/delete?noticeNo=' + no;
}

function noticeList() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/notice/list';
}

function customerModify(no) {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/customer/modify?customerNo=' + no;
}

function customerDelete(no) {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/admin/customer/delete?customerNo=' + no;
}
