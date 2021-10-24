<%-- 
    Document   : add_invoice
    Created on : Oct 24, 2021, 5:42:16 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/invoice-manager/add-invoice" var="action"/>
<h2 class="mt-4">Thêm Hóa Đơn </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-hoadon</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Hoá Đơn</h2>
        </header>
        <article class="card-body">
            
        
            

            <form:form id="invoice" action="${action}" modelAttribute="invoice" method="post" enctype="multipart/form-data">
                <form:errors path="*" cssClass="alert alert-danger" element="div" />
                
                 <div class="form-group">
                    <label for="tcate">Mã toa thuốc</label>
                    <form:select path="prescription" id="pre" cssClass="form-control">

                        <c:forEach items="${prescriptions}" var="pre">
                            <option value="${pre.id}">${pre.id}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="prescription" element="div"/>
                </div>
                
                
                
                <div class=" form-row">
                    <div class=" form-group col-md-6">  
                     <label for="fee">Giá tiền</label>   
                     <form:input path="fee" id="fee" name="fee" type="text" cssClass="form-control"/>
                     <form:errors path="fee" cssClass="alert alert-danger" element="div" />
                    </div>
                
               
                      <div class=" form-group col-md-6">      
                    <label for="createdDay">Ngày tạo</label>
                   <form:input path="createdDay" placeholder="dd-MM-yyyy"  id="createdDay" name="title" type="date" cssClass="form-control"/>
                   <form:errors path="createdDay" cssClass="alert alert-danger" element="div" />
                      </div>
                </div>
                        
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Tạo Thuốc</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
