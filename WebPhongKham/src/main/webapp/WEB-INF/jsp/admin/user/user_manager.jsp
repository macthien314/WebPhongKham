<%-- 
    Document   : user_controller
    Created on : Sep 28, 2021, 9:36:29 PM
    Author     : Admin
--%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="Spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="mt-4">User thường</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quan-ly-slide</li>
                        </ol>
<div class="container py-5">
<div class="row text-center">
    <c:forEach var="u" items="${users}">
    <c:if test="${u.userRole.equals('ROLE_USER') == true}">
            
        <div class="col-xl-3 col-sm-6 mb-5">
        
        <div class="bg-white rounded shadow-sm py-5 px-4">
            <c:if test="${u.image !=null && u.image.startsWith('https') == true}">
                <img class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" src="<c:url value="${u.image}"/> " alt="${p.name}"/>
            </c:if>
            <c:if test="${ u.image== null || u.image.startsWith('https') == false}">
                <img class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm" src="<c:url value="https://res.cloudinary.com/ikj/image/upload/v1629733269/xj1uz3fcgzxigczoqu8m.png"/>" alt="${p.name}" />

            </c:if>
           <h5 class="mb-0">${u.username}</h5><span class="small text-uppercase text-muted">Bệnh nhân</span>
          <ul class="social mb-0 list-inline mt-3">
            <li class="list-inline-item"><a href="#" class="social-link"><i class="fas fa-info-circle"></i></i></a></li>
            
          </ul>
        </div>
        
      </div>
          </c:if>
    </c:forEach>
</div>

    

   