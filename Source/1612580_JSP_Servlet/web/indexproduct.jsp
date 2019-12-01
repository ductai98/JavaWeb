<%-- 
    Document   : indexproduct
    Created on : May 2, 2019, 9:49:57 PM
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
                    <h1>Quản lý sản phẩm</h1>
                </div>

                <div class="panel-body">
                    <table class="table table-hover hover-bordered" >
                        <tr>
                            <th>ID</th>
                            <th>Tên sản phẩm</th>
                            <th>Đường dẫn hình</th>
                            <th>Giá tiền</th>
                            <th>Số lượng</th>
                            <th>Nhà sản xuất</th>
                            <th>Xuất xứ</th>
                            <th>Mô tả</th>
                            <th>Loại Sản Phẩm</th>
                        </tr>
                        
                        <c:forEach var="item" items="${listItem}">
                            <tr>
                                <td>${item.maSanPham}</td>
                                <td>${item.tenSanPham}</td>
                                <td>${item.hinhSanPham}</td>
                                <td>${item.giaTien}</td>
                                <td>${item.soLuong}</td>
                                <td>${item.nhaSanXuat}</td>
                                <td>${item.xuatXu}</td>
                                <td>${item.moTa}</td>
                                <td>${item.maLoaiSanPham.tenLoaiSanPham}</td>
                                <td>
                                    <a href="suasanpham?masanpham=${item.maSanPham}">Edit</a>
                                </td>
                                <td>
                                    <a href="xoasanpham?masanpham=${item.maSanPham}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                                
                        <tr>
                            <th>
                                <a href="themsanpham" >Create</a>
                            </th>
                            <th>
                                <form method="POST">
                                    <input type="submit" name="sapxeptheoten" value="Sắp xếp theo tên">
                                    <input type="submit" name="sapxeptheoid" value="Sắp xếp theo ID">
                                </form>
                            </th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
