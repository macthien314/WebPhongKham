<%-- 
    Document   : prescriptiondrug_manager
    Created on : Nov 2, 2021, 11:06:21 AM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="mt-4">Quản Lý Chi Tiết Toa Thuốc</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-chitiettoathuoc</li>
                        </ol>
<c:if test="${err != null}">
    <div class="alert alert-danger">${err}</div>
</c:if>
    <div class="row">
            <div class="col-md-3">
            <a href="<c:url value="/admin/prescriptiondrug-manager/add-prescriptiondrug"/>" class=" btn btn-primary btn-xs pull-right"><b>+</b> ADD Drug</a>
             </div>
    
        <table  class="table table-striped table-bordered" width="100%">
        
        <thead>
        
      <tr>
                <th class="th-sm">Mã</th>
                <th>Hướng dẫn sử dụng</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Mã toa thuốc</th>
                <th>Tên thuốc</th>
                
                <th><i class="fas fa-cog"></i></th>
           </tr>

            
        </thead>
        <tbody>
            <c:forEach items="${prescriptiondrugs}" var="s">
                <td>${s.id}</td>
                <td>${s.userGuide}</td>
                <td>${s.unitPrice}</td>
                <td>${s.quantity}</td>
                <td>${s.prescription.id}</td>   
                <td>${s.drug.name}</td>
                
               
                            
                         <td class="setting">
                             
                             <a data-toggle="tooltip" title="xem thông tin" title="thông tin"href="<c:url value="/admin/quanly-slide/chitiet-slide/${s.id}"/>"> <i class="fas fa-info-circle" style="color:#18d26e"></i></a>
                              <a data-toggle="tooltip" title="chỉnh sửa" href="<c:url value="/admin/prescriptiondrug-manager/edit-prescriptiondrug/${s.id}"/>">
                                  <i class="fas fa-edit" style="color:#6633ff"></i>
                               </a>

                              <a id="modal" href="<c:url value="/admin/prescriptiondrug-manager/delete-prescriptiondrug/${s.id}"/>" name="deleteButton" type="button" class="btn btn-primary" data-toggle="tooltip modal" data-target="#deleteModal" title="Xóa sản phẩm">
                                   <i class="fas fa-trash-alt" style="color:#ed3c0d"></i>
                              </a>
                               
                         </td>
                    </tr>
            </c:forEach>
          </tbody>
          
    </table>
  
    
    </div>
                                     

  <!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Xóa chi tiết toa thuốc</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Bạn có muốn chắn xóa chi tiết toa thuốc
      </div>
      <div class="modal-footer">
          <a href="" class="btn btn-primary" id="delRef">Vâng,tôi chắc</a> 
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

