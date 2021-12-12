<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <c:set var='root' value='${pageContext.request.contextPath}/'/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>write</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${root }resources/css/all.css">

    <style>
        section{float: left; width: 70%; margin-top: 5%;}
        textarea{align-items: center; font-size: 20px; font-weight: lighter; text-decoration-line: none; font-family: 'Jua', sans-serif;
                background-color: white; opacity: 80%; color: black;}
        #b1{margin-left: 20%; margin-right: 3%;}
        #b2{margin-right: 3%;}
        button{text-align: center; color: rgba(36, 130, 126);   font-family: 'Cute Font', cursive;
                cursor: pointer; border:rgba(99, 186, 181) solid 1px;  border-radius: 7px; width: 8%; font-size: 25px; margin-top:2%}
        button:hover{color: rgba(255, 255, 255, 0.8); box-shadow: rgba(99, 186, 181, 0.7) 0 80px 0px 2px inset;}
        nav{width: 30%; height: 300px; float: left; margin-top: 7%;}
        #tip1{width: 30%; font-size:22px; margin-left: 20%;}
        #tipbox{width: 250px; height: 150px; margin-top: 20px; font-size: 15px; display: none;
        		font-weight: lighter; text-decoration-line: none; font-family: 'Jua', sans-serif; margin-left: 15%; margint-top: 5%;}
    </style>
    
	<script>
	$(function(){
		$("#tip1").click(function(){
			$("#tipbox").slideToggle("slow");
		});
	});
</script>
    
</head>

<body>

	<header>
		<jsp:include page="../header.jsp">
			<jsp:param value="${url }" name="url"/>
		</jsp:include>
	</header>
	
	<nav>
	<button id="tip1">감사 일기 쓰는 Tip</button>
        <div id="tipbox">
        1. 매일 3가지 이상 감사 일기를 쓴다.<br>
        2. 구체적으로 감사의 이유를 적는다.<br>
        3.'때문에'가 아니라 '덕분에'라고 쓴다.<br>
        4. 모든 문장을 감사합니다로 마무리 한다.
        </div>
	</nav>

<form action="insert" method="post">
    <section>
        
        <textarea name="post_sub" cols="70" rows="15" placeholder="오늘의 감사한 일을 적어볼까요?" ></textarea><br>
        <button id="b1" type="button" onclick="history.go(-1)">뒤로가기</button>
        <button type="reset" id="b2" >초기화</button>
		<button type="submit" id="b3" >등록</button>

    </section>
</form>

<footer>
	<jsp:include page="../footer.jsp"/>
</footer>

</body>

</html>