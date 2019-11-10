package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Info.RoleInfo;
import Model.RoleModel;
import java.util.ArrayList;
import Info.UserInfo;
import Model.UserModel;
import java.sql.Connection;
import DBLib.ConnectionLib;

public final class user_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    int p = 1;
    String s = "";
    
    if(request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    
    if(request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }
    
    Connection connection = ConnectionLib.getConnection();
    UserModel um = new UserModel(connection);
    ArrayList<UserInfo> userList = um.getPaging(p, s);
    RoleModel rm = new RoleModel(connection);
    ArrayList<RoleInfo> roleList = rm.getRole();


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User List Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .sp-image {\n");
      out.write("                width: 64px;\n");
      out.write("                height: 64px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 style=\"text-align: center\">User List</h1>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"table-responsive\">          \n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th colspan=\"10\" align=\"center\">\n");
      out.write("                                <form>\n");
      out.write("                                    <div class=\"input-group\" style=\"width: 95%\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Search\"\n");
      out.write("                                               name=\"s\" value=\"");
      out.print(s);
      out.write("\">\n");
      out.write("                                        <div class=\"input-group-btn\">\n");
      out.write("                                            <button class=\"btn btn-default\" type=\"submit\">\n");
      out.write("                                                <i class=\"glyphicon glyphicon-search\"></i>\n");
      out.write("                                            </button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </th>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th colspan=\"10\" align=\"center\">\n");
      out.write("                                ");
      out.print(um.getPagingString(p, s));
      out.write("\n");
      out.write("                            </th>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>STT</td>\n");
      out.write("                            <td>User name</td>\n");
      out.write("                            <td>Image</td>\n");
      out.write("                            <td>Gender</td>\n");
      out.write("                            <td>Phone</td>\n");
      out.write("                            <td>Address</td>\n");
      out.write("                            <td>Account name</td>\n");
      out.write("                            <td>Static</td>\n");
      out.write("                            <td>Role</td>\n");
      out.write("                            <td>Manage  \n");
      out.write("                                <button type=\"button\" onclick=\"location.href = 'user-new.jsp?&trang=");
      out.print(p);
      out.write("&s=");
      out.print(s);
      out.write("'\" class=\"btn btn-default btn-sm\">\n");
      out.write("                                    <span class=\"glyphicon glyphicon-plus\"></span> Plus\n");
      out.write("                                </button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            int user_no = (p - 1) * um.SoDong_Trang;
                            String user_trangThai="";
                            String gender="";
                            String roleName="";
                            for (UserInfo userInfo : userList) {
                                ++user_no;
                                if(userInfo.getStatus() == 0){
                                    user_trangThai = "Unavailability";
                                } else if(userInfo.getStatus() == 1){
                                    user_trangThai = "Availability";
                                }
                                
                                if(userInfo.getUser_gender()==0) {
                                    gender = "Male";
                                } else if(userInfo.getUser_gender() ==1) {
                                    gender = "Female";
                                }
                                
                                for(RoleInfo roleInfo: roleList){
                                    if(userInfo.getRole_id()== roleInfo.getRole_id()){
                                        roleName = roleInfo.getRole_name();
                                    }
                                }
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(user_no);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( userInfo.getUser_name() );
      out.write("</td>\n");
      out.write("                            <td><img class=\"sp-image\" src=\"img/");
      out.print(userInfo.getUser_img());
      out.write("\"/></td>\n");
      out.write("                            <td>");
      out.print(gender);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(userInfo.getUser_phone());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(userInfo.getUser_address());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(userInfo.getUser_username());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(user_trangThai);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(roleName);
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default btn-sm btn-warning\"\n");
      out.write("                                        onclick=\"location.href = 'user-edit.jsp?id=");
      out.print(userInfo.getUser_id());
      out.write("&trang=");
      out.print(p);
      out.write("&s=");
      out.print(s);
      out.write("'\">\n");
      out.write("                                    <span class=\"glyphicon glyphicon-plus\"></span>\n");
      out.write("                                </button>\n");
      out.write("\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default btn-sm btn-danger\"\n");
      out.write("                                        onclick=\"if (confirm('Do you want to delete this ");
      out.print(userInfo.getUser_name());
      out.write("?'))\n");
      out.write("                                                    location.href = 'user-delete.jsp?id=");
      out.print(userInfo.getUser_id());
      out.write("&trang=");
      out.print(p);
      out.write("&s=");
      out.print(s);
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
