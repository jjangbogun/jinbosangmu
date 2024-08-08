/**
 * 
 */

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