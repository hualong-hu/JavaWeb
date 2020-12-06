<%@ page import="org.bigjava.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: 洛笙
  Date: 2020-05-30
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("胡华龙");

        person.setPhones(new String[]{"10086","110","119"});

        ArrayList<String> cities = new ArrayList<>();
        cities.add("北京");
        cities.add("上海");
        cities.add("香港");
        person.setCities(cities);

        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        person.setMap(map);

        pageContext.setAttribute("person", person);
    %>

    输出person：${person}<br/>
    输出person的name属性：${person.name}<br/>
    输出person的phones属性：${person.phones[0]}&nbsp;${person.phones[1]}&nbsp;${person.phones[2]}<br/>
    输出person的cities的个别属性：${person.cities[0]}&nbsp;${person.cities[1]}&nbsp;${person.cities[2]}<br/>
    输出person的cities的所有属性：${person.cities}<br/>
    输出person的Map集合的所有属性：${person.map}<br/>
    输出person的Map集合中的某个key的值：${person.map.key1}&nbsp;${person.map.key2}&nbsp;${person.map.key3}

</body>
</html>
