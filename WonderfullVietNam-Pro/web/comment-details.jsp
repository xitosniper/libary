<%@page import="Model.EditorModel"%>
<%@page import="Model.LocationModel"%>
<%@page import="Info.LocationInfo"%>
<%@page import="Info.ImageInfo"%>
<%@page import="Info.EditorInfo"%>
<%@page import="Model.RoleModel"%>
<%@page import="Model.ImageModel"%>
<%@page import="Info.RoleInfo"%>
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
    int commentNo = 1;
    String s = "";
    String sortColumn = "";
    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("commentNo") != null) {
        commentNo = Integer.parseInt(request.getParameter("commentNo"));
    }
    Connection con = ConnectionLib.getConnection();
    
    UserModel um = new UserModel(con);
    PostModel pm = new PostModel(con);
    CommentModel cm = new CommentModel(con);
    PlaceModel pm1 = new PlaceModel(con);
    
    ArrayList<UserInfo> userInfos = um.getUser();
    ArrayList<PostInfo> postInfos = pm.getPost();
    ArrayList<CommentInfo> commentInfos = cm.getComment();
    ArrayList<PlaceInfo> placeInfos = pm1.getPlace();
    ArrayList<CommentInfo> commentInfos1 = cm.getPaging(commentNo, s, sortColumn);

    int role_id = -1;
    int user_id = -1;
    String user_username = "";
    String username = "";
    String role_name = "";
    String user_img = "";
    if (request.getParameter("username") != null) {
        user_username = request.getParameter("username");
    }
    ArrayList<UserInfo> uis = um.getUser();
    for (UserInfo elem : uis) {
        if (user_username.equals(elem.getUser_username())) {
            username = elem.getUser_name();
            role_id = elem.getRole_id();
            user_img = elem.getUser_img();
        }
    }

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
        <h1 style="text-align: center">COMMENT LIST(<%=cm.getNumberOfProduct(commentNo, s, sortColumn)%> comments)</h1>
        
        <div class="col-lg-12 mb-12 table_span container-fluid">
            <button name="submit" type="submit" class="btn btn-primary btnBack" onclick="location.href = 'tables.jsp?username=<%=user_username%>'">Back</button>
            <br>
            <div class="card">
                <div class="card-header">
                    <h3 class="text-uppercase mb-0">Comment Table</h3>
                    <!--<ins><p class="mb-0 text-uppercase text-right "><a href="comment-details.jsp" class="external">More Details</a></p></ins>-->
                </div>
                <div class="card-body">                           
                    <table class="table table-striped table-hover card-text">
                        <thead>
                            <tr class="">
                                <th class="paging" colspan="9" align="left">
                                    <%=cm.getPagingString(commentNo, s, sortColumn)%>
                                </th>
                            </tr>
                            <tr>
                                <th>#</th>
                                <th>Email</th>
                                <th>Time</th>
                                <th scope="col">Description</th>
                                <th>Status</th>
                                <th>Edit</th>
                                <th>Post</th>
                                <th>Manage</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%

                                String placeName = "";
                                String editorName = "";
                                int cmt_no = (commentNo - 1) * CommentModel.SoDong_Trang;
                                String status = "";
                                SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
                                for (CommentInfo cmt : commentInfos1) {
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
                                    for (UserInfo uinf : uis) {
                                        if (uinf.getUser_id() == cmt.getUser_id()) {
                                            editorName = uinf.getUser_name();
                                        }
                                    }
                                    for (PostInfo pinf : postInfos) {
                                        if (pinf.getPost_id() == cmt.getPost_id()) {
                                            for (PlaceInfo plinf : placeInfos) {
                                                if (plinf.getPlace_id() == pinf.getPlace_id()) {
                                                    placeName = plinf.getPlace_name();
                                                }
                                            }
                                        }
                                    }
                            %>
                            <tr>
                                <th scope="row"><%=cmt_no%></th>
                                <td><%=cmt.getComment_email()%></td>
                                <td><%=cmt.getComment_time()%></td>
                                <td><%=cmt.getComment_description()%></td>
                                <td><%=status%></td>
                                <td><%=editorName%></td>
                                <td><%=placeName%></td>
                                <td>
                                    <button type="button" class="btn btn-default btn-sm btn-danger"
                                            onclick="if (confirm('Do you want to delete this comment by <%=cmt.getComment_email()%>?'))
                                                        location.href = 'comment-details-delete.jsp?username=<%=user_username%>&id=<%=cmt.getComment_id()%>'">
                                        <i class='fa fa-ban'></i>
                                    </button>


                                    <button type="button" class="btn btn-default btn-sm btn-success"
                                            onclick="if (confirm('Do you want to delete this comment by <%=cmt.getComment_email()%>?'))
                                                        location.href = 'comment-details-notAccecpt.jsp?username=<%=user_username%>&id=<%=cmt.getComment_id()%>'">
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
        </div>
    </body>
</html>

