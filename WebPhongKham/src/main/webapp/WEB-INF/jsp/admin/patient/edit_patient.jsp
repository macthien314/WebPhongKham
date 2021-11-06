<%-- 
    Document   : edit_patient
    Created on : Oct 22, 2021, 6:42:31 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/patient-manager/edit-patient" var="action"/>
<h2 class="mt-4">Chỉnh sửa bệnh nhân</h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-benhnhan</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Patient</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="patient" action="${action}" modelAttribute="patient" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
                <form:hidden path="id" />
             <form:hidden path="image"/>          
                <div class="form-group preview text-center">
                    <img class="" src=""id="preview" alt="Preview Image" width="50%" height="20%"/>
                    <div class="browse-button">
                        <i class="fa fa-pencil-alt"></i>
                        <form:input path="file" type="file" requiredname="UploadedFile" id="UploadedFile"/>
                    </div>
                    <span class="Error"></span>
                </div>
                    <div class="form-row">
                        <div class=" form-group col-md-6">
                             <label for="title">Họ: </label>   
                             <form:input path="lastName" id="title" name="title" type="text" cssClass="form-control"/>
                             <form:errors path="lastName" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">

                            <label for="title">Tên:</label>
                            <form:input path="firstName" id="title" name="title" type="text" cssClass="form-control"/>
                            <form:errors path="firstName" cssClass="alert alert-danger" element="div" />

                         </div>
                    </div>
               
                   <div class=" form-group">
                     <label for="title">Ngày sinh</label>   
                     <form:input path="birthDate" id="birthDate" name="birthDate" type="date" value="2000-12-31"
       min="01-01-1935" max="2021-12-31" cssClass="form-control"/>
                     <form:errors path="birthDate" cssClass="alert alert-danger" element="div" />
                </div> 
               
                <div class="form-group">
                    Nam:<form:radiobutton path="gender" value="Nam"/>
                    Nữ:<form:radiobutton path="gender" value="Nữ"/>
                </div><!-- form-group end.// -->
                
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
                
                 
             
                
              
                <!-- form-group end.// -->
       
                <!-- form-group end.// -->
                       
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Chỉnh sữa thông tin</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>

