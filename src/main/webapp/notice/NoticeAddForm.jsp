<%@page import="jbsm.user.member.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>공지 등록</title>
</head>
<body>

	
	<h1>공지등록</h1>
	<form action='add' method='post'>
		공지제목 
		<br>
		<input type='text' name='noticeTitle' id='noticeTitle'>
		<br>
		<br>
		공지내용: 
		<br>
		<textarea name='noticeContent' id='noticeContent'
		rows="10" cols="100"></textarea> 
		<br>
		
		<input type='submit' value='추가'>
		<input type='reset' value='취소'>
	</form>
	

</body>
</html>