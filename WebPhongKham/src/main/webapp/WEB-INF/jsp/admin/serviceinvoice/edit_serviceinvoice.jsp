<%-- 
    Document   : edit_serviceinvoice
    Created on : Oct 27, 2021, 2:13:47 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/serviceinvoice-manager/edit-serviceinvoice" var="action"/>
<h2 class="mt-4">Chỉnh sửa hóa đơn dịch vụ </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-hoadondichvu</li>
                        </ol>


    <div class="Back">
         <a href="<c:url value="/admin/serviceinvoice-manager"/>">  <i class="fa fa-arrow-left" onclick=""></i></a>
       </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Hóa Đơn Dịch Vụ</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="serviceinvoice" action="${action}" modelAttribute="serviceinvoice" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
                <form:hidden path="id" />   
                <div class="form-row">
                   <div class="form-group col-md-6">
                    <label for="tcate">Tên bệnh nhân</label>
                    <form:select path="patient" id="p" cssClass="form-control">

                        <c:forEach items="${patients}" var="p">
                            <option value="${p.id}">${p.firstName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="patient" element="div"/>
                </div>
                
                 <div class="form-group col-md-6">
                 <label for="tcate">Tên y tá</label>
                    <form:select path="nurse" id="n" cssClass="form-control">

                        <c:forEach items="${nurses}" var="n">
                            <option value="${n.id}">${n.firstName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="nurse" element="div"/>
                 </div>
               </div>  
                   
                 <div class=" form-group">
                     <label for="fee">Giá tiền</label>   
                     <form:input path="fee" id="yearsExperience" name="yearsExperience" type="text" cssClass="form-control"/>
                     <form:errors path="fee" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class="form-row">
                 <div class=" form-group col-md-6">

                            <label for="date">Ngày tạo hóa đơn</label>
                            <form:input path="createdDate" id="title" name="title" type="date" cssClass="form-control"/>
                            <form:errors path="createdDate" cssClass="alert alert-danger" element="div" />
                </div>
                
                 <div class="form-group col-md-6">
                 <label for="tcate">Tên dịch vụ</label>
                    <form:select path="service" id="s" cssClass="form-control">

                        <c:forEach items="${services}" var="s">
                            <option value="${s.id}">${s.name}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="service" element="div"/>
                 </div>
         </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Chỉnh Sửa Hóa Đơn Dịch Vụ</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>

