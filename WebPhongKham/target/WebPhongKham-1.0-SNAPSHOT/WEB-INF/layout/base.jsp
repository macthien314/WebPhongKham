<%-- 
    Document   : base
    Created on : Aug 25, 2021, 4:59:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="Spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title"/>
        </title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <!-- HEADER-->
            <tiles:insertAttribute name="header"/>
            <!-- CONTENT-->
            <tiles:insertAttribute name="content"/>
            <!--Footer-->
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>
