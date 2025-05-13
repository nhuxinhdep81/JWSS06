<%@ page import="com.tien.ss06.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 13/05/2025
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
  Employee emp = (Employee) request.getAttribute("employee");
%>
<html>
<head>
  <title>Cập nhật nhân viên</title>
</head>
<body>
<h1>Cập nhật nhân viên</h1>
<form method="post" action="employees">
  <input type="hidden" name="action" value="edit"/>
  <input type="hidden" name="id" value="<%= emp.getId() %>"/>
  Tên: <input type="text" name="name" value="<%= emp.getName() %>" required/><br/>
  Ngày sinh: <input type="date" name="birthday" value="<%= emp.getBirthday() %>" required/><br/>
  SĐT: <input type="text" name="phone" value="<%= emp.getPhone() %>" required/><br/>
  Email: <input type="email" name="email" value="<%= emp.getEmail() %>" required/><br/>
  Lương: <input type="number" step="0.01" name="salary" value="<%= emp.getSalary() %>" required/><br/>
  Chức vụ: <input type="text" name="position" value="<%= emp.getPosition() %>" required/><br/>
  <button type="submit">Cập nhật</button>
  <a href="employees">Quay lại</a>
</form>
</body>
</html>

