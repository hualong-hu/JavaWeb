<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-03
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        1.要有一个form标签，method = post请求
        2.form标签的encType属性值必须为multipart/form-data值
        3.在form标签中使用 input type="file" 添加上传文件
        4.编写服务器代码接收（servlet程序），处理上传数据

     --%>
    <form action="http://localhost:8080/day08/upload" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"/><br/>
        头像：<input type="file" name="photo"/> <br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
