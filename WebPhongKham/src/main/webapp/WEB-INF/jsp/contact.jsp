<%-- 
    Document   : contact
    Created on : Nov 16, 2021, 7:12:05 PM
    Author     : macth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/contact" var="action"/>
<section id="contact" class="contact">
      <div class="container">
          <section style="margin-bottom: 20px; margin-top: -50px;" class="breadcrumbs">
      <div class="container">    
          <div class="d-flex justify-content-between align-items-center">
            <h2></h2>
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
          <div class="section-title">
          <h2>LIÊN HỆ</h2>
          
        </div>
<div class="row mt-5">

          <div class="col-lg-4">
            <div class="info">
              <div class="address">
                <i class="icofont-google-map"></i>
                <h4>Địa Chỉ:</h4>
                    <p>371 Nguyễn Kiệm, Phường 3, Quận Gò Gấp, TP.Hồ Chí Minh</p>
              </div>

              <div class="email">
                <i class="icofont-envelope"></i>
                <h4>Email:</h4>
                <p>phongkhamtaman@gmail.com</p>
              </div>

              <div class="phone">
                <i class="icofont-phone"></i>
                <h4>Số Điện Thoại:</h4>
                <p>(028) 3873 8994</p>
              </div>

            </div>

          </div>

          <div class="col-lg-8 mt-5 mt-lg-0">

            <form action="${action}" modelAttribute="appointment" method="post" role="form" class="php-email-form">
              <div class="form-row">
                <div class="col-md-6 form-group">
                  <input path="lastName" type="text" name="lastName" class="form-control" id="lastName" placeholder="Họ" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validate"></div>
                </div>
                <div class="col-md-6 form-group">
                  <input path="firstName" type="text" class="form-control" name="firstName" id="firstName" placeholder="Tên" data-rule="firstName" data-msg="Please enter a valid email" />
                  <div class="validate"></div>
                </div>
              </div>
              <div class="form-row">
              <div class="col-md-6 form-group">
                <input path="email" type="text" class="form-control" name="email" id="subject" placeholder="Email" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                <div class="validate"></div>
              </div>
              <div class="col-md-6 form-group">
                <input path="phone" type="text" class="form-control" name="phone" id="subject" placeholder="Số điện thoại" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                <div class="validate"></div>
              </div>    
                </div>    
              <div class="form-group">
                <textarea path="description" class="form-control" name="description" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Nội dung liên hệ"></textarea>
                <div class="validate"></div>
              </div>
            
              <div class="mb-3">
                <div class="loading">Loading</div>
                <div class="error-message"></div>
                <div class="sent-message">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button onclick="showalert()" type="submit">Gửi liên hệ</button></div>
            </form>

          </div>

        </div>
      </div>
</section>
              
              

 
