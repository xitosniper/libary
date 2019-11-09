<%@page import="java.sql.Connection"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="Model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="Model.UserModel"%>--%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    Connection con = ConnectionLib.getConnection();
    UserModel um = new UserModel(con);
    if (um.checkAccount(username, password)) {
        session.setAttribute("username", username);
    } else {
        session.removeAttribute("username");
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