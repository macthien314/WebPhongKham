<%-- 
    Document   : add_medical
    Created on : Sep 30, 2021, 9:22:25 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/prescription-manager/add-prescription" var="action"/>
<h2 class="mt-4">Thêm chuyên khoa </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-toathuoc</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Prescription</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="prescription" action="${action}" modelAttribute="prescription" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
              
                <div class=" form-group">
                     <label for="createdDate">Ngày lập toa</label>   
                     <form:input path="createdDate" id="createdDate" name="title" type="date" cssClass="form-control"/>
                     <form:errors path="createdDate" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                   <div class="form-group">
                    <label for="tcate">Tên bệnh nhân</label>
                    <form:select path="patient" id="p" cssClass="form-control">

                        <c:forEach items="${patients}" var="p">
                            <option value="${p.id}">${p.firstName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="patient" element="div"/>
                </div>
                
                 <div class="form-group">
                 <label for="tcate">Tên bác sĩ</label>
                 <form:select path="doctor" id="d" cssClass="form-control">

                        <c:forEach items="${doctors}" var="d">
                            <option value="${d.id}">${d.firstName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="doctor" element="div"/>
                 </div>
                 
                  <div class=" form-group">
                     <label for="totalPrice">Tổng tiền</label>   
                     <form:input path="totalPrice" id="createdDate" name="title" type="text" cssClass="form-control"/>
                     <form:errors path="totalPrice" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                 
                     
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Tạo thuốc</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
