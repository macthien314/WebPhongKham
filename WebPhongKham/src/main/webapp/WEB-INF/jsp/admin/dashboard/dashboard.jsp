<%-- 
    Document   : dashboard
    Created on : Nov 11, 2021, 2:16:47 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js"/>"></script>

<h4 class="mt-4">Dash Board</h4>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                </ol>
<!-- ======= Counts Section ======= -->
    <section id="counts" class="counts">
      <div class="container">

        <div class="row">

          <div class="col-lg-3 col-md-6">
            <div class="count-box">
              <i class="icofont-doctor-alt"></i>
              <span data-toggle="counter-up">6
                  <c:forEach items="${countabouts}" var="p">
    <tr>
        <td>${p[2]}</td>
    </tr>
    </c:forEach></span>
             
              <p>Bác sĩ</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-5 mt-md-0">
            <div class="count-box">
              <i class="icofont-nurse-alt"></i>
              <span data-toggle="counter-up">6</span>
              <p>Y tá</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
            <div class="count-box">
              <i class="icofont-medical-sign"></i>
              <span data-toggle="counter-up">8</span>
              <p>Chuyên khoa</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
              <a href="<c:url value="/admin"/>">
            <div class="count-box">
              <i class="icofont-award"></i>
              <span data-toggle="counter-up">20</span>
              <p>Dịch vụ</p>
            </div>
              </a>
          </div>
            
        </div>

      </div>
    </section>
    <div class="row">
        <div class="col-xl-6">
             <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-area me-1"></i>
                    Bệnh nhân đến khám theo tháng(2021) <a class="btn btn-success" href="<c:url value="/admin/numpatient-month"/>">Chi tiết</a>
                </div>
                 
                <div class="card-body">
                    <canvas id="numPatientChart" width="100%" height="40"></canvas>
                </div>
            </div>
        </div>
        
        <div class="col-xl-6">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-bar me-1"></i>
                    Danh thu theo tháng(2021)<a class="btn btn-success" href="<c:url value="/admin/revenuestats-month"/>">Chi tiết</a>
                </div>
                                    
                <div class="card-body">
                    <canvas id="revenueStats" width="100%" height="40"></canvas>
                </div>
            </div>
        </div>
    </div>
    <script>
    let numLabels =[], info = [], infoMedCar=[]
    
    <c:forEach items ="${numPatientMonths}" var ="p">
        numLabels.push('Tháng: ' + '${p[0]}/${p[1]}')
        infoMedCar.push(${p[2]})
        info.push(${p[3]})
    </c:forEach>
        
    
    window.addEventListener("load",function(){
        numPatientChart("numPatientChart", numLabels, info,infoMedCar)
    })
    
    let numLabels2 =[], info2 = []
    
    <c:forEach items ="${revenueStats}" var ="i">
        numLabels2.push('Tháng: ' + '${i.month}/${i.year}')
        info2.push(${i.price})
    </c:forEach>
        
    window.addEventListener("load",function(){
        revenueMonthChart("revenueStats", numLabels2, info2)
    })
</script>


