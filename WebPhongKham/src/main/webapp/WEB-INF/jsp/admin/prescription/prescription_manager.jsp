<%-- 
    Document   : medical_manager
    Created on : Sep 29, 2021, 4:58:50 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="mt-4">Quản lý toa thuốc </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-toathuoc</li>
                        </ol>
<c:if test="${err != null}">
    <div class="alert alert-danger">${err}</div>
</c:if>
    <div class="row">
            
        <div class="col-md-3">
            <a href="<c:url value="/admin/prescription-manager/add-prescription"/>" class=" btn btn-primary btn-xs pull-right"><b>+</b>Thêm toa thuốc</a>
            </div>
             
             <div class="col-md-8">
            
                 <div class="input-group" id="adv-search">
                <form  id ="find"role="form">
                    <input value="${presID}" name="id" type="number" class="form-control" placeholder="NHẬP ID TOA THUỐC" />
                </form>
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <div class="dropdown dropdown-lg">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                <form  class="form-horizontal" role="form">
                                  
             
                                  <div class="form-group">
                                    <label for="patientID">Bệnh nhân</label>
                                    <select  name ="patientID"class="form-control">
                                        <option value="all" <c:if test="${medid.equals('all')}">selected</c:if>>ALL</option>
                                        <option>TẤT CÁ</option>
                                        <c:forEach items="${patients}" var="p">
                                            <option value="${p.id}"<c:if test="${patientID.equals(Integer.toString(p.id))}"> selected</c:if>>${p.id} ${p.firstName} ${p.lastName}</option>
                                         </c:forEach>
                                    </select>
                                  </div>
                                   
                                     
                                  
                                  <div class="form-group">
                                     <label for="pagequan">Số lượng hiển thị</label>
                                     <input autocomplete="off" value="${pagequan}" class="form-control" name ="pagequan"maxlength="3" type="text" onkeypress="return onlyNumberKey(event)" list="cars" />
                                     <datalist id="cars">
                                          <option>all</option>
                                     </datalist>
                                  </div>
                                    
                                  <button type="submit" class="btn btn-primary">Tìm</button>
                                </form>
                            </div>
                        </div>
                        <button type="submit" form="find" class="btn btn-primary">LỌC</button>
                        
                    </div>
                </div>
            </div>
          </div>
            </div>
<div id="managerTable" class="table table-striped w-auto" >
        
        <table  class="table table-striped table-bordered" width="100%">
        
        <thead>
        
    

            <tr>
                <th class="th-sm">Mã</th>
                <th>Ngày lập</th>
                <th>Tên bệnh nhân</th>
                <th>Tên bác sĩ</th>
                <th>Chuẩn đoán</th>
   
                <th><i class="fas fa-cog"></i></th>
           </tr>
        </thead>
        <tbody>
            
                <c:forEach items="${prescriptions}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.createdDate}</td>
                        <td>${s.patient.firstName}</td>
                        <td>${s.doctor.firstName}</td> 
                        <td>${s.diagnosis}</td>
                       
                         <td class="setting">

                         <a data-toggle="tooltip" title="xem thông tin" title="thông tin"href="<c:url value="/admin/quanly-slide/chitiet-slide/${s.id}"/>"> <i class="fas fa-info-circle" style="color:#18d26e"></i></a>
                         <a data-toggle="tooltip" title="chỉnh sửa" href="<c:url value="/admin/prescription-manager/edit-prescription/${s.id}"/>">
                              <i class="fas fa-edit" style="color:#6633ff"></i>
                         </a>

                         <a id="modal" href="<c:url value="/admin/prescription-manager/delete-prescription/${s.id}"/>" name="deleteButton" type="button" class="btn btn-primary" data-toggle="tooltip modal" data-target="#deleteModal" title="Xóa toa thuốc">
                               <i class="fas fa-trash-alt" style="color:#ed3c0d"></i>
                         </a>

                     </td>
                    </tr>
                </c:forEach>
          </tbody>
          
    </table>
  
    
    </div>
<c:if test="${!pagequan.equals('all')}"> 
<div class="pagination">
   <a href="<c:url value="/admin/doctor-manager"/>?page=1">«</a>
   
  
   <c:forEach begin = "1" end="${Math.ceil(count/Integer.parseInt(pagequan))}" var="i">
   <c:if test="${page != i}">
       <a href="<c:url value="/admin/doctor-manager">
                    
                    <c:param name="lastname"
                    value="${presID}"></c:param>
                    <c:param name="account"
                    value="${patientID}"></c:param>
                   
                    <c:param name="pagequan"
                    value="${pagequan}"></c:param>
                    <c:param name="page"
                    value="${i}"></c:param>
                </c:url>"
       >${i}</a></li>
   </c:if>
   <c:if test="${page == i}">
   
  <a class ="active"href="<c:url value="/admin/doctor-manager">
                    <c:param name="id"
                    value="${presID}"></c:param>
                  
                    <c:param name="pres"
                    value="${firstname}"></c:param>
                    <c:param name="pagequan"
                    value="${pagequan}"></c:param>
                    <c:param name="page"
                    value="${i}"></c:param>
                </c:url>"
       >${i}</a></li>
   </c:if>
   </c:forEach>
   
   <a href="#">»</a>
 </div>
   </c:if >       

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Xóa slide</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Bạn có muốn chắn xóa toa thuốc
      </div>
      <div class="modal-footer">
          <a href="" class="btn btn-primary" id="delRef">Vâng,tôi chắc</a> 
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

         
         