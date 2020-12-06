<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-05-30
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br/>
    主要信息<br/>
                            <%--  静态包含  --%>

    <%--
         <%@include file=" "%>就是静态包含
         file属性指定需要包含的jsp页面的路径
         地址中第一个斜杠 / 表示为http://ip:port/工程路径/  映射到代码的web目录

         静态包含的特点
            1.静态包含不会翻译被包含的jsp页面
            2.静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出
    --%>
<%--    <%@include file="/include/footer.jsp"%>--%>

                            <%--  动态包含  --%>

    <%--
      动态包含：<jsp:include page=" ">   </jsp:include>
      page属性是指定需要包含的jsp页面的路径
      动态包含也可以像动态包含一样，把被包含的jsp页面的代码拷贝到包含的位置执行输出

      动态包含的特点:
      1.动态包含会把包含的jsp页面也翻译成java代码
      2.动态包含底层代码使用如下代码去调用被包含的jsp页面执行输出
        JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
      3.动态包含还可以传递参数
      --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="root"/>
        <jsp:param name="password" value="123456"/>
    </jsp:include>

    <%--
       请求转发：<jsp:forward page=" "> </jsp:forward>
       page属性是指定需要转发的jsp页面的路径
      --%>
    <jsp:forward page="footer.jsp">

    </jsp:forward>
</body>
</html>
