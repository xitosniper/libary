
<%@page import="Info.PlaceInfo"%>
<%@page import="Model.PlaceModel"%>
<%@page import="Info.PostInfo"%>
<%@page import="Model.PostModel"%>
<%@page import="Info.UserInfo"%>
<%@page import="Model.UserModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DBLib.ConnectionLib"%>
<%@page import="Info.CommentInfo"%>
<%@page import="Model.CommentModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int p = 1;
    String s = "";
    String sortColumn = "";

    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }

    Connection con = ConnectionLib.getConnection();
    CommentModel cm = new CommentModel();
    UserModel um = new UserModel(con);
    PostModel pm = new PostModel();
    PlaceModel placem = new PlaceModel(con);

    ArrayList<PlaceInfo> pllist = placem.getPlace();
    ArrayList<PostInfo> plist = pm.getPost();
    ArrayList<UserInfo> ulist = um.GetUser();
    ArrayList<CommentInfo> list = cm.getPaging(p, s, sortColumn);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sunshine Web Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <style type="text/css">
            .sp-price {
                text-align: right;
            }
            .sp-image {
                width: 64px;
                height: 64px;
            }
            .table tr {
                vertical-align: middle !important;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center">Danh sách comment (<%=cm.getNumberOfProduct(p, s, sortColumn)%> comment)</h1>
        <div class="container">
            <div class="table-responsive">          
                <table class="table">
                    <thead>
                        <tr>
                            <th colspan="9" align="center">
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
                        <td>STT</td>
                        <td>Email</td>
                        <td>Time</td>
                        <td>Description</td>
                        <td>Status</td>
                        <td>Edit</td>
                        <td>Post</td>
                        <td>Control</td>
                    </tr>
                    </thead>
                    <tbody>
                        <%

                            String placeName = "";
                            String editorName = "";
                            int cmt_no = (p - 1) * CommentModel.SoDong_Trang;
                            String status = "";
                            SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
                            for (CommentInfo cmt : list) {
                                ++cmt_no;
                                if (cmt.getStatus() == 1) {
                                    status = "<i class='fa fa-check-square text-success'></i>";
                                } else if (cmt.getStatus() == 0) {
                                    status = "<i class='fa fa-ban text-danger'></i>";
                                } else if (cmt.getStatus() == 2) {
                                    status = "<i class='fa fa-exclamation text-warning'></i>";
                                }
//                                status = (cmt.getStatus() == 0
//                                        ? "<span class='glyphicon glyphicon-remove-sign text-danger'></span>"
//                                        : "<span class='glyphicon glyphicon-ok-sign text-success'></span>");
                                for (UserInfo uinf : ulist) {
                                    if (uinf.getUser_id() == cmt.getUser_id()) {
                                        editorName = uinf.getUser_name();
                                    }
                                }
                                for (PostInfo pinf : plist) {
                                    if (pinf.getPost_id() == cmt.getPost_id()) {
                                        for (PlaceInfo plinf : pllist) {
                                            if (plinf.getPlace_id() == pinf.getPlace_id()) {
                                                placeName = plinf.getPlace_name();
                                            }
                                        }
                                    }
                                }
                        %>
                        <tr>
                            <td><%=cmt_no%></td>
                            <td><%=cmt.getComment_email()%></td>
                            <td><%=cmt.getComment_time()%></td>
                            <td><%=cmt.getComment_description()%></td>
                            <td><%=status%></td>
                            <td><%=editorName%></td>
                            <td><%=placeName%></td>
                            <td>
                                <button type="button" class="btn btn-default btn-sm btn-danger"
                                        onclick="if (confirm('Do you want to delete this comment by <%=cmt.getComment_email()%>?'))
                                                    location.href = 'comment-delete.jsp?id=<%=cmt.getComment_id()%>'">
                                    <i class='fa fa-ban'></i>
                                </button>


                                <button type="button" class="btn btn-default btn-sm btn-success"
                                        onclick="if (confirm('Do you want to delete this comment by <%=cmt.getComment_email()%>?'))
                                                    location.href = 'comment-notAccecpt.jsp?id=<%=cmt.getComment_id()%>'">
                                    <i class='fa fa-check-square'></i>
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
