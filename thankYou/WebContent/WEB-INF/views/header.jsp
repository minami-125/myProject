<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value='${pageContext.request.contextPath}/'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>header</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">

    <style>
        header{font-family: 'Jua', sans-serif; font-size: 30px; height: 105px;}
        img{width: 130px; height: 90px; margin: 5px;}
        .menu {margin-left: 4%;}
        #one{margin-left: 29%;}
        a{text-decoration: none; color: rgba(36, 130, 126);}
    </style>
</head>

<body>
    <header>
        <div>
            <a href="${root }"><img src="${root }resources/images/peace.png"></a>
            <a href="${root }freeboard/write"><span class="menu" id="one">write</span></a>
            <a href="${root }freeboard/list"><span class="menu">list</span></a>
            <a href="${root }meditation"><span class="menu">meditation</span></a>
        </div>
    </header>

</body>

</html>