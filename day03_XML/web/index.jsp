<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-09-27
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="script/jquery-1.7.2.js"></script>
<html>
<head>
    <script type="text/javascript">
        $(function () {
            $("#selectBook").change(function () {
                var type = $(this).val();
                if (type === '必修课'){
                    $("#xuanxiu").css('display','none');
                    $("#bixiu").css('display','');
                }else if (type === '选修课'){
                    $("#bixiu").css('display','none');
                    $("#xuanxiu").css('display','');
                }else {
                    $("#bixiu").css('display','none');
                    $("#xuanxiu").css('display','none');
                }
            })
        })

    </script>

    <title>Title</title>
</head>
<body>

    <select id="selectBook">
        <option>请选择</option>
        <c:forEach items="${map}" var="book">
            <option>${book.type}</option>
        </c:forEach>
    </select>

    <div id="bixiu" style="display: none">
        <c:forEach items="${map}" var="book">
            <c:if test="${book.type == '必修课'}">
            <strong>${book.sn}</strong>
            <strong>${book.type}</strong>
            <strong>${book.name}</strong>
            <strong>${book.price}</strong>
            <strong>${book.author}</strong>
            <br>
            </c:if>
        </c:forEach>
    </div>

    <div id="xuanxiu" style="display: none">
        <c:forEach items="${map}" var="book">
            <c:if test="${book.type == '选修课'}">
                <strong>${book.sn}</strong>
                <strong>${book.type}</strong>
                <strong>${book.name}</strong>
                <strong>${book.price}</strong>
                <strong>${book.author}</strong>
                <br>
            </c:if>
        </c:forEach>
    </div>




</body>
</html>
