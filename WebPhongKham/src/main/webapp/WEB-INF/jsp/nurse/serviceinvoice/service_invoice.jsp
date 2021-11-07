<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="mt-4">Hóa Đơn Dịch Vụ</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-hoadondichvu</li>
                        </ol>
<c:if test="${err != null}">
    <div class="alert alert-danger">${err}</div>
</c:if>
    <c:set var="now" value="<%=new java.util.Date()%>" />
<div id="managerTable" class="table table-striped w-auto" >
    
        <table  class="slide-table table table-striped table-bordered" width="100%">
        
        <thead>
         <form action="">
        <div class="row">
            <div class="col-md-3">
                <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           TẠO HÓA ĐƠN DỊCH VỤ
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
                <th>Giá tiền</th>
                <th>Ngày Tạo Hóa Đơn</th>
                <th>Tên dịch vụ</th>
                <th>Tên bệnh nhân</th>
                <th>Tên y tá</th>
                <th>Chi tiết</th>
           </tr>
        </thead>
        <tbody>
            
                <c:forEach items="${serviceinvoices}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.fee}</td>
                        <td>${s.createdDay}</td>
                        <td>${s.service.name}</td>
                        <td>${s.patient.firstName}</td>
                        <td>${s.nurse.firstName}</td>
                        <td>
                         <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           
                         </button>
               
                        </td>
                          
                    </tr>
                </c:forEach>
          </tbody>
          
    </table>
  
    
    </div>
    <c:url value="/nurse/patient-serviceinvoice/${patient.id}/create" var="action"/>
             
              <!-- Modal -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Xóa slide</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form id="serviceinvoice" action="${action}" modelAttribute="serviceinvoice" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
               
                <div class="form-row">
                   <div class="form-group col-md-6">
                       <label for="tcate"><b>Tên bệnh nhân</b> : ${patient.firstName} ${patient.lastName}</label>
                    
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
                   
                 <div class="form-group">
                 <label for="tcate">Tên dịch vụ</label>
                    <form:select path="service" id="s" cssClass="form-control">
                        <c:forEach items="${services}" var="s">
                            <option value="${s.id}">${s.name}: giá tiền ${s.fee}VNĐ</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="service" element="div"/>
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
