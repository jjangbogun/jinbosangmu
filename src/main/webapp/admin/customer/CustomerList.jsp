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
                                    <h6 class="m-0 font-weight-bold text-primary font_size_20">질문 리스트</h6>
                                    <div class="dropdown no-arrow">
                                    </div>
                                </div>
                                
                                 
                                
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class='card mb-4'>
                                                          
		<table class="table text-center">
			<thead>
				<tr style='background: #f6f6f6;'>
					<th class='w-25' scope="col">질문</th>
					<th class='w-25' scope="col">질문날짜</th>
					<th class='w-25' scope="col">답변유무</th>
					<th class='w-25' scope="col">비고</th>
				</tr>
			</thead>
			<tbody >
			
			<c:forEach var="customerDto" items="${customerList}">
				<tr>
					<td>${customerDto.customerQue}</td>
					<td>${customerDto.customerQdate}</td>
					<td>
						<c:choose> 
							<c:when test="${customerDto.customerAns == null}"> 
								답변준비중
							</c:when> 
							<c:otherwise> 
								답변완료
							</c:otherwise> 
						</c:choose> 
					</td>
					<td>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-secondary btn-sm" onclick='customerModify(${customerDto.customerNo});'>답변</button>
							<button type="button" class="btn btn-danger btn-sm" onclick='customerDelete(${customerDto.customerNo});'>삭제</button>
						</div>
					</td>
				</tr>
			
			</c:forEach>
	
			</tbody>
		</table>

                                    </div>                                   
                                    
                                   
                                </div>
                            </div>
                        </div>
                    
					</div>
									                       

<jsp:include page="/include/incAdminFooter.jsp"></jsp:include>

<jsp:include page="/include/incAdminClose.jsp"></jsp:include>