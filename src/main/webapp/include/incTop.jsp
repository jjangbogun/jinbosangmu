<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Preloader -->
<section id="preloader">
	<div class="loader" id="loader">
		<div class="loader-img"></div>
	</div>
</section>
<!-- End Preloader -->



<!-- Sidebar Menu -->
<div class="sidebar-menu">
	<div class="sidembar-menu-wrap">
		<a href="javascript:void(0)" class="sidebar-close-icon icon--close">
			<i class="ion ion-android-close"></i>
		</a>
		<!--Sidebar Content-->
		<div class="sidebar-content">
			<ul>
				<c:choose>
				    <c:when test="${sessionScope.memberNo == null}">
				        <li><a href="#" onclick='top_user_login();'>로그인</a></li>
				    </c:when>
				    <c:otherwise>
				        <li>${sessionScope.memberName}님 반갑습니다!</li>
				        <li><a href="#" onclick='top_user_logout();'>로그아웃</a></li>
				        <li><a href="#" onclick='top_user_modify(${sessionScope.memberNo});'>정보변경</a></li>
				    </c:otherwise>
				</c:choose>
			
				<li><a href="#">호텔 소개</a></li>
				<li><a href="../promotion/list">패키지 상품</a></li>
				<li><a href="../event/list">이벤트</a></li>
				<li>
					<%
					if (session.getAttribute("memberName") == null) {
					%>
						<a href="#" onclick='sendLoginFnc()'>1:1 문의</a>
					<%
					} else {
					%>
						<a href="../customer/list">1:1 문의</a>
					<%
					}
					%>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- End Sidebar Menu -->

<!-- Site Wraper -->
<div class="wrapper">

	<!-- Header ("header--dark", "header-transparent", "header--sticky")-->
	<header id="header"
		class="header header-transparent header--sticky sticky--on">
		<!-- Nav Bar -->
		<nav id="navigation" class="header-nav">
			<div class="container">
				<div class="row d-flex flex-md-row align-items-center">
					<div class="logo mr-auto">
						<!--logo-->
						<a href="${pageContext.request.contextPath}/main"> <img
							class="logo-dark" src="${pageContext.request.contextPath}/images/logo-black.png" alt="" /> <img
							class="logo-light" src="${pageContext.request.contextPath}/images/logo-white.png" alt="" />
						</a>
						<!--End logo-->
					</div>

					<div class="nav-menu ml-auto">
						<ul class="">
							<li class="nav-menu-item"><a href="sampleReservation.jsp">호텔 소개</a></li>
							<li class="nav-menu-item"><a href="../promotion/list">패키지 상품</a></li>
							<li class="nav-menu-item"><a href="../event/list">이벤트</a>
							<li class="nav-menu-item"><a href="../notice/list">공지사항</a></li>
							<li class="nav-menu-item">
							<%
							if (session.getAttribute("memberName") == null) {
							%>
								<a href="#" onclick='sendLoginFnc()'>1:1 문의</a>
							<%
							} else {
							%>
								<a href="../customer/list">1:1 문의</a>
							<%
							}
							%>
							</li>
						</ul>
					</div>
					<div class="nav-icons">
						<div class="nav-icon-item">
							<%
							if (session.getAttribute("memberName") == null) {
							%>
							<span class='nav-icon-trigger align-middle'
								onclick='top_user_login();'><i
								class='fa fa-sign-in font_size_18'></i>&nbsp;&nbsp;&nbsp;&nbsp;로그인</span>
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

						<div class="nav-icon-item">
							<span class="nav-icon-trigger sidebar-menu_btn align-middle"><i
								class="ion ion-navicon font_size_26"></i></span>
						</div>

					</div>
				</div>
			</div>
		</nav>
		<!-- End Nav Bar -->
	</header>
	<!-- End Header -->