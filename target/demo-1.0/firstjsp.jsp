<%--
  Created by IntelliJ IDEA.
  User: hermi
  Date: 08/04/2022
  Time: 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Testing JSP</h1>
    <p>
        <%@ page import="java.util.Date, com.example.demo.logic.TestClass" %>
        <%
            Date now = new Date();
            String someString = "Текущая дата: " + now;
        %>
        <%= someString %>
        <%
            for (int i = 0; i < 10; i++) {
                out.println("<p>" + "Hello: " + i + "</p>");
            }
        %>
    </p>
    <p>
        <%
            TestClass testClass = new TestClass();
        %>
        <%= testClass.getInfo() %>
    </p>
    <p>
        <%
            String name = request.getParameter("name");
            if (name == null)
                name = "Name";
//            String surname = request.getParameter("surname");
        %>

        <%= "Hello, " + name %>
    </p>
    <a href="index.jsp">Home</a>
</body>
</html>
