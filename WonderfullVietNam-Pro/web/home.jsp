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
                                <li class="nav-item active"><a class="nav-link" href="home.jsp">Home</a></li>
                                <li class="nav-item"><a class="nav-link" href="packages.jsp">Packages</a></li>
                                <li class="nav-item submenu dropdown">
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

        <!--================ Start Home Banner Area =================-->
        <section class="home_banner_area">
            <div class="banner_inner">
                <div class="container">
                    <div class="row fullscreen d-flex align-items-center justify-content-center">
                        <div class="banner_content">
                            <!--<p>Our knowledge, your experiences</p>-->
                            <h2>Wonderful Việt Nam</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================ End Home Banner Area =================-->

        <!--================ Khu vực miền bắc  =================-->
        <section class="feature-area section_gap_top">
            <div class="container">
                <!-- Miền Bắc -->
                <div class="row align-items-end justify-content-left">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <p>Cảnh đẹp Việt Nam</p>
                            <h1>Miền Bắc</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- single-feature -->
                    <%
                        String place_name = "";
                        String place_description = "";
                        String image_name = "";
                        ArrayList<PlaceInfo> plist = pm.getPlaceByLocation(2);
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < ilist.size(); j++) {
                                if (plist.get(i).getPlace_id() == ilist.get(j).getPlace_id()) {
                                    if (ilist.get(j).getPlace_id() == ilist.get(j + 1).getPlace_id()) {
                                        image_name = ilist.get(j).getImage_name();
                                        j++;
                                    }
                                    place_name = plist.get(i).getPlace_name();
                                    place_description = pm.printWord(plist.get(i).getPlace_description(), 100);


                    %>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-feature">
                            <div class="feature-details">
                                <h5><%=place_name%></h5>
                                <div style="text-align: justify;">
                                    <p>
                                        <%=place_description%>
                                    </p>
                                </div>
                                <a href="blog.jsp" class="primary-btn mb-40">Đọc Tiếp</a>
                            </div>
                            <div class="feature-thumb">
                                <img class="img-fluid" style="height: 128px; width: 256px;" src="img/<%=image_name%>" alt="">
                            </div>
                        </div>
                    </div>
                    <%                        }
                            }
                        }
                    %>
                </div>
            </div>
            <!--================ Kết thúc khu vực miền bắc =================-->

            <!--================ Khu vực miền Trung  =================-->
            <div class="container">
                <!-- Miền Bắc -->
                <div class="row align-items-end justify-content-left">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <h1>Miền Trung</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- single-feature -->
                    <%
                        ArrayList<PlaceInfo> plist1 = pm.getPlaceByLocation(1);
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < ilist.size(); j++) {
                                if (plist1.get(i).getPlace_id() == ilist.get(j).getPlace_id()) {
                                    if (ilist.get(j).getPlace_id() == ilist.get(j + 1).getPlace_id()) {
                                        image_name = ilist.get(j).getImage_name();
                                        j++;
                                    }
                                    place_name = plist1.get(i).getPlace_name();
                                    place_description = pm.printWord(plist1.get(i).getPlace_description(), 100);


                    %>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-feature">
                            <div class="feature-details">
                                <h5><%=place_name%></h5>
                                <div style="text-align: justify;">
                                    <p>
                                        <%=place_description%>
                                    </p>
                                </div>
                                <a href="blog.jsp" class="primary-btn mb-40">Đọc Tiếp</a>
                            </div>
                            <div class="feature-thumb">
                                <img class="img-fluid" style="height: 128px; width: 256px;" src="img/<%=image_name%>" alt="">
                            </div>
                        </div>
                    </div>
                    <%                        }
                            }
                        }
                    %>
                </div>
            </div>
            <!--================ Kết thúc khu vực miền trung =================-->

            <!--================ Khu vực miền nam  =================-->
            <div class="container">
                <!-- Miền Bắc -->
                <div class="row align-items-end justify-content-left">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <h1>Miền Nam</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- single-feature -->
                    <%
                        ArrayList<PlaceInfo> plist2 = pm.getPlaceByLocation(0);
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < ilist.size(); j++) {
                                if (plist2.get(i).getPlace_id() == ilist.get(j).getPlace_id()) {
                                    if (ilist.get(j).getPlace_id() == ilist.get(j + 1).getPlace_id()) {
                                        image_name = ilist.get(j).getImage_name();
                                        j++;
                                    }
                                    place_name = plist2.get(i).getPlace_name();
                                    place_description = pm.printWord(plist2.get(i).getPlace_description(), 100);


                    %>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-feature">
                            <div class="feature-details">
                                <h5><%=place_name%></h5>
                                <div style="text-align: justify;">
                                    <p>
                                        <%=place_description%>
                                    </p>
                                </div>
                                <a href="blog.jsp" class="primary-btn mb-40">Đọc Tiếp</a>
                            </div>
                            <div class="feature-thumb">
                                <img class="img-fluid" style="height: 128px; width: 256px;" src="img/<%=image_name%>" alt="">
                            </div>
                        </div>
                    </div>
                    <%                        }
                            }
                        }
                    %>
                    <div row>
                        <form class="col-md-12 contact_form" action="blog.jsp" method="post" id="contactForm" novalidate="novalidate">
                            <div class=" text-right">
                                <button type="submit" value="submit" class="primary-btn text-uppercase">Xem thêm</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!--================ Kết thúc khu vực miền nam =================-->
        </section>








        <!--================ Start CTA Area =================-->
        <div class="cta-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5">
                        <h1>Xem tất cả hình ảnh</h1>
                        <p>
                            Trong đây có rất nhiều ảnh đẹp, vô xem đi mọi người ơi.
                        </p>
                        <a href="images.jsp" class="primary-btn">Xem ngay</a>
                    </div>
                    <div class="offset-lg-1 col-lg-6">
                        <img class="cta-img img-fluid" src="img/cta-img.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <!--================ End CTA Area =================-->

        <!--================ Start Trip Package Area =================-->
        <section class="package-area section_gap_top">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="ol-lg-12">
                        <div class="main_title">
                            <p>Những địa điểm tốt dành cho bạn</p>
                            <h1>TOP 3 địa điểm đẹp nổi tiếng</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="single-package">
                            <div class="thumb">
                                <img class="img-fluid" style="height: 200px;" src="img/PhanThiet01.jpg" alt="">								
                            </div>
                            <p class="date"><span>1 ST</span> <br> </p>
                            <div class="meta-top d-flex">
                                <p><span class="fa fa-location-arrow"></span> Miền Nam</p>
                                <p class="ml-20"><span class="fa fa-calendar"></span> 2 April</p>
                            </div>
                            <h4>Phan Thiết</h4>
                            <p style="text-align: justify;">
                                Phan Thiết là một thành phố trẻ, thành phố công nghiệp mới và là tỉnh lỵ, trung tâm chính trị, kinh tế, văn hóa và khoa học kỹ thuật của tỉnh Bình Thuận, Việt Nam.
                            </p>
                            <a href="#" class="primary-btn">Đọc Tiếp</a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-package">
                            <div class="thumb">
                                <img class="img-fluid" style="height: 200px;" src="img/LangSon_SaPa.jpg" alt="">								
                            </div>
                            <p class="date"><span>2 ND</span> <br> </p>
                            <div class="meta-top d-flex">
                                <p><span class="fa fa-location-arrow"></span> Miền Bắc</p>
                                <p class="ml-20"><span class="fa fa-calendar"></span> 10 Oct</p>
                            </div>
                            <h4>Lạng Sơn</h4>
                            <p style="text-align: justify;">
                                Cảnh thiên nhiên tuyệt mĩ của Sa Pa. - Tháng 9 đến tháng 11: là thời điểm đẹp nhất trong năm ở Sapa, đây là lúc những cánh đồng lúa chín vàng rực. Vào thời ...
                            </p>
                            <a href="#" class="primary-btn">Đọc Tiếp</a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-package">
                            <div class="thumb">
                                <img class="img-fluid" style="height: 200px;" src="img/HaiPhong_DoSon.jpg" alt="">								
                            </div>
                            <p class="date"><span>3 RD</span> <br> </p>
                            <div class="meta-top d-flex">
                                <p><span class="fa fa-location-arrow"></span> Miền Trung</p>
                                <p class="ml-20"><span class="fa fa-calendar"></span> 5 Dec</p>
                            </div>
                            <h4>Đồ Sơn</h4>
                            <p style="text-align: justify;">
                                Đồ Sơn là một quận thuộc thành phố Hải Phòng, cách trung tâm thành phố khoảng 22 km về hướng đông nam. Đây là địa điểm đẹp thu hút hàng trăm nghàn lượt...
                            </p>
                            <a href="#" class="primary-btn">Đọc Tiếp</a>
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
                            <p>Những địa điểm tốt dành cho bạn</p>
                            <h1>Những điểm nhấn vẻ đẹp Việt Nam</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="popular-places-slider owl-carousel">
                <a href="img/places/p1.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img style="height: 570px;" src="img/places/halong.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Vẻ đẹp thuần tinh tế các miền biển</p>
                        <h4>
                            Vịnh Hạ Long - vẻ đẹp nguyên sơ đến thời điểm hiện tại. Một trong những nơi bạn nên đến 1 lần trong đời.
                        </h4>
                    </div>
                </a>
                <a href="img/places/p2.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img style="height: 570px;" src="img/places/danang.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Công trình mang vẻ đẹp hoang sơ</p>
                        <h4>
                            Đà Nẵng - nơi được mệnh danh là “thành phố đáng đến nhất Việt Nam”.
                        </h4>
                    </div>
                </a>
                <a href="img/places/p3.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img style="height: 570px;" src="img/places/hoian.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Một bức tranh mộc mạc, giản dị và nên thơ</p>
                        <h4>
                            Hội An - mang trong mình những vẻ đẹp lôi cuốn khác nhau.
                        </h4>
                    </div>
                </a>
                <a href="img/places/p4.jpg" class="single-popular-places d-block img-gal">
                    <div class="popular-places-img">
                        <img style="height: 570px;" src="img/places/cantho.jpg" alt="">
                    </div>
                    <div class="popular-places-text">
                        <p>Vẻ đẹp người Miền Tây</p>
                        <h4>
                            Cần Thơ - trung tâm của vùng đồng bằng sông Cửu Long, du lịch Cần Thơ mang đến cho bạn nhiều trải nghiệm đặc trưng và thú vị của miền Tây. 
                        </h4>
                    </div>
                </a>
            </div>
        </section>
        <!--================ End Popular Places Area =================-->

        <!--================Team Area =================-->
        <section class="team_area">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-12">
                        <div class="main_title">
                            <p>Thành viên nhóm phát triển</p>
                            <h1>Nhóm FatMan</h1>
                            <span class="title-widget-bg"></span>
                        </div>
                    </div>
                </div>
                <div class="row team_inner">
                    <div class="col-lg-3 col-md-6">
                        <div class="team_item">
                            <div class="team_img">
                                <img class="img-fluid w-100" src="img/team/hau.jpg" alt="">
                                <div class="hover">
                                    <h4>Quốc Hậu</h4>
                                    <p>Nhóm trưởng</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="team_item">
                            <div class="team_img">
                                <img class="img-fluid w-100" src="img/team/an.jpg" alt="">
                                <div class="hover">
                                    <h4>Quốc An</h4>
                                    <p>Thành viên</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="team_item">
                            <div class="team_img">
                                <img class="img-fluid w-100" src="img/team/tu.jpg" alt="">
                                <div class="hover">
                                    <h4>Anh Tú</h4>
                                    <p>Thành viên</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="team_item">
                            <div class="team_img">
                                <img class="img-fluid w-100" src="img/team/dinh.jpg" alt="">
                                <div class="hover">
                                    <h4>Hồng Đỉnh</h4>
                                    <p>Thành viên</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Team Area =================-->

        <!--================ Start CTA Area =================-->
        <div class="cta-area2 section_gap">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-5">
                        <img class="cta-img2 img-fluid" src="img/cta-img2.png" alt="">
                    </div>
                    <div class="offset-lg-2 col-lg-5">
                        <h1>Đăng ký <br>
                            cho bản tin của chúng tôi</h1>
                        <p>
                            Nhóm sinh viên phát triển website tại đại học FPT Cần Thơ - bản phát hành thử nghiệm.
                        </p>
                        <div class="" id="mc_embed_signup2">	
                            <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                  method="get" class="form-inline">
                                <div class="d-flex flex-row">
                                    <input class="form-control" name="EMAIL" placeholder="Địa chỉ email của bạn" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email Address '"
                                           required="" type="email">
                                    <button class="click-btn btn text-uppercase">đăng ký</button>
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
                            <p>Các bài viết mới nhất hiện tại</p>
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
                                <img class="img-fluid" style="height: 200px;"  src="img/DaNang_HoiAn.jpg" alt="">
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
