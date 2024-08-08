<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/userIncHead.jsp"/>
<jsp:include page="/include/userIncTop.jsp"/>

<div>
	<table class="table table-bordered">
		<thead>
		    <tr>
				<th>memberNo</th>
				<th>memberEmail</th>
				<th>memberPw</th>
				<th>memberPhone</th>
				<th>memberZip</th>
				<th>memberAddr1</th>
				<th>memberAddr2</th>
				<th>memberCdate</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="memberDto" items="${memberList}">
		    <tr>
		    	<td>
					<a href='./modify?memberNo=${memberDto.memberNo}'>
						${memberDto.memberName}
					</a>
				</td>
				<td>${memberDto.memberEmail}</td>
				<td>${memberDto.memberPw}</td>
				<td>${memberDto.memberPhone}</td>
				<td>${memberDto.memberZip}</td>
				<td>${memberDto.memberAddr1}</td>
				<td>${memberDto.memberAddr2}</td>
				<td>${memberDto.memberCdate}</td>
		    </tr>
		    
			</c:forEach>
		  </tbody>
	</table>
</div>

<jsp:include page="/include/userIncFooter.jsp"/>
<jsp:include page="/include/userIncClose.jsp"/>

    