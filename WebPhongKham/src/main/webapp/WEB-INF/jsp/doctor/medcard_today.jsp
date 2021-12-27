<%-- 
    Document   : med_cart_list
    Created on : Nov 7, 2021, 8:00:51 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="mt-4">Phiếu Khám của Bác sĩ(Hôm nay)</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="<c:url value="/doctor"/>">doctor</a></li>
                    <li class="breadcrumb-item active">quanly-phieukham</li>
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
            <th>Y tá</th>
            <th>Bệnh nhân</th>
            <th>Bác sĩ</th>
            <th><i class="fas fa-cog"></i></th>
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
                    
                   
                    <td class="setting">
                        <c:if test="${s.receive == false}">
                      <a data-toggle="tooltip" title="xem thông tin" title="thông tin"href="<c:url value="/doctor/today-medcard/receive/${s.id}"/>">
                       <button type="button" class="btn btn-outline-primary">                         
                           Tiếp nhận
                       </button>
                    </a>
                       </c:if>
                        <c:if test="${s.receive == true}">
                      <a data-toggle="tooltip" title="xem thông tin" title="thông tin"href="<c:url value="/doctor/today-medcard/receive/${s.id}"/>">
                       <button type="button" class="btn btn-danger">                         
                           Đã tiếp nhận
                       </button>
                    </a>
                       </c:if>
                     </td>
                </tr>
            </c:forEach>
      </tbody>

</table>
</div>