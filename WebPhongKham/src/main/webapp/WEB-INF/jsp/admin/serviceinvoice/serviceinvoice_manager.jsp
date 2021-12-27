<%-- 
    Document   : medical_manager
    Created on : Sep 29, 2021, 4:58:50 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="mt-4">Quản lý Hóa Đơn Dịch Vụ</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-hoadondichvu</li>
                        </ol>
<c:if test="${err != null}">
    <div class="alert alert-danger">${err}</div>
</c:if>
    <div class="row">
            

         <div class="col-md-3">
            <a href="<c:url value="/admin/serviceinvoice-manager/add-serviceinvoice"/>" class=" btn btn-primary btn-xs pull-right"><b>+</b>Thêm hóa đơn dịch vụ</a>
             </div>
            
             <div class="col-md-8">
            
                 <div class="input-group" id="adv-search">
                <form  id ="find"role="form">
                    <input disabled="true" name="lastname" type="text" class="form-control" placeholder="Click vào mũi tên để tìm kiếm" />
                </form>
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <div class="dropdown dropdown-lg">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                <form  class="form-horizontal" role="form">
                                 
                                 <div class="form-group">
                                    <label for="fromDate">Từ thời điểm</label>
                                    <input value="${fromDate}" type="date" name="fromDate" class="form-control"><!-- comment -->
                                </div>
                                <div class="form-group">
                                    <label for="fromDate">Đến thời điểm</label>
                                <input value="${toDate}" type="date" name="toDate"  class="form-control"><!-- comment -->
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
                 
                        
                    </div>
                </div>
            </div>
          </div>
            </div>
<div id="managerTable" class="table table-striped w-auto" >
    
        <table  class="slide-table table table-striped table-bordered" width="100%">
        
        <thead>
         
        <div class="row">
           

            <tr>
                <th class="th-sm">Mã</th>
                <th>Giá tiền</th>
                <th>Ngày Tạo Hóa Đơn</th>
                <th>Tên dịch vụ</th>
                <th>Tên bệnh nhân</th>
                <th>Tên y tá</th>
                <th>Chỉnh sửa</th>
                <th>Xóa bỏ</th>
           </tr>
        </thead>
        <tbody>
            
                <c:forEach items="${serviceinvoices}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.fee}</td>
                        <td>${s.createdDate}</td>
                        <td>${s.service.name}</td>
                        <td>${s.patient.firstName}</td>
                        <td>${s.nurse.firstName}</td>
                           

                           <td >
                        <a data-toggle="tooltip" class="btn btn-success"title="chỉnh sửa" href="<c:url value="/admin/serviceinvoice-manager/edit-serviceinvoice/${s.id}"/>">
                              <i class="fas fa-edit" style=""></i>
                         </a>
                        </td>
                        <td >
                        <a id="modal"  href="<c:url value="/admin/serviceinvoice-manager/delete-serviceinvoice/${s.id}"/>" name="deleteButton" type="button" class="btn btn-primary" data-toggle="tooltip modal" data-target="#deleteModal" title="Xóa sản phẩm">
                               <i class="fas fa-trash-alt" style="color:#ed3c0d"></i>
                         </a>
                        </td>
                               
                        
                    </tr>
                </c:forEach>
          </tbody>
          
    </table>
 
    </div>
         
    

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Xóa Hóa Đơn Dịch Vụ</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Bạn có muốn chắn xóa hóa đơn dịch vụ
      </div>
      <div class="modal-footer">
          <a href="" class="btn btn-primary" id="delRef">Vâng,tôi chắc</a> 
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

         
         
