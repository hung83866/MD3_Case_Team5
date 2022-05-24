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
<center>
    <h1>Delete???</h1>
    <form method="post" action="BlogServlet?action=delete&id=${id}&idblog=${idblog}">
        <button style="width: 100px;height: 50px;background: #28a745;border-radius: 20px">YES</button>
    </form>
    <a href="/UserServlet?id=${id}"><h3 style="width: 100px;height: 50px ;background: #003eff;border-radius: 20px">NO</h3></a>

</center>

</body>
</html>
