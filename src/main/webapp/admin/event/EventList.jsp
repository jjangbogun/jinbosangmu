<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="/include/incAdminHead.jsp"></jsp:include>

<jsp:include page="/include/incAdminTop.jsp"></jsp:include>

                    <!-- Content Row -->

                    <div class="row">

                        <div class="col-xl-12 col-lg-12">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary font_size_20">이벤트 리스트</h6>
                                    <div class="dropdown no-arrow">
                                    </div>
                                </div>
                                
                                 
                                
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class='card mb-4'>
                                                          
		<table class="table">
			<thead>
				<tr style='background: #f6f6f6;'>
					<th class='w-25' scope="col">이미지</th>
					<th class='w-25' scope="col">이벤트명</th>
					<th class='w-25' scope="col">시작일 / 종료일</th>
					<th class='w-25' scope="col">비고</th>
				</tr>
			</thead>
			<tbody >
			
			<c:forEach var="eventDto" items="${eventList}" varStatus="i">
			
				<tr>
					<th scope="row">
						<div class='mb-2'>
							<img src="${pageContext.request.contextPath}/upload/${eventDto.eventTimg}" 
							class="img-fluid" alt="${eventDto.eventName}" style='width:200px;'>
						</div>
					</th>
					<td><div style="margin-top: 60px">${eventDto.eventName}</div></td>
					<td><div style="margin-top: 60px">${eventDto.eventSdate} / ${eventDto.eventEdate}</div></td>
					<td>
						<div class="btn-group" role="group" style="margin-top: 60px">
							<button type="button" class="btn btn-secondary btn-sm" onclick='eventModify(${eventDto.eventNo});'>변경</button>
							<button type="button" class="btn btn-danger btn-sm" onclick='eventDelete(${eventDto.eventNo});'>삭제</button>
						</div>
					</td>
				</tr>
			
			</c:forEach>
	
			</tbody>
		</table>

                                    </div>    
        <div class='text-center'>
			<input type='button' value='신규등록' class='btn btn-secondary' onclick='eventNew();'>
		</div>                                
                                    
                                   
                                </div>
                            </div>
                        </div>
                    
					</div>
									                       

<jsp:include page="/include/incAdminFooter.jsp"></jsp:include>

<jsp:include page="/include/incAdminClose.jsp"></jsp:include>