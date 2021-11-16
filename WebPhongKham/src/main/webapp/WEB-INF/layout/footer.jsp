<%-- 
    Document   : footer
    Created on : Aug 25, 2021, 5:00:00 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer id="footer">

    <div class="footer-top">
        <div  class="container">
        <div class="row">

          <div class="col-lg-3 col-md-4 footer-contact">
              <h3>Liên Hệ</h3>
              <h5>Phòng Khám Đa Khoa Tâm An</h5>
              <p id="text">
                  <b><i id="location" class="fas fa-map-marker-alt"></i>371 Nguyễn Kiệm, Phường 3, Gò Vấp,</b>
                  <b>Thành phố Hồ Chí Minh<br></b>
               <b><i id="phone" class="fas fa-phone"></i>(028) 3873 8994<br></b>
              <b><i id="fax" class="fas fa-fax"></i>(028) 3873 8994<br></b>
              <b> <i id="email" class="far fa-envelope"></i>phongkhamtaman@gmail.com<br></b>
     
            </p>
          </div>

          <div class="col-lg-3 col-md-4 footer-links">
            <h3>Giới Thiệu</h3>
            <ul>
              <li><i class="fas fa-chevron-right"></i> <a href="#">Home</a></li>
              <li><i class="fas fa-chevron-right"></i><a href="<c:url value="/aboutus"/>">Về chúng tôi</a></li>
              <li><i class="fas fa-chevron-right"></i> <a href="<c:url value="/valuevision"/>">Tầm nhìn-Sứ mệnh-Giá trị cốt lõi</a></li>
              <li><i class="fas fa-chevron-right"></i> <a href="<c:url value="/organizationchart"/>">Sơ đồ tổ chức</a></li>
             
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h3>Dịch vụ</h3>
            <ul>
           
          <c:forEach var="s" items="${services}">
                  <li>   <i class="fas fa-chevron-right"></i>   <a href="<c:url value="/dich-vu/${s.id}"/>">${s.name}</a></li>
          </c:forEach>  
            
            </ul>
          </div>

              <div id="date" class="col-lg-3 col-md-4 footer-newsletter">
            <h3>Thời Gian Làm Việc</h3>
            <h5>Thứ 2 đến Thứ 6: </h5>
            <p>
                <b>Sáng:</b> 7:00 đến 11:00<br>
                <b>Chiều:</b> 13:00 đến 21:00
            </p>
            <h5>Thứ 7, Chủ nhật </h5>  
                <b>Sáng:</b> 7:00 đến 11:00<br>
              <b>Chiều:</b>  13:00 đến 22:00
               </p>
          </div>

        </div>
      </div>
    </div>

    <div class="container d-md-flex py-4">

      <div class="mr-md-auto text-center text-md-left">
        <div class="copyright">
           <strong><span></span></strong>
        </div>
        <div class="credits">
         
        </div>
      </div>
      <div class="social-links text-center text-md-right pt-3 pt-md-0">
       
        <a href="#" class="twitter"><i class="fab fa-twitter"></i></a>
        <a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="instagram"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="skype"><i class="fab fa-instagram"></i></a>
        <a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a>
    </div>
    </div>
  </footer>