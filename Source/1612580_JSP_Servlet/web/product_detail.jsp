<%-- 
    Document   : product_detal
    Created on : Apr 29, 2019, 9:02:16 PM
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
        <title>Product Details | E-Shopper</title>
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
        <jsp:include page="header.jsp"></jsp:include>
        
        <section>
            <div class="container">
                <div class="row">
                    <jsp:include page="/category"></jsp:include>

                    <div class="col-sm-9 padding-right">
                        <div class="product-details"><!--product-details-->
                            <div class="col-sm-5">
                                <div class="view-product">
                                    <img src="${sanpham.hinhSanPham}" width="60" height="200" />
                                </div>
                            </div>
                            <div class="col-sm-7">
                                <div class="product-information"><!--/product-information-->
                                    <h2>${sanpham.tenSanPham}</h2>
                                    <p>Mô tả: ${sanpham.moTa}</p>
                                    <img src="images/product-details/rating.png" alt="" />
                                    <span>
                                        <span>${sanpham.giaTien} VND</span>
                                        <button type="button" class="btn btn-fefault cart">
                                            <i class="fa fa-shopping-cart"></i>
                                            Add to cart
                                        </button>
                                    </span>
                                    <p><b>Số lượng còn:</b> ${sanpham.soLuong}</p>
                                    <p><b>Xuất xứ:</b> ${sanpham.xuatXu} </p>
                                    <p><b>Nhà sản xuất:</b>${sanpham.nhaSanXuat}</p>
                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->
                        
                        <div class="recommended_items"><!--recommended_items-->
                            <h2 class="title text-center">Cùng loại</h2>
                            <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    
                                    <c:forEach var="sanpham1" items ="${sanPhamList}">
                                    <div class="item active">	
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <a href="detail?masanpham=${sanpham1.getMaSanPham()}">
                                                            <img src="${sanpham1.hinhSanPham}" width="30" height="150" />
                                                        </a                                                        <h2>${sanpham1.giaTien} VND</h2>
                                                        <p>${sanpham1.tenSanPham}</p>
                                                        <button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach>    
                                                        
                                </div>   
                            </div>
                        </div><!--/recommended_items-->
                        
                    </div>
                </div>
            </div>
        </section>
                    
        <jsp:include page="footer.jsp"></jsp:include>
        
        <script src="js/jquery.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
