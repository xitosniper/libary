<%--
    Document   : forms
    Created on : Nov 8, 2019, 12:52:34 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="Info.PlaceInfo"%>
<%@page import="Model.PlaceModel"%>
<%@page import="Info.RoleInfo"%>
<%@page import="Info.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.RoleModel"%>
<%@page import="Model.UserModel"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int role_id = -1;
    int user_id = -1;
    int place_id = -1;
    int editor_id = 0;
    String user_username = "";
    String username = "";
    String role_name = "";
    String user_img = "";

    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    Connection con = ConnectionLib.getConnection();
    UserModel um = new UserModel(con);
    RoleModel rm = new RoleModel(con);
    PlaceModel pm = new PlaceModel(con);

    ArrayList<PlaceInfo> pis = pm.getPlace();
    ArrayList<UserInfo> uis = um.getUser();
    for (UserInfo elem : uis) {
        if (user_username.equals(elem.getUser_username())) {
            username = elem.getUser_name();
            role_id = elem.getRole_id();
            user_img = elem.getUser_img();
            user_id = elem.getUser_id();
        }
    }
    ArrayList<RoleInfo> ris = rm.getRole();
    for (RoleInfo elem : ris) {
        if (role_id == elem.getRole_id()) {
            role_name = elem.getRole_name();
        }
    }
    ;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FatMan | Dashboard - Forms</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
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
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
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
                            <div class="dropdown-divider"></div><a href="#" class="dropdown-item">Settings</a><a href="#" class="dropdown-item">Activity log</a>
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
                    <li class="sidebar-list-item"><a href="tables.jsp?username=<%=user_username%>" class="sidebar-link text-muted"><i class="o-table-content-1 mr-3 text-gray"></i><span>Manage</span></a></li>
                    <li class="sidebar-list-item"><a href="forms.jsp?username=<%=user_username%>" class="sidebar-link text-muted active"><i class="o-survey-1 mr-3 text-gray"></i><span>Forms</span></a></li>
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
            </div>
            <div class="page-holder w-100 d-flex flex-wrap">
                <div class="container-fluid px-xl-5">
                    <section class="py-5">
                        <div class="row">
                            <!-- Form Elements -->
                            <div class="col-lg-12 mb-5">
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="h6 text-uppercase mb-0">Form post</h3>
                                    </div>
                                    <div class="card-body">
                                        <form class="form-horizontal" name="upload" enctype="multipart/form-data" method="post" action="addPost">


                                            <input name="txtUser_id" value="<%=user_id%>" type="hidden">

                                            <input name="txtEditor_id" value="<%=editor_id%>" type="hidden">

                                            <input name="txtUsername" value="<%=user_username%>" type="hidden">
                                            <div class="input-group-icon mt-10">
                                                <div class="form-select" id="default-select">
                                                    <label>Place name</label>
                                                    <select name="txtPlace_id" style="margin-left: 200px;">
                                                        <%
                                                            for (int i = 0; i < pis.size(); i++) {

                                                                place_id = pis.get(i).getPlace_id();
                                                        %>
                                                        <option value="<%=place_id%>"><%=pis.get(i).getPlace_name()%></option>
                                                        <%  }

                                                        %>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-md-3 form-control-label">Content</label>
                                                <div class="col-md-9">
                                                    <textarea class="form-control" style="height:300px;" name="txtPost_text"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-md-3 form-control-label">Image</label>
                                                <div class="col-md-9">
                                                    <input type="file" name="image_name" multiple="multiple" class="form-control">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <div class="col-md-9 ml-auto">
                                                    <button type="reset" class="btn btn-secondary">Cancel</button>
                                                    <button type="submit" name="submit" value="upload" class="btn btn-primary">Save changes</button>
                                                </div>
                                            </div>


                                        </form>
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
    </body>
</html>