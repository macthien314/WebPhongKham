<%-- 
    Document   : add_drug
    Created on : Sep 30, 2021, 11:22:25 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/drug-manager/add-drug" var="action"/>
<h2 class="mt-4">Thêm thuốc </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-thuoc</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Drug</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="drug" action="${action}" modelAttribute="drug" method="post" enctype="multipart/form-data">
                <div class=" form-group">
                     <label for="name">Tên thuốc</label>   
                     <form:input path="name" id="name" name="title" type="text" cssClass="form-control"/>
                     <form:errors path="name" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class=" form-row">
                    <div class=" form-group col-md-6">  
                     <label for="unitPrice">Giá tiền</label>   
                     <form:input path="unitPrice" id="unitPrice" name="title" type="text" cssClass="form-control"/>
                     <form:errors path="unitPrice" cssClass="alert alert-danger" element="div" /></div>
                     <div class=" form-group col-md-6">  
                     <label for="quantity">Số lượng</label>   
                     <form:input path="quantity" id="quantity" name="title" type="number" cssClass="form-control"/>
                     <form:errors path="quantity" cssClass="alert alert-danger" element="div" /></div>
                </div> <!-- form-group end.// -->
                
                <div class=" form-row">
                      <div class=" form-group col-md-6">      
                    <label for="expiry">Hạn sử dụng</label>
                   <form:input path="expiry" id="expiry" name="title" type="date" cssClass="form-control"/>
                   <form:errors path="expiry" cssClass="alert alert-danger" element="div" /></div>
                   <div class=" form-group col-md-6">
                    <label for="manufacturer">Ngày sản xuất</label>
                   <form:input path="manufacturer" id="manufacturer" name="title" type="date" cssClass="form-control"/>
                    <form:errors path="manufacturer" cssClass="alert alert-danger" element="div" /></div>
                 </div>
                        
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Tạo Thuốc</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
