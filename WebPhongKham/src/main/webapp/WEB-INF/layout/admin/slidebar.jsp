<%-- 
    Document   : slidebar
    Created on : Sep 23, 2021, 8:48:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <nav id="slidebar" >

                    <div class="sildebar-header">
                        <h1>tập tành</h1>
                    </div>

                    <ul class="list-unstyle components">
                        
                        <li class ="active">
                            <a href="#uiMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-drafting-compass"></i>Demo cho y tá user</a>
                            <ul class="collapse list-unstyled" id="uiMenu">
                                <li>
                                    <a href="<c:url value="/nurse/patient-manager"/>"><i class="fab fa-slideshare"></i>Danh sách bệnh nhân</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/nurse/patient-serviceinvoice"/>">Lập hóa đơn dịch vụ</a>

                                </li>
                                <li>
                                    <a href="<c:url value="/nurse/medical-examination-card"/>">Phiếu khám</a>

                                </li>
                                <li>
                                    <a href="<c:url value="/nurse/invoice/prescription-list"/>">HÓA ĐƠN</a>

                                </li>
                            </ul>
                        </li> 
                        <li class ="active">
                            <a href="#uiMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-drafting-compass"></i>Quản lý giao diện</a>
                            <ul class="collapse list-unstyled" id="uiMenu">
                                <li>
                                    <a href="<c:url value="/admin/quanly-slide"/>"><i class="fab fa-slideshare"></i>Quản lý slide</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/admin/quanly-user"/>">dog1</a>

                                </li>
                                <li>
                                    <a href="#">dog1</a>

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
                        
                         <li>
                            <a href="<c:url value="/admin/prescriptiondrug-manager"/>"><i class="fas fa-file-prescription"></i>Chi Tiết Toa Thuốc</a>
                        </li>
                        
                        
                             <li class ="active">
                            <a href="#uiMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-drafting-compass"></i>Thống Kê Báo Cáo</a>
                            <ul class="collapse list-unstyled" id="uiMenu">
                                <li>
                                    <a href="<c:url value="/admin/numpatient-month"/>"><i class="fab fa-slideshare"></i>Số Lượng Bệnh Nhân Đến Khám</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/admin/invoicestats-month"/>">Doanh Thu Theo Tháng, Qúy, Năm</a>

                                </li>    
                            </ul>
                        </li>
                        

                        <li>
                            <a href="#">about</a>

                        </li>

                        <li>
                            <a href="#pagesubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Trang</a>
                            <ul class="collapse list-unstyled" id="pagesubmenu">
                                <li>
                                    <a href="#">trang 1</a>
                                </li>
                                <li>
                                    <a href="#">trang 2</a>
                                </li>
                                <li>
                                    <a href="#">trang 3</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
  </nav>