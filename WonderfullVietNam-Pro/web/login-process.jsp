<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="Model.UserModel"%>--%>
<%

//    String username = "";
//    String password = "";
//    if (request.getParameter("username") != null) {
//        username = request.getParameter("username");
//    }
//    if (request.getParameter("password") != null) {
//        password = request.getParameter("password");
//    }
//    UserModel um = new UserModel();
//    if (username.equals(password) && username != null && password != null) {
//        session.setAttribute("username", username);
//    } else if (session.getAttribute("username") == null) {
//        session.removeAttribute("username");
//    }
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username.equals(password)) {
        session.setAttribute("username", username);
    } else if (session.getAttribute("username") == null) {
        session.removeAttribute(username);
    }
    response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>

    </body>
</html>