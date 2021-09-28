<%-- 
    Document   : slidebar
    Created on : Sep 23, 2021, 8:48:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <nav id="slidebar" >

                    <div class="sildebar-header">
                        <h1>tập tành</h1>
                    </div>

                    <ul class="list-unstyle components">
                        
                         
                        <li class ="active">
                            <a href="#homesubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fas fa-drafting-compass"></i>Quản lý giao diện</a>
                            <ul class="collapse list-unstyled" id="homesubmenu">
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
                            <a href="<c:url value="/admin/quanly-user"/>"><i class="fas fa-users-cog"></i> Quản lý user</a>

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