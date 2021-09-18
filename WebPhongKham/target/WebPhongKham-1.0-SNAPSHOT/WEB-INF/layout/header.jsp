<%-- 
    Document   : header
    Created on : Aug 25, 2021, 5:00:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!-- Hospital Begin -->
    <div id="topbar" class="d-none d-lg-flex align-items-center fixed-top">
    <div class="container d-flex">
      <div class="contact-info mr-auto">
        <i class="fa fa-envelope-open" aria-hidden="true"></i> <a href="mailto:contact@example.com">PhongKhamThienTai@gmail.com</a>
        <i class="fa fa-phone" aria-hidden="true"></i> 0123456789
        <i class="fa fa-globe" aria-hidden="true"></i> 371 Nguyễn Kiệm, Gò Vấp
      </div>
        
      <div class="social-links">
        <a href="#" class="twitter"><i class="fab fa-twitter"></i></a>
        <a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="skype"><i class="fab fa-instagram"></i></a>
        <a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a>
         <c:if test="${pageContext.request.userPrincipal.name == null}">
     
                <a href="<c:url value="/login"/>"><i class="fa fa-user"></i> Login</a>
        </c:if>
    
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            
            <a href="<c:url value="/login"/>"><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
        </c:if>
      </div>
       
    </div>
    </div>
    <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo mr-auto"><a href="<c:url value="/"/>">Bệnh Viện thientai</a></h1>


      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="index.html">Home</a></li>
          <li class="drop-down"><a href="">Giới thiệu</a>
            <ul>
              <li><a href="#">Về chúng tôi</a></li>
              <li><a href="#">Tầm nhìn-Sứ mệnh-Giá trị cốt lõi</a></li>
              <li><a href="#">Sơ đồ tổ chức</a></li>
              <li><a href="#">Đội ngũ bác sĩ</a></li>
              
            </ul>
          </li>
          <li><a href="#services">Services</a></li>
          <li><a href="#departments">Departments</a></li>
          <li><a href="#doctors">Doctors</a></li>
          <li class="drop-down"><a href="">Chuyên Khoa</a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="drop-down"><a href="#">Deep Drop Down</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li>
          <li><a href="#contact">Contact</a></li>

        </ul>
      </nav><!-- .nav-menu -->

      <a href="#appointment" class="appointment-btn scrollto">Make an Appointment</a>

    </div>
      <br><!-- comment -->
      
  </header>
  
    <!-- Hospital Beign -->
    
 <!-- ======= Testimonials Section ======= -->
    
    </section><!-- End Testimonials Section -->
     
    