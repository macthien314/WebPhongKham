<%-- 
    Document   : edit_slide
    Created on : Sep 28, 2021, 3:47:59 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h2 class="mt-4">Chỉnh sửa slide</h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item"><a href="<c:url value="/"/>">quản lý slide</a></li>
                            <li class="breadcrumb-item active">chỉnh sữa slide</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick="Back()"></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Slide ${slide.id} </h2>
        </header>
        <article class="card-body">
            <c:url value="/admin/quanly-slide/sua-slide" var="action"/>
        
            
            <form:form id="slide" action="${action}" modelAttribute="slide" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
               <form:hidden path="id" />
             <form:hidden path="image"/>
                <div class="form-group preview text-center">
                    <img class="" src="${slide.image}"id="preview" alt="Preview Image" width="50%" height="20%"/>
                    <div class="browse-button">
                        <i class="fa fa-pencil-alt"></i>
                        <form:input name="file" path="file" type="file" requiredname="UploadedFile" id="UploadedFile"/>
                    </div>
                    <span class="Error"></span>
                </div>
                <div class=" form-group">
                     <label for="title">Tiêu đề</label>   
                     <form:input  path="title" id="title" name="title" type="text" cssClass="form-control"/>
                     
                </div> <!-- form-group end.// -->
                <div class=" form-group">
                            
                      <label for="descripstion">Description</label>
                       <form:textarea path="description" id="description" name="description" type="text" cssClass="form-control"/>


                </div>
                 <div class="form-group">
                        <label class="form-check-inline">
                            <form:checkbox path="active" name="active" value="true" />
                          <span class="checkbox-inline"> kích hoạt </span>
                        </label>
                        
    
                </div>          
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Cập nhập</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
       