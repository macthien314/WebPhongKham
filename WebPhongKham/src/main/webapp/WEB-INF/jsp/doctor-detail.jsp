<%-- 
    Document   : doctor-detail
    Created on : Oct 8, 2021, 12:57:48 PM
    Author     : macth
--%>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="Spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/doctor-detail" var="action"/>
 <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
     <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">    
          <div class="d-flex justify-content-between align-items-center">
            <h2 style=" font-weight: bold;">Giới Thiệu Đội Ngũ Bác Sĩ</h2>
            <ol>
            <li><a href="http://localhost:8080/WebPhongKham/">Trang chủ</a></li>
             <li>
              <c:if test="${pageContext.request.userPrincipal.name == null}">
     
                <a href="<c:url value="/login"/>"><i class="fa fa-user"></i>Đăng nhập</a>
              </c:if>
    
              <c:if test="${pageContext.request.userPrincipal.name != null}">
            
                <a href="<c:url value="/login"/>"><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
              </c:if>
          </li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->
    <section class="inner-page">
<c:forEach items="${doctor}" var="d">
      <div class="container">
          <h1 style="margin-top: 40px; 
                     font-family:verdana; 
                     font-size: 35px;
                     " class="text-md-left">Bác sĩ ${d.firstName}
          </h1>
        <div class="row">
        <div class="col-sm-4">
              <div> <img class="img-fluid" src="${d.image}" alt="alt"/></div>
        </div>
        <div style="left: 20px;" class="col-sm-8">
              <p>Họ tên: ${d.lastName} ${d.firstName}</p>
              <p>Ngày sinh: ${d.birthDate}</p>
              <p>Giới tính: ${d.gender}</p>
              <p>Số điện thoại liên hệ: ${d.phone}</p>
              <p>Email liên hệ: ${d.email}</p>
              <p>Năm kinh nghiệm: ${d.yearsExperience}</p>
              <p>Chuyên khoa phụ trách: ${d.medical.name}</p>
        </div>
      </div>  
      </div>
         </c:forEach>
    </section>
      
  </main>