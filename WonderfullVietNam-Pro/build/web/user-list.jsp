<%-- 
    Document   : user-list
    Created on : Nov 9, 2019, 10:21:04 AM
    Author     : DELL
--%>

<%@page import="Info.RoleInfo"%>
<%@page import="Model.RoleModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Info.UserInfo"%>
<%@page import="Model.UserModel"%>
<%@page import="java.sql.Connection"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int p = 1;
    String s = "";
    
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }

    if (request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }
    String user_username ="";
    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    Connection connection = ConnectionLib.getConnection();
    UserModel um = new UserModel(connection);
    ArrayList<UserInfo> userList = um.getPaging(p, s);
    RoleModel rm = new RoleModel(connection);
    ArrayList<RoleInfo> roleList = rm.getRole();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style type="text/css">
            .sp-image {
                width: 64px;
                height: 64px;
            }
            .table tr td {
                vertical-align: middle !important;
            }
            .table tr th {
                vertical-align: middle !important;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center">USER LIST (<%=um.getNumberUser(p, s)%> users)</h1>
        <div class="container-fluid">
            <button name="submit" type="submit" class="btn btn-primary btnBack" onclick="location.href = 'tables.jsp?username=<%=user_username%>'">Back</button>
            <div class="table-responsive">          
                <table class="table">
                    <thead>
                        <tr>
                            <th colspan="10" align="center">
                                <form>
                                    <div class="input-group" style="width: 95%">
                                        <input type="text" class="form-control" placeholder="Search"
                                               name="s" value="<%=s%>">
                                        <div class="input-group-btn">
                                            <button class="btn btn-default" type="submit">
                                                <i class="glyphicon glyphicon-search"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </th>
                        </tr>
                        <tr>
                            <th colspan="10" align="center">
                                <%=um.getPagingString(p, s)%>
                            </th>
                        </tr>
                        <tr>
                            <th>#</th>
                            <th>User name</th>
                            <th>Image</th>
                            <th>Gender</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Account name</th>
                            <th>Static</th>
                            <th>Role</th>
                            <th>Manage  
                                <button type="button" onclick="location.href = 'user-new.jsp?username=<%=user_username%>&trang=<%=p%>&s=<%=s%>'" class="btn btn-default btn-sm btn-primary">
                                    <span class="glyphicon glyphicon-plus"></span> Plus
                                </button>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int user_no = (p - 1) * um.SoDong_Trang;
                            String user_trangThai = "";
                            String gender = "";
                            String roleName = "";
                            for (UserInfo userInfo : userList) {
                                ++user_no;
                                if (userInfo.getStatus() == 0) {
                                    user_trangThai = "Unavailability";
                                } else if (userInfo.getStatus() == 1) {
                                    user_trangThai = "Availability";
                                }

                                if (userInfo.getUser_gender() == 0) {
                                    gender = "Male";
                                } else if (userInfo.getUser_gender() == 1) {
                                    gender = "Female";
                                }

                                for (RoleInfo roleInfo : roleList) {
                                    if (userInfo.getRole_id() == roleInfo.getRole_id()) {
                                        roleName = roleInfo.getRole_name();
                                    }
                                }
                        %>
                        <tr>
                            <th scope="col"><%=user_no%></th>
                            <td><%= userInfo.getUser_name()%></td>
                            <td><img class="sp-image" src="img/<%=userInfo.getUser_img()%>"/></td>
                            <td><%=gender%></td>
                            <td><%=userInfo.getUser_phone()%></td>
                            <td><%=userInfo.getUser_address()%></td>
                            <td><%=userInfo.getUser_username()%></td>
                            <td><%=user_trangThai%></td>
                            <td><%=roleName%></td>
                            <td>
                                <button type="button" class="btn btn-default btn-sm btn-warning"
                                        onclick="location.href = 'user-edit.jsp?username=<%=user_username%>&id=<%=userInfo.getUser_id()%>&trang=<%=p%>&s=<%=s%>'">
                                    <span class="glyphicon glyphicon-info-sign"></span>
                                </button>

                                <button type="button" class="btn btn-default btn-sm btn-danger"
                                        onclick="if (confirm('Do you want to delete this <%=userInfo.getUser_name()%>?'))
                                                    location.href = 'user-delete.jsp?username=<%=user_username%>&id=<%=userInfo.getUser_id()%>&trang=<%=p%>&s=<%=s%>'">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </button>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
