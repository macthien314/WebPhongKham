<%-- 
    Document   : medical
    Created on : Sep 22, 2021, 11:07:54 PM
    Author     : Admin
--%>

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
          <h2>Inner Page</h2>
          <ol>
            <li><a href="index.html">Home</a></li>
            <li>Inner Page</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

    <section class="inner-page">
      <div class="container">
          <h1 class="text-center">Khoa ${medical.name}</h1>
          <div> <img src="${medical.image}" alt="alt"/></div>

          <br><!-- comment -->
          <p>${medical.description}</p>
      </div>
      <textarea>
          
      </textarea>
    </section>
      
  </main>