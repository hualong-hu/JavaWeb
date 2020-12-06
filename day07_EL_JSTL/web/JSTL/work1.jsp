<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-09
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for (int i = 2; i <= 100; i++) {
        boolean flog = true;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                flog = false;
                break;
            }
        }
        if (flog) {
%>
            <%=i%>
<%
        }
    }
%>
</body>
</html>
