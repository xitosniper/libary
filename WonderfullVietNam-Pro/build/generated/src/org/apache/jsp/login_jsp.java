package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DBLib.ConnectionLib;
import java.sql.Connection;
import Model.UserModel;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String warning = "";
    if(session.getAttribute("warning") != null){
        warning = (String)session.getAttribute("warning");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>FatMan | Login</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"robots\" content=\"all,follow\">       \n");
      out.write("        <link rel=\"stylesheet\" href=\"vendor/bootstrap/css/bootstrap.min.css\">       \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">      \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Poppins:300,400,800\">      \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/orionicons.css\">       \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.default.css\" id=\"theme-stylesheet\">      \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">        \n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.png?3\">        \n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section class=\"login-block\">\n");
      out.write("            <div class=\"page-holder d-flex align-items-center\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <button name=\"submit\" type=\"submit\" class=\"btn btn-primary btnBack\" onclick=\"location.href = 'home.jsp?'\">Back</button>\n");
      out.write("                    <div class=\"row align-items-center py-5\">\n");
      out.write("                        <div class=\"col-5 col-lg-7 mx-auto mb-5 mb-lg-0\">\n");
      out.write("                            <div class=\"pr-lg-5\"><img src=\"img/illustration.svg\" alt=\"\" class=\"img-fluid\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-5 px-lg-4\">\n");
      out.write("                            <h1 class=\"text-base text-primary text-uppercase mb-4\">Wonderful Viet Nam</h1>\n");
      out.write("                            <h2 class=\"mb-4\">Welcome!</h2>\n");
      out.write("                            <p class=\"text-muted\">Local culture and practical experience.</p>\n");
      out.write("                            <form id=\"loginForm\" action=\"login-process.jsp\" method=\"post\" class=\"mt-4\">\n");
      out.write("                                <div class=\"form-group mb-4\">\n");
      out.write("                                    <input type=\"text\" name=\"username\" placeholder=\"Username\" class=\"form-control border-0 shadow form-control-lg\" required>\n");
      out.write("                                    <div class=\"valid-feedback\">Valid.</div>\n");
      out.write("                                    <div class=\"invalid-feedback\">Please fill out this field.</div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group mb-4\">\n");
      out.write("                                    <input type=\"password\" name=\"password\" placeholder=\"Password\" class=\"form-control border-0 shadow form-control-lg\" required>\n");
      out.write("                                    <div class=\"valid-feedback\">Valid.</div>\n");
      out.write("                                    <div class=\"invalid-feedback\">Please fill out this field.</div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group mb-4\">\n");
      out.write("                                    <div class=\"custom-control custom-checkbox\">\n");
      out.write("                                        <input id=\"customCheck1\" type=\"checkbox\"  class=\"custom-control-input\">\n");
      out.write("                                        <label for=\"customCheck1\" class=\"custom-control-label\">Remember Me</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" name=\"submit\" value=\"load\" class=\"btn btn-primary shadow px-5\">Log in</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"mt-5 mb-0 text-gray-400 text-center\">Design by <a href=\"https://www.facebook.com/hau.mai.796569\" class=\"external text-gray-400\">MaiHau</a> & FatMan Group</p>              \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"vendor/popper.js/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"vendor/jquery.cookie/jquery.cookie.js\"></script>\n");
      out.write("        <script src=\"vendor/chart.js/Chart.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js\"></script>\n");
      out.write("        <script src=\"js/front.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                    // Disable form submissions if there are invalid fields\n");
      out.write("                    (function () {\n");
      out.write("                        'use strict';\n");
      out.write("                        window.addEventListener('load', function () {\n");
      out.write("                            // Get the forms we want to add validation styles to\n");
      out.write("                            var forms = document.getElementsByClassName('needs-validation');\n");
      out.write("                            // Loop over them and prevent submission\n");
      out.write("                            var validation = Array.prototype.filter.call(forms, function (form) {\n");
      out.write("                                form.addEventListener('submit', function (event) {\n");
      out.write("                                    if (form.checkValidity() === false) {\n");
      out.write("                                        event.preventDefault();\n");
      out.write("                                        event.stopPropagation();\n");
      out.write("                                    }\n");
      out.write("                                    form.classList.add('was-validated');\n");
      out.write("                                }, false);\n");
      out.write("                            });\n");
      out.write("                        }, false);\n");
      out.write("                    })();\n");
      out.write("        </script>\n");
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
