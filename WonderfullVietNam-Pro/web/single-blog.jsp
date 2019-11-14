<%-- 
    Document   : single-blog
    Created on : Nov 8, 2019, 12:53:39 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page import="Info.CommentInfo"%>
<%@page import="Model.CommentModel"%>
<%@page import="Info.UserInfo"%>
<%@page import="Model.UserModel"%>
<%@page import="Info.ImageInfo"%>
<%@page import="Info.PlaceInfo"%>
<%@page import="Model.ImageModel"%>
<%@page import="Model.PlaceModel"%>
<%@page import="Info.PostInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.PostModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    int id = -1;
    if (request.getParameter("id") != null) {
        id = Integer.parseInt(request.getParameter("id"));
    }
    Connection con = ConnectionLib.getConnection();
    PostModel pm = new PostModel(con);
    PlaceModel pl = new PlaceModel(con);
    ImageModel im = new ImageModel(con);
    PostModel pom = new PostModel(con);
    UserModel um = new UserModel(con);
    CommentModel cm = new CommentModel(con);
    ArrayList<CommentInfo> cis = cm.getComment();
    ArrayList<UserInfo> uis = um.getUser();
    ArrayList<PlaceInfo> plist = pl.getPlace();
    ArrayList<ImageInfo> ilist = im.getListImage();
    ArrayList<PostInfo> polist = pom.getPost();


%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        
        <link rel="icon" href="img/favicon.png" type="image/png">
        <title>FatMan | Home - Blog Details</title>
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
                                <li class="nav-item submenu dropdown active">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Blog</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="blog.jsp">Blog</a></li>
                                        <!--                                        <li class="nav-item"><a class="nav-link" href="single-blog.jsp">Blog Details</a></li>-->

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

        <!--================Home Banner Area =================-->
        <section class="banner_area ">
            <div class="banner_inner overlay d-flex align-items-center">
                <div class="container">
                    <div class="banner_content">
                        <div class="page_link">
                            <a href="home.jsp">Home</a>
                            <a href="blog.jsp">Blog</a>
                            <a href="single-blog.jsp">Blog Details</a>
                        </div>
                        <h2>Blog Details</h2>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->

        <!--================Blog Area =================-->
        <section class="blog_area single-post-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 posts-list">

                        <%                            String place_name = "";
                            String image = "";
                            String post_text = "";
                            //loop of post list
                            String user_name = "";
                            for (int i = 0; i < polist.size(); i++) {
                                for (int j = 0; j < plist.size(); j++) {
                                    for (int k = 0; k < ilist.size(); k++) {
                                        if (polist.get(i).getPlace_id() == plist.get(j).getPlace_id() && polist.get(i).getPlace_id() == ilist.get(k).getPlace_id() && polist.get(i).getPost_id() == id) {
                                            post_text = plist.get(j).getPlace_description() + polist.get(i).getPost_text();
                                            if (ilist.get(k).getPlace_id() == ilist.get(k + 1).getPlace_id()) {
                                                image = ilist.get(k).getImage_name();
                                                k++;
                                            }
                                            for (UserInfo ui : uis) {
                                                if (polist.get(i).getUser_id() == ui.getUser_id()) {
                                                    user_name = ui.getUser_name();
                                                }
                                            }
                                            place_name = plist.get(j).getPlace_name();

                        %>
                        <div class="single-post row">
                            <div class="col-lg-12 text-center">
                                <div class="feature-img">
                                    <img class="img" src="img/<%=image%>" alt="">
                                </div>
                            </div>

                            <div class="col-lg-3  col-md-3">
                                <div class="blog_info text-right">
                                    <div class="post_tag">
                                        <a href="#">Du lịch,</a>
                                        <a class="active" href="#">Ẩm thực,</a>
                                        <a href="#">Trải nghiệm,</a>
                                        <a href="#">Cuộc sống</a>
                                    </div>
                                    <ul class="blog_meta list">
                                        <li><a href="#"><%=user_name%><i class="lnr lnr-user"></i></a></li>
                                        <li><a href="#"><%=polist.get(i).getPost_time()%><i class="lnr lnr-calendar-full"></i></a></li>
                                        <li><a href="#">1.2M Views<i class="lnr lnr-eye"></i></a></li>
                                        <li><a href="#">06 Comments<i class="lnr lnr-bubble"></i></a></li>
                                    </ul>
                                    <ul class="social-links">
                                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-github"></i></a></li>
                                        <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-lg-9 col-md-9 blog_details">
                                <h2><%=place_name%></h2>
                                <p class="excert">
                                    <%=post_text%>
                                </p>
                            </div>
                            <div class="col-lg-12">

                            </div>
                        </div>
                        <%                                        }
                                    }

                                }
                            }
                        %>

                        <div class="navigation-area">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                                    <div class="thumb">
                                        <a href="#"><img class="img-fluid" style="width: 60px; height: 60px;" src="img/blog/user-img.jpg" alt=""></a>
                                    </div>
                                    <div class="arrow">
                                        <a href="#"><span class="lnr text-white lnr-arrow-left"></span></a>
                                    </div>
                                    <div class="detials">
                                        <p>Prev Post</p>
                                        <a href="#">
                                            <h4>Space The Final Frontier</h4>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
                                    <div class="detials">
                                        <p>Next Post</p>
                                        <a href="#">
                                            <h4>Telescopes 101</h4>
                                        </a>
                                    </div>
                                    <div class="arrow">
                                        <a href="#"><span class="lnr text-white lnr-arrow-right"></span></a>
                                    </div>
                                    <div class="thumb">
                                        <a href="#"><img class="img-fluid" style="width: 60px; height: 60px;" src="img/blog/user-img.jpg" alt=""></a>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="comments-area">
                            <h4>Comments</h4>
                            <%
                                for (CommentInfo ci : cis) {
                                    for (PostInfo pi : polist) {
                                        if (ci.getPost_id() == pi.getPost_id() && ci.getPost_id() == id) {


                            %>

                            <div class="comment-list">
                                <div class="single-comment justify-content-between d-flex">
                                    <div class="user justify-content-between d-flex">
                                        <div class="thumb">
                                            <img style="width: 60px; height: 60px;" src="img/blog/user-img.jpg" alt="">
                                        </div>
                                        <div class="desc">
                                            <h5><a href="#"><%=ci.getComment_email()%></a></h5>
                                            <p class="date"><%=ci.getComment_time()%> </p>
                                            <p class="comment">
                                                <%=ci.getComment_description()%>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="reply-btn">
                                        <a href="" class="btn-reply text-uppercase">reply</a>
                                    </div>
                                </div>
                            </div>
                            <%

                                        }
                                    }

                                }
                            %>
                            <div class="comment-form">
                                <h4>Leave a Reply</h4>

                                <form method="post" action="addComment" name="upload" enctype="multipart/form-data">
                                    <input name="txtPost_id" value="<%=id%>" type="hidden">

                                    <div class="form-group form-inline">
                                        <div class="form-group col-lg-6 col-md-6 email">
                                            <input type="email" name="txtEmail" class="form-control" id="email" placeholder="Enter email address"
                                                   onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <!--                                        <textarea class="form-control mb-10" rows="5" name="message" placeholder="Messege"
                                                                                          onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>-->
                                        <textarea class="form-control" style="height:300px;" name="massage"></textarea>
                                    </div>
                                    <button type="submit" name="submit" value="upload" class="primary-btn">Post Comment</button>
                                </form>
                            </div>


                        </div>

                    </div>
                </div>
        </section>
        <!--================Blog Area =================-->

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
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/mail-script.js"></script>
        <!--gmaps Js-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="js/gmaps.min.js"></script>
        <script src="js/theme.js"></script>
    </body>

</html>
