<%-- 
    Document   : slide
    Created on : Sep 22, 2021, 9:08:40 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="hero" class="d-flex align-items-center">
    <div class="container">
      <div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1" ></li>
    <li data-target="#demo" data-slide-to="2"></li>
    <li data-target="#demo" data-slide-to="3"></li>
    <li data-target="#demo" data-slide-to="4"></li>
    <li data-target="#demo" data-slide-to="5"></li><!-- comment -->
    <li data-target="#demo" data-slide-to="6"></li>
  </ul>
  
  <div id ="carousel"class="carousel-inner">
     <c:forEach items="${showSlide}" var="s" >    
      
      <c:if test="${showSlide.indexOf(s) == 0}">
            <div class="carousel-item active">
      <img src="${s.image}" alt="Los Angeles" class="w-100">  
            </div>
     </c:if>
          <c:if test="${showSlide.indexOf(s) != 0}">
            <div class="carousel-item">
      <img src="${s.image}" alt="Los Angeles" class="w-100">  
            </div>
     </c:if>
      </c:forEach>
  </div>
  
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
    </div>    
  </section><!-- End Hero -->
  <script>
      $('#carousel').carousel({
  interval: 1,
  cycle: true
}); 
      </script>