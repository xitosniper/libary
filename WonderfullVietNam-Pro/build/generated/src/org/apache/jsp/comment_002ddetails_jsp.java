package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

    int p = 1;
    String s = "";
    String sortColumn = "";

    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }

    Connection con = ConnectionLib.getConnection();
    CommentModel cm = new CommentModel(con);
    UserModel um = new UserModel(con);
    PostModel pm = new PostModel(con);
    PlaceModel placem = new PlaceModel(con);

    ArrayList<PlaceInfo> pllist = placem.getPlace();
    ArrayList<PostInfo> plist = pm.getPost();
    ArrayList<UserInfo> ulist = um.getUser();
    ArrayList<CommentInfo> list = cm.getPaging(p, s, sortColumn);

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sunshine Web Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
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
      out.write("        <h1 style=\"text-align: center\">Danh sách comment (");
      out.print(cm.getNumberOfProduct(p, s, sortColumn));
      out.write(" comment)</h1>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"table-responsive\">          \n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th colspan=\"9\" align=\"center\">\n");
      out.write("                    <form>\n");
      out.write("                        <div class=\"input-group\" style=\"width: 95%\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Search\"\n");
      out.write("                                   name=\"s\" value=\"");
      out.print(s);
      out.write("\">\n");
      out.write("                            <div class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-default\" type=\"submit\">\n");
      out.write("                                    <i class=\"glyphicon glyphicon-search\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    </th>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>STT</td>\n");
      out.write("                        <td>Email</td>\n");
      out.write("                        <td>Time</td>\n");
      out.write("                        <td>Description</td>\n");
      out.write("                        <td>Status</td>\n");
      out.write("                        <td>Edit</td>\n");
      out.write("                        <td>Post</td>\n");
      out.write("                        <td>Control</td>\n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");


                            String placeName = "";
                            String editorName = "";
                            int cmt_no = (p - 1) * CommentModel.SoDong_Trang;
                            String status ="";
                            SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
                            for (CommentInfo cmt : list) {
                                ++cmt_no;
//                                if(cmt.getStatus() == 1) {
//                                    status ="<span class='glyphicon glyphicon-ok-sign text-success'></span>";
//                                } else if(cmt.getStatus() == 0){
//                                    status = "<span class='glyphicon glyphicon-remove-sign text-danger'></span>";
//                                }
                                status = (cmt.getStatus() == 0
                                        ? "<span class='glyphicon glyphicon-remove-sign text-danger'></span>"
                                        : "<span class='glyphicon glyphicon-ok-sign text-success'></span>");
                                for (UserInfo uinf : ulist) {
                                    if (uinf.getUser_id() == cmt.getUser_id()) {
                                        editorName = uinf.getUser_name();
                                    }
                                }
                                for (PostInfo pinf : plist) {
                                    if (pinf.getPost_id() == cmt.getPost_id()) {
                                        for (PlaceInfo plinf : pllist) {
                                            if(plinf.getPlace_id() == pinf.getPlace_id()) {
                                                placeName = plinf.getPlace_name();
                                            }
                                        }
                                    }
                                }
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(cmt_no);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cmt.getComment_email());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cmt.getComment_time());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(cmt.getComment_description());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(status);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(editorName);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(placeName);
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default btn-sm btn-danger\"\n");
      out.write("                                        onclick=\"if (confirm('Do you want to delete this comment by ");
      out.print(cmt.getComment_email());
      out.write("?'))\n");
      out.write("                                                    location.href = 'comment-delete.jsp?id=");
      out.print(cmt.getComment_id());
      out.write("'\">\n");
      out.write("                                    <span class=\"glyphicon glyphicon-fire\"></span>\n");
      out.write("                                </button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
