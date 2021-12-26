<%-- 
    Document   : MedicalExaminationCard_manager
    Created on : Oct 15, 2021, 2:52:09 PM
    Author     : macth
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="mt-4">Quản lý lịch hẹn</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="<c:url value="/nurse"/>">yta</a></li>
                    <li class="breadcrumb-item active">quanly-lichhen</li>
                </ol>
<c:if test="${err != null}">
<div class="alert alert-danger">${err}</div>
<script>
    alert('!error! thêm bị lỗi');
</script>


</c:if>
<c:if test="${success != null}">
<div class="alert alert-success">thêm lịch hẹn thành công</div>
<script>
    alert(' thêm lịch hẹn thành công');
</script>

</c:if>
<c:if test="${deleteErr != null}">
<div class="alert alert-danger">Xóa thất bại có lỗi gì đó</div>
<script>
    alert('!error! xóa bị lỗi');
</script>


</c:if>
<c:if test="${deleteSucces != null}">
<div class="alert alert-success">Xóa lịch hẹn thành công</div>
<script>
    alert(' xóa lịch hẹn thành công');
</script>

</c:if>
<div class="row">
          
        <div class="col-md-3">
<button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           Thêm lịch hẹn
</button>
        </div>
            
             <div class="col-md-8">
             <div class="input-group" id="adv-search">
                <form  id ="find"role="form">
                    <input value="${appointmentID}" name="id" type="text" class="form-control" placeholder="Nhập mã lịch hẹn" />
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
                                        <option value="all" <c:if test="${medid.equals('all')}">selected</c:if>>Tất cả</option>
                                       
                                        <c:forEach items="${patients}" var="p">
                                            <option value="${p.id}"<c:if test="${patientID.equals(Integer.toString(p.id))}"> selected</c:if>>${p.id} ${p.firstName} ${p.lastName}</option>
                                         </c:forEach>
                                    </select>
                                  </div>
                                        
                                         <div class="form-group">
                                    <label for="appointmentID">Mã lịch hẹn</label>
                                    <select  name ="appointmentID"class="form-control">
                                        <option value="all" <c:if test="${medid.equals('all')}">selected</c:if>>Tất cả</option>
                                        
                                        <c:forEach items="${appointments}" var="p">
                                            <option value="${p.appointmentId}"<c:if test="${appointmentID.equals(Integer.toString(p.appointmentId))}"> selected</c:if>>${p.appointmentId}</option>
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


        <tr>
           <th class="th-sm">Mã</th> 
            <th>Tên Bác Sĩ</th>
            <th>Tên Bệnh Nhân</th>
            <th>Ngày hẹn</th>
            <th>Họ</th>
            <th>Tên</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Chi tiết</th>
            <th>Chỉnh sửa</th>
           <th>Xóa</th>
       </tr>
    </thead>
    <tbody>

            <c:forEach items="${appointments}" var="s">
                <tr>
                    <td>${s.appointmentId}</td>
                    <td>${s.doctor.firstName}</td>
                    <td>${s.patient.firstName}</td>
                    <td>${s.appointmentDate}</td>
                    <td>${s.lastName}</td>
                    <td>${s.firstName}</td>
                    <td>${s.email}</td>
                    <td>${s.phone}</td>
                    <td>${s.description}</td>
                   
                    <td><a data-toggle="tooltip" title="chỉnh sửa" href="<c:url value="/nurse/appointment/edit-appointment/${s.appointmentId}"/>">
                              <i class="fas fa-edit" style="color:#6633ff"></i>
                         </a>
                    </td>
                    <td><a id="modal" href="<c:url value="/nurse/appointment/delete-appointment/${s.appointmentId}"/>" name="deleteButton" type="button" class="btn btn-primary" data-toggle="tooltip modal" data-target="#deleteModal" title="Xóa sản phẩm">
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
        <h5 class="modal-title" id="exampleModalLabel">Xóa cuộc hẹn</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Bạn có muốn chắn xóa cuộc hẹn
      </div>
      <div class="modal-footer">
          <a href="" class="btn btn-primary" id="delRef">Vâng,tôi chắc</a> 
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

<c:url value="/nurse/create-appointment" var="actionCreate"/>
  <!--modal create  -->
   <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thêm mới cuộc hẹn</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
            <form:form id="appointment" action="${actionCreate}" modelAttribute="appointment" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
           
                <div class="form-row">
                   <div class="form-group col-md-6">
                    <label for="tcate">Tên bệnh nhân</label>
                    <form:select path="patient" id="p" cssClass="form-control">

                        <c:forEach items="${patients}" var="p">
                            <option value="${p.id}">${p.firstName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="patient" element="div"/>
                </div>
                
                 <div class="form-group col-md-6">
                 <label for="tcate">Tên bác sĩ</label>
                 <form:select path="doctor" id="n" cssClass="form-control">

                        <c:forEach items="${doctors}" var="n">
                            <option value="${n.id}">${n.firstName}</option>
                        </c:forEach>
                    </form:select>
                    <form:errors cssClass="alert alert-danger" path="doctor" element="div"/>
                 </div>
               </div>    
                 <div class="form-row">
                        <div class=" form-group col-md-6">
                             <label for="lastName">Họ: </label>   
                             <form:input path="lastName" id="title" name="title" type="text" cssClass="form-control"/>
                             <form:errors path="lastName" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">

                            <label for="firstName">Tên:</label>
                            <form:input path="firstName" id="title" name="title" type="text" cssClass="form-control"/>
                            <form:errors path="firstName" cssClass="alert alert-danger" element="div" />

                         </div>
                    </div>
                    <div class="form-row">
                       <div class=" form-group  col-md-6">
                             <label for="title">SĐT</label>   
                             <form:input path="phone" id="phone" name="phone" type="text" cssClass="form-control"/>
                             <form:errors path="phone" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->


                        <div class=" form-group  col-md-6">
                             <label for="title">Email</label>   
                             <form:input path="email" id="email" name="email" type="text" cssClass="form-control"/>
                             <form:errors path="email" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->        
                      </div>
                 <div class=" form-group">
                     <label for="appointmentDate">Ngày hẹn</label>   
                     <form:input path="appointmentDate" id="appointmentDate" name="title" type="date" cssClass="form-control"/>
                     <form:errors path="appointmentDate" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                <div class=" form-group">
                            
                    <label for="description">Chi tiết thông tin</label>
                    <form:input path="description" id="title" name="title" type="text" cssClass="form-control"/>
                    <form:errors path="description" cssClass="alert alert-danger" element="div" />

                 </div>
                                  
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Thêm cuộc hẹn</button>
            </div>
                
            </form:form>
      
           <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
      
    </div>
  </div>
</div>                    
         



