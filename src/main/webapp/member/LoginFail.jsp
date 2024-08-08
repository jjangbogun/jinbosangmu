<%
//****************************************************************************************
//** FILE NAME   : /sampleSub.jsp
//** DESCRIPTION : 
//** DATABASE    :
//** AUTHOR      : ChoMooYeon
//** DATE        : 2024-08-06
//** HISTORY
//****************************************************************************************
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<jsp:include page="../include/incHead.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/assets/incUser.css" rel="stylesheet">

<body>

<script type="text/javascript">
<!--



//-->
</script>
  
<jsp:include page="../include/incTop.jsp"></jsp:include>

	<link href="/S2.User/inc/inc-sub.css" rel="stylesheet">

	<!-- CONTENT --------------------------------------------------------------------------------->

		<section class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70' data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
			<div class='container'>
				<div class='row title'>
					<h2>서브페이지 타이틀</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>여기에 서브페이지의 설명 멘트가 들어 갑니다!</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub" style='height: 400px'>

				<%
				String memberEmail = request.getParameter("memberEmail");
				%>
				<h1>로그인 실패</h1>
				<pre>
					아이디(로그인 전용 아이디) 또는 비밀번호가 잘못 되었습니다. 
					아이디와 비밀번호를 정확히 입력해 주세요.
					다시 시도하거나 비밀번호 찾기를 클릭하여 재설정하세요.
					
					잠시 후에 다시 로그인 화면으로 전환합니다.
				</pre>
				<div>
					<span>
						입력하신 이메일 : 
					</span>
					<span>
						<%=memberEmail %>
					</span>
				</div>
				<button onclick="location.href='LoginForm.jsp'">로그인 페이지로 이동</button>
				<button onclick="loginFnc();">로그인 페이지로 이동</button>

            </div>
        </section>
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>