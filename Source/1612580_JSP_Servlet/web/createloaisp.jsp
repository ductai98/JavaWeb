<%-- 
    Document   : createloaisp
    Created on : May 2, 2019, 9:01:19 PM
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
                    <h1>Tạo mới loại sản phẩm</h1>
                </div>

                <div class="panel-body">
                    <form method="POST">
                        <table class="table table-hover hover-bordered">
                            <tr>
                                <td>ID</td>
                                <td><input type="text" name="id"/></td>
                            </tr>
                            <tr>
                                <td>Name</td>
                                <td><input type="text" name="name"/></td>
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
