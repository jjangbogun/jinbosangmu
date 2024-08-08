<%@page import="jbsm.user.member.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>이벤트 등록</title>
</head>
<body>

	
	<h1>이벤트 등록</h1>
	<form action='new' method='post'>
		이벤트 제목 
		<br>
		<input type='text' name='eventName' id='eventName'>
		<br>

		이벤트 사진1: 
		<br>
		<input type='text' name='eventTimg' id='eventTimg'>
		<br>
		이벤트 사진2: 
		<br>
		<input type='text' name='eventDimg' id='eventDimg'>
		<br>
		이벤트 시작일: 
		<br>
		<input type='text' name='eventSdate' id='eventSdate'>
		<br>
		이벤트 종료일: 
		<br>
		<input type='text' name='eventEdate' id='eventEdate'>
		
		
		
		
		<input type='submit' value='추가'>
		<input type='reset' value='취소'>
	</form>
	

</body>
</html>