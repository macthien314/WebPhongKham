<%-- 
    Document   : edit_appointment
    Created on : Oct 26, 2021, 5:15:45 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/nurse/appointment/edit-appointment/${appointmentId}" var="action"/>
<h2 class="mt-4">Chỉnh sửa cuộc hẹn </h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="<c:url value="/nurse"/>">yta</a></li>
                            <li class="breadcrumb-item active">quanly-cuochen</li>
                        </ol>


      <div class="Back">
         <a href="<c:url value="/nurse/appointment"/>">  <i class="fa fa-arrow-left" onclick=""></i></a>
       </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Lịch hẹn</h2>
        </header>
        <article class="card-body">
            
        

            <form:form id="appointment" action="${action}" modelAttribute="appointment" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
                 <form:hidden path="appointmentId" />       
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
                 <label for="tcate">Tên bác sĩ</label>
                 <form:select path="doctor" id="n" cssClass="form-control">

                        <c:forEach items="${doctors}" var="n">
                            <option value="${n.id}">${n.firstName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="doctor" element="div"/>
                 </div>
               </div>    
                 <div class="form-row">
                        <div class=" form-group col-md-6">
                             <label for="lastName">Họ: </label>   
                             <form:input path="lastName" id="title" name="title" type="text" cssClass="form-control"/>
                             <form:errors path="lastName" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">

                            <label for="firstName">Tên:</label>
                            <form:input path="firstName" id="title" name="title" type="text" cssClass="form-control"/>
                            <form:errors path="firstName" cssClass="alert alert-danger" element="div" />

                         </div>
                    </div>
                    <div class="form-row">
                       <div class=" form-group  col-md-6">
                             <label for="title">SĐT</label>   
                             <form:input path="phone" id="phone" name="phone" type="number" cssClass="form-control"/>
                             <form:errors path="phone" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->


                        <div class=" form-group  col-md-6">
                             <label for="title">Email</label>   
                             <form:input path="email" id="email" name="email" type="text" cssClass="form-control"/>
                             <form:errors path="email" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->        
                      </div>
                 <div class=" form-group">
                     <label for="appointmentDate">Ngày hẹn</label>   
                     <form:input path="appointmentDate" id="appointmentDate" name="title" type="date" cssClass="form-control"/>
                     <form:errors path="appointmentDate" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class=" form-group">
                            
                    <label for="description">Chi tiết thông tin</label>
                    <form:input path="description" id="title" name="title" type="text" cssClass="form-control"/>
                    <form:errors path="description" cssClass="alert alert-danger" element="div" />

                 </div>
                                  
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Chỉnh sửa Cuộc Hẹn</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>
