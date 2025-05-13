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
  <title>Register</title>
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
  <h2>Register</h2>
  <% if (request.getAttribute("error") != null) { %>
  <p class="error"><%= request.getAttribute("error") %></p>
  <% } %>
  <form action="<%=request.getContextPath()%>/RegisterController" method="post">
    <div>
      <label>Username:</label>
      <input type="text" name="username" required>
    </div>
    <div>
      <label>Password:</label>
      <input type="password" name="password" required>
    </div>
    <div>
      <label>Email:</label>
      <input type="email" name="email" required>
    </div>
    <div>
      <label>Phone:</label>
      <input type="text" name="phone">
    </div>
    <div>
      <input type="submit" value="Register">
    </div>
  </form>
  <p>Ban da co tai khoan? <a href="views/b2/login.jsp">Login</a></p>
</div>
</body>
</html>
