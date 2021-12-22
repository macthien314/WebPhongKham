<%-- 
    Document   : appointment-date
    Created on : Nov 16, 2021, 7:11:59 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/appointment-date" var="action"/>
  <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
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

    <!-- ======= Appointment Section ======= -->
    <section style=" margin-bottom: 50px; "id ="appointment" class="appointment section-bg">
      <div class="container">

        <div class="section-title">
          <h2>ĐẶT LỊCH HẸN</h2>
        </div>

       <form id="appointment" action="${action}" modelAttribute="appointment"  method="post" role="form" class="php-email-form">
          <div class="form-row">
            <div class="col-md-4 form-group">
              <input  path="lastName" type="text" name="lastName" class="form-control" id="lastName" placeholder="Họ" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <div  class="col-md-4 form-group">
              <input  path="firstName" type="text" class="form-control" name="firstName" id="firstName" placeholder="Tên" data-rule="email" data-msg="Please enter a valid email">
              <div class="validate"></div>
            </div>
            <div class="col-md-4 form-group">
              <input  path="phone" type="text" class="form-control" name="phone" id="phone" placeholder="Số điện thoại" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
          </div>
          <div class="form-row">
            <div class="col-md-4 form-group">
              <input path="appointmentDate" type="date" name="appointmentDate" class="form-control datepicker" id="date" placeholder="Ngày đặt lịch" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <div class="col-md-4 form-group">
              <input path="email" type="text" class="form-control" name="email" id="email" placeholder="Email" data-rule="email" data-msg="Please enter a valid email">
              <div class="validate"></div>
            </div>
           
            <div class="col-md-4 form-group">
                
              <select path="doctor" name="doctor" id="doctor" class="form-control">
                   <c:forEach items="${doctors}" var="d">
                  <option value="${d.id}">${d.firstName}</option>
                  </c:forEach>
              </select>  
              <div class="validate"></div>
             
            </div>
           
          </div>

          <div class="form-group">
            <textarea path="description" class="form-control" name="description" rows="5" placeholder="Nôi dung đặt lịch"></textarea>
            <div class="validate"></div>
          </div>
          <div class="mb-3">
            <div class="loading">Loading</div>
            <div class="error-message"></div>
            <div class="sent-message">Your appointment request has been sent successfully. Thank you!</div>
          </div>
          <div class="text-center"><button type="submit">Đặt lịch hẹn</button></div>
        </form>

      </div>
    </section><!-- End Appointment Section -->
