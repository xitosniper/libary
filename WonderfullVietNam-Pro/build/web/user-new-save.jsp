<%-- 
    Document   : user-new-save
    Created on : Nov 9, 2019, 3:50:04 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>\
<%
    int p = 1;
    String s = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    String user_username = "";
    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    if (request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }
    response.sendRedirect("user-list.jsp?username="+user_username+"&p=" + p + "&search=" + s);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>
