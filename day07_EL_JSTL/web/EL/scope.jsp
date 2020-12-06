<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-01
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      pageContext.setAttribute("key", "pageContext1");
      request.setAttribute("key", "request");
      session.setAttribute("key","session");
      application.setAttribute("key", "application");
    %>

    ${ pageScope.key }<br/>
    ${ requestScope.key }<br/>
    ${sessionScope.key}<br/>
    ${applicationScope.key}<br/>
</body>
</html>
