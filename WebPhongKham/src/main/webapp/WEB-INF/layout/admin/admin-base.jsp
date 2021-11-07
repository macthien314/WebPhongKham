<%-- 
    Document   : base
    Created on : Sep 23, 2021, 8:25:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="Spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>

    <meta charset="utf-8">
   

    
    <!-- comment -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js" integrity="sha512-Tn2m0TIpgVyTzzvmxLNuqbSJH3JP8jm+Cy3hvHrW7ndTDcJ1w5mBiksqDBb8GpE2ksktFvDB/ykZ0mDpsZj20w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
    <link href="<c:url value="/css/admin-style.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="https://harvesthq.github.io/chosen/chosen.css">
    </head>
    
            <!--Slide bar-->
        
          <tiles:insertAttribute name="header"/>
        <div class ="wrapper">
            
         <tiles:insertAttribute name="slidebar"/>

            <div id="content">
             <div class="container-fluid col-m-8">
         <tiles:insertAttribute name="content"/>
              </div>
           </div>
        </div>  
   
       
       
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
  
   <script src="<c:url value="/js/admin.js"/>"></script>
   
  <script src="https://harvesthq.github.io/chosen/chosen.jquery.js"></script>

    
</html>