<%-- 
    Document   : register
    Created on : Sep 10, 2021, 4:38:38 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/register" var="action"/>
<main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Đăng ký tài khoán</h2>
          <ol>
            <li><a href="index.html">Home</a></li>
            <li>Đăng ký</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

    <section class="inner-page">
                <div class="container">
        


        <div class="row justify-content-center">
        <div class="col-md-6">
        <div class="card">
        <header class="card-header">
                <a href="" class="float-right btn btn-outline-primary mt-1">Log in</a>
                <h2 class="card-title mt-2">Đăng ký</h2>
        </header>
        <article class="card-body">
            <c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
            <form:form  method="post" action="${action}" modelAttribute="user"
                        enctype="multipart/form-data">
                <form:errors path="*" cssClass="alert alert-danger" element="div" />
                        <div class=" form-group">
                                <label for="firstName">Họ</label>   
                                <form:input type="text" id="firstName" path="firstName" class="form-control" placeholder=""/>
                        </div> <!-- form-group end.// -->
                        <div class=" form-group">
                                <label for="lastName">Tên</label>
                                <form:input type="text" id="lastName" path="lastName" class="form-control" placeholder=""/>
                        </div> <!-- form-group end.// -->
                
                 
                <div class="form-group">
                        <label for="username">Tên đăng nhập</label>
                        <form:input id="username" path="username" type="text" class="form-control" placeholder=""/>
                        <small class="form-text text-muted"></small>
                </div> <!-- form-group end.// -->
                 
                <div class="form-group">
                        <label for="password">Mật khẩu</label>
                        <form:input id="password" path="password" class="form-control" type="password"/>
                </div> <!-- form-group end.// -->  
                
                <div class="form-group">
                        <label for="confirm-password">Xác nhận mật khẩu</label>
                        <form:input id="confirm-password" path="confirmPassword" class="form-control" type="password"/>
                </div> <!-- form-group end.// -->  
                
                <div class="form-group">
                        <label for="email">Email address</label>
                        <form:input id="email" path="email" type="email" class="form-control" placeholder=""/>
                        <small class="form-text text-muted"></small>
                </div> <!-- form-group end.// -->
                
                <div class="form-group">
                        <label for="phone">Phone</label>
                        <form:input type="phone" id="phone" path="phone" 
                                    cssClass="form-control" placeholder=""/>
                </div> <!-- form-group end.// -->
<!--                <div class="form-group">
                           <label class="form-check-inline">
                          <input class="form-check-label" type="radio" name="gender" value="option1">
                          <span class="checkbox-inline"> Male </span>
                        </label>
                        <label class="form-check-inline">
                          <input class="checkbox-inline" type="radio" name="gender" value="option2">
                          <span class="checkbox-inline"> Female</span>
                        </label>
                </div>  form-group end.// -->
<!--                <div class="form-row">
                        <div class="form-group col-md-6">
                          <label>City</label>
                          <input type="text" class="form-control">
                        </div>  form-group end.// 
                        <div class="form-group col-md-6">
                          <label>Country</label>
                          <select id="inputState" class="form-control">
                            <option> Choose...</option>
                              <option>Uzbekistan</option>
                              <option>Russia</option>
                              <option selected="">United States</option>
                              <option>India</option>
                              <option>Afganistan</option>
                          </select>
                        </div>  form-group end.// 
                </div>  form-row.// -->
            <div class="form-group">
                <label for="img">Ảnh đại diện</label>
                <div class="file-upload">
                 
                    
                    <form:input path ="File" type="file" name="chooseFile" id="chooseFile"/>
                </div>
            </div>   
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Register  </button>
            </div> <!-- form-group// -->      
            <small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>                                          
        </form:form>
        </article> <!-- card-body end .// -->
        <div class="border-top card-body text-center">Have an account? <a href="">Log In</a></div>
        </div> <!-- card.// -->
        </div> <!-- col.//-->

        </div> <!-- row.//-->


        </div> 
        <!--container end.//-->
        
    </section>
</main>