<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/admin">
                <div class="sidebar-brand-icon rotate-n-15">
                </div>
                <div class="sidebar-brand-text mx-3">JBSM ADMIN</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <li class="nav-item active">
                <a class="nav-link" href="#" onclick='adminList();'>
                    <i class="fas fa-fw fa-table"></i>
                    <span>관리자 설정</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>패키지 관리</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>예약 관리</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>회원 관리</span></a>
            </li>                              

            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>공지사항 관리</span></a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>고객센터 관리</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=session.getAttribute("ssoAdminName")%> (<%=session.getAttribute("ssoAdminEmail")%>)</span>
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">