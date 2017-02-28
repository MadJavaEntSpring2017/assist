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
            <h2>Teams: </h2>
            <table>
                <thead>
                    <tr>
                        <th>Division</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="team" items="${teams}">
                        <tr>
                            <td>${team.division.name}</td>
                            <td>${team.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>