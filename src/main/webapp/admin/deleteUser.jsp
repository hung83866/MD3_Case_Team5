<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/23/2022
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center >
    <div style="background-image: url('/images/img7.jpg') ;height: 100%;width: 100%">
        <br><br><br><br><br><br><br><br><br><br><br><br>
        <table border="4">
            <tr>
                <th colspan="2" style="color: black"><h2>Do you want delete user : "${user.userName}"</h2></th>
            </tr><tr>
            <th> <form method="post" action="UserServlet?action=deleteUser&id=${id}" ><br>
                <button style="width: 100px;height: 50px;background: #38c8a8;border-radius: 20px">YES</button>
            </form></th>
            <th><a href="/UserServlet?action=userlist">
                <button style="width: 100px;height: 50px ;background: #38c8a8;border-radius: 20px">NO</button>
            </a>
            </th>
        </tr>
        </table>
    </div>
</center>

</body>
</html>
