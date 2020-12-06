<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-02
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        <c:set/>
            作用：set标签可以往域中保存数据

            scope : 属性设置保存到哪个域
                page表示PageContext域（默认值）
                request表示Request域
                session表示Session域
                application表示ServletContext域
            var属性设置key值
            value属性设置值
    --%>
    保存之前：${requestScope.abc}<br/>
    <c:set scope="request" var="abc" value="123456"/>
    保存之后：${requestScope.abc}

    <hr>

    <%--
        <c:if test="">
            if标签用来做if判断
            test属性用来表示判断的条件（使用el表达式输出！）
            不能进行if-else操作
    --%>

    <c:if test="${12 == 12}">
        <h1>12等于12</h1>
    </c:if>

    <hr/>

    <%--
        <c:choose>
            <c:when test=""></c:when>
        </c:choose>
        作用：多路判断。跟switch ... case ... default 非常接近

        choose标签开始选择判断（等同于java里的switch）
        when标签表示每一种判断情况（等同于java里的case）
            test属性表示当前这种判断情况的值
        otherwise标签表示剩下的情况（等同于java里的default）
            1.标签里不能使用HTML注释，要使用jsp注释
            2.when标签的父标签一定要是choose标签

    --%>
    <%
        request.setAttribute("height", 191);
    %>
    <c:choose>
        <c:when test="${requestScope.height>190}">
            <h1>非常高</h1>
        </c:when>
        <c:when test="${requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${requestScope.height>170}">
            <h3>还可以</h3>
        </c:when>
        <c:when test="${requestScope.height}>160">
            <h4>一般般</h4>
        </c:when>
        <c:otherwise>
            <h5>太矮了！！！！！</h5>
        </c:otherwise>
    </c:choose>



</body>
</html>
