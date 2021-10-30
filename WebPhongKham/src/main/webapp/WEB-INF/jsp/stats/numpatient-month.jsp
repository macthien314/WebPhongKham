<%-- 
    Document   : numpatient-month
    Created on : Oct 30, 2021, 2:31:43 PM
    Author     : macth
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js"/>"></script>
<h1 class ="text-center text-danger">THỐNG KÊ SỐ LƯỢNG BỆNH NHÂN ĐẾN KHÁM</h1>
<div>
  <canvas id="numPatientChart"></canvas>
</div>
<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Năm</th>
        <th>Số lần bệnh nhân đến khám</th>
        <th>Số lượng bệnh nhân đến khám</th>
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
        numLabels.push(${p[0]})
        info.push(${p[3]})
    </c:forEach>
        
    window.onload = function(){
        numPatientChart("numPatientChart", numLabels, info)
    }
</script>