<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 13/05/2025
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Trang chủ</title>
  <style>
    .container {
      width: 400px;
      margin: 50px auto;
      padding: 20px;
      border: 1px solid #ccc;
      text-align: center;
    }
    .success {
      color: green;
    }
    .user-info {
      margin-top: 10px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2 class="success">Đăng nhập thành công!</h2>
  <p>Chào mừng bạn đến với trang chủ.</p>

  <c:if test="${not empty user}">
    <div class="user-info">
      <p>Thông tin người dùng:</p>
      <p>Tên đăng nhập: ${user.username}</p>
      <p>Email: ${user.email}</p>
      <p>Số điện thoại: ${user.phone}</p>
    </div>
  </c:if>

  <p><a href="${pageContext.request.contextPath}/index.jsp">Đăng xuất</a></p>
</div>
</body>
</html>
