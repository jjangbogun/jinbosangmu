<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset='UTF-8'>
<title>회원상세 정보&수정</title>

<script type="text/javascript">
	function pageMoveListFnc() {
		location.href="./list";
	}
	
// 	function pageMoveDeleteFnc(no) {
// 		var url = "./modify?memberNo=" + no;
// 		location.href = url;
// 	}
</script>

</head>

<jsp:useBean id="memberDto"
   scope="request"
   class="jbsm.user.member.dto.MemberDto"/>

<body>

   <jsp:include page="/Header.jsp"/>

   <h1>회원정보</h1>
   <form action='./modify' method='post'>
      <input type='hidden' name='memberNo' 
      value='${memberDto.memberNo}'>
       
      이름: <input type='text' name='memberName' 
      value='${memberDto.memberName}'><br>
      
      전화번호: <input type='text' name='memberPhone'
      value='${memberDto.memberPhone}'><br>
      
      우편번호: <input type='text' name='memberZip' 
      value='${memberDto.memberZip}'><br>
      
      주소: <input type='text' name='memberAddr1' 
      value='${memberDto.memberAddr1}'><br>
       
      상세주소: <input type='text' name='memberAddr2' 
      value='${memberDto.memberAddr2}'><br>
       
      <input type='submit' value='정보 수정'>
      <input type='button' value='삭제' 
         onclick='pageMoveDeleteFnc(${memberDto.memberNo})'>
      <input type='button' value='취소' onclick='pageMoveListFnc();'>
   </form>

   <jsp:include page="/Tail.jsp"/>
</body>
</html>
