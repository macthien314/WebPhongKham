<%-- 
    Document   : edit_medicalexaminationcard
    Created on : Oct 24, 2021, 12:49:40 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/medicalexaminationcard-manager/edit-medicalexaminationcard" var="action"/>
<h2 class="mt-4">Chỉnh sửa phiếu khám</h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-phieukham</li>
                        </ol>


        <div class="Back">
         <a href="<c:url value="/admin/medicalexaminationcard-manager"/>">  <i class="fa fa-arrow-left" onclick=""></i></a>
       </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Phiếu Khám</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="medicalexaminationcard" action="${action}" modelAttribute="medicalexaminationcard" method="post" enctype="multipart/form-data">
              <form:errors path="*" cssClass="alert alert-danger" element="div" />
               <form:hidden path="id" />
      
             
                    <div class="form-row">
                        <div class=" form-group col-md-6">
                             <label for="num">STT </label>   
                             <form:input path="num" id="title" name="title" type="text" cssClass="form-control"/>
                             <form:errors path="num" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">

                            <label for="date">Ngày khám</label>
                            <form:input path="date" id="title" name="title" type="date" cssClass="form-control"/>
                            <form:errors path="date" cssClass="alert alert-danger" element="div" />

                         </div>
                    </div>
                            
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
                
                
                <div class=" form-group">
                     <label for="title">Triệu chứng</label>   
                     <form:input path="sympton" id="sympton" name="sympton" type="text" cssClass="form-control"/>
                     <form:errors path="sympton" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                <div class=" form-group">
                     <label for="diagnosis">Chuẩn đoán</label>   
                     <form:input path="diagnosis" id="diagnosis" name="diagnosis" type="text" cssClass="form-control"/>
                     <form:errors path="diagnosis" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                  
               
              
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Chỉnh Sửa Phiếu Khám</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>


