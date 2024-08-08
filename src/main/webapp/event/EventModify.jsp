<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset='UTF-8'>
<title>이벤트 수정</title>

<script type="text/javascript">
	function pageMoveListFnc() {
		location.href="./list";
	}
	
	function pageMoveDeleteFnc(no) {
		var url = "./delete?eventNo=" + no;
		location.href = url;
	}
</script>

</head>

<jsp:useBean id="eventDto"
   scope="request"
   class="jbsm.user.event.dto.EventDto"/>

<body>

   <jsp:include page="/Header.jsp"/>

   <h1>이벤트수정</h1>
   <form action='./modify' method='post'>
      <input type='hidden' name='eventNo' 
      value='${eventDto.eventNo}'>
       
      이름: <input type='text' name='eventName' 
      value='${eventDto.eventName}'><br>
      
      전화번호: <input type='text' name='eventTimg'
      value='${eventDto.eventTimg}'><br>
      
      우편번호: <input type='text' name='eventDimg' 
      value='${eventDto.eventDimg}'><br>
      
      주소: <input type='text' name='eventSdate' 
      value='${eventDto.eventSdate}'><br>
       
      상세주소: <input type='text' name='eventEdate' 
      value='${eventDto.eventEdate}'><br>
       
      <input type='submit' value='정보 수정'>
      <input type='button' value='삭제' 
         onclick='pageMoveDeleteFnc(${eventDto.eventNo})'>
      <input type='button' value='취소' onclick='pageMoveListFnc();'>
   </form>

   <jsp:include page="/Tail.jsp"/>
</body>
</html>
