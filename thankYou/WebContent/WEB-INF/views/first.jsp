<%@page import="com.spring.beans.board"%>
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
    <title>Home</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${root }resources/css/all.css">

    <style>
        header{text-align: center; font-family: 'Jua', sans-serif; font-size: 50px; color: rgba(14, 59, 57);}
        section{text-align: center; margin-top: 7%; margin-bottom: 10%; font-family: 'Cute Font', cursive; font-size: 37px; }
        #ex{color: rgba(29, 104, 101);}
        img{width: 70px; height: 70px;  }
        button{text-align: center; color: rgba(36, 130, 126); width: 7%; font-size: 25px; border:rgba(99, 186, 181) solid 1px ;
            border-radius: 7px; font-family: 'Cute Font', cursive; cursor: pointer; }
        #b1, #b2{margin-right: 3%;}
        button:hover{color: rgba(255, 255, 255, 0.8); box-shadow: rgba(99, 186, 181, 0.7) 0 80px 0px 2px inset;}
    </style>
</head>

<body>
    <header>
        <p><img src="${root }resources/images/peaceL.png" >Thank You Note<img src="${root }resources/images//peaceR.png" ></p>
    </header>

    <section>

        <p id="ex">오늘은 어떤 하루를 보내셨나요?<br>오늘 하루를 되돌아보며 감사한 일을 떠올리고<br>
        감사 노트를 작성해 보아요</p>

        <button onclick="location.href='freeboard/write'" id="b1">글쓰기</button>
        <button onclick="location.href='freeboard/list'" id="b2">목록</button>
        <button onclick="location.href='meditation'" id="b3">명상</button>
        
    </section>
    
<footer>
    <jsp:include page="footer.jsp"/>
</footer>   

</body>

</html>