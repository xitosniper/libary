<%-- 
    Document   : index
    Created on : Nov 7, 2019, 9:55:51 AM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <%
            if (session.getAttribute("username") == null) {
        %>
        <jsp:include page="login.html"></jsp:include>

        <% } else {
        %>
        <jsp:include page="dashboard-index.html"></jsp:include>
        <%}

        %>
    </body>
</html>
