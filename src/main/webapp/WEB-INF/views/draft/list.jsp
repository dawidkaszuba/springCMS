<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Drafts</title>
    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta lang="pl">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>

<body class="bg-dark text-light">

<div class="container">
    <jsp:include page="../fragments/header.jsp"/>

    <h1>Drafts</h1>
    <div class="row">
        <div class="col-md-3">
            <span>TITLE</span>
        </div>
        <div class="col-md-5">
            <span>CONTENT</span>
        </div>
        <div class="col-md-1">
            <span>EDIT</span>
        </div>
        <div class="col-md-1">
            <span>DELETE</span>
        </div>
    </div>

    <div class="row">
        <c:forEach items="${drafts}" var="draft">
            <div class="col-md-3">
                <div><p><span>${draft.title}</span></p></div>
            </div>
            <div class="col-md-5">
                <div><p><span>${fn:substring(draft.content,0,200)}</span></p></div>
            </div>
            <div class="col-md-1">
                <div><a href="/drafts/edit/${draft.id}">edit</a></div>
            </div>
            <div class="col-md-1">
                <div><a href="/drafts/delete/${draft.id}">delete</a></div>
            </div>

        </c:forEach>
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
