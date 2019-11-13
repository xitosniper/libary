<%-- 
    Document   : form-new-save
    Created on : Nov 13, 2019, 10:46:40 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user_username = "";
    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    response.sendRedirect("tables.jsp?username=" + user_username);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
    </body>
</html>
