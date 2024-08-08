<%@page import="jbsm.user.member.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원 목록</title>

<style type="text/css">

</style>

<script type="text/javascript">

</script>

</head>

<body>

	<%
	MemberDto memberDto = (MemberDto)session.getAttribute("memberDto");
	%>

	<jsp:include page="/Header.jsp"/>
	<h1>회원목록</h1>
<!-- 	<p> -->
<!-- 		<a href="./add">신규 회원 등록</a> -->
<!-- 	</p> -->
	
	<c:forEach var="memberDto" items="${memberList}">
		${memberDto.memberNo},
		${memberDto.memberEmail},
		${memberDto.memberPw},
		<a href='./modify?memberNo=${memberDto.memberNo}'>
			${memberDto.memberName}
		</a>,
		${memberDto.memberPhone},
		${memberDto.memberZip},
		${memberDto.memberAddr1},
		${memberDto.memberAddr2},
		${memberDto.memberCdate}
		<br>
	</c:forEach>
	
	<jsp:include page="/Tail.jsp"/>
	
</body>
</html>