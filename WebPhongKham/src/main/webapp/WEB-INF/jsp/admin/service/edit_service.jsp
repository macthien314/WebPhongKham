<%-- 
    Document   : edit_service
    Created on : Oct 26, 2021, 4:26:07 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/services-manager/edit-services" var="action"/>
<h2 class="mt-4">Chỉnh sửa dịch vụ </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-dichvu</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Service</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="services" action="${action}" modelAttribute="services" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
          
                 <form:hidden path="id" />   
                <div class="form-group preview text-center">
                    <img class="" src=""id="preview" alt="Preview Image" width="50%" height="20%"/>
                    <div class="browse-button">
                        <i class="fa fa-pencil-alt"></i>
                        <form:input path="file" type="file" requiredname="UploadedFile" id="UploadedFile"/>
                    </div>
                    <span class="Error"></span>
                </div>
                <div class=" form-group">
                     <label for="title">Tên dịch vụ</label>   
                     <form:input path="name" id="title" name="title" type="text" cssClass="form-control"/>
                     <form:errors path="name" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                <div class=" form-group">
                            
                    <label for="lastName">Giá tiền</label>
                    <form:input path="fee" id="title" name="title" type="number" cssClass="form-control"/>
                    <form:errors path="fee" cssClass="alert alert-danger" element="div" />

                 </div>
                        
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Chỉnh sửa dịch vụ</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>