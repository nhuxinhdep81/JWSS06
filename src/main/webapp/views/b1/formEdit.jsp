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
    <title>Cap nhat sach</title>
</head>
<body>
<h2>Cap nhat sach</h2>
<form action="<%=request.getContextPath()%>/BookController?action=update" method="post">

    <label for="id">ID sach:</label>
    <input type="text" name="bookId" id="id" value="${book.bookId}" readonly>

    <label for="bookName">Ten Sach:</label>
    <input type="text" name="bookName" id="bookName" value="${book.bookName}">

    <label for="author">Ten tac gia:</label>
    <input type="text" name="author" id="author" value="${book.author}">

    <label for="quantity">So luong:</label>
    <input type="number" name="quantity" id="quantity" value="${book.quantity}">

    <button type="submit">Sua sach</button>
</form>
</body>
</html>
