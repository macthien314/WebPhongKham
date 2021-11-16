<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="mt-4">Quản lý Bệnh Nhân</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                    <li class="breadcrumb-item active">quanly-benhnhan</li>
                </ol>
<c:if test="${err != null}">
<div class="alert alert-danger">${err}</div>
<script>
    alert('!error! thêm bị lỗi');
</script>


</c:if>
<c:if test="${success != null}">
<div class="alert alert-success">thêm bệnh nhân thành công</div>
<script>
    alert(' thêm bệnh nhân thành công');
</script>

</c:if>
<c:if test="${deleteErr != null}">
<div class="alert alert-danger">Xóa thất bại có lỗi gì đó</div>
<script>
    alert('!error! xóabị lỗi');
</script>


</c:if>
<c:if test="${success != null}">
<div class="alert alert-success">Xóa bệnh nhân thành công</div>
<script>
    alert(' xóa bệnh nhân nhân thành công');
</script>

</c:if>
<div class="row">
          
        <div class="col-md-3">
<button  type="button" data-toggle="modal" data-target="#createModal"  class="btn btn-outline-primary">                         
                           Thêm bệnh nhân
                 </button>
        </div>
            
             <div class="col-md-8">
            
                 <div class="input-group" id="adv-search">
                <form  id ="find"role="form">
                    <input value="${lastname}" name="lastname" type="text" class="form-control" placeholder="tên điệm và tên" />
                </form>
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <div class="dropdown dropdown-lg">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                <form  class="form-horizontal" role="form">
                                  <div class="form-group">
                                    <label for="firstName">Nhập họ</label>
                                    <input value="${firstname}" name ="firstname" class="form-control" type="text" />
                                  </div>
                                  <div class="form-group">
                                    <label for="lastname">Nhập tên đệm và tên</label>
                                    <input value="${lastname}" name ="lastname" class="form-control" type="text" />
                                  </div>
                                  
                                    
                                  <div class="form-group">
                                    <label for="account">Account</label>
                                    <select  name ="account"class="form-control">
                                        <option value="all" <c:if test="${account.equals('all')}">selected</c:if>>Tất cả</option>
                                        <option value="1"
                                        <c:if test="${account.equals('1')}">selected</c:if>
                                        >Đã cấp</option>
                                        <option value="0"
                                        <c:if test="${account.equals('0')}">selected</c:if>>Chưa cấp</option>
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
            <th>Họ</th>
            <th >Tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>SĐT</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th >Ảnh</th>
            <th>Tên tài khoản</th>
            <th>Chi tiết</th>
            <th>Xóa</th>
       </tr>
    </thead>
    <tbody>

            <c:forEach items="${patients}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.firstName}</td>
                    <td>${s.lastName}</td>
                    
                    <td>${s.birthDate}</td>
                    <td>${s.gender}</td>
                    <td>${s.phone}</td>
                    <td>${s.email}</td>
                    <td>${s.address}</td>
                    
                    <td class="w-auto">
                          <img src="${s.image}" class="img-fluid img-thumbnail" alt="Sheep">
                    </td>
                    <td>${s.user.username}</td>
                    <td><a data-toggle="tooltip" title="chỉnh sửa" href="<c:url value="/nurse/patient/edit-patient/${s.id}"/>">
                              <i class="fas fa-edit" style="color:#6633ff"></i>
                         </a></td>
                    <td><a id="modal" href="<c:url value="/nurse/patient/delete-patient/${s.id}"/>" name="deleteButton" type="button" class="btn btn-primary" data-toggle="tooltip modal" data-target="#deleteModal" title="Xóa sản phẩm">
                                   <i class="fas fa-trash-alt" style="color:#ed3c0d"></i>
                              </a></td>
                </tr>
            </c:forEach>
      </tbody>

</table>

    <c:if test="${!pagequan.equals('all')}"> 
<div class="pagination">
   <a href="<c:url value="/nurse/patient">
                    <c:param name="lastname"
                    value="${lastname}"></c:param>
                    <c:param name="account"
                    value="${account}"></c:param>
                    <c:param name="firstname"
                    value="${firstname}"></c:param>
                    <c:param name="pagequan"
                    value="${pagequan}"></c:param>
                    <c:param name="page"
                    value="1"></c:param>
                </c:url>"
       >«</a>
   
  
   <c:forEach begin = "1" end="${Math.ceil(count/Integer.parseInt(pagequan))}" var="i">
   <c:if test="${page != i}">
       <a href="<c:url value="/nurse/patient">
                    
                    <c:param name="lastname"
                    value="${lastname}"></c:param>
                    <c:param name="account"
                    value="${account}"></c:param>
                    <c:param name="firstname"
                    value="${firstname}"></c:param>
                    <c:param name="pagequan"
                    value="${pagequan}"></c:param>
                    <c:param name="page"
                    value="${i}"></c:param>
                </c:url>"
       >${i}</a></li>
   </c:if>
   <c:if test="${page == i}">
   
  <a class ="active"href="<c:url value="/nurse/patient">
                    <c:param name="lastname"
                    value="${lastname}"></c:param>
                    <c:param name="account"
                    value="${account}"></c:param>
                    <c:param name="firstname"
                    value="${firstname}"></c:param>
                    <c:param name="pagequan"
                    value="${pagequan}"></c:param>
                    <c:param name="page"
                    value="${i}"></c:param>
                </c:url>"
       >${i}</a></li>
   </c:if>
   </c:forEach>
   
   <a href="<c:url value="/nurse/patient">
                    <c:param name="lastname"
                    value="${lastname}"></c:param>
                    <c:param name="account"
                    value="${account}"></c:param>
                    <c:param name="firstname"
                    value="${firstname}"></c:param>
                    <c:param name="pagequan"
                    value="${pagequan}"></c:param>
                    <c:param name="page"
                    value="${fn:replace((Math.ceil(count/Integer.parseInt(pagequan))), '.0', '')}"></c:param>
                </c:url>"
       >»</a>
 </div>
   </c:if >    

</div>
  <!-- Modal -->
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
        Bạn có muốn chắn xóa bệnh nhân
      </div>
      <div class="modal-footer">
          <a href="" class="btn btn-primary" id="delRef">Vâng,tôi chắc</a> 
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
<c:url value="/nurse/create-patient" var="actionCreate"/>
  <!--modal create  -->
   <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thêm mới bệnh nhân</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
            <form:form id="patient" action="${actionCreate}" modelAttribute="patient" method="post" enctype="multipart/form-data">
               <form:errors path="*" cssClass="alert alert-danger" element="div" />
                <form:hidden path="id" />
             <form:hidden path="image"/>          
                <div class="form-group preview text-center">
                    <img class="" src=""id="preview" alt="Preview Image" width="50%" height="20%"/>
                    <div class="browse-button">
                        <i class="fa fa-pencil-alt"></i>
                        <form:input path="file" type="file" requiredname="UploadedFile" id="UploadedFile"/>
                    </div>
                    <span class="Error"></span>
                </div>
                    <div class="form-row">
                        <div class=" form-group col-md-6">
                             <label for="title">Họ: </label>   
                             <form:input path="firstName" id="title" name="title" type="text" cssClass="form-control"/>
                             <form:errors path="firstName" cssClass="alert alert-danger" element="div" />
                        </div> <!-- form-group end.// -->
                        <div class=" form-group col-md-6">

                            <label for="title">Tên:</label>
                            <form:input path="lastName" id="title" name="title" type="text" cssClass="form-control"/>
                            <form:errors path="lastName" cssClass="alert alert-danger" element="div" />

                         </div>
                    </div>
               
                   <div class=" form-group">
                     <label for="title">Ngày sinh</label>   
                     <form:input path="birthDate" id="birthDate" name="birthDate" type="date" value="2000-12-31"
       min="01-01-1935" max="2021-12-31" cssClass="form-control"/>
                     <form:errors path="birthDate" cssClass="alert alert-danger" element="div" />
                </div> 
               
                <div class="form-group">
                    Nam:<form:radiobutton path="gender" value="Nam"/>
                    Nữ:<form:radiobutton path="gender" value="Nữ"/>
                </div><!-- form-group end.// -->
                
                <div class=" form-group">
                     <label for="title">SĐT</label>   
                     <form:input path="phone" id="phone" name="phone" type="number" cssClass="form-control"/>
                     <form:errors path="phone" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                
                
                <div class=" form-group">
                     <label for="title">Email</label>   
                     <form:input path="email" id="email" name="email" type="text" cssClass="form-control"/>
                     <form:errors path="email" cssClass="alert alert-danger" element="div" />
                </div> <!-- form-group end.// -->
                <div class=" form-group">
                     <label for="address">Địa chỉ</label>   
                     <form:input path="address" id="address" name="address" type="text" cssClass="form-control"/>
                     <form:errors path="address" cssClass="alert alert-danger" element="div" />
                </div>
                 
             
                
              
                <!-- form-group end.// -->
       
                <!-- form-group end.// -->
                       
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Chỉnh sữa thông tin</button>
            </div>
                
            </form:form>
      
       
       
           <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
      
    </div>
  </div>
</div>           
