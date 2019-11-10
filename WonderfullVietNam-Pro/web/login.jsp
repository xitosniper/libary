<%-- 
    Document   : login
    Created on : Nov 8, 2019, 12:44:01 PM
    Author     : haumqce130436@fpt.edu.vn
--%>

<%@page import="DBLib.ConnectionLib"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String warning = "";
    if(session.getAttribute("warning") != null){
        warning = (String)session.getAttribute("warning");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FatMan | Login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">       
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">       
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">      
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">      
        <link rel="stylesheet" href="css/orionicons.css">       
        <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">      
        <link rel="stylesheet" href="css/custom.css">        
        <link rel="shortcut icon" href="img/favicon.png?3">        
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="css/style.css" rel="stylesheet">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       
    </head>
    <body>
        <section class="login-block">
            <div class="page-holder d-flex align-items-center">
                <div class="container">
                    <button name="submit" type="submit" class="btn btn-primary btnBack" onclick="location.href = 'home.jsp?'">Back</button>
                    <div class="row align-items-center py-5">
                        <div class="col-5 col-lg-7 mx-auto mb-5 mb-lg-0">
                            <div class="pr-lg-5"><img src="img/illustration.svg" alt="" class="img-fluid"></div>
                        </div>
                        <div class="col-lg-5 px-lg-4">
                            <h1 class="text-base text-primary text-uppercase mb-4">Wonderful Viet Nam</h1>
                            <h2 class="mb-4">Welcome!</h2>
                            <p class="text-muted">Local culture and practical experience.</p>
                            <form id="loginForm" action="login-process.jsp" method="post" class="mt-4">
                                <div class="form-group mb-4">
                                    <input type="text" name="username" placeholder="Username" class="form-control border-0 shadow form-control-lg" required>
                                    <div class="valid-feedback">Valid.</div>
                                    <div class="invalid-feedback">Please fill out this field.</div>
                                </div>
                                <div class="form-group mb-4">
                                    <input type="password" name="password" placeholder="Password" class="form-control border-0 shadow form-control-lg" required>
                                    <div class="valid-feedback">Valid.</div>
                                    <div class="invalid-feedback">Please fill out this field.</div>
                                </div>
                                <div class="form-group mb-4">
                                    <div class="custom-control custom-checkbox">
                                        <input id="customCheck1" type="checkbox"  class="custom-control-input">
                                        <p style="color: red;"><%=warning%></p>
                                        <label for="customCheck1" class="custom-control-label">Remember Me</label>
                                    </div>
                                </div>
                                <button type="submit" name="submit" value="load" class="btn btn-primary shadow px-5">Log in</button>
                            </form>
                        </div>
                    </div>
                    <p class="mt-5 mb-0 text-gray-400 text-center">Design by <a href="https://www.facebook.com/hau.mai.796569" class="external text-gray-400">MaiHau</a> & FatMan Group</p>              
                </div>
            </div>
        </section>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper.js/umd/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery.cookie/jquery.cookie.js"></script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
        <script src="js/front.js"></script>
        <script>
                    // Disable form submissions if there are invalid fields
                    (function () {
                        'use strict';
                        window.addEventListener('load', function () {
                            // Get the forms we want to add validation styles to
                            var forms = document.getElementsByClassName('needs-validation');
                            // Loop over them and prevent submission
                            var validation = Array.prototype.filter.call(forms, function (form) {
                                form.addEventListener('submit', function (event) {
                                    if (form.checkValidity() === false) {
                                        event.preventDefault();
                                        event.stopPropagation();
                                    }
                                    form.classList.add('was-validated');
                                }, false);
                            });
                        }, false);
                    })();
        </script>
    </body>
</html>
