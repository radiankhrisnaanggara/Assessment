<%@page import="models.BatchClass"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%
        List<BatchClass> batchClasses = (List<BatchClass>) request.getSession().getAttribute("batchClasses");
        if (batchClasses == null) {
            response.sendRedirect("managebatchclassservlet");
        } else {

    %>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table id="example" class="display" cellspacing="0" width="100%"> <!--TABEL OUTPUT-->
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Region</th>
                    <th>Birth Month</th>
                </tr>
            </thead>
            <tbody>
                <%                    
                    for (BatchClass bc : batchClasses) {
                %>
                <tr>
                    <td><%= bc.getId()%></td>
                    <td><%= bc.getBatch().getId()%></td>
                    <td><%= bc.getClass1().getName() %></td>
                    <td><%= bc.getTrainer().getFirstName()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
    <%
            session.removeAttribute("batchClasses");
        }
    %>
</html>

