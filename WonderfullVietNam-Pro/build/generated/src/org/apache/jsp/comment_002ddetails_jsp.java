package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.EditorModel;
import Model.LocationModel;
import Info.LocationInfo;
import Info.ImageInfo;
import Info.EditorInfo;
import Model.RoleModel;
import Model.ImageModel;
import Info.RoleInfo;
import Info.PlaceInfo;
import Model.PlaceModel;
import Info.PostInfo;
import Model.PostModel;
import Info.UserInfo;
import Model.UserModel;
import java.text.SimpleDateFormat;
import DBLib.ConnectionLib;
import Info.CommentInfo;
import Model.CommentModel;
import java.util.ArrayList;
import java.sql.Connection;

public final class comment_002ddetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    int commentNo = 1;
    String s = "";
    String sortColumn = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("commentNo") != null) {
        commentNo = Integer.parseInt(request.getParameter("commentNo"));
    }
    Connection con = ConnectionLib.getConnection();
    
    UserModel um = new UserModel(con);
    PostModel pm = new PostModel(con);
    CommentModel cm = new CommentModel(con);
    PlaceModel pm1 = new PlaceModel(con);
    
    ArrayList<UserInfo> userInfos = um.getUser();
    ArrayList<PostInfo> postInfos = pm.getPost();
    ArrayList<CommentInfo> commentInfos = cm.getComment();
    ArrayList<PlaceInfo> placeInfos = pm1.getPlace();
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


      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sunshine Web Page</title>\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"path/to/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/a076d05399.js\"></script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .sp-price {\n");
      out.write("                text-align: right;\n");
      out.write("            }\n");
      out.write("            .sp-image {\n");
      out.write("                width: 64px;\n");
      out.write("                height: 64px;\n");
      out.write("            }\n");
      out.write("            .table tr {\n");
      out.write("                vertical-align: middle !important;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 style=\"text-align: center\">COMMENT LIST(");
      out.print(cm.getNumberOfProduct(commentNo, s, sortColumn));
      out.write(" comments)</h1>\n");
      out.write("        \n");
      out.write("        <div class=\"col-lg-12 mb-12 table_span container-fluid\">\n");
      out.write("            <button name=\"submit\" type=\"submit\" class=\"btn btn-primary btnBack\" onclick=\"location.href = 'tables.jsp?username=");
      out.print(user_username);
      out.write("'\">Back</button>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-header\">\n");
      out.write("                    <h3 class=\"text-uppercase mb-0\">Comment Table</h3>\n");
      out.write("                    <!--<ins><p class=\"mb-0 text-uppercase text-right \"><a href=\"comment-details.jsp\" class=\"external\">More Details</a></p></ins>-->\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">                           \n");
      out.write("                    <table class=\"table table-striped table-hover card-text\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr class=\"\">\n");
      out.write("                                <th class=\"paging\" colspan=\"9\" align=\"left\">\n");
      out.write("                                    ");
      out.print(cm.getPagingString(commentNo, s, sortColumn));
      out.write("\n");
      out.write("                                </th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>#</th>\n");
      out.write("                                <th>Email</th>\n");
      out.write("                                <th>Time</th>\n");
      out.write("                                <th scope=\"col\">Description</th>\n");
      out.write("                                <th>Status</th>\n");
      out.write("                                <th>Edit</th>\n");
      out.write("                                <th>Post</th>\n");
      out.write("                                <th>Manage</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");


                                String placeName = "";
                                String editorName = "";
                                int cmt_no = (commentNo - 1) * CommentModel.SoDong_Trang;
                                String status = "";
                                SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
                                for (CommentInfo cmt : commentInfos1) {
                                    ++cmt_no;
                                    if (cmt.getStatus() == 1) {
                                        status = "<i class='fa fa-check-square text-success'></i>";
                                    } else if (cmt.getStatus() == 0) {
                                        status = "<i class='fa fa-ban text-danger'></i>";
                                    } else if (cmt.getStatus() == 2) {
                                        status = "<i class='fa fa-exclamation text-warning'></i>";
                                    }
//                                status = (cmt.getStatus() == 0
//                                        ? "<span class='glyphicon glyphicon-remove-sign text-danger'></span>"
//                                        : "<span class='glyphicon glyphicon-ok-sign text-success'></span>");
                                    for (UserInfo uinf : uis) {
                                        if (uinf.getUser_id() == cmt.getUser_id()) {
                                            editorName = uinf.getUser_name();
                                        }
                                    }
                                    for (PostInfo pinf : postInfos) {
                                        if (pinf.getPost_id() == cmt.getPost_id()) {
                                            for (PlaceInfo plinf : placeInfos) {
                                                if (plinf.getPlace_id() == pinf.getPlace_id()) {
                                                    placeName = plinf.getPlace_name();
                                                }
                                            }
                                        }
                                    }
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"row\">");
      out.print(cmt_no);
      out.write("</th>\n");
      out.write("                                <td>");
      out.print(cmt.getComment_email());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(cmt.getComment_time());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(cmt.getComment_description());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(status);
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(editorName);
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(placeName);
      out.write("</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default btn-sm btn-danger\"\n");
      out.write("                                            onclick=\"if (confirm('Do you want to delete this comment by ");
      out.print(cmt.getComment_email());
      out.write("?'))\n");
      out.write("                                                        location.href = 'comment-details-delete.jsp?username=");
      out.print(user_username);
      out.write("&id=");
      out.print(cmt.getComment_id());
      out.write("'\">\n");
      out.write("                                        <i class='fa fa-ban'></i>\n");
      out.write("                                    </button>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default btn-sm btn-success\"\n");
      out.write("                                            onclick=\"if (confirm('Do you want to delete this comment by ");
      out.print(cmt.getComment_email());
      out.write("?'))\n");
      out.write("                                                        location.href = 'comment-details-notAccecpt.jsp?username=");
      out.print(user_username);
      out.write("&id=");
      out.print(cmt.getComment_id());
      out.write("'\">\n");
      out.write("                                        <i class='fa fa-check-square'></i>\n");
      out.write("                                    </button>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
