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
    <div class="card mr-auto ml-auto" style="width: 18rem;">

  <div class="card-body">
    <h5 class="card-title text-center">Bệnh nhân</h5>
    <p class="card-text">${patient.id} . ${patient.firstName} ${patient.lastName}</p>
    <p class="card-text">Ngày sinh: ${patient.birthDate} </p>
  </div>
</div>
    <br>

<div class="row">
            

        <div class="col-md-3">
            <button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           TẠO HÓA ĐƠN DỊCH VỤ
                 </button>
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
         <tr>
                <th class="th-sm">Mã</th>
                <th>Giá tiền</th>
                <th>Ngày Tạo Hóa Đơn</th>
                <th>Tên dịch vụ</th>
                <th>Tên bệnh nhân</th>
                <th>Tên y tá</th>
                
           </tr>
        </thead>
        <tbody>
            
                <c:forEach items="${serviceinvoices}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.fee}</td>
                        <td>${s.createdDate}</td>
                        <td>${s.service.name}</td>
                        <td>${s.patient.firstName} ${s.patient.lastName}</td>
                        <td>${s.nurse.id}. ${s.nurse.firstName} ${s.nurse.lastName}</td>
                       
                          
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
                    
                    <form:select path="service" id="find" cssClass="js-example-basic-single">
                        <option disabled selected="true">Chưa chọn</option>
                        <c:forEach items="${services}" var="s">
                            <option  value="${s.id}">${s.name}: giá tiền ${s.fee}VNĐ</option>
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
              <c:if test="${!wrong.equals('')}">
                  <script type="text/javascript">
    
        $('#createModal').modal('show');
    
                  </script>             <p>f</p>
              </c:if>
