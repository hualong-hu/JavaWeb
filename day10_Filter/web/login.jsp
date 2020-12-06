<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-15
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>这里是登录页面</h1>
    <form action="http://localhost:8080/day10/loginServlet" method="get">
        用户名：
        <label>
        <input type="text" name="username">
        </label><br>
        密码：
        <label>
        <input type="password" name="password">
        </label>
        <input type="submit">
    </form>

</body>
</html>
