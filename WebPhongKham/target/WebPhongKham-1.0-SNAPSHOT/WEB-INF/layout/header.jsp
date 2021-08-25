<%-- 
    Document   : header
    Created on : Aug 25, 2021, 5:00:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Trang chủ</a>
    </li>
    <li>
        <a class="nav-link" href="<c:url value ="/cart"/>">Giỏ hàng</a>
    </li>
  </ul>

</nav>