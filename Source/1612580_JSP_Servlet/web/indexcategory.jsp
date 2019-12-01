<%-- 
    Document   : indexcategory
    Created on : May 2, 2019, 8:27:41 PM
    Author     : ronin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h1>Index Category</h1>
                </div>

                <div class="panel-body">
                    <table class="table table-hover hover-bordered" >
                        <tr>
                            <th>ID</th>
                            <th>Tên loại sản phẩm</th>
                        </tr>
                        
                        <c:forEach var="item" items="${listItem}">
                            <tr>
                                <td>${item.maLoaiSanPham}</td>
                                <td>${item.tenLoaiSanPham}</td>
                                <td>
                                    <a href="sualoaisanpham?maloai=${item.maLoaiSanPham}">Edit</a>
                                </td>
                                <td>
                                    <a href="xoaloaisanpham?maloai=${item.maLoaiSanPham}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                                
                        <tr>
                        <a href="themloaisanpham" >Create</a>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
