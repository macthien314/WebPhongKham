<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h4 class="mt-4">Tìm và lập hóa đơn theo bệnh nhân</h4>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                    <li class="breadcrumb-item active">patient-serviceinvoice</li>
                </ol>
<c:if test="${err != null}">
<div class="alert alert-danger">${err}</div>
</c:if>
<div id="managerTable" class="table table-striped w-auto" >

    <table  class=" table table-striped table-bordered" width="100%">

    <thead>
     <form action="">
    <div class="row">
        
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
            <th>Họ</th>
            <th >Tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>SĐT</th>
            <th>Email</th>
            
           

            <th><i class="fas fa-cog"></i></th>
       </tr>
    </thead>
    <tbody>

            <c:forEach items="${patients}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.lastName}</td>
                    <td>${s.firstName}</td>
                    <td>${s.birthDate}</td>
                    <td>${s.gender}</td>
                    <td>${s.phone}</td>
                    <td>${s.email}</td>
           
                     <td >

                         <button type="button" class="btn btn-outline-primary">                         
                             <a data-toggle="tooltip" title="xem thông tin" title="thông tin"href="<c:url value="/nurse/patient-serviceinvoice/${s.id}"/>">Check hóa đơn</a>
                         </button>
                     </td>
                </tr>
            </c:forEach>
      </tbody>

</table>


</div>
  <!-- Modal -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-hidden="true">
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

