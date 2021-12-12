<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value='${pageContext.request.contextPath}/'/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>update</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${root }resources/css/all.css">

    <style>
		section{margin-left: 25%; margin-top: 5%;}
		footer{height: 30%;}
        textarea{align-items: center; font-size: 20px; font-weight: lighter; text-decoration-line: none; font-family: 'Jua', sans-serif;
                background-color: white; opacity: 80%; color: black;}
        #b1{margin-left:20%; margin-right: 3%;}
        #b2{margin-right: 3%;}
        button{text-align: center; color: rgba(36, 130, 126);   font-family: 'Cute Font', cursive;
                cursor: pointer; border:rgba(99, 186, 181) solid 1px;  border-radius: 7px; width: 8%; font-size: 25px; margin-top: 2%;}
        button:hover{color: rgba(255, 255, 255, 0.8); box-shadow: rgba(99, 186, 181, 0.7) 0 80px 0px 2px inset;}
    </style>
</head>

<body>

	<header>
		<jsp:include page="../header.jsp">
			<jsp:param value="${url }" name="url"/>
		</jsp:include>
	</header>

<form action="updateProc" method="post">
    <section>

        <textarea name="post_sub" cols="70" rows="15">${board.post_sub }</textarea><br>
        <input type="hidden" name="post_num" value="${board.post_num }"/>
        <button id="b1" type="button" onclick='location.href="list"'>목록</button>
        <button type="reset" id="b2">초기화</button>
		<button type="submit" id="b3">수정</button>

    </section>
</form>

<footer>
	<jsp:include page="../footer.jsp"/>
</footer>
</body>

</html>