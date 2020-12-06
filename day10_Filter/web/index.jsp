<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-15
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String username ="“bigjava”";
    session.setAttribute("“userName”",username);
  %>
  <%
    String getName = (String) session.getAttribute("“userName”");
    out.println(getName);
  %>


  $END$
  </body>
</html>
