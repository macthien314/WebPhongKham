<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="mt-4">Danh sách Hóa đơn của toa thuốc ${prescription.id}</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-hoadon</li>
                        </ol>
<c:if test="${err != null}">
    <div class="alert alert-danger">${err}</div>
</c:if>
<div id="managerTable" class="table table-striped w-auto" >
    
        <table  class="table table-striped table-bordered" width="100%">
        
        <thead>
         <form action="">
        <div class="row">
            <div class="col-md-3">
                <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                          LẬP HÓA ĐƠN
                 </button>
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
                <th>Ngày tạo</th>
                <th>Giá tiền</th>
                <th>Mã toa thuốc</th>
                
                <th><i class="fas fa-cog"></i></th>
           </tr>

            
        </thead>
        <tbody>
          
                <c:forEach items="${invoices}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.createdDay}</td>
                        <td>${s.totalPrice}</td>
                        <td>${s.prescription.id}</td>
                            
                         <td class="setting">
                             
                             <a data-toggle="tooltip" title="xem thông tin" title="thông tin"href="<c:url value="/admin/quanly-hoadon/chitiet-hoadon/${s.id}"/>"> <i class="fas fa-info-circle" style="color:#18d26e"></i></a>
                              <a data-toggle="tooltip" title="chỉnh sửa" href="<c:url value="/admin/invoice-manager/edit-invoice/${s.id}"/>">
                                  <i class="fas fa-edit" style="color:#6633ff"></i>
                               </a>

                             <a id="modal" href="<c:url value="/admin/invoice-manager/delete-invoice/${s.id}"/>" name="deleteButton" type="button" class="btn btn-primary" data-toggle="tooltip modal" data-target="#deleteModal" title="Xóa hóa đơn">
                               <i class="fas fa-trash-alt" style="color:#ed3c0d"></i>
                            </a>
                               
                         </td>
                    </tr>
                </c:forEach>
          </tbody>
          
    </table>
  
    
    </div>
    
<c:url value="/nurse/invoice/prescription-list/${prescription.id}/create" var="action"/>
             
              <!-- Modal -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Tạo hóa đơn</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form id="serviceinvoice" action="${action}" modelAttribute="invoice" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
               
                <div class="form-row">
                  <div class="form-group col-md-6">
                       <label for="dname"><b>Bệnh nhân</b> : ${prescription.patient.firstName} ${prescription.patient.lastName}</label>
                  </div>
                  <div class="form-group col-md-6">
                       <label for="did"><b>Mã bệnh nhân</b> : ${prescription.patient.id} </label>
                    
                  </div>  
                    
                </div>   
                <div class="form-row">
                  <div class="form-group col-md-6">
                       <label for="dname"><b>Bác sĩ:</b>${prescription.doctor.firstName} ${prescription.doctor.lastName}</label>
                  </div>
                  <div class="form-group col-md-6">
                       <label for="dname"><b>Mã Bác sĩ:</b>${prescription.doctor.id}</label>
                  </div>
                    
                </div>
              
                 <div class="form-row">
                   <div class="form-group col-md-6">
                       <label for="tcate"><b>Tên Ý tá</b> : ${nurse.firstName}</label>
                    
                </div>
                <div class="form-group col-md-6">
                       <label for="tcate"><b>Mã bệnh nhân</b> : ${patient.id} </label>
                    
                </div>     
                
               </div>  
               <div class="form-row">
                   <div class="form-group col-md-6">
                       <label for="tcate"><b>Tên Ý tá</b> : ${nurse.firstName}</label>
                    
                </div>
                <div class="form-group col-md-6">
                       <label for="tcate"><b>Mã bệnh nhân</b> : ${patient.id} </label>
                    
                </div>     
                
               </div> 
               <div>
                   <input type="textarea" value="${prescription}"><!-- comment -->
               </div>
                   
                
                 
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Tạo Hóa Đơn Dịch Vụ</button>
            </div>
                
            </form:form>
           <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
      
    </div>
  </div>
</div>

              <c:if test="${!success.equals('')}">
                  <script>
                      alert('Tạo hóa đơn thành công ${susscess}');
                  </script>
              </c:if>
