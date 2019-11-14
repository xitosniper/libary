<%-- 
    Document   : home
    Created on : Nov 8, 2019, 12:47:49 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page import="Info.ImageInfo"%>
<%@page import="Model.ImageModel"%>
<%@page import="Model.PlaceModel"%>
<%@page import="Info.PlaceInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Connection con = ConnectionLib.getConnection();
    PlaceModel pm = new PlaceModel(con);
    ImageModel im = new ImageModel(con);

    ArrayList<PlaceInfo> plist = pm.getPlace();
    ArrayList<ImageInfo> ilist = im.getListImage();
    session.removeAttribute("warning");
%>
<!doctype html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="" type="image/png">
        <title>FatMan | Home </title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <!-- main css -->
        <link rel="stylesheet" href="css/style.css">
        <style>
            .size-img{
                height: 64px;
                width: 64px;
            }
            .team_img {
                height: 230px;
                width: 210px;
            }
            .single-feature{
                border-bottom-width: 2px;
            }
        </style>
    </head>

    <body>

        <!--================ Start Header Menu Area =================-->
        <header class="header_area">
            <div class="main_menu">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <a class="navbar-brand logo_h" href="home.jsp"><img src="img/logo.png" style="width: 64px; height: 64px;" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                            <ul class="nav navbar-nav menu_nav ml-auto">
                                <li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
                                <li class="nav-item"><a class="nav-link" href="packages.jsp">Packages</a></li>
                                <li class="nav-item submenu dropdown active">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Pages</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="about-us.jsp">About</a></li>
<!--                                        <li class="nav-item"><a class="nav-link" href="book-trip.jsp">Book trip</a></li>-->
                                        <li class="nav-item"><a class="nav-link" href="images.jsp">Images</a></li>
<!--                                        <li class="nav-item"><a class="nav-link" href="elements.jsp">Elements</a></li>-->
                                    </ul>
                                </li>
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Blog</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="blog.jsp">Blog</a></li>
                                        
                                    </ul>
                                </li>
                                <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
<!--                                <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>-->
                            </ul>
                            <ul class="nav navbar-nav ml-auto">
                                <li class="nav-item">
                                    <a href="login.jsp" class="primary-btn">Login</a>
                                </li>
                                <li class="nav-item">
                                    <button type="button" class="search nav-link">
                                        <i class="lnr lnr-magnifier" id="search"></i>
                                    </button>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="search_input" id="search_input_box">
                    <div class="container">
                        <form class="d-flex justify-content-between">
                            <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                            <button type="submit" class="btn"></button>
                            <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
                        </form>
                    </div>
                </div>
            </div>
        </header>
        <!--================ End Header Menu Area =================-->

        <!--================Home Banner Area =================-->
        <section class="banner_area ">
            <div class="banner_inner overlay d-flex align-items-center">
                <div class="container">
                    <div class="banner_content">
                        <div class="page_link">
                            <a href="home.jsp">Home</a>
                            <a href="about-us.jsp">Images</a>
                        </div>
                        <h2>Images</h2>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->
        <br>
        <br>
        <!--================ Start Popular Places Area =================-->
        <section class="popular-places-area section_gap_bottom">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <p>We’re Offering these Popular Places</p>
                            <h1>Những điểm nhấn vẻ đẹp Việt Nam</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="popular-places-slider owl-carousel">
                <a href="img/places/p1.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img src="img/places/p1.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </a>
                <a href="img/places/p2.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img src="img/places/p2.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </a>
                <a href="img/places/p3.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img src="img/places/p3.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </a>
                <a href="img/places/p4.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img src="img/places/p4.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </a>
            </div>
        </section>
        <!--================ End Popular Places Area =================-->

        <!--================ Start Testimonials Area =================-->
        <section class="testimonials-area section_gap">
            <div class="container">
                <div class="testi-slider owl-carousel" data-slider-id="1">
                    <div class="item">
                        <div class="testi-item">
                            <img src="img/quote.png" alt="">
                            <h4>Quốc Hậu</h4>
                            <ul class="list">
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                            </ul>
                            <div class="wow fadeIn" data-wow-duration="1s">
                                <p>
                                    Admin - Leader's FatMan Group <br>
                                    Student from FPT University <br>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="testi-item">
                            <img src="img/quote.png" alt="">
                            <h4>Quốc An</h4>
                            <ul class="list">
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                            </ul>
                            <div class="wow fadeIn" data-wow-duration="1s">
                                <p>
                                    Editor - Member's FatMan Group <br>
                                    Student from FPT University <br>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="testi-item">
                            <img src="img/quote.png" alt="">
                            <h4>Anh Tú</h4>
                            <ul class="list">
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                            </ul>
                            <div class="wow fadeIn" data-wow-duration="1s">
                                <p>
                                    Writer - Member's FatMan Group <br>
                                    Student from FPT University <br>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="testi-item">
                            <img src="img/quote.png" alt="">
                            <h4>Hồng Đỉnh</h4>
                            <ul class="list">
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                            </ul>
                            <div class="wow fadeIn" data-wow-duration="1s">
                                <p>
                                    Guest - Member's FatMan Group <br>
                                    Student from FPT University <br>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="owl-thumbs d-flex justify-content-center" data-slider-id="1">
                    <div class="owl-thumb-item">
                        <div>
                            <img class="img-fluid rounded-circle size-img" src="img/team/hau.jpg" alt="">
                        </div>
                        <div class="overlay overlay-grad "></div>
                    </div>
                    <div class="owl-thumb-item">
                        <div>
                            <img class="img-fluid rounded-circle size-img" src="img/team/an.jpg" alt="">
                        </div>
                        <div class="overlay overlay-grad"></div>
                    </div>
                    <div class="owl-thumb-item">
                        <div>
                            <img class="img-fluid rounded-circle size-img" src="img/team/tu.jpg" alt="">
                        </div>
                        <div class="overlay overlay-grad"></div>
                    </div>
                    <div class="owl-thumb-item">
                        <div>
                            <img class="img-fluid rounded-circle size-img" src="img/team/dinh.jpg" alt="">
                        </div>
                        <div class="overlay overlay-grad"></div>
                    </div>
                </div>
            </div>
        </section>
        <!--================ End Testimonials Area =================-->

        <!--================ Start Blog Area =================-->
        <section class="home-blog-area">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <p>We’re Offering these Latest Posts</p>
                            <h1>Những bài đăng mới nhất</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- single-blog -->
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-blog">
                            <div class="blog-thumb">
                                <img class="img-fluid" style="height: 200px;" src="img/DaLat02.jpg" alt="">
                            </div>
                            <div class="blog-details">
                                <div class="blog-meta d-flex">
                                    <p>
                                        <a href="#">
                                            <span class="fa fa-calendar"></span>
                                            13th Dec
                                        </a>
                                    </p>
                                    <p>
                                        <a href="#">
                                            <span class="fa fa-heart-o"></span>
                                            15
                                        </a>
                                    </p>
                                    <p>
                                        <a href=""></a>
                                    </p>
                                </div>
                                <h5>
                                    <a href="#">Cổng trời Đà Lạt</a>
                                </h5>
                                <p>Cổng trời Bali Đà Lạt là một trong những cụm từ. Mà trong thời gian gần đây, đặc biệt là trong dịp hè này. Được quý du khách thập phương ...</p>
                            </div>
                        </div>
                    </div>

                    <!-- single-blog -->
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-blog">
                            <div class="blog-thumb">
                                <img class="img-fluid" style="height: 200px;" src="img/DaNang_HoiAn.jpg" alt="">
                            </div>
                            <div class="blog-details">
                                <div class="blog-meta d-flex">
                                    <p>
                                        <a href="#">
                                            <span class="fa fa-calendar"></span>
                                            13th Dec
                                        </a>
                                    </p>
                                    <p>
                                        <a href="#">
                                            <span class="fa fa-heart-o"></span>
                                            15
                                        </a>
                                    </p>
                                    <p>
                                        <a href=""></a>
                                    </p>
                                </div>
                                <h5>
                                    <a href="#">Hội An - Đà Nẳng</a>
                                </h5>
                                <p>Hội An – nơi mà cuộc sống cứ bình lặng như thế. Hội An – nơi mà dường như dòng chảy vô tình của thời gian chẳng thể nào vùi lấp đi cái ...</p>
                            </div>
                        </div>
                    </div>

                    <!-- single-blog -->
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-blog">
                            <div class="blog-thumb">
                                <img class="img-fluid" style="height: 200px;" src="img/LangSon_SaPa02.jpg" alt="">
                            </div>
                            <div class="blog-details">
                                <div class="blog-meta d-flex">
                                    <p>
                                        <a href="#">
                                            <span class="fa fa-calendar"></span>
                                            13th Dec
                                        </a>
                                    </p>
                                    <p>
                                        <a href="#">
                                            <span class="fa fa-heart-o"></span>
                                            15
                                        </a>
                                    </p>
                                    <p>
                                        <a href=""></a>
                                    </p>
                                </div>
                                <h5>
                                    <a href="#">SaPa - Lạng Sơn</a>
                                </h5>
                                <p>Tên gọi của thị xã xuất phát từ tên thị trấn Sa Pa cũ. Thị trấn này ra đời vào cỡ 1905, khi người Pháp phát hiện...</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================ End Blog Area =================-->

 <!--================  Start Footer Area =================-->
        <footer class="footer-area">
            <div class="footer_top section_gap_top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h5 class="footer_title">Thông tin pháp lý</h5>
                                <p class="about-text">Trang website phát triển trên nguyên tắc cộng đồng mở. Phục vụ cho sự phát triển cộng đồng và nổ lực vì Việt Nam.</p>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h5 class="footer_title">Các liên kết</h5>
                                <div class="row">
                                    <div class="col-5">
                                        <ul class="list">
                                            <li><a href="#">Home</a></li>
                                            <li><a href="#">Features</a></li>
                                            <li><a href="#">Services</a></li>
                                            <li><a href="#">Portfolio</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-5">
                                        <ul class="list">
                                            <li><a href="#">Team</a></li>
                                            <li><a href="#">Pricing</a></li>
                                            <li><a href="#">Blog</a></li>
                                            <li><a href="#">contact</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h5>Bản tin</h5>
                                <p>Đối với các chuyên gia kinh doanh bị bắt giữa giá OEM cao và sản lượng đồ họa và in ấn tầm thường, </p>
                                <div class="footer-newsletter" id="mc_embed_signup">	
                                    <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                          method="get" class="form-inline">
                                        <div class="d-flex flex-row">
                                            <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '"
                                                   required="" type="email">
                                            <button class="click-btn btn btn-default"><span class="lnr lnr-location" aria-hidden="true"></span></button>
                                            <div style="position: absolute; left: -5000px;">
                                                <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                                            </div>
                                        </div>
                                        <div class="info"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3  col-md-6 col-sm-6">
                            <div class="single-footer-widget mail-chimp">
                                <h5 class="mb-20">Instragram Feed</h5>
                                <ul class="instafeed d-flex flex-wrap">
                                    <li><img src="img/i1.jpg" alt=""></li>
                                    <li><img src="img/i2.jpg" alt=""></li>
                                    <li><img src="img/i3.jpg" alt=""></li>
                                    <li><img src="img/i4.jpg" alt=""></li>
                                    <li><img src="img/i5.jpg" alt=""></li>
                                    <li><img src="img/i6.jpg" alt=""></li>
                                    <li><img src="img/i7.jpg" alt=""></li>
                                    <li><img src="img/i8.jpg" alt=""></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-12">
                            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://www.facebook.com/hau.mai.796569" target="_blank">FatMan</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>
                        </div>
                        <div class="col-lg-6 col-md-12 text-right">
                            <div class="social-icons">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                <a href="#"><i class="fa fa-behance"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!--================ End Footer Area =================-->

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/stellar.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/owl-carousel-thumb.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/mail-script.js"></script>
        <!--gmaps Js-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="js/gmaps.min.js"></script>
        <script src="js/theme.js"></script>
    </body>

</html>
