<%-- 
    Document   : category
    Created on : Apr 29, 2019, 8:53:07 PM
    Author     : ronin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head>
    <body>
        <div class="col-sm-3">
            <div class="left-sidebar">
                <h2>Loại sản phẩm</h2>
                <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                    
                    <c:forEach var="loaisanpham" items="${listItem}">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title"><a href="index.jsp?maloai=${loaisanpham.maLoaiSanPham}"> 
                                    ${loaisanpham.tenLoaiSanPham}
                                </a>
                            </h4>
                        </div>
                    </div>
                    </c:forEach>
                    
                </div><!--/category-products-->

                <div class="price-range"><!--price-range-->
                    <h2>Giá Tiền</h2>
                    <div class="well text-center">
                        <form method="POST">
                            <input type="submit" name="tangdan" value="Tăng dần">
                            <input type="submit" name="giamdan" value="Giảm dần">
                        </form>
                    </div>
                </div><!--/price-range-->

            </div>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
