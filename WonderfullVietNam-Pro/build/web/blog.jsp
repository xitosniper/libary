<%-- 
    Document   : blog
    Created on : Nov 8, 2019, 12:49:37 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page import="Info.UserInfo"%>
<%@page import="Model.UserModel"%>
<%@page import="Info.PostInfo"%>
<%@page import="Info.ImageInfo"%>
<%@page import="Info.PlaceInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.PostModel"%>
<%@page import="Model.ImageModel"%>
<%@page import="Model.PlaceModel"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int postNo = 1;
    String s = "";
    String sortColumn = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("postNo") != null) {
        postNo = Integer.parseInt(request.getParameter("postNo"));
    }
    Connection con = ConnectionLib.getConnection();
    PlaceModel pm = new PlaceModel(con);
    ImageModel im = new ImageModel(con);
    PostModel pom = new PostModel(con);
    UserModel um = new UserModel(con);
    ArrayList<UserInfo> uis = um.getUser();
    ArrayList<PlaceInfo> plist = pm.getPlace();
    ArrayList<ImageInfo> ilist = im.getListImage();
    ArrayList<PostInfo> polist = pom.getPost();

    ArrayList<PostInfo> postInfos = pom.getPaging(postNo, s, sortColumn);

    session.removeAttribute("warning");
%>
<!doctype html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="img/favicon.png" type="image/png">
        <title>FatMan | Home - Blog</title>
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
            .image{
                width: 550px !important;
                height: 270px !important;
            }
            .image-mien {
                height: 200px;
                width: 330px;
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
                            <a href="blog.jsp">Blog</a>
                        </div>
                        <h2>Blog Home</h2>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->

        <!--================Blog Categorie Area =================-->
        <section class="blog_categorie_area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img class="image-mien" src="img/blog/cat-post/mienbac.jpg" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a href="blog-details.jsp">
                                        <h5>Miền Bắc</h5>
                                    </a>
                                    <div class="border_line"></div>
                                    <p>Vẻ đẹp thuần khiết</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img class="image-mien" src="img/blog/cat-post/mientrung.jpg" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a href="blog-details.jsp">
                                        <h5>Miền Trung</h5>
                                    </a>
                                    <div class="border_line"></div>
                                    <p>Vẻ đẹp nhẹ nhàng, tinh tế</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img class="image-mien" src="img/blog/cat-post/miennam.jpg" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a href="blog-details.jsp">
                                        <h5>Miền Nam</h5>
                                    </a>
                                    <div class="border_line"></div>
                                    <p>Giao thoa văn hóa, vẻ đẹp mặn mà</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================Blog Categorie Area =================-->

        <!--================Blog Area =================-->
        <section class="blog_area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="blog_left_sidebar">
                            <%
                                String place_name = "";
                                String image = "";
                                String post_text = "";
                                int post_id = -1;
                                String user_name = "";
                                //loop of post list
                                for (int i = 0; i < postInfos.size(); i++) {
                                    post_text = postInfos.get(i).getPost_text();
                                    
                                    for (int j = 0; j < plist.size(); j++) {
                                        
                                        for (int k = 0; k < ilist.size(); k++) {
                                            if (postInfos.get(i).getPlace_id() == plist.get(j).getPlace_id() && postInfos.get(i).getPlace_id() == ilist.get(k).getPlace_id()) {

                                                if (ilist.get(k).getPlace_id() == ilist.get(k + 1).getPlace_id()) {
                                                    image = ilist.get(k).getImage_name();

                                                    k++;
                                                }
                                                for (UserInfo ui : uis) {
                                                    if (postInfos.get(i).getUser_id() == ui.getUser_id()) {
                                                        user_name = ui.getUser_name();

                                                    }
                                                }
                                                post_id = postInfos.get(i).getPost_id();
                                                place_name = plist.get(j).getPlace_name();


                            %>
                            <article class="row blog_item">
                                <div class="col-md-3">
                                    <div class="blog_info text-right">
                                        <div class="post_tag">
                                            <a href="#">Du lịch,</a>
                                            <a class="active" href="#">Ẩm thực,</a>
                                            <a href="#">Trải nghiệm,</a>
                                            <a href="#">Cuộc sống</a>
                                        </div>
                                        <ul class="blog_meta list">
                                            <li><a href="#"><%=user_name%><i class="lnr lnr-user"></i></a></li>
                                            <li><a href="#"><%=postInfos.get(i).getPost_time()%><i class="lnr lnr-calendar-full"></i></a></li>
                                            <li><a href="#">1.2M Views<i class="lnr lnr-eye"></i></a></li>
                                            <li><a href="#">06 Comments<i class="lnr lnr-bubble"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-md-9">
                                    <div class="blog_post">
                                        <img class="image" src="img/<%=image%>" alt="">
                                        <div class="blog_details">
                                            <a href="single-blog.jsp?id=<%=post_id%>">
                                                <h2><%=place_name%></h2>
                                            </a>
                                            <p><%=post_text%></p>
                                            <a href="single-blog.jsp?id=<%=post_id%>" class="blog_btn">Chi tiết</a>
                                        </div>
                                    </div>
                                </div>
                            </article>
                            <%

                                            }
                                        }
                                    }
                                }%>
                            <nav class="blog-pagination justify-content-center d-flex">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a href="#" class="page-link" aria-label="Previous">
                                            <span aria-hidden="true">
                                                <!--                                                <span class="lnr lnr-chevron-left"></span>-->
                                            </span>
                                        </a>
                                    </li>
                                    <li class="paging"><%=pom.getPagingString(postNo, s, sortColumn)%></li>
                                    <li class="page-item">
                                        <a href="#" class="page-link" aria-label="Next">
                                            <span aria-hidden="true">
                                                <!--                                                <span class="lnr lnr-chevron-right"></span>-->
                                            </span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="blog_right_sidebar">
                            <aside class="single_sidebar_widget search_widget">
                                <form class="form_search">
                                    <div class="input-group">
                                        <input type="text" class="form-control" value="<%=s%>" name="s" placeholder="Search Posts">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit"><i class="lnr lnr-magnifier"></i></button>
                                        </span>
                                    </div><!-- /input-group -->
                                </form>
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget author_widget">
                                <img class="author_img rounded-circle" src="img/blog/author.png" alt="">
                                <h4>Charlie Barber</h4>
                                <p>Senior blog writer</p>
                                <div class="social_icon">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-github"></i></a>
                                    <a href="#"><i class="fa fa-behance"></i></a>
                                </div>
                                <p>Boot camps have its supporters andit sdetractors. Some people do not understand why you
                                    should have to spend money on boot camp when you can get. Boot camps have itssuppor
                                    ters andits detractors.</p>
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget popular_post_widget">
                                <h3 class="widget_title">Popular Posts</h3>
                                <div class="media post_item">
                                    <img src="img/blog/popular-post/post1.jpg" alt="post">
                                    <div class="media-body">
                                        <a href="blog-details.jsp">
                                            <h3>Space The Final Frontier</h3>
                                        </a>
                                        <p>02 Hours ago</p>
                                    </div>
                                </div>
                                <div class="media post_item">
                                    <img src="img/blog/popular-post/post2.jpg" alt="post">
                                    <div class="media-body">
                                        <a href="blog-details.jsp">
                                            <h3>The Amazing Hubble</h3>
                                        </a>
                                        <p>02 Hours ago</p>
                                    </div>
                                </div>
                                <div class="media post_item">
                                    <img src="img/blog/popular-post/post3.jpg" alt="post">
                                    <div class="media-body">
                                        <a href="blog-details.jsp">
                                            <h3>Astronomy Or Astrology</h3>
                                        </a>
                                        <p>03 Hours ago</p>
                                    </div>
                                </div>
                                <div class="media post_item">
                                    <img src="img/blog/popular-post/post4.jpg" alt="post">
                                    <div class="media-body">
                                        <a href="blog-details.jsp">
                                            <h3>Asteroids telescope</h3>
                                        </a>
                                        <p>01 Hours ago</p>
                                    </div>
                                </div>
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget ads_widget">
                                <a href="#"><img class="img-fluid" src="img/blog/add.jpg" alt=""></a>
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget post_category_widget">
                                <h4 class="widget_title">Post Catgories</h4>
                                <ul class="list cat-list">
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Technology</p>
                                            <p>37</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Lifestyle</p>
                                            <p>24</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Fashion</p>
                                            <p>59</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Art</p>
                                            <p>29</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Food</p>
                                            <p>15</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Architecture</p>
                                            <p>09</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Adventure</p>
                                            <p>44</p>
                                        </a>
                                    </li>
                                </ul>
                                <div class="br"></div>
                            </aside>
                            <aside class="single-sidebar-widget newsletter_widget">
                                <h4 class="widget_title">Newsletter</h4>
                                <p>
                                    Here, I focus on a range of items and features that we use in life without
                                    giving them a second thought.
                                </p>
                                <div class="form-group d-flex flex-row">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                                        </div>
                                        <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Enter email"
                                               onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email'">
                                    </div>
                                    <a href="#" class="bbtns">Subcribe</a>
                                </div>
                                <p class="text-bottom">You can unsubscribe at any time</p>
                                <div class="br"></div>
                            </aside>
                            <aside class="single-sidebar-widget tag_cloud_widget">
                                <h4 class="widget_title">Tag Clouds</h4>
                                <ul class="list">
                                    <li><a href="#">Technology</a></li>
                                    <li><a href="#">Fashion</a></li>
                                    <li><a href="#">Architecture</a></li>
                                    <li><a href="#">Fashion</a></li>
                                    <li><a href="#">Food</a></li>
                                    <li><a href="#">Technology</a></li>
                                    <li><a href="#">Lifestyle</a></li>
                                    <li><a href="#">Art</a></li>
                                    <li><a href="#">Adventure</a></li>
                                    <li><a href="#">Food</a></li>
                                    <li><a href="#">Lifestyle</a></li>
                                    <li><a href="#">Adventure</a></li>
                                </ul>
                            </aside>
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
