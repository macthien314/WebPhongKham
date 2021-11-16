<%-- 
    Document   : header
    Created on : Sep 26, 2021, 1:49:30 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="sb-topnav navbar navbar-expand bg-light navbar-fixed-top  navbar-inverse">
    <div class="container-fluid">
            <!-- Navbar Brand-->
          
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="slidebarCollapse" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            
            <!-- Navbar-->
            <!-- Links -->
  <div class="collapse navbar-collapse" id="basicExampleNav3">
      <ul class="nav ml-auto mr-auto">
        <li class="nav-item">
            <a class=" hopname nav-link active" href="#"><h3 style="margin: 0px 0px 0px 0px;"><b>phòng khám của tôi</b></h3></a>
        </li>

      </ul>
    <!-- Right -->
    <ul class="navbar-nav  nav-flex-icons">
      
      <li class="nav-item dropdown">
            
          <a class="nav-link dropdown-toggle collapse navbar-collapse" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-user"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink-333"> 
              <a class="dropdown-item" href="<c:url value="/profil"/>">Thông tin người dùng</a>
              <a class="dropdown-item" href="<c:url value="/logout"/>">Đăng xuất</a>
            </div>
      </li>
    </ul>

  </div>
  <!-- Links -->
</nav>
