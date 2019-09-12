<%-- 
    Document   : home
    Created on : Sep 12, 2019, 9:43:04 AM
    Author     : asus
--%>

<%@page import="models.EmployeeRole"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<EmployeeRole> logSession = (List<EmployeeRole>) session.getAttribute("sessionLogin");
    String status = (String) session.getAttribute("status");
    if (logSession == null) {
        out.println("<script>alert('Anda belum login!')</script>");
        out.println("<script>window.location.href=\"login.jsp\"</script>");
    } else {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
        <title>JSP Page</title>

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <a class="navbar-brand" href="#">Assessment</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="home.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="assessment.jsp">Assessment Process</a>
                    </li>
                </ul>
                <a class="btn btn-danger" onClick="logout()" href="#">Logout</a>
            </div>
        </nav>

        <div class="container">

            <div class="modal fade" id="detail" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-scrollable" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalScrollableTitle">Assessment Result Detail</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="control-label col-lg-2">ID :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="text" id="assessmentId" name="assessmentId" readonly=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-5">Participant Name :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="text" id="name" name="name" readonly=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-5">Batch Class :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="text" id="batchClass" name="batchClass" readonly=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-5">Lesson Criteria :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="text" id="lessonCriteria" name="lessonCriteria" readonly=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-5">Score :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="number" id="score" name="score" readonly=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-5">Lesson :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="number" id="score" name="lesson" readonly=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-5">Score :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="number" id="scoreLesson" name="scoreLesson" readonly=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-5">Grade :</label>
                                <div class="col-lg-12">
                                    <input class="form-control" type="number" id="grade" name="grade" readonly=""/>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>            

            <div class="" style="margin-top: 20px;">
                <div class="card">
                    <div class="card-header">
                        Assessment Result
                    </div>
                    <div class="card-body">
                        <table id="example" class="hover" style="width:100%">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Participant Name</th>
                                    <th>Score</th>
                                    <th>Grade</th>
                                    <th>Detail Assessment</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Coba UI</td>
                                    <td>99</td>
                                    <td>A</td>
                                    <td><button class="btn btn-primary" type="button" data-toggle="modal" data-target="#detail">Detail</button></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
        
        <script type="text/javascript">
            function logout() {
                swal({
                    title: "Are you sure?",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true
                }).then((willDelete) => {
                    if (willDelete) {
                        window.location.href = "loginservlet?action=logout";
                    } else {
                        swal("Batal Logout!");
                    }
                });
            }
            
        </script>
        
    </body>
</html>
<%
    }
    session.removeAttribute("status");
%>
