<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Dash</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>

<body class="bg-dark text-light">

<div class="container">


    <nav class="navbar navbar-dark bg-secondary navbar-expand-md">
        <style>
            .nav-item:hover, .navbar-toggler-icon, .dropdown-item:hover {
                background-color: lightgrey;
            }

        </style>


        <button class="navbar navbar-toggler" type="button" data-toggle="collapse" data-target="#mainMenu"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="mainMenu">

            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link text-dark active" href="/">Dash</a></li>
                <li class="nav-item dropdown">

                    <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">articles</a>

                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">add article</a>
                        <a class="dropdown-item" href="/articles">all articles</a>
                    </div>
                </li>
                <li class="nav-item dropdown">

                    <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">categories</a>

                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">add category</a>
                        <a class="dropdown-item" href="/categories">all categories</a>
                    </div>
                </li>
                <li class="nav-item dropdown">

                    <a class="nav-link text-dark dropdown-toggle" href="#" data-toggle="dropdown" role="button">authors</a>

                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">add author</a>
                        <a class="dropdown-item" href="#">all authors</a>
                    </div>
                </li>

            </ul>

        </div>

    </nav>

    <table class="table">
        <tr><th>TITLE</th><th>CREATED</th><th>CONTENT</th></tr>
        <c:forEach items="${articlesByCategory}" var="article">
            <tr><td>${article.title}</td><td>${article.created}</td><td>${article.content}</td></tr>
        </c:forEach>
    </table>


</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</div>
</body>
</html>
