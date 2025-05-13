<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 13/05/2025
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="com.tien.ss06.model.Employee" %>
<%
  List<Employee> employees = (List<Employee>) request.getAttribute("employees");
  String keyword = request.getAttribute("keyword") != null ? (String) request.getAttribute("keyword") : "";
  String sortBy = (String) request.getAttribute("sortBy");
  int currentPage = (int) request.getAttribute("currentPage");
  int totalPages = (int) request.getAttribute("totalPages");
%>

<html>
<head>
  <title>Danh sách nhân viên</title>
</head>
<body>
<h1>Danh sách nhân viên</h1>

<form method="get" action="employees">
  <input type="text" name="keyword" value="<%= keyword %>" placeholder="Tìm theo tên hoặc ID"/>

  <button type="submit">Tìm kiếm</button>
  <a href="employees?action=add">Thêm nhân viên</a>
</form>

<table border="1" cellpadding="5" cellspacing="0">
  <tr>
    <th>ID</th><th>Tên</th><th>Ngày sinh</th><th>SĐT</th><th>Email</th><th>Lương</th><th>Chức vụ</th><th>Hành động</th>
  </tr>
  <% for (Employee emp : employees) { %>
  <tr>
    <td><%= emp.getId() %></td>
    <td><%= emp.getName() %></td>
    <td><%= emp.getBirthday() %></td>
    <td><%= emp.getPhone() %></td>
    <td><%= emp.getEmail() %></td>
    <td><%= emp.getSalary() %></td>
    <td><%= emp.getPosition() %></td>
    <td>
      <a href="employees?action=edit&id=<%= emp.getId() %>">Sửa</a> |
      <a href="employees?action=delete&id=<%= emp.getId() %>" onclick="return confirm('Xóa nhân viên này?')">Xóa</a>
    </td>
  </tr>
  <% } %>
</table>

<div>
  Trang:
  <% for (int i = 1; i <= totalPages; i++) { %>
  <a href="employees?page=<%= i %>&keyword=<%= keyword %>&sortBy=<%= sortBy %>">
    <%= i == currentPage ? ("<b>" + i + "</b>") : i %>
  </a>
  <% } %>
</div>
</body>
</html>

