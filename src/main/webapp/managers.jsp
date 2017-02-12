<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 2/10/2017
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>

<html>
    <body>

        <div class="container-fluid">
            <h2>Managers: </h2>
            <table>
                <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Phone</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="manager" items="${managers}">
                        <tr>
                            <td>${manager.firstname}</td>
                            <td>${manager.lastname}</td>
                            <td>${manager.phone}</td>
                            <td>${manager.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
