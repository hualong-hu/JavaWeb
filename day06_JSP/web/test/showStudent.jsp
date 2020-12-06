<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bigjava.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-05-30
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px aqua solid;
            width: 500px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px aqua solid;
        }
    </style>
</head>
<body>
    <%
        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("student");
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <%for (Student student : students){%>
        <tr>
            <td align="center"><%=student.getId()%></td>
            <td align="center"><%=student.getName()%></td>
            <td align="center"><%=student.getAge()%></td>
            <td align="center"><%=student.getPhone()%></td>
            <td align="center">删除、修改</td>
        </tr>
        <%}%>
    </table>
</body>
</html>
