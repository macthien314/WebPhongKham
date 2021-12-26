<%-- 
    Document   : slidebar
    Created on : Sep 23, 2021, 8:48:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <nav id="slidebar" >

                    
                    <c:if test="${currentUser.userRole.equals('ROLE_ADMIN')}">
                        <div class="sildebar-header">
             <h3 class="text-center" style="">ADMIN</h3>
                        </div> 
                    <ul class="list-unstyle components">
                        
                          <li>
                            <a href="<c:url value="/admin"/>"><i class="fas fa-columns"></i> Bảng điều khiển</a>

                        </li>
                        <li>
                            <a href="#uiMenus" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-drafting-compass"></i>Quản lý giao diện</a>
                            <ul class="collapse list-unstyled" id="uiMenus">
                                <li>
                                    <a href="<c:url value="/admin/quanly-slide"/>"><i class="fab fa-slideshare"></i>Quản lý slide</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/admin/quanly-user"/>">Quản lý tin tức</a>

                                </li>
                            </ul>
                        </li>
                          <li class ="active">
                            <a href="#uiMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-drafting-compass"></i>Thống Kê Báo Cáo</a>
                            <ul class="collapse list-unstyled" id="uiMenu">
                                <li>
                                    <a href="<c:url value="/admin/numpatient-month"/>"><i class="fab fa-slideshare"></i>Số Lượng Bệnh Nhân Đến Khám</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/admin/revenuestats-month"/>">Doanh Thu Theo Tháng</a>

                                </li>    
                            </ul>
                        </li>
                         <li>
                            <a href="#pagesubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-users"></i>Quản lý user</a>
                            <ul class="collapse list-unstyled" id="pagesubmenu">
                                <li>
                                    <a href=""><i class="fas fa-user-shield"></i>Admin User</a>
                                </li>
                                
                                <li>
                                    <a href="<c:url value="/admin/user-manager/doctor-user"/>"><i class="fas fa-user-md"></i>Doctor User</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/admin/user-manager/nurse-user"/>"><i class="fas fa-user-nurse"></i>Nurse User</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/admin/user-manager/normal-user"/>"><i class="far fa-meh-blank"></i> User thường</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="<c:url value="/admin/medical-manager"/>"><i class="fas fa-briefcase-medical"></i> Quản lý Chuyên khoa</a>

                        </li>
                        <li>
                            <a href="<c:url value="/admin/services-manager"/>"><i class="fas fa-briefcase-medical"></i> Quản lý dịch vụ</a>

                        </li>
                         <li>
                            <a href="<c:url value="/admin/doctor-manager"/>"><i class="fas fa-user-md"></i> Quản lý Bác Sĩ</a>

                        </li>
                        <li>
                            <a href="<c:url value="/admin/nurse-manager"/>"><i class="fas fa-user-nurse"></i> Quản lý Y Tá</a>

                        </li>
                        <li>
                            <a href="<c:url value="/admin/drug-manager"/>"><i class="fas fa-capsules"></i> Quản lý Thuốc</a>

                        </li>
                        
                        <li>
                            <a href="<c:url value="/admin/patient-manager"/>"><i class="fas fa-user-injured"></i> Quản lý Bệnh Nhân</a>
                        </li>
                        
                        <li>
                            <a href="<c:url value="/admin/medicalexaminationcard-manager"/>"><i class="fas fa-notes-medical"></i> Quản lý Phiếu Khám</a>
                        </li>
                        
                         <li>
                            <a href="<c:url value="/admin/appointment-manager"/>"><i class="far fa-calendar-check"></i> Quản lý Cuộc Hẹn</a>
                         </li><!-- comment -->
                         
                          <li>
                            <a href="<c:url value="/admin/serviceinvoice-manager"/>"><i class="fas fa-receipt"></i> Quản lý Hóa Đơn Dịch Vụ</a>
                        </li>
                        
                         <li>
                            <a href="<c:url value="/admin/prescription-manager"/>"><i class="fas fa-file-prescription"></i> Quản lý Toa Thuốc</a>
                        </li>
                        
                        <li>
                            <a href="<c:url value="/admin/invoice-manager"/>"><i class="fas fa-file-invoice-dollar"></i> Quản lý Hóa Đơn</a>
                        </li>
                        
                        
                    </ul>
                         </c:if>
                        <!-- START NURSE-->
                                   
     <c:if test="${currentUser.userRole.equals('ROLE_NURSE')}">
         <div class="sildebar-header">
             <h3 class="text-center" style="">Y Tá</h3>
                        </div>          
         <ul class="list-unstyle components">
               <li>
                    <a href="<c:url value="/nurse"/>"><i class="fas fa-columns"></i> Bảng điều khiển</a>

                </li>
                <li>
                    <a href="#menuServiceInvoice" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-file-invoice"></i>Hóa đơn dịch vụ</a>
                            <ul class="collapse list-unstyled" id="menuServiceInvoice">
                                <li>
                                    <a href="<c:url value=""/>"><i class="fab fa-slideshare"></i>Hóa đơn mới hôm nay</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/nurse/patient-serviceinvoice"/>"><i class="fas fa-folder-plus"></i>Tìm và lập theo bệnh nhân</a>

                                </li>
                          
                             </ul>   
                </li>
                <li>
                    <a href="<c:url value="/nurse/medical-examination-card"/>"><i class="fas fa-list-ul"></i>Phiếu khám</a>

                 </li> 
                 <li>
                    <a href="<c:url value="/nurse/patient"/>"><i class="fas fa-user-injured"></i>Quản lý bệnh nhân</a>

                </li>
                 <li>
                    <a href="<c:url value="/nurse/appointment"/>"><i class="far fa-calendar-check"></i>Quản lý lịch hẹn</a>

                </li>
                <li>
                    <a href="#menuInvoice" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-file-invoice"></i>Hóa đơn Toa thuốc</a>
                            <ul class="collapse list-unstyled" id="menuInvoice">
                                <li>
                                </li>
                                <li>
                                   <a href="<c:url value="/nurse/invoice/prescription-list"/>"><i class="fas fa-folder-plus"></i>Kiểm tra toa thuốc và lập HĐ</a>
                                </li>
                          
                    </ul> 
                    

                </li>       
                        
                    </ul>
                     
                       
                                    </c:if>
         <!-- START NURSE-->
         <!-- START Doctor-->                          
     <c:if test="${currentUser.userRole.equals('ROLE_DOCTOR')}">
         <div class="sildebar-header">
             <h3 class="text-center" style="">Bác Sĩ</h3>
                        </div>          
         <ul class="list-unstyle components">
               <li>
                    <a href="<c:url value="/doctor"/>"><i class="fas fa-columns"></i> Bảng điều khiển</a>

                </li>
                <li>
                    <a href="<c:url value="/doctor/today-medcard"/>"><i class="fab fa-slideshare"></i>Phiếu khám hôm nay</a>
                </li>
                <li>
                    <a href="<c:url value="/doctor/prescription-list"/>"><i class="fab fa-slideshare"></i>Tra cứu toa thuốc</a>
                </li>
                
                                
                              
         </ul>
                        
                       
        </c:if>                
  </nav>