package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Info.LocationInfo;
import Model.LocationModel;
import Info.ImageInfo;
import Model.ImageModel;
import Info.CommentInfo;
import Model.CommentModel;
import java.text.SimpleDateFormat;
import Model.EditorModel;
import Info.EditorInfo;
import Info.PlaceInfo;
import Model.PlaceModel;
import Info.PostInfo;
import Model.PostModel;
import Info.RoleInfo;
import Model.RoleModel;
import Info.UserInfo;
import java.util.ArrayList;
import DBLib.ConnectionLib;
import java.sql.Connection;
import Model.UserModel;

public final class tables_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>FatMan | Dashboard - Tables</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"robots\" content=\"all,follow\">\n");
      out.write("        <!-- Bootstrap CSS-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <!-- Font Awesome CSS-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Google fonts - Popppins for copy-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Poppins:300,400,800\">\n");
      out.write("        <!-- orion icons-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/orionicons.css\">\n");
      out.write("        <!-- theme stylesheet-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.default.css\" id=\"theme-stylesheet\">\n");
      out.write("        <!-- Custom stylesheet - for your changes-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\n");
      out.write("        <!-- Favicon-->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.png?3\">\n");
      out.write("\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .size_img{\n");
      out.write("                height: 32px;\n");
      out.write("                width: 32px;\n");
      out.write("            }\n");
      out.write("            .size_img2{\n");
      out.write("                height: 128px;\n");
      out.write("                width: 128px;\n");
      out.write("            }\n");
      out.write("            .sp_center{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .table tr td {\n");
      out.write("                vertical-align: middle !important;\n");
      out.write("            }\n");
      out.write("            .table tr th {\n");
      out.write("                vertical-align: middle !important;\n");
      out.write("            }\n");
      out.write("            .table_span{\n");
      out.write("                padding-top: 50px;\n");
      out.write("            }\n");
      out.write("            .paging {\n");
      out.write("                margin: 10px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- navbar-->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <nav class=\"navbar navbar-expand-lg px-4 py-2 bg-white shadow\"><a href=\"#\" class=\"sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead\"><i class=\"fas fa-align-left\"></i></a><a href=\"dashboard.jsp?username=");
      out.print(user_username);
      out.write("\" class=\"navbar-brand font-weight-bold text-uppercase text-base\">Fat Man Dashboard</a>\n");
      out.write("                <ul class=\"ml-auto d-flex align-items-center list-unstyled mb-0\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <form id=\"searchForm\" class=\"ml-auto d-none d-lg-block\">\n");
      out.write("                            <div class=\"form-group position-relative mb-0\">\n");
      out.write("                                <button type=\"submit\" style=\"top: -3px; left: 0;\" class=\"position-absolute bg-white border-0 p-0\"><i class=\"o-search-magnify-1 text-gray text-lg\"></i></button>\n");
      out.write("                                <input type=\"search\" placeholder=\"Search ...\" class=\"form-control form-control-sm border-0 no-shadow pl-4\">\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown mr-3\"><a id=\"notifications\" href=\"http://example.com\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" class=\"nav-link dropdown-toggle text-gray-400 px-1\"><i class=\"fa fa-bell\"></i><span class=\"notification-icon\"></span></a>\n");
      out.write("                        <div aria-labelledby=\"notifications\" class=\"dropdown-menu\"><a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <div class=\"d-flex align-items-center\">\n");
      out.write("                                    <div class=\"icon icon-sm bg-violet text-white\"><i class=\"fab fa-twitter\"></i></div>\n");
      out.write("                                    <div class=\"text ml-2\">\n");
      out.write("                                        <p class=\"mb-0\">You have 2 followers</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div></a><a href=\"#\" class=\"dropdown-item\"> \n");
      out.write("                                <div class=\"d-flex align-items-center\">\n");
      out.write("                                    <div class=\"icon icon-sm bg-green text-white\"><i class=\"fas fa-envelope\"></i></div>\n");
      out.write("                                    <div class=\"text ml-2\">\n");
      out.write("                                        <p class=\"mb-0\">You have 6 new messages</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div></a><a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <div class=\"d-flex align-items-center\">\n");
      out.write("                                    <div class=\"icon icon-sm bg-blue text-white\"><i class=\"fas fa-upload\"></i></div>\n");
      out.write("                                    <div class=\"text ml-2\">\n");
      out.write("                                        <p class=\"mb-0\">Server rebooted</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div></a><a href=\"#\" class=\"dropdown-item\">\n");
      out.write("                                <div class=\"d-flex align-items-center\">\n");
      out.write("                                    <div class=\"icon icon-sm bg-violet text-white\"><i class=\"fab fa-twitter\"></i></div>\n");
      out.write("                                    <div class=\"text ml-2\">\n");
      out.write("                                        <p class=\"mb-0\">You have 2 followers</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div><a href=\"#\" class=\"dropdown-item text-center\"><small class=\"font-weight-bold headings-font-family text-uppercase\">View all notifications</small></a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown ml-auto\"><a id=\"userInfo\" href=\"http://example.com\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" class=\"nav-link dropdown-toggle\"><img src=\"img/");
      out.print(user_img);
      out.write("\" alt=\"\" style=\"max-width: 2.5rem;\" class=\"img-fluid rounded-circle shadow\"></a>\n");
      out.write("                        <div aria-labelledby=\"userInfo\" class=\"dropdown-menu\"><a href=\"#\" class=\"dropdown-item\"><strong class=\"d-block text-uppercase headings-font-family\">");
      out.print(username);
      out.write("</strong><small>");
      out.print(role_name);
      out.write("</small></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div><a href=\"#\" class=\"dropdown-item\">Settings</a><a href=\"#\" class=\"dropdown-item\">Activity log       </a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div><a href=\"login.jsp\" class=\"dropdown-item\">Logout</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"d-flex align-items-stretch\">\n");
      out.write("            <div id=\"sidebar\" class=\"sidebar py-3\">\n");
      out.write("                <div class=\"text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family\">MAIN</div>\n");
      out.write("                <ul class=\"sidebar-menu list-unstyled\">\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"dashboard.jsp?username=");
      out.print(user_username);
      out.write("\" class=\"sidebar-link text-muted\"><i class=\"o-home-1 mr-3 text-gray\"></i><span>Home</span></a></li>\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"charts.jsp?username=");
      out.print(user_username);
      out.write("\" class=\"sidebar-link text-muted\"><i class=\"o-sales-up-1 mr-3 text-gray\"></i><span>Charts</span></a></li>\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"tables.jsp?username=");
      out.print(user_username);
      out.write("\" class=\"sidebar-link text-muted active\"><i class=\"o-table-content-1 mr-3 text-gray\"></i><span>Tables</span></a></li>\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"forms.jsp?username=");
      out.print(user_username);
      out.write("\" class=\"sidebar-link text-muted\"><i class=\"o-survey-1 mr-3 text-gray\"></i><span>Forms</span></a></li>\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"#\" data-toggle=\"collapse\" data-target=\"#pages\" aria-expanded=\"false\" aria-controls=\"pages\" class=\"sidebar-link text-muted\"><i class=\"o-wireframe-1 mr-3 text-gray\"></i><span>Pages</span></a>\n");
      out.write("                        <div id=\"pages\" class=\"collapse\">\n");
      out.write("                            <ul class=\"sidebar-menu list-unstyled border-left border-primary border-thick\">\n");
      out.write("                                <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted pl-lg-5\">Page one</a></li>\n");
      out.write("                                <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted pl-lg-5\">Page two</a></li>\n");
      out.write("                                <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted pl-lg-5\">Page three</a></li>\n");
      out.write("                                <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted pl-lg-5\">Page four</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"login.jsp\" class=\"sidebar-link text-muted\"><i class=\"o-exit-1 mr-3 text-gray\"></i><span>Login</span></a></li>\n");
      out.write("                </ul>\n");
      out.write("                <!--                <div class=\"text-gray-400 text-uppercase px-3 px-lg-4 py-4 font-weight-bold small headings-font-family\">EXTRAS</div>\n");
      out.write("                                <ul class=\"sidebar-menu list-unstyled\">\n");
      out.write("                                    <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted\"><i class=\"o-database-1 mr-3 text-gray\"></i><span>Demo</span></a></li>\n");
      out.write("                                    <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted\"><i class=\"o-imac-screen-1 mr-3 text-gray\"></i><span>Demo</span></a></li>\n");
      out.write("                                    <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted\"><i class=\"o-paperwork-1 mr-3 text-gray\"></i><span>Demo</span></a></li>\n");
      out.write("                                    <li class=\"sidebar-list-item\"><a href=\"#\" class=\"sidebar-link text-muted\"><i class=\"o-wireframe-1 mr-3 text-gray\"></i><span>Demo</span></a></li>\n");
      out.write("                                </ul>-->\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"page-holder w-100 d-flex flex-wrap\">\n");
      out.write("                <div class=\"container-fluid px-xl-5\">\n");
      out.write("                    <section class=\"py-5\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-12 mb-12 table_span\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-header\">\n");
      out.write("                                        <h6 class=\"text-uppercase mb-0\">User Table</h6>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <table class=\"table card-text\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>Fullname</th>\n");
      out.write("                                                    <th>Image</th>\n");
      out.write("                                                    <th>Gender</th>\n");
      out.write("                                                    <th>Phone</th>\n");
      out.write("                                                    <th>Address</th>\n");
      out.write("                                                    <th>Position</th>\n");
      out.write("                                                    <th class=\"sp_center\">Manage Details</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");

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
                                                
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th scope=\"row\">");
      out.print(userNo);
      out.write("</th>\n");
      out.write("                                                    <td>");
      out.print(us.getUser_name());
      out.write("</td>\n");
      out.write("                                                    <td><img class=\"size_img\" src=\"img/");
      out.print(us.getUser_img());
      out.write("\"></td>\n");
      out.write("                                                    <td>");
      out.print(gender);
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(us.getUser_phone());
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(us.getUser_address());
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(role_name1);
      out.write("</td>\n");
      out.write("                                                    <td class=\"sp_center\">\n");
      out.write("                                                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"location.href = ''\">\n");
      out.write("                                                            <i class='glyphicon glyphicon-info-sign '></i></button>\n");
      out.write("\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-12 mb-12 table_span\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-header\">\n");
      out.write("                                        <h6 class=\"text-uppercase mb-0\">Post Table</h6>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card-body\">                           \n");
      out.write("                                        <table class=\"table table-striped card-text\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr class=\"\">\n");
      out.write("                                                    <th class=\"paging\" colspan=\"9\" align=\"left\">\n");
      out.write("                                                        ");
      out.print(pm.getPagingString(postNo, s, sortColumn));
      out.write("\n");
      out.write("                                                    </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>Place Name</th>\n");
      out.write("                                                    <th>Post Time</th>\n");
      out.write("                                                    <th>Writer</th>\n");
      out.write("                                                    <th>Editor</th>\n");
      out.write("                                                    <th class=\"sp_center\">Manage Details</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");

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
                                                
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th scope=\"row\">");
      out.print(poNo);
      out.write("</th>\n");
      out.write("                                                    <td>");
      out.print(place_name);
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(dFormat.format(po.getPost_time()));
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(writer_name);
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(editor_name);
      out.write("</td>\n");
      out.write("                                                    <td class=\"sp_center\">\n");
      out.write("                                                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"location.href = ''\">\n");
      out.write("                                                            <i class='glyphicon glyphicon-info-sign '></i></button>\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-12 mb-12 table_span\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-header\">\n");
      out.write("                                        <h6 class=\"text-uppercase mb-0\">Comment Table</h6>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card-body\">                           \n");
      out.write("                                        <table class=\"table table-striped table-hover card-text\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr class=\"\">\n");
      out.write("                                                    <th class=\"paging\" colspan=\"9\" align=\"left\">\n");
      out.write("                                                        ");
      out.print(cm.getPagingString(commentNo, s, sortColumn));
      out.write("\n");
      out.write("                                                    </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>Place Name</th>\n");
      out.write("                                                    <th>Email</th>\n");
      out.write("                                                    <th>Comment Time</th>\n");
      out.write("                                                    <th>Editor</th>\n");
      out.write("                                                    <th class=\"sp_center\">Manage Details</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");

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
                                                
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th scope=\"row\">");
      out.print(cNo);
      out.write("</th>\n");
      out.write("                                                    <td>");
      out.print(place_name1);
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(ci.getComment_email());
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(dFormat.format(ci.getComment_time()));
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(editor_name1);
      out.write("</td>\n");
      out.write("                                                    <td class=\"sp_center\">\n");
      out.write("                                                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"location.href = ''\">\n");
      out.write("                                                            <i class='glyphicon glyphicon-info-sign '></i></button>\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-12 table_span\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-header\">\n");
      out.write("                                        <h6 class=\"text-uppercase mb-0\">Place Table</h6>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card-body\">                          \n");
      out.write("                                        <table class=\"table table-striped table-sm card-text\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr class=\"\">\n");
      out.write("                                                    <th class=\"paging\" colspan=\"9\" align=\"left\">\n");
      out.write("                                                        ");
      out.print(plm.getPagingString(placeNo, s, sortColumn));
      out.write("\n");
      out.write("                                                    </th>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>#</th>\n");
      out.write("                                                    <th>Place Name</th>\n");
      out.write("                                                    <th>Image</th>\n");
      out.write("                                                    <th>Location</th>\n");
      out.write("                                                    <th class=\"sp_center\">Manage Details</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                ");

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
                                                
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th scope=\"row\">");
      out.print(pNo);
      out.write("</th>\n");
      out.write("                                                    <td>");
      out.print(pl.getPlace_name());
      out.write("</td>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        ");

                                                            for (ImageInfo ii : imageInfos) {
                                                                if (pl.getPlace_id() == ii.getPlace_id()) {
                                                                    image_place = ii.getImage_name();

                                                        
      out.write("\n");
      out.write("                                                        <span><img class=\"size_img2\" src=\"img/");
      out.print(image_place);
      out.write("\"></span>\n");
      out.write("                                                            ");

                                                                    }
                                                                }
                                                            
      out.write("\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td>");
      out.print(location_name);
      out.write("</td>\n");
      out.write("                                                    <td class=\"sp_center\">\n");
      out.write("                                                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"location.href = ''\">\n");
      out.write("                                                            <i class='glyphicon glyphicon-info-sign '></i></button>\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </section>\n");
      out.write("                </div>\n");
      out.write("                <footer class=\"footer bg-white shadow align-self-end py-3 px-xl-5 w-100\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6 text-center text-md-left text-primary\">\n");
      out.write("                                <p class=\"mb-2 mb-md-0\">Fat Man Group: 2019</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-6 text-center text-md-right text-gray-400\">\n");
      out.write("                                <p class=\"mb-0\">Design by <a href=\"https://www.facebook.com/hau.mai.796569\" class=\"external text-gray-400\">FatManGroup</a></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </footer>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- JavaScript files-->\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"vendor/popper.js/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"vendor/jquery.cookie/jquery.cookie.js\"></script>\n");
      out.write("        <script src=\"vendor/chart.js/Chart.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js\"></script>\n");
      out.write("        <script src=\"js/front.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-latest.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
