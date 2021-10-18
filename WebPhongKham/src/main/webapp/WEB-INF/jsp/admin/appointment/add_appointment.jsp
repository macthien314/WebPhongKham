<%-- 
    Document   : add_medical
    Created on : Sep 30, 2021, 9:22:25 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/appointment-manager/add-appointment" var="action"/>
<h2 class="mt-4">Thêm cuộc hẹn </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-cuochen</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Medical</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="appointment" action="${action}" modelAttribute="appointment" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
                        
               
                                  
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Tạo Chuyên khoa</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
