<%-- 
    Document   : numpatient-month
    Created on : Oct 30, 2021, 2:31:43 PM
    Author     : macth
--%>

<<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js"/>"></script>
<h3 class ="text-center text-danger">THỐNG KÊ SỐ LƯỢNG BỆNH NHÂN ĐẾN KHÁM</h3>
<form>
    <div class="form-group">
        <label for="fromDate">Từ thời điểm</label>
        <input type="date" value="${fromDate}" name="fromDate" class="form-control"><!-- comment -->
    </div>
    <div class="form-group">
        <label for="fromDate">Đến thời điểm</label>
    <input type="date" valu="${toDate}" name="toDate"  class="form-control"><!-- comment -->
    </div>
    <div class="form-group">
        
        <input type="submit" value="Thống kê" class="btn btn-success"><!-- comment -->
    </div>
</form>

<div>
  <canvas id="numPatientChart"></canvas>
</div>
<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Năm</th>
        <th>Số lượt khám</th>
        <th>Số bệnh nhân đến khám</th>
    </tr>
    <c:forEach items="${numPatientMonths}" var="p">
    <tr>
        <td>${p[0]}</td>
        <td>${p[1]}</td>
        <td>${p[2]}</td>
        <td>${p[3]}</td>
  
    </tr>
    </c:forEach>
</table>


<script>
    let numLabels =[], info = []
    
    <c:forEach items ="${numPatientMonths}" var ="p">
        numLabels.push('Tháng: ' + '${p[0]}/${p[1]}')
        info.push(${p[3]})
    </c:forEach>
        
    window.onload = function(){
        numPatientChart("numPatientChart", numLabels, info)
    }
</script>