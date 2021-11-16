<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4 class="mt-4">Chi tiết toa thuốc(Mã = ${prescription.id})</h4>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="<c:url value="/nurse"/>">nurse</a></li>
                            <li class="breadcrumb-item active">toathuoc-hoadon</li>
                        </ol>
<c:if test="${err != null}">
    <div class="alert alert-danger">${err}</div>
</c:if>
    <c:if test="${err != null}">
    
          <div class="alert alert-danger">
            <strong>${err}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
         </div>
    
</c:if>
<c:if test="${success != null}">
    <div class="alert alert-success">
            <strong>${success }</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
         </div>
</c:if>
    <div class="row">
            <div class="col-md-3">
                
            </div>
             <div >
                 
             </div>
             
            
              
            </div>
 <div class="card">
        <header class="card-header">
               
<div class="d-flex justify-content-between align-items-center">
          <h2>Chi tiết toa thuốc</h2>
          <c:if test="${currentUser.userRole.equals('ROLE_NURSE')}">
          <c:if test="${check == true}">
            <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           TẠO HÓA ĐƠN
            </button>
            </c:if>
           <c:if test="${check == false}">
            <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           Không thể tạo hóa đơn
            </button>
            </c:if>
          </c:if >
        </div>
        </header>
        <article class="card-body">
            
                <div class="form-row">
                        <div class=" form-group col-md-3">
                             <label for="createdDate"><b>Mã bệnh nhân:</b> ${prescription.patient.id} </label>   
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">
                            <label for="firstName"><b>Tên:</b> ${prescription.patient.firstName} ${prescription.patient.lastName}</label>
                         </div>
                </div>
                
                    <div class="row">
                    <div class=" form-group col-md-3">
                   
                             <label for="createdDate"><b>Ngày sinh:</b>  <fmt:formatDate value="${prescription.patient.birthDate}" pattern="dd-MM-yyyy" /></label>   
                    </div> <!-- form-group end.// -->
                    <div class=" form-group col-md-3">
                            <label for="firstName"><b>Giới tính:</b> ${prescription.patient.gender}</label>
                    </div>
                    <div class=" form-group col-md-3">
                            <label for="firstName"><b>SDT:</b> ${prescription.patient.phone}</label>
                    </div>
                    
                    

                </div>
                    
                   
                       <div class="form-group">
                             <label for="createdDate"><b>Ngày lập toa thuốc</b>  <fmt:formatDate value="${prescription.createdDate}" pattern="dd-MM-yyyy hh:mm:ss" /></label>   
                        </div>  
                    
                        
                <div class="form-row">
                        <div class=" col-md-3">
                             <label for="createdDate"><b>Mã bác sĩ kê toa:</b> ${prescription.doctor.id} </label>   
                        </div> <!-- form-group end.// -->
                        <div class="  col-md-6">
                            <label for="firstName"><b>Tên bác sĩ:</b> ${prescription.doctor.firstName} ${prescription.doctor.lastName}</label>
                         </div>
                </div>
                         
                <div class="form-group">
                        <div>
                             <label for="createdDate"><b>Chuẩn đoán</b>  </label>   
                             <textarea disabled="true" rows="3" cols="30" class="form-control">${p.diagnosis}</textarea>
                        </div> <!-- form-group end.// -->
                       
                </div>        
                                  
                <div class="form-group">
                    
                    <p class="text-danger"> <b>Tổng tiền: </b>${totalPrice}</p>  

                </div> 
                        <br><br>
                         <h4 class="text-center">Chi tiết toa thuốc</h4>
                    <c:if test="${prescriptionDrugs.size() <= 0}">
                        <h4 class="text-danger">Không có thuốc trong toa!!</h4>
                    </c:if>
                    <c:if test="${prescriptionDrugs.size() > 0}">
                        
                        <table class="table table-striped table-bordered table-sm">
                            <tr>
                                <th>Mã thuốc</th>
                                <th>tên thuốc</th>
                                <th>Số lương(Viên)</th>
                                <th>Thốc trong kho</th>
                                <th>Cách sử dụng</th>
                                <th>Thành tiền</th>
                            </tr>
                            <c:forEach items="${prescriptionDrugs}" var="p">
                                <tr>
                                <td>${p.drug.id}</td>
                                <td>${p.drug.name}}</td>
                                <td>
                                    ${p.quantity}
                                </td>
                                <td>
                                     
                                    <c:if test="${p.drug.quantity >= p.quantity}"><p class="text-primary">${p.drug.quantity}(còn thuốc)</p></c:if>
                                    <c:if test="${p.drug.quantity < p.quantity}"><p class="text-danger">${p.drug.quantity}(Thiếu thuốc)</p></c:if>

                                </td>
                                <td>
                                    <textarea disabled="true" rows="3" cols="30" class="form-control">${p.userGuide}</textarea>
                                </td>
                                <td>
                                    ${p.drug.unitPrice * p.quantity}
                                </td>
                                
                            </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            
                
            
        </article> 
<c:url value="/nurse/invoice/prescription-list/${prescription.id}/create" var="action"/>
             
              <!-- Modal -->

<c:if test="${check == true}">
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
                       <label for="dname"><b>Mã Toa</b> : ${prescription.id}</label>
                  </div>
                </div>
                  
                  
                  
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
                       <label for="dname"><b>Bác sĩ lập toa:</b> ${prescription.doctor.firstName} ${prescription.doctor.lastName}</label>
                  </div>
                  <div class="form-group col-md-6">
                       <label for="dname"><b>Mã Bác sĩ:</b> ${prescription.doctor.id}</label>
                  </div>
                    
                </div>
              
                 <div class="form-row">
                   <div class="form-group col-md-6">
                       <label for="tcate"><b>Y tá lập toa</b> : ${nurse.firstName} ${nurse.lastName}</label>
                    
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
 </c:if>

<c:if test="${check == false}">
     <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Không thể tạo hóa đơn</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <p class="text-danger">Toa thuốc này thiếu thuốc hoặc có thuốc hết hạn!!</p>
      </div>
      <div class="modal-footer">
          
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
      
  </div>
</div>    
 </c:if>
              
              
              
              
              
              
              <c:if test="${!success.equals('')}">
                  <script>
                      alert('Tạo hóa đơn thành công ${susscess}');
                  </script>
              </c:if>
