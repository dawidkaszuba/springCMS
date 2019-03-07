<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Articles in Category</title>
</head>
<body>
    <table border="2">
        <tr><th>TITLE</th><th>CREATED</th><th>CONTENT</th></tr>
        <c:forEach items="${articlesByCategory}" var="article">
            <tr><td>${article.title}</td><td>${article.created}</td><td>${article.content}</td></tr>
        </c:forEach>
    </table>

</body>
</html>
