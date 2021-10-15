<%-- 
    Document   : patient_manager
    Created on : Oct 10, 2021, 2:51:41 PM
    Author     : macth
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="mt-4">Quản lý Bệnh Nhân</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                    <li class="breadcrumb-item active">quanly-benhnhan</li>
                </ol>
<c:if test="${err != null}">
<div class="alert alert-danger">${err}</div>
</c:if>
<div id="managerTable" class="table table-striped w-auto" >

    <table  class="slide-table table table-striped table-bordered" width="100%">

    <thead>
     <form action="">
    <div class="row">
        <div class="col-md-3">
        <a href="<c:url value="/admin/doctor-manager/add-doctor"/>" class=" btn btn-primary btn-xs pull-right"><b>+</b> ADD Doctor</a>
         </div>
         <div class="col-md-3">

         <select name="quantity" id="inputState" class="form-control">

                          <option>10</option>
                          <option>15</option>
                          <option>All</option>

         </select>
         </div>


          <div style="margin-right: 0; margin-left: auto;"class="col-md-2">
         <input type="submit" value="Lọc" class="btn btn-danger"/>
            </div>  
        </div>
      </form>

        <tr>
            <th class="th-sm">Mã</th>
            <th>Họ</th>
            <th >Tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>SĐT</th>
            <th>Email</th>
            <th style="width:50%;" ">Ảnh</th>
            <th>Tài khoản</th>

            <th><i class="fas fa-cog"></i></th>
       </tr>
    </thead>
    <tbody>

            <c:forEach items="${patients}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.firstName}</td>
                    <td>${s.lastName}</td>
                    <td>${s.birthDate}</td>
                    <td>${s.gender}</td>
                    <td>${s.phone}</td>
                    <td>${s.email}</td>
           
                    
                    <td class="w-auto">
                          <img src="${s.image}" class="img-fluid img-thumbnail" alt="Sheep">

                    </td>
                      <td>${s.user}</td>
                     <td class="setting">

                         <a data-toggle="tooltip" title="xem thông tin" title="thông tin"href="<c:url value="/admin/quanly-slide/chitiet-slide/${s.id}"/>"> <i class="fas fa-info-circle" style="color:#18d26e"></i></a>
                          <a data-toggle="tooltip" title="chỉnh sửa" href="<c:url value="/admin/quanly-slide/sua-slide/${s.id}"/>">
                              <i class="fas fa-edit" style="color:#6633ff"></i>
                           </a>

                          <a id="modal" href="<c:url value="/admin/quanly-slide/xoa-slide/${s.id}"/>" name="deleteButton" type="button" class="btn btn-primary" data-toggle="tooltip modal" data-target="#deleteModal" title="Xóa sản phẩm">
                               <i class="fas fa-trash-alt" style="color:#ed3c0d"></i>
                          </a>

                     </td>
                </tr>
            </c:forEach>
      </tbody>

</table>


</div>




