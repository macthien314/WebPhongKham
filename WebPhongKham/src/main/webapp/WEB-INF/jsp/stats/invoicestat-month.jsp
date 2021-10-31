<%-- 
    Document   : invoicestat-month
    Created on : Oct 31, 2021, 1:02:53 PM
    Author     : macth
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js"/>"></script>
<h1 class ="text-center text-danger">THỐNG KÊ DOANH THU THEO THÁNG</h1>
<div>
  <canvas id="invoicesChart"></canvas>
</div>
<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Năm</th>
        <th>Doanh thu trong tháng</th>
    </tr>
    <c:forEach items="${invoicestats}" var="p">
    <tr>
        <td>${p[0]}</td>
        <td>${p[1]}</td>
        <td>${p[2]}</td>

  
    </tr>
    </c:forEach>
</table>


<script>
    let numLabels =[], info = []
    
    <c:forEach items ="${invoicestats}" var ="p">
        numLabels.push(${p[0]})
        info.push(${p[2]})
    </c:forEach>
        
    window.onload = function(){
        numPatientChart("invoicesChart", numLabels, info)
    }
</script>
