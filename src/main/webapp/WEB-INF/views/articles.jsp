<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Articles</title>
</head>
<p>Articles</p>
<body>
    <table border="2">
        <tr><th>TITLE</th><th>CREATED</th><th>CONTENT</th></tr>
        <c:forEach items="${lastArticles}" var="article">
            <tr><td>${article.title}</td><td>${article.created}</td><td>${fn:substring(article.content,0,200)}</td></tr>
        </c:forEach>
    </table>

    <p>Categories</p>
    <table border="2">
        <tr><th>NAME</th><th>GET ARTICLES</th></tr>
        <c:forEach items="${categories}" var="catagory">
            <tr><td>${catagory.name}</td><td><a href="/categories/${catagory.id}">get all articles</a></td></tr>
        </c:forEach>
    </table>
</body>
</html>
