<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 13/05/2025
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Thêm nhân viên</title>
</head>
<body>
<h1>Thêm nhân viên mới</h1>
<form method="post" action="employees">
  <input type="hidden" name="action" value="add"/>
  Tên: <input type="text" name="name" required/><br/>
  Ngày sinh: <input type="date" name="birthday" required/><br/>
  SĐT: <input type="text" name="phone" required/><br/>
  Email: <input type="email" name="email" required/><br/>
  Lương: <input type="number" step="0.01" name="salary" required/><br/>
  Chức vụ: <input type="text" name="position" required/><br/>
  <button type="submit">Thêm</button>
  <a href="employees">Quay lại</a>
</form>
</body>
</html>

