<%-- 
    Document   : createproduct
    Created on : May 2, 2019, 10:30:47 PM
    Author     : ronin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h1>Tạo mới sản phẩm</h1>
                </div>

                <div class="panel-body">
                    <form method="POST">
                        <table class="table table-hover hover-bordered">
                            <tr>
                                <td>ID</td>
                                <td><input type="text" name="id"/></td>
                            </tr>
                            <tr>
                                <td>Tên sản phẩm</td>
                                <td><input type="text" name="tensp"/></td>
                            </tr>
                            <tr>
                                <td>Mã loại</td>
                                <td><input type="text" name="maloai"/></td>
                            </tr>
                            <tr>
                                <td>Đường dẫn hình</td>
                                <td><input type="text" name="hinhanh"/></td>
                            </tr>
                            <tr>
                                <td>Giá tiền</td>
                                <td><input type="text" name="giatien"/></td>
                            </tr>
                            <tr>
                                <td>Số lượng</td>
                                <td><input type="text" name="soluong"/></td>
                            </tr>
                            <tr>
                                <td>Nhà sản xuất</td>
                                <td><input type="text" name="nhasx"/></td>
                            </tr>
                            <tr>
                                <td>Xuất sứ</td>
                                <td><input type="text" name="xuatsu"/></td>
                            </tr>
                            <tr>
                                <td>Mô tả</td>
                                <td><input type="text" name="mota"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">                   
                                    <input type="submit" value="Submit" />
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>     
    </body>
</html>
