/**
 * 
 */

function userLogin() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/user/login';
}

function userSignup() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/user/signup';
}

function userTermsSignup() {

	let setUrl = document.getElementById('setUrl').value;
	location.href = setUrl + '/user/signup?signupMode=1';
}

function ajaxValidEmail(chk_n)
{
	let setUrl = document.getElementById('setUrl').value;
	let email = $.trim($('#memberEmail').val()); 
	if (email == 0)
	{
		$('#emailChk').html("<div class='alert alert-danger'>아이디(이메일)를 입력해 주세요!</div>");
		$('#memberEmail').select();
		return;
	}
	else
	{
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		if (email.match(regExp) != null) 
		{
			$('#emailChk').html('');
		}
		else 
		{
			$('#emailChk').html("<div class='alert alert-danger'>이메일 형식이 잘못되었습니다. 다시 입력해 주세요!</div>");
			$('#memberEmail').select();
			return;
		}
	}
	if (chk_n == 0)
	{
		var form_name = '#memberIForm';
	}
	else if (chk_n == 1)
	{
		var form_name = '#memberUForm';
	}

	var string = $(form_name).serialize();

	$.ajax({
		type: 'POST',
		url: setUrl + '/user/ajaxVaildEmail?chk_n='+chk_n,
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
				$('#emailChk').html("<div class='alert alert-success'>등록 가능한 아이디(이메일) 입니다!</div>");
			}
			else if (returnValue[0] == 'error')
			{
				Swal.fire({   
					title: '',
  					text: returnValue[1],
  					icon: "error"
				}).then((result) => {  
					swal.close();
					$('#memberEmail').val('');
					$('#memberEmail').select();
				});
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

function ajaxValidPw(chk_n)
{
	var memberPw = $.trim($('#memberPw').val());
	var memberPwN = $.trim($('#memberPwN').val());
	if (memberPw == 0)
	{
		$('#passChk').html("<div class='alert alert-danger'>비밀번호를 입력해 주세요!</div>");
		$('#memberPw').select();
		return;
	}
	else
	{
		var num = memberPw.search(/[0-9]/g);
		var eng = memberPw.search(/[a-z]/ig);
		var spe = memberPw.search(/[`~!@@#$%^&*|\\\'\";:\/?]/gi);
		var spa = checkSpace(memberPw);

		if (memberPw.length < 4 || memberPw.length > 16) 
		{
			$('#passChk').html("<div class='alert alert-danger'>비밀번호는 4자리~16자리로 입력해주세요!</div>");
			$('#memberPw').select();
			return;
		}
		if (num < 0 || eng < 0 || spe < 0) 
		{
			$('#passChk').html("<div class='alert alert-danger'>비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요!</div>");
			$('#memberPw').select();
			return;
		}

		if (spa) 
		{
			$('#passChk').html("<div class='alert alert-danger'>비밀번호는 공백없이 입력해주세요!</div>");
			$('#memberPw').select();
			return;
		}
		if (chk_n == 1)
		{
			if (memberPw != memberPwN)
			{
				$('#passNChk').html("<div class='alert alert-danger'>비밀번호가 일치하지 않습니다!</div>");
				$('#memberPw').select();
				return;
			}
			$('#passNChk').html('');
		}
		$('#passChk').html('');
	}
}

function ajaxMemberInsert()
{
	let setUrl = document.getElementById('setUrl').value;
	var memberEmail = $.trim($('#memberEmail').val()); 
	var memberPw = $.trim($('#memberPw').val()); 
	var memberPwN = $.trim($('#memberPwN').val()); 
	var memberName = $.trim($('#memberName').val()); 
	var memberPhone1 = $.trim($('#memberPhone1').val());
	var memberPhone2 = $.trim($('#memberPhone2').val()); 
	var memberPhone3 = $.trim($('#memberPhone3').val()); 
	var memberZip = $.trim($('#memberZip').val()); 
	var memberAddr1 = $.trim($('#memberAddr1').val()); 
	var memberAddr2 = $.trim($('#memberAddr2').val()); 

	var num = memberPw.search(/[0-9]/g);
	var eng = memberPw.search(/[a-z]/ig);
	var spe = memberPw.search(/[`~!@@#$%^&*|\\\'\";:\/?]/gi);
	var spa = checkSpace(memberPw);

	if (memberEmail.length == 0) 
	{
		Swal.fire({   
			title: '',
			text: '아이디(이메일)를 입력해 주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberEmail').select();
		});
		return;
	}

	if (memberPw.length < 4 || memberPw.length > 16) 
	{
		Swal.fire({   
			title: '',
			text: '비밀번호는 4자리~16자리로 입력해주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberPw').val('');
			$('#memberPw').select();
		});
		return;
	}

	if (num < 0 || eng < 0 || spe < 0) 
	{
		Swal.fire({   
			title: '',
			text: '비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberPw').val('');
			$('#memberPw').select();
		});
		return;
	}

	if (spa) 
	{
		Swal.fire({   
			title: '',
			text: '비밀번호는 공백없이 입력해주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberPw').val('');
			$('#memberPw').select();
		});
		return;
	}

	if (memberPw != memberPwN)
	{
		Swal.fire({   
			title: '',
			text: '비밀번호가 일치하지 않습니다!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberPwN').val('');
			$('#memberPwN').select();
		});
		return;		
	}

	if (memberName.length == 0) 
	{
		Swal.fire({   
			title: '',
			text: '이름을 입력해 주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberName').select();
		});
		return;			
	}

	if (memberPhone1.length == 0) 
	{
		Swal.fire({   
			title: '',
			text: '휴대전화 번호를 입력해 주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberPhone1').select();
		});
		return;		
	}

	if (memberPhone2.length == 0) 
	{
		Swal.fire({   
			title: '',
			text: '휴대전화 번호를 입력해 주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberPhone2').select();
		});
		return;		
	}
	
	if (memberPhone3.length == 0) 
	{
		Swal.fire({   
			title: '',
			text: '휴대전화 번호를 입력해 주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
			$('#memberPhone3').select();
		});
		return;		
	}

	if (memberZip.length == 0 || memberAddr1.length == 0) 
	{
		Swal.fire({   
			title: '',
			text: '주소를 입력해 주세요!',
			icon: "error"
		}).then((result) => {  
			swal.close();
		});
		return;			
	}
	
	var memberPhone = memberPhone1 + '-' + memberPhone2 + '-' + memberPhone3;
	$('#memberPhone').val(memberPhone);
	var memberPwS = CryptoJS.SHA256(memberPw);
	$('#memberPwS').val(memberPwS);

	$('#btnMemberInsert').addClass('disabled');
	$('#btnMemberInsert').html('<i class="ion-load-d"></i>&nbsp;&nbsp;처리중');

	var string = $('#memberIForm').serialize();

	$.ajax({
		type: 'POST',
		url: setUrl + '/member/new',
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
				Swal.fire({   
					title: '',
					text: returnValue[1],
					icon: "success"
				}).then((result) => {  
					swal.close();
					setTimeout(function(){    
						userLogin();
					}, 1000);
				});
			}
			else if (returnValue[0] == 'error')
			{
				Swal.fire({   
					title: '',
					text: returnValue[1],
					icon: "error"
				}).then((result) => {  
					swal.close();
				});
			}
			else if (returnValue[0] == 'reset')
			{

			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown)
		{
			alert('Error : ' + errorThrown);
		}
	});
	 
	return false;
}

function onlyNum(obj) {
	$(obj).keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/g,''));
	});
}

function checkSpace(str) 
{
	if (str.search(/\s/) != -1) {
		return true;
	} else {
		return false;
	}
}