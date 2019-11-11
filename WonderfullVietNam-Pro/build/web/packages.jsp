<%-- 
    Document   : packages
    Created on : Nov 8, 2019, 12:53:12 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="img/favicon.png" type="image/png">
        <title>FatMan | Home - Packages</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">

        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <!-- main css -->
        <link rel="stylesheet" href="css/style.css">
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
                                <li class="nav-item active"><a class="nav-link" href="packages.jsp">Packages</a></li>
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Pages</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="about-us.jsp">About</a></li>
                                        <li class="nav-item"><a class="nav-link" href="book-trip.jsp">Book trip</a></li>
                                        <li class="nav-item"><a class="nav-link" href="images.jsp">Images</a></li>
                                        <li class="nav-item"><a class="nav-link" href="elements.jsp">Elements</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Blog</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="blog.jsp">Blog</a></li>
                                        <li class="nav-item"><a class="nav-link" href="single-blog.jsp">Blog Details</a></li>
                                        
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
                            <a href="packages.jsp">Packages</a>
                        </div>
                        <h2>Trip Packages</h2>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->

        <!--================ Start Trip Package Area =================-->
        <section class="package-area section_gap_top">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="ol-lg-12">
                        <div class="main_title">
                            <p>We’re Offering these Trip Packages</p>
                            <h1>Famous Trips Packages</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="single-package">
                            <div class="thumb">
                                <img class="img-fluid" src="img/package/p1.jpg" alt="">								
                            </div>
                            <p class="date"><span>18</span> <br> December</p>
                            <div class="meta-top d-flex">
                                <p><span class="fa fa-location-arrow"></span> Stockholmes</p>
                                <p class="ml-20"><span class="fa fa-calendar"></span> 5 days 6 nights</p>
                            </div>
                            <h4>Desert Riding Turning So <br>
                                much Flowery</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consecter adipisicing elit, sed do eiusmod tempor incididunt.
                            </p>
                            <a href="#" class="primary-btn">Read More</a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-package">
                            <div class="thumb">
                                <img class="img-fluid" src="img/package/p2.jpg" alt="">								
                            </div>
                            <p class="date"><span>18</span> <br> December</p>
                            <div class="meta-top d-flex">
                                <p><span class="fa fa-location-arrow"></span> Stockholmes</p>
                                <p class="ml-20"><span class="fa fa-calendar"></span> 5 days 6 nights</p>
                            </div>
                            <h4>Desert Riding Turning So <br>
                                much Flowery</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consecter adipisicing elit, sed do eiusmod tempor incididunt.
                            </p>
                            <a href="#" class="primary-btn">Read More</a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-package">
                            <div class="thumb">
                                <img class="img-fluid" src="img/package/p3.jpg" alt="">								
                            </div>
                            <p class="date"><span>18</span> <br> December</p>
                            <div class="meta-top d-flex">
                                <p><span class="fa fa-location-arrow"></span> Stockholmes</p>
                                <p class="ml-20"><span class="fa fa-calendar"></span> 5 days 6 nights</p>
                            </div>
                            <h4>Desert Riding Turning So <br>
                                much Flowery</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consecter adipisicing elit, sed do eiusmod tempor incididunt.
                            </p>
                            <a href="#" class="primary-btn">Read More</a>
                        </div>
                    </div>
                </div>
            </div>	
        </section>
        <!--================ End Trip Package Area =================-->

        <!--================ Start Popular Places Area =================-->
        <section class="popular-places-area section_gap_bottom">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <p>We’re Offering these Trip Packages</p>
                            <h1>Popular Places Around the World</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="popular-places-slider owl-carousel">
                <div class="single-popular-places">
                    <div class="popular-places-img">
                        <img src="img/places/p1.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <a href="single-blog.jsp">
                        </a>
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </div>
                <div class="single-popular-places">
                    <div class="popular-places-img">
                        <img src="img/places/p2.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <a href="single-blog.jsp">
                        </a>
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </div>
                <div class="single-popular-places">
                    <div class="popular-places-img">
                        <img src="img/places/p3.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <a href="single-blog.jsp">
                        </a>
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </div>
                <div class="single-popular-places">
                    <div class="popular-places-img">
                        <img src="img/places/p4.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <a href="single-blog.jsp">
                        </a>
                        <p>Proper Guided Tour</p>
                        <h4>
                            Santorini Island Dream Holiday
                            and Fun package
                        </h4>
                    </div>
                </div>
            </div>
        </section>
        <!--================ End Popular Places Area =================-->

        <!--================ Start Feature Area =================-->
        <section class="feature-area section_gap_bottom">
            <div class="container">
                <div class="row align-items-end justify-content-left">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <p>We’re Offering these Popular Services</p>
                            <h1>Getting Adventure with Services</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- single-feature -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-feature">
                            <div class="feature-details">
                                <h5>Desert Riding Turning <br>
                                    So much Flowery</h5>
                                <p>
                                    Lorem ipsum dolor sit amet, consecter adipisicing elit, sed do eiusmod tempor incididunt.
                                </p>
                                <a href="#" class="primary-btn mb-40">Read More</a>
                            </div>
                            <div class="feature-thumb">
                                <img class="img-fluid" src="img/service/s1.png" alt="">
                            </div>
                        </div>
                    </div>
                    <!-- single-feature -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-feature">
                            <div class="feature-details">
                                <h5>Relaxation in the <br>
                                    Local Beach Campfire</h5>
                                <p>
                                    Lorem ipsum dolor sit amet, consecter adipisicing elit, sed do eiusmod tempor incididunt.
                                </p>
                                <a href="#" class="primary-btn mb-40">Read More</a>
                            </div>
                            <div class="feature-thumb">
                                <img class="img-fluid" src="img/service/s2.png" alt="">
                            </div>
                        </div>
                    </div>
                    <!-- single-feature -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-feature">
                            <div class="feature-details">
                                <h5>Forest Exploration <br>
                                    with Energy Package</h5>
                                <p>
                                    Lorem ipsum dolor sit amet, consecter adipisicing elit, sed do eiusmod tempor incididunt.
                                </p>
                                <a href="#" class="primary-btn mb-40">Read More</a>
                            </div>
                            <div class="feature-thumb">
                                <img class="img-fluid" src="img/service/s3.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================ End Feature Area =================-->

        <!--================ Start CTA Area =================-->
        <div class="cta-area2 section_gap">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-5">
                        <img class="cta-img2 img-fluid" src="img/cta-img2.png" alt="">
                    </div>
                    <div class="offset-lg-2 col-lg-5">
                        <h1>Subscribe <br>
                            for our Newsletter</h1>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod 
                            tempor incididunt ut labore et dolore magna aliqua.
                        </p>
                        <div class="" id="mc_embed_signup2">	
                            <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                  method="get" class="form-inline">
                                <div class="d-flex flex-row">
                                    <input class="form-control" name="EMAIL" placeholder="Enter Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email Address '"
                                           required="" type="email">
                                    <button class="click-btn btn text-uppercase">subscribe</button>
                                    <div style="position: absolute; left: -5000px;">
                                        <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                                    </div>
                                </div>
                                <div class="info"></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--================ End CTA Area =================-->

        <!--================  start footer Area =================-->
        <footer class="footer-area">
            <div class="footer_top section_gap_top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h5 class="footer_title">About Agency</h5>
                                <p class="about-text">The world has become so fast paced that people don’t want to stand by reading a page of information, they would much rather look at a presentation and understand the message. It has come to a point where images and videos are used more to </p>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h5 class="footer_title">Navigation Links</h5>
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
                                <h5>Newsletter</h5>
                                <p>For business professionals caught between high OEM price and mediocre print and graphic output, </p>
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
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
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
        <!--================ End footer Area =================-->

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
