<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 13/05/2025
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <style>
    .container {
      width: 300px;
      margin: 0 auto;
      padding: 20px;
    }
    .error {
      color: red;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Login</h2>
  <% if (request.getAttribute("error") != null) { %>
  <p class="error"><%= request.getAttribute("error") %></p>
  <% } %>
  <form action="<%=request.getContextPath()%>/LoginController" method="post">
    <div>
      <label>Username:</label>
      <input type="text" name="username" required>
    </div>
    <div>
      <label>Password:</label>
      <input type="password" name="password" required>
    </div>
    <div>
      <input type="submit" value="Login">
    </div>
  </form>
  <p>Ban chua co tai khoan? <a href="views/b2/register.jsp">Register</a></p>
</div>
</body>
</html>
