<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-05-29
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
                                <%--声明脚本--%>
<%--    声明类属性    --%>
    <%!
        private Integer age;
        private String name;
        private static Map<String, Object> map;
    %>
    <%--声明static静态代码块--%>
    <%!
        static {
            map = new HashMap<String,Object>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
        }
    %>
    <%--声明类方法--%>
    <%!
        public int get(){
            return 0;
        }
    %>
    <%--声明内部类--%>
    <%!
        public static class A{
            private Integer age = 19;
            private String name = "name";
        }
    %>

                                <%--表达式脚本--%>
<%--表达式脚本的所有特点
    1.所有的表达式脚本都会被翻译到_jspService()方法中
    2.表达式脚本都会被翻译成out.print()输出在页面上
    3.由于表达式脚本翻译的内容都在_jspService()方法中，所以_jspService()方法中的对象都可以直接使用
    4.表达式脚本中的表达式不能以分号结尾
--%>
    <%--输出整型--%>
    <%=12%><br/>
    <%--输出浮点型--%>
    <%=12.23%><br/>
    <%--输出字符串--%>
    <%="java天下第一"%><br/>
    <%--输出对象--%>
    <%=map%><br/>

    <%=request.getParameter("username")%>

                                <%--代码脚本--%>

<%--1.if语句--%>
    <%
        int i = 30;
        if (i == 30){
            System.out.println("i等于30");
        }else{
            System.out.println("i不等于30");
        }
    %>
<%--2.for循环语句--%>
    <%
        for (int j = 0; j < 10; j++) {
    %>
           <br>
           <font color="#7fff00" face="宋体" size="5">java天下第一</font>
    <%
        }
    %>
<%--3.翻译后java文件中_jspService方法内的代码都可以写--%>
    <%
        String username = request.getParameter("username");
    %>
    <h1><%=username%></h1>

</body>
</html>
