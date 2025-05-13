<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 13/05/2025
  Time: 06:58
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách các sách</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f6f8fa;
            padding: 20px;
        }

        h2 {
            color: #333;
        }

        form {
            margin-bottom: 20px;
        }

        .search-input {
            padding: 10px 15px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            transition: all 0.3s ease;
        }

        .search-input:focus {
            border-color: #007bff;
            outline: none;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
        }

        .search-button {
            padding: 10px 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 14px;
            cursor: pointer;
            margin-left: 5px;
            transition: background-color 0.3s ease;
        }

        .search-button:hover {
            background-color: #0056b3;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #e9f5ff;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-right: 8px;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>Danh sách các sách</h2>

<!-- Form tìm kiếm -->
<form action="BookController?action=search" method="post">
    <input type="text" name="bookId" placeholder="Nhập ID sách" class="search-input">
    <input type="text" name="bookName" placeholder="Nhập tên sách" class="search-input">
    <button type="submit" class="search-button">Tìm kiếm</button>
</form>

<!-- Bảng danh sách sách -->
<table>
    <tr>
        <th>ID</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Action</th>
    </tr>
    <c:forEach var="book" items="${listBooks}" >
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.quantity}</td>
            <td>
                <a href="<%=request.getContextPath()%>/BookController?bookId=${book.bookId}&&action=initUpdate">Sửa</a>
                <a href="<%=request.getContextPath()%>//BookController?bookId=${book.bookId}&&action=delete">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="views/b1/formAdd.jsp">Them sach</a>
</body>
</html>


