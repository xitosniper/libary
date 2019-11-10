
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FatMan | Home Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("username") == null) {
                
        %>
        <jsp:include page="home.jsp"></jsp:include>

        <% } else { %>
        <jsp:include page="dashboard.jsp"></jsp:include>
        <%
            }
        %>
    </body>
</html>

