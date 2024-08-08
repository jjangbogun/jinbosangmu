<%@page import="jbsm.user.notice.dto.NoticeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>공지사항</title>

<style type="text/css">
table {
/*    border: 1px solid black; */
   text-align: center;
   border-collapse: collapse;
   margin: auto;
}

tr {
   height: 100px;
   
}

td {
   border: 1px solid black;
   width: 300px;
}

#boardFirstTr {
   background-color: skyblue;
   font-weight: bold;
}

.contentTd {
   width: 500px;
}

.creDateTd {
   width: 200px;
}

</style>

<script type="text/javascript">

</script>

</head>

<body>

   <h1>공지사항</h1>
   
   <table>
      <tr id="boardFirstTr">
         <td>제목</td>
         <td class="contentTd">내용</td>
         <td class="creDateTd">작성일</td>
      </tr>
   
   <c:forEach var="NoticeDto" items="${noticeList}">
      <tr>
         <td>
             ${NoticeDto.noticeTitle}           
         </td>
         <td class="contentTd">
             ${NoticeDto.noticeContent}
         </td>
         <td class="creDateTd">
        	 ${NoticeDto.noticeCdate}
         </td>
      </tr>
   </c:forEach>
   </table>
   
</body>
</html>