<%-- 
    Document   : add_medicalexaminationcard_manager
    Created on : Oct 24, 2021, 12:49:27 PM
    Author     : macth
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/doctor/today-medcard/receive/${medcard.id}" var="action"/>
<h2 class="mt-4">Tiếp nhận phiếu khám</h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quanly-phieukham</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick=""></i>
        </div>
       <div class="card">
        <header class="card-header">
               
                <h2 class="card-title mt-2">Lập Toa Thuốc</h2>
        </header>
        <article class="card-body">
            
            

            <form:form id="prescription" action="${action}" modelAttribute="prescription" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
                
                       
                <div class="form-row">
                        <div class=" form-group col-md-3">
                             <label for="createdDate">Mã bác sĩ: ${doctor.id} </label>   
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">
                            <label for="firstName">Tên: ${doctor.firstName} ${doctor.lastName}</label>
                         </div>
                </div>
                <div class="form-row">
                        <div class=" form-group col-md-3">
                             <label for="createdDate">Mã bệnh nhân: ${medcard.patient.id} </label>   
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">
                            <label for="firstName">Tên: ${medcard.patient.firstName} ${medcard.patient.lastName}</label>
                         </div>
                </div>
                <div class="form-group">
                    <label for="diagnosis">Chuẩn đoán của bác: </label>
                    <form:textarea rows="3" cols="30" path ="diagnosis" cssClass="form-control"/>
                    <form:errors path="diagnosis" cssClass="alert alert-danger" element="div" />

                </div>
                <div class="form-group">
                    <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                          Thêm thuốc
                    </button>
                    <br>
                    <c:if test="${drugCarts == null}">
                        <h4 class="text-danger">Chưa có thuốc trong toa</h4>
                    </c:if>
                        
                    <c:if test="${drugCarts != null}">
                        
                        <table class="table table-striped table-bordered table-sm">
                            <tr>
                                <th>Mã thuốc</th>
                                <th>tên thuốc</th>
                                <th>Số lương(Viên)</th>
                                <th>Cách sử dụng</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${drugCarts}" var="d">
                                <tr>
                                <td>${d.drugID}</td>
                                <td>${d.drugName}</td>
                                <td>
                                   <input id="quantity${d.drugID}"onblur="updateDrugCart(${d.drugID})" type="number" class="form-control" value="${d.quantity}"/>
                                </td>
                                <td>
                                    <textarea id="userGuide${d.drugID}" rows="3" cols="30" onblur="updateDrugCart(${d.drugID})" class="form-control">${d.userGuide}</textarea>
                                </td>
                                <td>
                                    <input type="button" 
                                           value="xóa"
                                           onclick="deleteDrugCart(${d.drugID})"
                                           class="btn btn-danger"/>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Lập toa thuốc</button>
            </div>
                
            </form:form>
        </article> 
       
        </div>






   
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
        
       
        <input class="form-control" id="myInput" type="text" placeholder="Search..">
        <table id="dtBasicExample"  class="table table-striped table-bordered table-sm" width="100%">
        
        <thead>
        
           <tr>
                <th class="th-sm">Mã</th>
                <th>Tên</th>
                <th><i class="fas fa-cog"></i></th>
           </tr>

            
        </thead>
        <tbody id="drugTable">
          
                <c:forEach items="${drugs}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        
                        <td>
                            <a href="#" class="btn btn-primary" onclick="addToDrugCart(${s.id}, '${s.name}')">Thêm thuốc</a>   
                         </td>
                    </tr>
                </c:forEach>
          </tbody>
          
    </table>
  
    
    
                                     
                                     
 
      </div>
      <div class="modal-footer">
          <a href="" class="btn btn-primary" id="delRef">Vâng,tôi chắc</a> 
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

