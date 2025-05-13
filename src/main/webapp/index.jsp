<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="BookController?action=getAll">Bai 1</a>
<br/>
<a href="${pageContext.request.contextPath}/LoginController">Bài 2 - Đăng nhập</a>
<br/>
<a href="${pageContext.request.contextPath}/RegisterController">Bài 2 - Đăng ký</a>
<br>
<a href="employees">Bai 4</a>
</body>
</html>