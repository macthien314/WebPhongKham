<%-- 
    Document   : invoicestat-month
    Created on : Oct 31, 2021, 1:02:53 PM
    Author     : macth
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js"/>"></script>
<h3 class ="text-center text-danger">THỐNG KÊ DOANH THU THEO THÁNG</h3>
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
  <canvas id="revenueStats"></canvas>
</div>
<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Năm</th>
        <th>Doanh thu trong tháng</th>
    </tr>
    <c:forEach items="${revenueStats}" var="i">
    <tr>
        <td>${i.month}</td>
        <td>${i.year}</td>
        <td>${i.price}</td>

  
    </tr>
    </c:forEach>
</table>


<script>
    let numLabels =[], info = []
    
    <c:forEach items ="${revenueStats}" var ="i">
        numLabels.push('Tháng: ' + '${i.month}/${i.year}')
        info.push(${i.price})
    </c:forEach>
        
    window.onload = function(){
        revenueMonthChart("revenueStats", numLabels, info)
    }
</script>
