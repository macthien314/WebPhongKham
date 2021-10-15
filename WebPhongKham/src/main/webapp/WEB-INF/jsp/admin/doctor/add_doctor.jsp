<%-- 
    Document   : add_doctor
    Created on : Oct 8, 2021, 12:12:31 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/doctor-manager/add-doctor" var="action"/>
<h2 class="mt-4">Thêm bác sĩ</h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-bacsi</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Doctor</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="doctor" action="${action}" modelAttribute="doctor" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
                        
                <div class="form-group preview text-center">
                    <img class="" src=""id="preview" alt="Preview Image" width="50%" height="20%"/>
                    <div class="browse-button">
                        <i class="fa fa-pencil-alt"></i>
                        <form:input path="file" type="file" requiredname="UploadedFile" id="UploadedFile"/>
                    </div>
                    <span class="Error"></span>
                </div>
                    <div class=" form-group">
                     <label for="title">Họ</label>   
                     <form:input path="lastName" id="lastName" name="lastName" type="text" cssClass="form-control"/>
                     <form:errors path="lastName" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                    
                <div class=" form-group">
                     <label for="title">Tên</label>   
                     <form:input path="firstName" id="firstName" name="firstName" type="text" cssClass="form-control"/>
                     <form:errors path="firstName" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
               
                   <div class=" form-group">
                     <label for="title">Ngày sinh</label>   
                     <form:input path="birthDate" id="birthDate" name="birthDate" type="date" value="2000-12-31"
       min="1935-01-01" max="2000-12-31" cssClass="form-control"/>
                     <form:errors path="birthDate" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
               
                <div class=" form-group">
                     <label for="title">Giới tính</label>   
                     <form:input path="gender" id="gender" name="gender" type="text" cssClass="form-control"/>
                     <form:errors path="gender" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class=" form-group">
                     <label for="title">SĐT</label>   
                     <form:input path="phone" id="phone" name="phone" type="number" cssClass="form-control"/>
                     <form:errors path="phone" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                
                <div class=" form-group">
                     <label for="title">Email</label>   
                     <form:input path="email" id="email" name="email" type="text" cssClass="form-control"/>
                     <form:errors path="email" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class=" form-group">
                     <label for="title">Kinh nghiệm</label>   
                     <form:input path="yearsExperience" id="yearsExperience" name="yearsExperience" type="text" cssClass="form-control"/>
                     <form:errors path="yearsExperience" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class=" form-group">
                     <label for="title">Tên Khoa</label>   
                     <form:input path="medical" id="medical" name="medical" type="text" cssClass="form-control"/>
                     <form:errors path="medical" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class=" form-group">
                     <label for="title">Tên tài khoản</label>   
                     <form:input path="user" id="user" name="user" type="text" cssClass="form-control"/>
                     <form:errors path="user" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                       
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Tạo Bác sĩ</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
