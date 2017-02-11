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
            <h2>Leagues: </h2>
            <table>
                <thead>
                    <tr>
                        <th colspan="3">Name : Divisions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="league" items="${leagues}">
                        <tr>
                            <td>${league.name}</td>
                            <c:forEach var="division" items="${league.getDivisions()}">
                                <td>${division.name}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
