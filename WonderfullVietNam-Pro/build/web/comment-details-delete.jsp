<%-- 
    Document   : comment-delete
    Created on : Nov 9, 2019, 3:58:36 PM
    Author     : TuPTACE130136
--%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.CommentModel"%>
<%@page import="DBLib.ConnectionLib"%>
<%
    String user_username = "";
    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    Connection con = ConnectionLib.getConnection();
    CommentModel cm = new CommentModel(con);
    int id = Integer.parseInt(request.getParameter("id"));
    cm.deleteComment(id);
    response.sendRedirect("comment.jsp?username="+user_username);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
