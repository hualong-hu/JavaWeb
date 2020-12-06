<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.bigjava.pojo.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-06-02
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px #00ffff solid;
            width: 500px;
            border-collapse: collapse;
            margin: 0 auto;
        }
        td,th{
            border: 1px aqua solid;
            vertical-align: middle;
            text-align: center;
        }
    </style>
</head>
<body>
    <%--1.遍历1到10，输出
        begin属性设置开始的索引
        end 属性设置结束的索引
        var 属性表示循环的变量（也是当前正在遍历到数据 等同于java里的int i）
    --%>
    <c:forEach begin="1" end="10" var="i">
        <h5>${i}</h5>
    </c:forEach>

    <hr>

    <%--
        2.遍历Object数组
        for(Object item : arr)
        items  表示遍历的数据源(遍历的集合)
        var  表示当前遍历的数据
    --%>
    <%
        request.setAttribute("arr", new String[]{"110","119","120"});
    %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item}<br/>
    </c:forEach>

    <hr>
<%--
    使用foreach循环遍历map集合
--%>
    <%
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        request.setAttribute("map",map);

    %>
    <c:forEach items="${requestScope.map}" var="entry">
        <h1>${entry.key} --> ${entry.value}</h1>
    </c:forEach>

    <hr/>

    <%--
        4.遍历list集合----list集合中存放student类，有属性：编号，用户名，密码，年龄，电话信息
    --%>
    <%
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"云澈", "123456", 50, "110"));
        studentList.add(new Student(2,"云千影", "123456", 125, "119"));
        studentList.add(new Student(3,"茉莉", "123456", 55, "120"));
        studentList.add(new Student(4,"彩脂", "123456", 60, "114"));

        request.setAttribute("list", studentList);
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <%--
            items:表示遍历的集合
            var：表示遍历到的数据
            begin：表示遍历的开始索引值
            end：表示结束的索引值
            step：表示遍历的步长值
            varStatus:表示当前遍历到的数据的状态，实现了以下方法
                getCurrrnt():表示获取当前遍历到的数据
                getIndex():表示获取遍历的索引
                getCount():表示遍历的个数
                isFirst():表示当前遍历的数据是否是第一条
                isLast():表示当前遍历的数据是否是最后一条
                getBegin():表示获取遍历的开始索引值
                getEnd():表示获取结束的索引值
                getStep():表示获取遍历的步长值
        --%>
        <c:forEach items="${requestScope.list}" var="list" varStatus="status">
            <tr>
                <td>${list.id}</td>
                <td>${list.username}</td>
                <td>${list.password}</td>
                <td>${list.age}</td>
                <td>${list.phone}</td>
                <td>添加、删除</td>
                <td>${status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
