<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-09
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("6666666666");
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    %>
    <%=format%>


    <%
        for (int i = 0 ; i<10; i++){
    %>
        <h1>软件一班同学最帅</h1>
    <%
        }
    %>

</body>
</html>
