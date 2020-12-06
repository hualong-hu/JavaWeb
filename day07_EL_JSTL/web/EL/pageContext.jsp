<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-01
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    request.getScheme() 获取请求的协议
    request.getServerName() 获取请求的服务器ip或域名
    request.getServerPort() 获取请求的服务器端口号
    request.getContextPath() 获取当前工程路径
    request.getMethod() 获取请求的方式（GET或POST）
    request.getRemoteHost() 获取客户端的ip地址
    session.getId() 获取会话的唯一标识
--%>

    <%=request.getScheme()%><br>
    1.协议：${pageContext.request.scheme}<br/>
    <%=request.getServerName()%><br>
    2.服务器ip：${pageContext.request.serverName}<br/>
    <%=request.getServerPort()%><br/>
    3.服务器端口：${pageContext.request.serverPort}<br/>
    <%=request.getContextPath()%><br>
    4.获取工程路径：${pageContext.request.contextPath}<br/>
    <%=request.getMethod()%><br>
    5.获取请求方法：${pageContext.request.method}<br/>
    <%=request.getRemoteHost()%><br>
    6.获取客户端IP地址：${pageContext.request.remoteHost}<br/>
    <%=session.getId()%><br>
    7.获取会话的id编号：${pageContext.session.id}<br/>

</body>
</html>
