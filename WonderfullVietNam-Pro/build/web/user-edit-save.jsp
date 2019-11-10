<%-- 
    Document   : user-edit-save
    Created on : Nov 9, 2019, 5:19:14 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int p = 1;
    String s = "";
    if(request.getParameter("s")!=null) {
        s = request.getParameter("s");
    } 
    
    if (request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }
    response.sendRedirect("user-list.jsp?p=" + p + "&search=" + s);
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
