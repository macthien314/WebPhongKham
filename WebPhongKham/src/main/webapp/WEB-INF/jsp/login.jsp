<%-- 
    Document   : login
    Created on : Sep 9, 2021, 5:35:54 PM
    Author     : Admin
--%>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="Spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/login" var="action"/>

<main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Đăng nhập</h2>
          <ol>
            <li><a href="index.html">Home</a></li>
            <li>Login</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

    <section class="inner-page">
      
        <div class="main">
            <div class="container-fluid">
    <div class="row no-gutter">
        <!-- The image half -->
        <div class="col-md-6 d-none d-md-flex bg-image"></div>
     

        <!-- The content half -->
        <div class="col-md-6 bg-light">
            <div class="login d-flex align-items-center py-5">

                <!-- Demo content-->
                <div class="container">
                    <div class="row">
                        <div class="col-lg-10 col-xl-7 mx-auto">
                            <h3 class="">Đăng nhập</h3>
                           
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    Có lỗi
                                </div>
                            </c:if>
                            <c:if test="${param.accessDinied != null}">
                                <div class ="alert alert-danger">
                                    Bạn không có quyền truy cập
                                </div>
                            </c:if>
                            
                            
                            <form method="post" action="${action}">
                                <div class="form-group mb-3">
                                    <input id="username" type="text" name ="username" placeholder="Tên đăng nhập" required="" autofocus="" class="form-control rounded-pill border-0 shadow-sm px-4">
                                </div>
                                <div class="form-group mb-3">
                                    <input id="password" type="password" name="password" placeholder="Mật khẩu" required="" class="form-control rounded-pill border-0 shadow-sm px-4 text-primary">
                                </div>
                                <div class="custom-control custom-checkbox mb-3">
                                    <input id="customCheck1" type="checkbox" checked class="custom-control-input">
                                    <label for="customCheck1" class="custom-control-label">Remember password</label>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Sign in</button>
                                <p class="text-center">OR</p>
                                <a href="<c:url value="/register"/>"><button type="button" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm btn-info">Đăng Ký</button></a>

                            </form>
                        </div>
                    </div>
                </div><!-- End -->

            </div>
        </div><!-- End -->

    </div>
</div>    
       

        </div>
        
      
    </section>

  </main>