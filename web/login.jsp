<%-- 
    Document   : login
    Created on : Sep 12, 2019, 11:22:46 AM
    Author     : asus
--%>

<%@page import="models.EmployeeRole"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String status = (String) session.getAttribute("status");
    List<EmployeeRole> username = (List<EmployeeRole>) session.getAttribute("sessionLogin");
    if (username != null) {
        response.sendRedirect("home.jsp");
    } else {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
        <style>
            body{
                background: url("http://cdn.backgroundhost.com/backgrounds/subtlepatterns/arches.png");
            }

            .absolute-center {
                margin: auto;
                position: absolute;
                top: 0; left: 0; bottom: 0; right: 0;
            }

            .absolute-center.is-responsive {
                width: 50%; 
                height: 50%;
                min-width: 200px;
                max-width: 300px;
                padding: 0px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="absolute-center is-responsive">
                <div class="row">
                    <div class="col-md">
                        <form action="loginservlet" method="POST" id="loginForm" autocomplete="off">
                            <div class="form-group">
                                <h3 class="text-center">Silahkan Login Dahulu</h3>
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="email" id="email" name='email' placeholder="Email" required/>          
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="password" id="password" name='password' placeholder="Password" required/>     
                            </div>
<!--                            <div class="form-group">
                                <div class="g-recaptcha" data-sitekey="6LdDwLUUAAAAAFLpOpQCbMoIAF1SxSRqaiIVWwNG" data-callback="correctCaptcha"></div>
                            </div>-->
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Login</button>
                                <hr>
                            </div>
                        </form>    
                    </div>  
                </div>    
            </div>
        </div>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>
<%
    }
    session.removeAttribute("status");
%>
