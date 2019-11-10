<%-- 
    Document   : comment-notAccecpt
    Created on : Nov 10, 2019, 11:05:45 AM
    Author     : TuPTACE130136
--%>

<%@page import="DBLib.ConnectionLib"%>
<%@page import="Model.CommentModel"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Connection con = ConnectionLib.getConnection();
    CommentModel cm = new CommentModel();
    int id = Integer.parseInt(request.getParameter("id"));
    cm.acceptComment(id);
    response.sendRedirect("comment.jsp?");
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
