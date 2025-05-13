<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 13/05/2025
  Time: 07:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them moi sach</title>
    <h2>Them moi sach</h2>
</head>
<body>
<form action="<%=request.getContextPath()%>/BookController?action=add" method="post">
    <label for="bookName">Ten Sach:</label>
    <input type="text" name="bookName" id="bookName">

    <label for="author">Ten tac gia:</label>
    <input type="text" name="author" id="author">

    <label for="quantity">So luong:</label>
    <input type="number" name="quantity" id="quantity">

    <button type="submit">Them sach</button>
</form>

</body>
</html>
