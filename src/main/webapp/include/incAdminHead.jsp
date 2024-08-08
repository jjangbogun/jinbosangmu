<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
if (session.getAttribute("ssoAdminNo") == null) {
	response.sendRedirect("/admin/LoginForm.jsp");
}
%>    

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>JINBOSANGMOO 관리자</title>

<link
    href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
    rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath}/assets/admin/css/sb-admin-2.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/assets/adminCommon.css" rel="stylesheet">

</head>