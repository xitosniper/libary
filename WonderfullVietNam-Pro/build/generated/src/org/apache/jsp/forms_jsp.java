package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Info.PlaceInfo;
import Model.PlaceModel;
import Info.RoleInfo;
import Info.UserInfo;
import java.util.ArrayList;
import Model.RoleModel;
import Model.UserModel;
import DBLib.ConnectionLib;
import java.sql.Connection;

public final class forms_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    int role_id = -1;
    int user_id = 1;
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
      out.write("        <title>FatMan | Dashboard - Forms</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"robots\" content=\"all,follow\">\n");
      out.write("        <!-- Bootstrap CSS-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <!-- Font Awesome CSS-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\">\n");
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
      out.write("        <!-- Tweaks for older IEs--><!--[if lt IE 9]>\n");
      out.write("            <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("            <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script><![endif]-->\n");
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
      out.write("                                </div></a><a href=\"#\" class=\"dropdown-item\">\n");
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
      out.write("                            <div class=\"dropdown-divider\"></div><a href=\"#\" class=\"dropdown-item\">Settings</a><a href=\"#\" class=\"dropdown-item\">Activity log</a>\n");
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
      out.write("\" class=\"sidebar-link text-muted\"><i class=\"o-sales-up-1 mr-3 text-gray\"></i><span>Report</span></a></li>\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"tables.jsp?username=");
      out.print(user_username);
      out.write("\" class=\"sidebar-link text-muted\"><i class=\"o-table-content-1 mr-3 text-gray\"></i><span>Manage</span></a></li>\n");
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"forms.jsp?username=");
      out.print(user_username);
      out.write("\" class=\"sidebar-link text-muted active\"><i class=\"o-survey-1 mr-3 text-gray\"></i><span>Forms</span></a></li>\n");
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
      out.write("                    <li class=\"sidebar-list-item\"><a href=\"login.jsp\" class=\"sidebar-link text-muted\"><i class=\"o-exit-1 mr-3 text-gray\"></i><span>Logout</span></a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"page-holder w-100 d-flex flex-wrap\">\n");
      out.write("                <div class=\"container-fluid px-xl-5\">\n");
      out.write("                    <section class=\"py-5\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <!-- Form Elements -->\n");
      out.write("                            <div class=\"col-lg-12 mb-5\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-header\">\n");
      out.write("                                        <h3 class=\"h6 text-uppercase mb-0\">Form post</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <form class=\"form-horizontal\" name=\"upload\" enctype=\"multipart/form-data\" method=\"post\" action=\"addPost\">\n");
      out.write("                                            <input name=\"txtUser_id\" value=\"");
      out.print(user_id);
      out.write("\" type=\"hidden\">\n");
      out.write("                                            <input name=\"txtEditor_id\" value=\"");
      out.print(editor_id);
      out.write("\" type=\"hidden\">\n");
      out.write("                                            <input name=\"txtUsername\" type=\"hidden\" value=\"");
      out.print(user_username);
      out.write("\">\n");
      out.write("                                            <div class=\"input-group-icon mt-10\">\n");
      out.write("                                                <div class=\"form-select\" id=\"default-select\">\n");
      out.write("                                                    <label>Place name</label>\n");
      out.write("                                                    <select name=\"txtPlace_id\" style=\"margin-left: 200px;\">\n");
      out.write("                                                        ");

                                                            for (int i = 0; i < pis.size(); i++) {

                                                                place_id = pis.get(i).getPlace_id();
                                                        
      out.write("\n");
      out.write("                                                        <option value=\"");
      out.print(place_id);
      out.write('"');
      out.write('>');
      out.print(pis.get(i).getPlace_name());
      out.write("</option>\n");
      out.write("                                                        ");
  }
                                                        
                                                        
      out.write("\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"form-group row\">\n");
      out.write("                                                <label class=\"col-md-3 form-control-label\">Content</label>\n");
      out.write("                                                <div class=\"col-md-9\">\n");
      out.write("                                                    <textarea class=\"form-control\" style=\"height:300px;\" name=\"txtPost_text\"></textarea>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"form-group row\">\n");
      out.write("                                                <label class=\"col-md-3 form-control-label\">Image</label>\n");
      out.write("                                                <div class=\"col-md-9\">\n");
      out.write("                                                    <input type=\"file\" name=\"image_name\" multiple=\"multiple\" class=\"form-control\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"form-group row\">\n");
      out.write("                                                <div class=\"col-md-9 ml-auto\">\n");
      out.write("                                                    <button type=\"reset\" class=\"btn btn-secondary\">Cancel</button>\n");
      out.write("                                                    <button type=\"submit\" name=\"submit\" class=\"btn btn-primary\">Save changes</button>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>\n");
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
      out.write("    </body>\n");
      out.write("</html>");
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
