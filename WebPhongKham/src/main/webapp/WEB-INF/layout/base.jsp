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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">       <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="css/style.css"/>" type="text/css" media="all">
       <link rel="stylesheet" href="<c:url value="vendor/datepicker/daterangepicker.css"/>" type="text/css" media="all">
       <link rel="stylesheet" href="<c:url value="vendor/select2/select2.min.css"/>" type="text/css" media="all">
       <link rel="stylesheet" href="<c:url value="vendor/mdi-font/css/material-design-iconic-font.min.css"/>" type="text/css" media="all">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       
        <script src="<c:url value="/vendor/datepicker/moment.min.js"/>"></script>    
        <script src="<c:url value="/vendor/select2/select2.min.js"/>"></script>  
       <script src="<c:url value="/vendor/datepicker/daterangepicker.js"/>"></script>
      
        <script src="<c:url value="/js/global.js"/>"></script>
        <script src="<c:url value="/js/main.js"/>"></script>
    </body>
</html>
