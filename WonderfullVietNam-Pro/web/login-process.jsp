<%-- 
    Document   : login-process
    Created on : Nov 7, 2019, 9:53:52 AM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
