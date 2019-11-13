<%-- 
    Document   : user-delete
    Created on : Nov 9, 2019, 3:32:09 PM
    Author     : DELL
--%>

<%@page import="Model.UserModel"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int p = 1;
    String s = "";
//    int ma_sp;

    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }
    String user_username ="";
    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    Connection connection = ConnectionLib.getConnection();
    UserModel um = new UserModel(connection);

    um.deleteUser(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("user-list.jsp?username="+ user_username + "&trang=" + p + "&s=" + s);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
