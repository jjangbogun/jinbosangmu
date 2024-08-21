<%
//****************************************************************************************
//** FILE NAME   : /sampleMain.jsp
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

        <!-- CONTENT --------------------------------------------------------------------------------->
    
        <!-- Intro Section -->
        <section id="intro" class="dark-bg">

            <!-- Hero Slider Section -->
            <div class="owl-carousel fullwidth-slider white o-flow-hidden">
                <!--Slide-->
                <div class="item bg-img slide-bg-image parallax parallax-section1" data-background-img="${pageContext.request.contextPath}/images/intro-bg1.jpg">
                    <!-- Content -->
                    <div class="full-cap-wraper overlay-dark40 light-color">
                        <div class="content-caption light-color">
                            <div class="container">
                    			<p class="lead">진보상무</p>
                                <h2>국내 최고의 럭셔리 비즈니스 호텔인 진보상무는 1,015실 규모를 자랑하며<br>서울 구로동에 자리잡고 있습니다.</h2>
                                <br />
                                <div class="xs-hidden"><a class="btn btn-outline-light" onclick="sendEventListFnc();">자세히보기</a></div>
                            </div>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>

                <!--Slide-->
                <div class="item bg-img slide-bg-image parallax parallax-section1" data-background-img="${pageContext.request.contextPath}/images/intro-bg2.jpg">
                    <!-- Content -->
                    <div class="full-cap-wraper overlay-dark40 light-color">
                        <div class="content-caption light-color">
                            <div class="container">
                    <p class="lead">진보상무 워터파크</p>
                                        <h2>진보상무 워터파크는 강서구의 랜드마크 '까치산'에 위치한<br> 260실 규모의 럭셔리 워터파크 입니다.</h2>
                                        <br />
                                        <div class="xs-hidden"><a class="btn btn-outline-light" onclick="sendEventListFnc();">자세히보기</a></div>
                            </div>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>

                <!--Slide-->
                <div class="item bg-img slide-bg-image parallax parallax-section1" data-background-img="${pageContext.request.contextPath}/images/intro-bg3.jpg">
                    <!-- Content -->
                    <div class="full-cap-wraper overlay-dark40 light-color">
                        <div class="content-caption light-color">
                            <div class="container">
                    			<p class="lead">진보상무 스파</p>
                                        <h2>패션쇼 런웨이처럼 화려한 유행의 거리 강서. 이 감각적인 도시의 문화를 닮은 진보상무 스파는<br> 서울 강서의 중심에 위치한 라이프 스타일 스파입니다.</h2>
                                        <br />
                                        <div class="xs-hidden"><a class="btn btn-outline-light" onclick="sendEventListFnc();">자세히보기</a></div>
                            </div>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>
            </div>
            <!-- End Hero Slider Section -->
        </section>
        <!-- End Intro Section -->

        <div class="clearfix"></div>

    	<section class="g-bg-orange-lineargradient-v2 text-s-white ptb-60" id="main-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-8">
                        <h4 class="text-s-white">Welcome Random Box</h4>
                        <h4 class="text-s-white">진보상무 회원 가입하고, 선물 받아 가세요!</h4>
                    </div>
                    <div class="col-md-4 col-sm-4 mt20 text-right">
            <a class="btn btn-outline-light" onclick="sendMemberNew();">자세히 보기</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-40" style='background: #fcfcfc;'>
            <div class="container">
				
				<div class="row mt-5">
			    	<c:forEach var="eventDto" items="${eventList}">
				    	<div class="col-md-6 text-center mb-5">
				    		<a href='${pageContext.request.contextPath}/event/detail?eventNo=${eventDto.eventNo}'>
				    		<img alt="event" class="etImg" style="border: 1px solid black"				    		
				             src="${pageContext.request.contextPath}/upload/${eventDto.eventTimg}">
							</a>
				            <p class="etPTag">${eventDto.eventName}</p>				            				            
				    	</div>
					</c:forEach>
			    </div>

			</div>
       		
        </section>
        <!-- End Content Section -->

        <!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>