<%-- 
    Document   : logout
    Created on : Nov 8, 2019, 2:45:45 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.removeAttribute("username");
    response.sendRedirect("home.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    </body>
</html>
