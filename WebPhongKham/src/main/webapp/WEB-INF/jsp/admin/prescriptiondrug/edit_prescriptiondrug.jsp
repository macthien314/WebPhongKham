<%-- 
    Document   : edit_prescriptiondrug
    Created on : Nov 2, 2021, 11:06:50 AM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/prescriptiondrug-manager/edit-prescriptiondrug" var="action"/>
<h2 class="mt-4">Chỉnh sửa chi tiết toa thuốc </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-chitiettoathuoc</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Chi tiết toa thuốc</h2>
        </header>
        <article class="card-body">
            
        
            

            <form:form id="drug" action="${action}" modelAttribute="prescriptiondrug" method="post" enctype="multipart/form-data">
                <form:errors path="*" cssClass="alert alert-danger" element="div" />
                <form:hidden path="id" />
                <div class=" form-group">
                     <label for="userGuide">Hướng dẫn sử dụng</label>   
                     <form:input path="userGuide" id="userGuide" name="title" type="text" cssClass="form-control"/>
                     <form:errors path="userGuide" cssClass="alert alert-danger" element="div" />
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
                    <label for="drug">Tên thuốc</label>
                  <form:select path="drug" id="d" cssClass="form-control">

                        <c:forEach items="${drugs}" var="d">
                            <option value="${d.id}">${d.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="drug" element="div"/>
                      </div>
                   <div class=" form-group col-md-6">
                    <label for="prescription">Ngày sản xuất</label>
                   <<form:select path="prescription" id="d" cssClass="form-control">

                        <c:forEach items="${prescriptions}" var="d">
                            <option value="${d.id}">${d.id}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="prescription" element="div"/>
                   </duv>
                        
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Chỉnh sửa Chi Tiết Toa Thuốc</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
