<%-- 
    Document   : patient-detail
    Created on : Oct 10, 2021, 2:49:10 PM
    Author     : macth
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
          <h1 class="text-center">Bệnh Nhân ${patient.last_name}</h1>
          <div> <img src="${patient.image}" alt="alt"/></div>

          <br><!-- comment -->
            <p>${s.first_name}</p>

            <p>${s.birth_date}</p>
            <p>${s.gender}</p>
            <p>${s.phone}</p>
            <p>${s.email}</p>
      
      </div>
      <textarea>
          
      </textarea>
    </section>
      
  </main>