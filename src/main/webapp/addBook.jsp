<%--
  Created by IntelliJ IDEA.
  User: hermi
  Date: 14/04/2022
  Time: 01:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add book</title>
</head>
<body>
    <h1>Add new book to db</h1>

    <form action="/demo-1.0/booksservlet" method="post">
        <%--@declare id="bname"--%>
        <%--@declare id="author"--%>
        <%--@declare id="quantity"--%>
        <label for="bname">Book name:</label><br>
        <input type="text" name="bname"><br>
        <label for="author">Author:</label><br>
        <input type="text" name="author"><br>
        <label for="quantity">Quantity in stock:</label><br>
        <input type="number" name="quantity"><br><br>
        <input type="submit" value="Submit">
    </form>

    <a href="index.jsp">Home</a>
</body>
</html>
