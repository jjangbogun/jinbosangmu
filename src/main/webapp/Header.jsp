<%@page import="jbsm.user.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="background-color: LightYellow; color: Red; 
	height: 40px; padding:5px;">
	JBSM(Jinwoo Bogeun Sanghyun Mooyeon)			
	<%
	if (session.getAttribute("memberName") == null) {
	%>	
		<span style="float: right;">
			<span class="notLogin">
				회원 로그인을 하세요!
			</span>
			<br>
			<a style="color: Cyan; float:right;" 
				href="<%=request.getContextPath()%>/member/login">로그인페이지로 가기
			</a>
		</span>	
	<%
	} else {
	%>	
		<span style="float: right;">
			<span class="successLogin">
				<%=session.getAttribute("memberName")%>님 반갑습니다!
			</span>
			<br>
			<a style="color: Cyan; float:right;" 
				href="<%=request.getContextPath()%>/member/logout">로그아웃
			</a>
		</span>
	<%
	}
	%>
</div>
