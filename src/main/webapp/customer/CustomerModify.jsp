<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset='UTF-8'>
<title>고객센터</title>

<script type="text/javascript">
	function pageMoveListFnc() {
		location.href="./list";
	}
	
	function pageMoveDeleteFnc(no) {
		var url = "./delete?customerNo=" + no;
		location.href = url;
	}
</script>

</head>

<jsp:useBean id="customerDto"
   scope="request"
   class="jbsm.user.customer.dto.CustomerDto"/>

<body>

   <jsp:include page="/Header.jsp"/>

   <h1>고객센터</h1>
   <form action='./modify' method='post'>
      <input type='hidden' name='customerNo' 
      value='${customerDto.customerNo}'>
       
      이름: <input type='text' name='customerQue' 
      value='${customerDto.customerQue}'><br>
      
      전화번호: <input type='text' name='customerAns'
      value='${customerDto.customerAns}'><br>     

       
      <input type='submit' value='정보 수정'>
      <input type='button' value='삭제' 
         onclick='pageMoveDeleteFnc(${customerDto.customerNo})'>
      <input type='button' value='취소' onclick='pageMoveListFnc();'>
   </form>

   <jsp:include page="/Tail.jsp"/>
</body>
</html>
