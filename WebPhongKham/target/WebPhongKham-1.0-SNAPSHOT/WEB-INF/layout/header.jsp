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
        <i class="fa fa-envelope-open" aria-hidden="true"></i> <a href="mailto:contact@example.com">PhongKhamTamAn@gmail.com</a>
        <i class="fa fa-phone" aria-hidden="true"></i> 0123456789
        <i class="fa fa-globe" aria-hidden="true"></i> 371 Nguyễn Kiệm, Gò Vấp
      </div>
        
      <div class="social-links">
        <a href="#" class="twitter"><i class="fab fa-twitter"></i></a>
        <a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="skype"><i class="fab fa-instagram"></i></a>
        <a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a>
         
      </div>
       
    </div>
    </div>
 
    <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">
   
      <h1 class="logo mr-auto"><a href="<c:url value="/"/>">TâmAn</a></h1>


      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="http://localhost:8080/WebPhongKham/">TRANG CHỦ</a></li>
          <li class="drop-down"><a href="">GIỚI THIỆU</a>
            <ul>
             
              <li class ="nav-item active">
                  <a class ="nav-link" href="<c:url value="/aboutus"/>">Về chúng tôi</a></li>
              <li><a href="<c:url value="/valuevision"/>">Tầm nhìn-Sứ mệnh-Giá trị cốt lõi</a></li>
              <li><a href="<c:url value="/organizationchart"/>">Sơ đồ tổ chức</a></li>
             
              
            </ul>
          </li>
          <li class="drop-down"><a href="#services">DỊCH VỤ</a>
              <ul>
          <c:forEach var="s" items="${services}">
                  <li><a href="<c:url value="/dich-vu/${s.id}"/>">${s.name}</a></li>
              </c:forEach> 
              </ul>
          </li>
        
         
          <li><a href="<c:url value="/bac-si"/>">ĐỘI NGŨ BÁC SĨ</a></li>
         
          <li class="drop-down"><a href="">CHUYÊN KHOA</a>
            <ul>
              
<!--              <li class="drop-down"><a href="#">Deep Drop Down</a>
                <ul>
                 
                </ul>
              </li>-->
              <c:forEach var="med" items="${medicals}">
                  <li><a href="<c:url value="/chuyen-khoa/${med.id}"/>">${med.name}</a></li>
              </c:forEach> 
              
            </ul>
          </li>
          <li><a href="<c:url value="/contact"/>">LIÊN HỆ</a></li>
          
           <c:if test="${pageContext.request.userPrincipal.name == null}">
               <li>
                <a href="<c:url value="/login"/>"><i class="fa fa-user"></i> Đăng Nhập</a>
            </li>   
           </c:if>
                
           <c:if test="${pageContext.request.userPrincipal.name != null}">
            
            
            
           <c:if test="${currentUser.userRole.equals('ROLE_USER')}">
            
            <li class="drop-down"><a href=""/><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
            <ul>
             
              <li><a href="<c:url value="/"/>">Bảng điều khiển</a></li>
              <li><a href="<c:url value="/logout"/>">Đăng xuất</a></li>
              
            </ul>
          </li>
            </c:if>
            
            
            <c:if test="${currentUser.userRole.equals('ROLE_DOCTOR')}">
                 <li class="drop-down"><a href=""/><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
            <ul>
             <li><a href="<c:url value="/doctor"/>">Bảng điều khiển</a></li>
              <li><a href="<c:url value="/logout"/>">Đăng xuất</a></li>
              
            </ul>
          </li>
           
           </c:if>
            <c:if test="${currentUser.userRole.equals('ROLE_NURSE')}">
             <li class="drop-down"><a href=""/><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
            <ul>
             <li><a href="<c:url value="/nurse"/>">Bảng điều khiển</a></li>
             <li><a href="<c:url value="/logout"/>">Đăng xuất</a></li>
              
            </ul>
          </li>
            </c:if>
            <c:if test="${currentUser.userRole.equals('ROLE_ADMIN')}">
             <li class="drop-down"><a href=""/><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
            <ul>
             <li><a href="<c:url value="/admin"/>">Bảng điều khiển</a></li>
             <li><a href="<c:url value="/logout"/>">Đăng xuất</a></li>
              
            </ul>
          </li>
            </c:if>
        
        </c:if>
         
        </ul>
      </nav><!-- .nav-menu -->

      <a href="<c:url value="/appointment-date"/>" class="appointment-btn scrollto">ĐẶT LỊCH HẸN</a>

    </div>
      <br><!-- comment -->
      
  </header>
  
    <!-- Hospital Beign -->
    
 <!-- ======= Testimonials Section ======= -->
    
     
    