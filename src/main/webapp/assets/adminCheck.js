/**
 * 
 */

function adminLoginCheck() {

	let loginEmail = document.getElementById('loginEmail');
	let loginPass = document.getElementById('loginPass');
	let loginPassS = document.getElementById('loginPassS');
	let loginEmailValue = loginEmail.value;
	let loginPassValue = loginPass.value;

	if (loginEmailValue.length < 1) {
		alert('이메일을 입력 하세요!');
		loginEmail.focus();
		return false;
	}
	else if (loginPassValue.length < 1) {
		alert('비밀번호를 입력 하세요!');
		loginPass.focus();
		return false;
	}
	else {
		
		loginPassS.value = CryptoJS.SHA256(loginPassValue);
		//loginPassS.value = loginPassValue;
		//alert(loginPassS.value);
		return;
	}

} 