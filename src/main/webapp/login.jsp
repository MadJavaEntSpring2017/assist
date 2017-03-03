<%@include file="head.jsp"%>

<html>
    <body>
        <form action="j_security_check" method="post">

            <table>
                <tr><td>Username: <input type="text" name="j_username" /></td></tr>
                <tr><td>Password: <input type="password" name="j_password" /></td></tr>
                <tr><th><input type="submit" value="Login"/></th></tr>
            </table>

        </form>
    </body>
</html>