<%-- 
    Document   : user-new
    Created on : Nov 9, 2019, 4:02:09 PM
    Author     : DELL
--%>

<%@page import="Model.RoleModel"%>
<%@page import="Info.UserInfo"%>
<%@page import="Model.UserModel"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page import="Info.RoleInfo"%>
<%@page import="java.util.ArrayList"%>
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
    String user_username = "";
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>New user Page</title>

        <style>
            form{
                margin: 40px;
            }
            label {
                color: darkblue;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center">Add New User</h1>
        
        <form class="container" action="addUser" method="post" enctype="multipart/form-data">
            <input id="productName" name="username" type="hidden" class="form-control" required="" value="<%=user_username%>">
            <!--Tên-->
            <div class="form-group row">
                <label for="text" class="col-4">User Name</label>
                <div class="col-8">
                    <input id="productName" name="userName" type="text" class="form-control" required="">
                </div>
            </div>
            <!--Hình ảnh-->
            <div class="form-group row">
                <label for="text2" class="col-4">Image</label>
                <div class="col-8">
                    <input id="picture-upload" name="picture-upload" type="file" required="">
                </div>
            </div>
            <!--Gender-->
            <div class="form-group row">
                <label class="col-4">Gender</label>
                <div class="col-8">
                    <div class="custom-control custom-radio custom-control-inline">
                        <input name="gender" id="gender-locked" type="radio" class="custom-control-input" value="0" checked>
                        <label for="gender-locked" class="custom-control-label">Male</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input name="gender" id="gender-unlock" type="radio" class="custom-control-input" value="1" checked>
                        <label for="gender-unlock" class="custom-control-label">Female</label>
                    </div>
                </div>
            </div>
            <!--Phone-->
            <div class="form-group row">
                <label for="text1" class="col-4">Number Phone</label>
                <div class="col-8">
                    <input id="productName" name="phone" type="text" min="0" class="form-control" required="">
                </div>
            </div>
            <!--Address-->
            <div class="form-group row">
                <label for="text3" class="col-4">Address</label>
                <div class="col-8">
                    <input id="productName" name="address" type="text" min="0" class="form-control" required="">
                </div>
            </div>

            <!--User_userName-->
            <div class="form-group row">
                <label for="text4" class="col-4">User Account Name</label>
                <div class="col-8">
                    <input id="productName" name="user_username" type="text" min="0" class="form-control" required="">
                </div>
            </div>

            <!--password-->
            <div class="form-group row">
                <label for="text5" class="col-4">Password</label>
                <div class="col-8">
                    <input id="productName" name="password" type="password" min="0" class="form-control" required="">
                </div>
            </div>


            <!--Status-->
            <div class="form-group row">
                <label class="col-4">Status</label>
                <div class="col-8">
                    <div class="custom-control custom-radio custom-control-inline">
                        <input name="status" id="status-locked" type="radio" class="custom-control-input" value="0" checked>
                        <label for="status-locked" class="custom-control-label">Unavailability</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input name="status" id="status-unlock" type="radio" class="custom-control-input" value="1" checked>
                        <label for="status-unlock" class="custom-control-label">Availability</label>
                    </div>
                </div>
            </div>

            <!-- Role-->
            <div class="form-group row">
                <label for="select" class="col-4 col-form-label">Role</label> 
                <div class="col-8">
                    <select id="product-type" name="role" class="custom-select">
                        <%
                            for (RoleInfo roleInfo : roleList) {
                        %>
                        <option value="<%=roleInfo.getRole_id()%>"><%=roleInfo.getRole_name()%></option>                            
                        <%
                            }
                        %>
                    </select>
                </div>
            </div> 

            <div class="form-group row">
                <div class="text-center col-12">
                    <button name="submit" type="submit" class="btn btn-primary btnBack" onclick="location.href = 'user-list.jsp?username=<%=user_username%>'">Back</button>
                    <button name="submit" type="submit" class="btn btn-primary">Sumit</button>
                </div>
            </div>
        </form>
    </body>
</html>
