<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-01
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    输出请求参数：${param}<br/>
    输出请求参数username的值：${param.username}<br/>
    输出请求参数password的值：${param.password}<br/>

    输出请求参数hobby的值：${paramValues.hobby[0]}
    ${paramValues.hobby[1]}
    ${paramValues.hobby[2]}
    <hr>
    输出请求头【User-Agent】的值：${header["User-Agent"]}<br>
    输出请求头【Connection】的值：${header.Connection}<br>
<%--    输出请求头【User-Agent】的某个值：${header["User-Agent"].[0]}<br>--%>
    <hr>
    输出Context-param的username值：${initParam.username}<br/>
    输出Context-param的password值：${initParam.password}<br/>

</body>
</html>
