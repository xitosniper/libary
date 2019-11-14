<%-- 
    Document   : comment-new-save
    Created on : Nov 14, 2019, 2:49:24 AM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    response.sendRedirect("single-blog.jsp?id="+id);
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
