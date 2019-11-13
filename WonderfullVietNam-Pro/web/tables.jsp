<%-- 
    Document   : tables
    Created on : Nov 8, 2019, 12:54:02 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page import="Info.LocationInfo"%>
<%@page import="Model.LocationModel"%>
<%@page import="Info.ImageInfo"%>
<%@page import="Model.ImageModel"%>
<%@page import="Info.CommentInfo"%>
<%@page import="Model.CommentModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.EditorModel"%>
<%@page import="Info.EditorInfo"%>
<%@page import="Info.PlaceInfo"%>
<%@page import="Model.PlaceModel"%>
<%@page import="Info.PostInfo"%>
<%@page import="Model.PostModel"%>
<%@page import="Info.RoleInfo"%>
<%@page import="Model.RoleModel"%>
<%@page import="Info.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int placeNo = 1;
    int postNo = 1;
    int commentNo = 1;
    String s = "";
    String sortColumn = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("placeNo") != null) {
        placeNo = Integer.parseInt(request.getParameter("placeNo"));
    }
    if (request.getParameter("postNo") != null) {
        postNo = Integer.parseInt(request.getParameter("postNo"));
    }
    if (request.getParameter("commentNo") != null) {
        commentNo = Integer.parseInt(request.getParameter("commentNo"));
    }
    Connection con = ConnectionLib.getConnection();
    UserModel um = new UserModel(con);
    RoleModel rm = new RoleModel(con);
    PostModel pm = new PostModel(con);
    PlaceModel plm = new PlaceModel(con);
    EditorModel em = new EditorModel(con);
    CommentModel cm = new CommentModel(con);
    ImageModel im = new ImageModel(con);
    LocationModel lm = new LocationModel(con);
    ArrayList<UserInfo> userInfos = um.getUser();
    ArrayList<RoleInfo> roleInfos = rm.getRole();
    ArrayList<PostInfo> postInfos = pm.getPost();
    ArrayList<PlaceInfo> placeInfos = plm.getPlace();

    ArrayList<EditorInfo> editorInfos = em.getListEditor();
    ArrayList<CommentInfo> commentInfos = cm.getComment();
    ArrayList<ImageInfo> imageInfos = im.getListImage();
    ArrayList<LocationInfo> locationInfos = lm.getListLocation();

    ArrayList<PlaceInfo> placeInfos1 = plm.getPaging(placeNo, s, sortColumn);
    ArrayList<PostInfo> postInfos1 = pm.getPaging(postNo, s, sortColumn);
    ArrayList<CommentInfo> commentInfos1 = cm.getPaging(commentNo, s, sortColumn);

    int role_id = -1;
    int user_id = -1;
    String user_username = "";
    String username = "";
    String role_name = "";
    String user_img = "";
    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    ArrayList<UserInfo> uis = um.getUser();
    for (UserInfo elem : uis) {
        if (user_username.equals(elem.getUser_username())) {
            username = elem.getUser_name();
            role_id = elem.getRole_id();
            user_img = elem.getUser_img();
        }
    }
    ArrayList<RoleInfo> ris = rm.getRole();
    for (RoleInfo elem : ris) {
        if (role_id == elem.getRole_id()) {
            role_name = elem.getRole_name();
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FatMan | Dashboard - Manage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <!-- Google fonts - Popppins for copy-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
        <!-- orion icons-->
        <link rel="stylesheet" href="css/orionicons.css">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.png?3">

        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <style>
            .size_img{
                height: 32px;
                width: 32px;
            }
            .size_img2{
                height: 128px;
                width: 128px;
            }
            .sp_center{
                text-align: center;
            }
            .table tr td {
                vertical-align: middle !important;
            }
            .table tr th {
                vertical-align: middle !important;
            }
            .table_span{
                padding-top: 50px;
            }
            .paging {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <!-- navbar-->
        <header class="header">
            <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow"><a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead"><i class="fas fa-align-left"></i></a><a href="dashboard.jsp?username=<%=user_username%>" class="navbar-brand font-weight-bold text-uppercase text-base">Fat Man Dashboard</a>
                <ul class="ml-auto d-flex align-items-center list-unstyled mb-0">
                    <li class="nav-item">
                        <form id="searchForm" class="ml-auto d-none d-lg-block">
                            <div class="form-group position-relative mb-0">
                                <button type="submit" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0"><i class="o-search-magnify-1 text-gray text-lg"></i></button>
                                <input type="search" placeholder="Search ..." class="form-control form-control-sm border-0 no-shadow pl-4">
                            </div>
                        </form>
                    </li>
                    <li class="nav-item dropdown mr-3"><a id="notifications" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle text-gray-400 px-1"><i class="fa fa-bell"></i><span class="notification-icon"></span></a>
                        <div aria-labelledby="notifications" class="dropdown-menu"><a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <div class="icon icon-sm bg-violet text-white"><i class="fab fa-twitter"></i></div>
                                    <div class="text ml-2">
                                        <p class="mb-0">You have 2 followers</p>
                                    </div>
                                </div></a><a href="#" class="dropdown-item"> 
                                <div class="d-flex align-items-center">
                                    <div class="icon icon-sm bg-green text-white"><i class="fas fa-envelope"></i></div>
                                    <div class="text ml-2">
                                        <p class="mb-0">You have 6 new messages</p>
                                    </div>
                                </div></a><a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <div class="icon icon-sm bg-blue text-white"><i class="fas fa-upload"></i></div>
                                    <div class="text ml-2">
                                        <p class="mb-0">Server rebooted</p>
                                    </div>
                                </div></a><a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <div class="icon icon-sm bg-violet text-white"><i class="fab fa-twitter"></i></div>
                                    <div class="text ml-2">
                                        <p class="mb-0">You have 2 followers</p>
                                    </div>
                                </div></a>
                            <div class="dropdown-divider"></div><a href="#" class="dropdown-item text-center"><small class="font-weight-bold headings-font-family text-uppercase">View all notifications</small></a>
                        </div>
                    </li>
                    <li class="nav-item dropdown ml-auto"><a id="userInfo" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle"><img src="img/<%=user_img%>" alt="" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></a>
                        <div aria-labelledby="userInfo" class="dropdown-menu"><a href="#" class="dropdown-item"><strong class="d-block text-uppercase headings-font-family"><%=username%></strong><small><%=role_name%></small></a>
                            <div class="dropdown-divider"></div><a href="#" class="dropdown-item">Settings</a><a href="#" class="dropdown-item">Activity log       </a>
                            <div class="dropdown-divider"></div><a href="login.jsp" class="dropdown-item">Logout</a>
                        </div>
                    </li>
                </ul>
            </nav>
        </header>
        <div class="d-flex align-items-stretch">
            <div id="sidebar" class="sidebar py-3">
                <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">MAIN</div>
                <ul class="sidebar-menu list-unstyled">
                    <li class="sidebar-list-item"><a href="dashboard.jsp?username=<%=user_username%>" class="sidebar-link text-muted"><i class="o-home-1 mr-3 text-gray"></i><span>Home</span></a></li>
                    <li class="sidebar-list-item"><a href="charts.jsp?username=<%=user_username%>" class="sidebar-link text-muted"><i class="o-sales-up-1 mr-3 text-gray"></i><span>Report</span></a></li>
                    <li class="sidebar-list-item"><a href="tables.jsp?username=<%=user_username%>" class="sidebar-link text-muted active"><i class="o-table-content-1 mr-3 text-gray"></i><span>Manage</span></a></li>
                    <li class="sidebar-list-item"><a href="forms.jsp?username=<%=user_username%>" class="sidebar-link text-muted"><i class="o-survey-1 mr-3 text-gray"></i><span>Forms</span></a></li>
                    <li class="sidebar-list-item"><a href="#" data-toggle="collapse" data-target="#pages" aria-expanded="false" aria-controls="pages" class="sidebar-link text-muted"><i class="o-wireframe-1 mr-3 text-gray"></i><span>Pages</span></a>
                        <div id="pages" class="collapse">
                            <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                                <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted pl-lg-5">Page one</a></li>
                                <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted pl-lg-5">Page two</a></li>
                                <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted pl-lg-5">Page three</a></li>
                                <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted pl-lg-5">Page four</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sidebar-list-item"><a href="login.jsp" class="sidebar-link text-muted"><i class="o-exit-1 mr-3 text-gray"></i><span>Logout</span></a></li>
                </ul>
                <!--                <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">EXTRAS</div>
                                <ul class="sidebar-menu list-unstyled">
                                    <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted"><i class="o-database-1 mr-3 text-gray"></i><span>Demo</span></a></li>
                                    <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted"><i class="o-imac-screen-1 mr-3 text-gray"></i><span>Demo</span></a></li>
                                    <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted"><i class="o-paperwork-1 mr-3 text-gray"></i><span>Demo</span></a></li>
                                    <li class="sidebar-list-item"><a href="#" class="sidebar-link text-muted"><i class="o-wireframe-1 mr-3 text-gray"></i><span>Demo</span></a></li>
                                </ul>-->
            </div>

            <div class="page-holder w-100 d-flex flex-wrap">
                <div class="container-fluid px-xl-5">
                    <section class="py-5">
                        <div class="row">

                            <div class="col-lg-12 mb-12 table_span">
                                <div class="card">
                                    <div class="card-header">
                                        <h6 class="text-uppercase mb-0">User Table</h6> 
                                        <ins><p class="mb-0 text-uppercase text-right "><a href="user-list.jsp?username=<%=user_username%>" class="external">More Details</a></p></ins>
                                    </div>
                                    <div class="card-body">
                                        <table class="table card-text">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Fullname</th>
                                                    <th>Image</th>
                                                    <th>Gender</th>
                                                    <th>Phone</th>
                                                    <th>Address</th>
                                                    <th>Position</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    String gender;
                                                    String role_name1 = "";
                                                    int userNo = 0;
                                                    for (UserInfo us : userInfos) {
                                                        userNo++;
                                                        gender = us.getUser_gender() == 0 ? "<i>Female</i>" : "<i>Male</i>";
                                                        for (RoleInfo rl : roleInfos) {
                                                            if (us.getRole_id() == rl.getRole_id()) {
                                                                role_name1 = rl.getRole_name();
                                                            }
                                                        }
                                                %>
                                                <tr>
                                                    <th scope="row"><%=userNo%></th>
                                                    <td><%=us.getUser_name()%></td>
                                                    <td><img class="size_img" src="img/<%=us.getUser_img()%>"></td>
                                                    <td><%=gender%></td>
                                                    <td><%=us.getUser_phone()%></td>
                                                    <td><%=us.getUser_address()%></td>
                                                    <td><%=role_name1%></td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 mb-12 table_span">
                                <div class="card">
                                    <div class="card-header">
                                        <h6 class="text-uppercase mb-0">Post Table</h6>
                                        <ins><p class="mb-0 text-uppercase text-right "><a href="" class="external">More Details</a></p></ins>
                                    </div>
                                    <div class="card-body">                           
                                        <table class="table table-striped card-text">
                                            <thead>
                                                <tr class="">
                                                    <th class="paging" colspan="9" align="left">
                                                        <%=pm.getPagingString(postNo, s, sortColumn)%>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Place Name</th>
                                                    <th>Post Time</th>
                                                    <th>Writer</th>
                                                    <th>Editor</th>
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    //Attribute 
                                                    int poNo = (postNo - 1) * PlaceModel.SoDong_Trang;
                                                    String place_name = "";
                                                    String writer_name = "";
                                                    String editor_name = "null";
                                                    SimpleDateFormat dFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                                                    for (PostInfo po : postInfos1) {
                                                        poNo++;
                                                        //get place name
                                                        for (PlaceInfo pi : placeInfos) {
                                                            if (po.getPlace_id() == pi.getPlace_id()) {
                                                                place_name = pi.getPlace_name();
                                                            }
                                                        }
                                                        //get writer name
                                                        for (UserInfo us : userInfos) {
                                                            if (us.getUser_id() == po.getUser_id()) {
                                                                writer_name = us.getUser_name();
                                                            }
                                                        }
                                                        for (UserInfo us : userInfos) {
                                                            //get editor name
                                                            for (EditorInfo ed : editorInfos) {
                                                                if (ed.getEditor_id() == po.getEditor_id() && ed.getUser_id() == us.getUser_id()) {
                                                                    editor_name = us.getUser_name();
                                                                }
                                                            }
                                                        }
                                                %>
                                                <tr>
                                                    <th scope="row"><%=poNo%></th>
                                                    <td><%=place_name%></td>
                                                    <td><%=dFormat.format(po.getPost_time())%></td>
                                                    <td><%=writer_name%></td>
                                                    <td><%=editor_name%></td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 mb-12 table_span">
                                <div class="card">
                                    <div class="card-header">
                                        <h6 class="text-uppercase mb-0">Comment Table</h6>
                                        <ins><p class="mb-0 text-uppercase text-right "><a href="comment-details.jsp?username=<%=user_username%>" class="external">More Details</a></p></ins>
                                    </div>
                                    <div class="card-body">                           
                                        <table class="table table-striped table-hover card-text">
                                            <thead>
                                                <tr class="">
                                                    <th class="paging" colspan="9" align="left">
                                                        <%=cm.getPagingString(commentNo, s, sortColumn)%>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Place Name</th>
                                                    <th>Email</th>
                                                    <th>Comment Time</th>
                                                    <th>Editor</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    //Attribute 
                                                    int cNo = (commentNo - 1) * PlaceModel.SoDong_Trang;
                                                    String place_name1 = "";
                                                    String editor_name1 = "";
                                                    for (CommentInfo ci : commentInfos1) {
                                                        cNo++;
                                                        for (PostInfo po : postInfos) {
                                                            if (ci.getPost_id() == po.getPost_id()) {
                                                                for (PlaceInfo pa : placeInfos) {
                                                                    if (pa.getPlace_id() == po.getPlace_id()) {
                                                                        place_name1 = pa.getPlace_name();
                                                                    }
                                                                }

                                                            }
                                                        }
                                                        for (UserInfo ui : userInfos) {
                                                            if (ci.getUser_id() == ui.getUser_id()) {
                                                                editor_name1 = ui.getUser_name();
                                                            }
                                                        }
                                                %>
                                                <tr>
                                                    <th scope="row"><%=cNo%></th>
                                                    <td><%=place_name1%></td>
                                                    <td><%=ci.getComment_email()%></td>
                                                    <td><%=dFormat.format(ci.getComment_time())%></td>
                                                    <td><%=editor_name1%></td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 table_span">
                                <div class="card">
                                    <div class="card-header">
                                        <h6 class="text-uppercase mb-0">Place Table</h6>
                                        <ins><p class="mb-0 text-uppercase text-right "><a href="" class="external">More Details</a></p></ins>
                                    </div>
                                    <div class="card-body">                          
                                        <table class="table table-striped table-sm card-text">
                                            <thead>
                                                <tr class="">
                                                    <th class="paging" colspan="9" align="left">
                                                        <%=plm.getPagingString(placeNo, s, sortColumn)%>
                                                    </th>
                                                </tr>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Place Name</th>
                                                    <th>Image</th>
                                                    <th>Location</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    int pNo = (placeNo - 1) * PlaceModel.SoDong_Trang;
                                                    String image_place = "";
                                                    String location_name = "";
                                                    for (PlaceInfo pl : placeInfos1) {
                                                        pNo++;
                                                        for (LocationInfo li : locationInfos) {
                                                            if (pl.getLocation_id() == li.getLocation_id()) {
                                                                location_name = li.getLocation_name();
                                                            }
                                                        }
                                                %>
                                                <tr>
                                                    <th scope="row"><%=pNo%></th>
                                                    <td><%=pl.getPlace_name()%></td>
                                                    <td>
                                                        <%
                                                            for (ImageInfo ii : imageInfos) {
                                                                if (pl.getPlace_id() == ii.getPlace_id()) {
                                                                    image_place = ii.getImage_name();

                                                        %>
                                                        <span><img class="size_img2" src="img/<%=image_place%>"></span>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                    </td>
                                                    <td><%=location_name%></td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <footer class="footer bg-white shadow align-self-end py-3 px-xl-5 w-100">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-6 text-center text-md-left text-primary">
                                <p class="mb-2 mb-md-0">Fat Man Group: 2019</p>
                            </div>
                            <div class="col-md-6 text-center text-md-right text-gray-400">
                                <p class="mb-0">Design by <a href="https://www.facebook.com/hau.mai.796569" class="external text-gray-400">FatManGroup</a></p>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <!-- JavaScript files-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper.js/umd/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery.cookie/jquery.cookie.js"></script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
        <script src="js/front.js"></script>
        <script src="https://code.jquery.com/jquery-latest.js"></script>
    </body>
</html>
