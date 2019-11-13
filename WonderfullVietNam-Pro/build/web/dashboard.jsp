<%-- 
    Document   : dashboard
    Created on : Nov 8, 2019, 12:51:46 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page import="Info.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Info.RoleInfo"%>
<%@page import="Model.RoleModel"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int role_id = -1;
    int user_id = -1;
    String user_username = "";
    String username = "";
    String role_name = "";
    String user_img ="";
    if (request.getParameter("username")!=null) {
            user_username = request.getParameter("username");
        }
    Connection con = ConnectionLib.getConnection();
    UserModel um = new UserModel(con);
    RoleModel rm = new RoleModel(con);
    
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
        <title>FatMan | Dashboard</title>
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
                            <div class="dropdown-divider"></div><a href="logout.jsp" class="dropdown-item">Logout</a>
                        </div>
                    </li>
                </ul>
            </nav>
        </header>
        <div class="d-flex align-items-stretch">
            <div id="sidebar" class="sidebar py-3">
                <div class="text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">MAIN</div>
                <ul class="sidebar-menu list-unstyled">
                    <li class="sidebar-list-item"><a href="dashboard.jsp?username=<%=user_username%>" class="sidebar-link text-muted active"><i class="o-home-1 mr-3 text-gray"></i><span>Home</span></a></li>
                    <li class="sidebar-list-item"><a href="charts.jsp?username=<%=user_username%>" class="sidebar-link text-muted"><i class="o-sales-up-1 mr-3 text-gray"></i><span>Report</span></a></li>
                    <li class="sidebar-list-item"><a href="tables.jsp?username=<%=user_username%>" class="sidebar-link text-muted"><i class="o-table-content-1 mr-3 text-gray"></i><span>Manage</span></a></li>
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
                            <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-violet"></div>
                                        <div class="text">
                                            <h6 class="mb-0">Data consumed</h6><span class="text-gray">145,14 GB</span>
                                        </div>
                                    </div>
                                    <div class="icon text-white bg-violet"><i class="fas fa-server"></i></div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-green"></div>
                                        <div class="text">
                                            <h6 class="mb-0">Open cases</h6><span class="text-gray">32</span>
                                        </div>
                                    </div>
                                    <div class="icon text-white bg-green"><i class="far fa-clipboard"></i></div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-blue"></div>
                                        <div class="text">
                                            <h6 class="mb-0">Work orders</h6><span class="text-gray">400</span>
                                        </div>
                                    </div>
                                    <div class="icon text-white bg-blue"><i class="fa fa-dolly-flatbed"></i></div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-red"></div>
                                        <div class="text">
                                            <h6 class="mb-0">New invoices</h6><span class="text-gray">123</span>
                                        </div>
                                    </div>
                                    <div class="icon text-white bg-red"><i class="fas fa-receipt"></i></div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section>
                        <div class="row mb-4">
                            <div class="col-lg-7 mb-4 mb-lg-0">
                                <div class="card">
                                    <div class="card-header">
                                        <h2 class="h6 text-uppercase mb-0">Current server uptime</h2>
                                    </div>
                                    <div class="card-body">
                                        <p class="text-gray">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                        <div class="chart-holder">
                                            <canvas id="lineChart1" style="max-height: 14rem !important;" class="w-100"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-5 mb-4 mb-lg-0 pl-lg-0">
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="row align-items-center flex-row">
                                            <div class="col-lg-5">
                                                <h2 class="mb-0 d-flex align-items-center"><span>86.4</span><span class="dot bg-green d-inline-block ml-3"></span></h2><span class="text-muted text-uppercase small">Work hours</span>
                                                <hr><small class="text-muted">Lorem ipsum dolor sit</small>
                                            </div>
                                            <div class="col-lg-7">
                                                <canvas id="pieChartHome1"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row align-items-center flex-row">
                                            <div class="col-lg-5">
                                                <h2 class="mb-0 d-flex align-items-center"><span>1.724</span><span class="dot bg-violet d-inline-block ml-3"></span></h2><span class="text-muted text-uppercase small">Server time</span>
                                                <hr><small class="text-muted">Lorem ipsum dolor sit</small>
                                            </div>
                                            <div class="col-lg-7">
                                                <canvas id="pieChartHome2"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-5 mb-4 mb-lg-0">
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="row align-items-center mb-3 flex-row">
                                            <div class="col-lg-5">
                                                <h2 class="mb-0 d-flex align-items-center"><span>86%</span><span class="dot bg-violet d-inline-block ml-3"></span></h2><span class="text-muted text-uppercase small">Monthly Usage</span>
                                                <hr><small class="text-muted">Lorem ipsum dolor sit</small>
                                            </div>
                                            <div class="col-lg-7">
                                                <canvas id="pieChartHome3"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row align-items-center flex-row">
                                            <div class="col-lg-5">
                                                <h2 class="mb-0 d-flex align-items-center"><span>$126,41</span><span class="dot bg-green d-inline-block ml-3"></span></h2><span class="text-muted text-uppercase small">All Income</span>
                                                <hr><small class="text-muted">Lorem ipsum dolor sit</small>
                                            </div>
                                            <div class="col-lg-7">
                                                <canvas id="pieChartHome4"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-7">
                                <div class="card">
                                    <div class="card-header">
                                        <h2 class="h6 text-uppercase mb-0">Total Overdue</h2>
                                    </div>
                                    <div class="card-body">
                                        <p class="text-gray">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                        <div class="chart-holder">
                                            <canvas id="lineChart2" style="max-height: 14rem !important;" class="w-100"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                       <section class="py-5">
                        
                        
                    </section>
                    <section>
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="card mb-5 mb-lg-0">         
                                    <div class="card-header">
                                        <h2 class="h6 mb-0 text-uppercase">Transaction history</h2>
                                    </div>
                                    <div class="card-body">
                                        <p class="text-gray mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                        <div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
                                            <div class="left d-flex align-items-center">
                                                <div class="icon icon-lg shadow mr-3 text-gray"><i class="fab fa-dropbox"></i></div>
                                                <div class="text">
                                                    <h6 class="mb-0 d-flex align-items-center"> <span>Dropbox Inc.</span><span class="dot dot-sm ml-2 bg-violet"></span></h6><small class="text-gray">Account renewal</small>
                                                </div>
                                            </div>
                                            <div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-violet">
                                                <h5>-$20</h5>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
                                            <div class="left d-flex align-items-center">
                                                <div class="icon icon-lg shadow mr-3 text-gray"><i class="fab fa-apple"></i></div>
                                                <div class="text">
                                                    <h6 class="mb-0 d-flex align-items-center"> <span>App Store.</span><span class="dot dot-sm ml-2 bg-green"></span></h6><small class="text-gray">Software cost</small>
                                                </div>
                                            </div>
                                            <div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-green">
                                                <h5>-$20</h5>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
                                            <div class="left d-flex align-items-center">
                                                <div class="icon icon-lg shadow mr-3 text-gray"><i class="fas fa-shopping-basket"></i></div>
                                                <div class="text">
                                                    <h6 class="mb-0 d-flex align-items-center"> <span>Supermarket.</span><span class="dot dot-sm ml-2 bg-blue"></span></h6><small class="text-gray">Shopping</small>
                                                </div>
                                            </div>
                                            <div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-blue">
                                                <h5>-$20</h5>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-start align-items-sm-center mb-4 flex-column flex-sm-row">
                                            <div class="left d-flex align-items-center">
                                                <div class="icon icon-lg shadow mr-3 text-gray"><i class="fab fa-android"></i></div>
                                                <div class="text">
                                                    <h6 class="mb-0 d-flex align-items-center"> <span>Play Store.</span><span class="dot dot-sm ml-2 bg-red"></span></h6><small class="text-gray">Software cost</small>
                                                </div>
                                            </div>
                                            <div class="right ml-5 ml-sm-0 pl-3 pl-sm-0 text-red">
                                                <h5>-$20</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="bg-white shadow roundy px-4 py-3 d-flex align-items-center justify-content-between mb-4">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-violet"></div>
                                        <div class="text">
                                            <h6 class="mb-0">Completed cases</h6><span class="text-gray">127 new cases</span>
                                        </div>
                                    </div>
                                    <div class="icon bg-violet text-white"><i class="fas fa-clipboard-check"></i></div>
                                </div>
                                <div class="bg-white shadow roundy px-4 py-3 d-flex align-items-center justify-content-between mb-4">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-green"></div>
                                        <div class="text">
                                            <h6 class="mb-0">New Quotes</h6><span class="text-gray">214 new quotes</span>
                                        </div>
                                    </div>
                                    <div class="icon bg-green text-white"><i class="fas fa-dollar-sign"></i></div>
                                </div>
                                <div class="bg-white shadow roundy px-4 py-3 d-flex align-items-center justify-content-between mb-4">
                                    <div class="flex-grow-1 d-flex align-items-center">
                                        <div class="dot mr-3 bg-blue"></div>
                                        <div class="text">
                                            <h6 class="mb-0">New clients</h6><span class="text-gray">25 new clients</span>
                                        </div>
                                    </div>
                                    <div class="icon bg-blue text-white"><i class="fas fa-user-friends"></i></div>
                                </div>
                                <div class="card px-5 py-4">
                                    <h2 class="mb-0 d-flex align-items-center"><span>86.4</span><span class="dot bg-red d-inline-block ml-3"></span></h2><span class="text-muted">Server time</span>
                                    <div class="chart-holder">
                                        <canvas id="lineChart3" style="max-height: 7rem !important;" class="w-100">      </canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="py-5">
                        <div class="row">
                            
                            <%
                                for (UserInfo ui : uis) {
                                    for (RoleInfo ri : ris) {  
                                        if (ui.getRole_id() == ri.getRole_id()) {
                            %>
                            <div class="col-lg-12"><a href="#" class="message card px-5 py-3 mb-4 bg-hover-gradient-primary no-anchor-style">
                                    <div class="row">
                                        <div class="col-lg-3 d-flex align-items-center flex-column flex-lg-row text-center text-md-left"><strong class="h5 mb-0">24<sup class="smaller text-gray font-weight-normal">Apr</sup></strong><img src="img/<%=ui.getUser_img()%>" alt="..." style="max-width: 3rem" class="rounded-circle mx-3 my-2 my-lg-0">
                                            <h6 class="mb-0"><%=ui.getUser_name()%></h6>
                                        </div>
                                        <div class="col-lg-9 d-flex align-items-center flex-column flex-lg-row text-center text-md-left">
                                            <div class="bg-gray-100 roundy px-4 py-1 mr-0 mr-lg-3 mt-2 mt-lg-0 text-dark exclode"><%=ri.getRole_name()%></div>
                                            <p class="mb-0 mt-3 mt-lg-0"><%=ri.getRole_description()%></p>
                                        </div>
                                    </div></a></div>
                            <%
                                        }
                                    }
                                }
                            %>
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
        <script src="js/charts-home.js"></script>
        <script src="js/front.js"></script>
    </body>
</html>
