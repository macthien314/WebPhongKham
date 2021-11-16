<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="Spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
      <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2 style=" font-weight: bold;">Giới Thiệu Về Dịch Vụ</h2>
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
      <div class="container">
          <h1 class="text-md-left">Dịch vụ ${service.name}</h1>
        <div class="row">
        <div class="col-sm-4">
              <div> <img class="img-fluid" src="${service.image}" alt="alt"/></div>
        </div>
        <div style="left: 20px;" class="col-sm-8">
              <p>Tên dịch vụ: ${service.name}</p>
              <p>Giá tiền: ${service.fee}</p>
        </div>
      </div>  
      </div>
    </section>
      
      
  </main>
