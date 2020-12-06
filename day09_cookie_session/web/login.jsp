<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-10
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="http://localhost:8080/day09/loginServlet">
        用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
        密码：<input type="password" name="password" ><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
