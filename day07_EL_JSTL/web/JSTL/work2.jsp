<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-09
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach begin="2000" end="2020" var="i">
        <c:if test="${(i % 4 == 0 && i % 100 != 0) || i % 400 == 0}">
            <h1>${i}</h1>
        </c:if>
    </c:forEach>
</body>
</html>
