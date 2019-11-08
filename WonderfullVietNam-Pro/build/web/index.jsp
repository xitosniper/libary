

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("username") == null) {


        %>
        <jsp:include page="home.html"></jsp:include>

        <% } else {
        %>
        <jsp:include page="dashboard.html"></jsp:include>
        <%}

        %>
    </body>
</html>

