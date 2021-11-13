<%-- 
    Document   : slide_information
    Created on : Sep 26, 2021, 9:41:22 PM
    Author     : Admin
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2 class="mt-4">Chi tiết Slide</h2>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">admin</a></li>
                            <li class="breadcrumb-item active">quan-ly-slide</li>
                        </ol>


       <div class="Back">
            <i class="fa fa-arrow-left" onclick="Back()"></i>
        </div>
       <div class="card">
            <header class="card-header">

                    <h2 class="card-title mt-2">Thông tin slide</h2>
            </header>
            <article class="card-body">
                <div class="preview text-center">
                    <img class="" src="${slide.image}"id="preview" alt="Preview Image" width="50%" height="20%"/>
                    
                </div>
                <p>ID      : ${slide.id}</p>  
                <p>Title   : ${slide.title}</p>  
                <p>Mô tả   : ${slide.description}</p>
                <p>Link ảnh:<a href="${slide.image}"> ${slide.image}</a></p>
            </article>    
        </div>