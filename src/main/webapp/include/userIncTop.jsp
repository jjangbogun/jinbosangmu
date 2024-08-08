<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="p-5 bg-primary text-white text-center">
  <h1>진보상무</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="#">Active</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
  </div>
  
	<%
	if (session.getAttribute("memberName") == null) {
	%>	
		<span class="spanTag">
			<span class="notLogin">
				회원 로그인을 하세요!
			</span>
			<br>
			<a style="color: Cyan; float:right;" 
				href="<%=request.getContextPath()%>/member/login">로그인페이지 이동
			</a>
		</span>	
	<%
	} else {
	%>	
		<span class="spanTag">
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
</nav>

<div class="container mt-5">