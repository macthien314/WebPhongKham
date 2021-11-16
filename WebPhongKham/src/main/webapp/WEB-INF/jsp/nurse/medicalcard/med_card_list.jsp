<%-- 
    Document   : med_cart_list
    Created on : Nov 7, 2021, 8:00:51 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h4 class="mt-4">Phiếu Khám của Bác sĩ(Hôm nay)</h4>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">Nurse</a></li>
                    <li class="breadcrumb-item active">medical-examination-card</li>
                    <li class="breadcrumb-item active">${doctor.id}. ${doctor.firstName} ${doctor.lastName}</li>
                </ol>
<c:if test="${err != null}">
    
          <div class="alert alert-danger">
            <strong>Tạo phiếu khám thất bại</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
         </div>
    
</c:if>
<c:if test="${success != null}">
    <div class="alert alert-success">
            <strong>Tạo phiếu khám thành công</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">x</button>
         </div>
</c:if>
<div id="managerTable" class="table table-striped w-auto" >

    <table  class=" table table-striped table-bordered" width="100%">

    <thead>
     <form action="">
    <div class="row">
        <div class="col-md-3">
         <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           TẠO PHIẾU KHÁM
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
            <th>STT</th>
            <th>Ngày khám</th>
            <th>Tiền khám</th>
            <th>Triệu chứng</th>
            <th>Chuẩn đoán</th>
            <th>y tá</th>
            <th>bệnh nhân</th>
            <th>Bác sĩ</th>
            <th>Đã khám</th>
       </tr>
    </thead>
    <tbody>

            <c:forEach items="${medExCarts}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.num}</td>
                    <td>${s.date}</td>
                    <td>${s.fee}</td>
                    <td>${s.sympton}</td>
                    <td>${s.diagnosis}</td>
                    <td>${s.nurse.id}.${s.nurse.firstName} ${s.nurse.lastName}</td>
                    <td>${s.patient.firstName} ${s.patient.lastName} </td>
                    <td>${s.doctor.id}.${s.doctor.firstName} ${s.doctor.lastName}</td>
                    <td>
                        <c:if test="${s.receive == true}">
                            <i class="far fa-check-circle" style="color:green"></i>
                       
                            </c:if>
                        <c:if test="${s.receive == false}">
                            <i class="fas fa-times" style="color:red"></i>
                       </c:if>
                    </td>
                </tr>
            </c:forEach>
      </tbody>

</table>
</div>
         <c:url value="/nurse/medical-examination-card/${doctor.id}/create" var="action"/>
             
              <!-- Modal -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Lập phiếu khám</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form id="medexcart" action="${action}" modelAttribute="medexcart" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
               
                     
                
               </div>  
                 <div class="form-row">
                   <div class="form-group col-md-6">
                       <label for="tcate"><b>Tên Ý tá</b> : ${nurse.firstName} ${nurse.lastName}</label>
                    
                </div>
                  <div class="form-group col-md-6">
                       <label for="tcate"><b>Mã Y tá</b> : ${nurse.id} </label>
                    
                </div>     
                
               </div>  
                   
                <div class=" form-group">
                     <label for="title">Triệu chứng</label>   
                     <form:textarea path="sympton" id="sympton" name="sympton" type="text" cssClass="form-control"/>
                     <form:errors path="sympton" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                <div class=" form-group">
                     <label for="diagnosis">Chuẩn đoán</label>   
                     <form:textarea path="diagnosis" id="diagnosis" name="diagnosis" type="text" cssClass="form-control"/>
                     <form:errors path="diagnosis" cssClass="alert alert-danger" element="div" />
                </div>  
                 <div class="chosen-container chosen-container-single" >
                    <label for="tcate">Tên bệnh nhân</label>
                    <form:select style="width: 50%" required="required" path="patient"  id="find" cssClass=" js-example-basic-single"> >
                        <option selected="true" value="">(mã bệnh nhân). (họ và tên)</option>
                        <c:forEach items="${patients}" var="p">
                            <option value="${p.id}">${p.id}. ${p.firstName} ${p.lastName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="patient" element="div"/>
                </div>
                 
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Tạo Hóa Đơn Dịch Vụ</button>
            </div>
                
            </form:form>
           <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
      
    </div>
  </div>


              <c:if test="${success != null}">
                  <script>
                      alert('Tạo phiếu khám thành công');
                  </script>
              </c:if>
               <c:if test="${err != null}">
                  <script>
                      alert('Tạo phiếu khám lỗi');
                  </script>
              </c:if>

<script src="https://harvesthq.github.io/chosen/docsupport/jquery-3.2.1.min.js"></script>
<script src="https://harvesthq.github.io/chosen/chosen.jquery.js"></script>
<link rel="stylesheet" href="https://harvesthq.github.io/chosen/chosen.css">
<script>$function(){ $('select').chosen(); }</script>