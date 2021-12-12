<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <c:set var='root' value='${pageContext.request.contextPath}/'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>read</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${root }resources/css/all.css">

    <style>
        section{margin-left: 25%; margin-top: 5%;}
        #content{align-items: center; font-size: 20px; font-weight: lighter; text-decoration-line: none; font-family: 'Jua', sans-serif;
                background-color: white; opacity: 80%; color: rgba(36, 130, 126); border: 1px solid black; width: 748px; height: 380px;}
        #bu1{margin-left: 20%}
        #bu2, #bu3{margin-left: 3%;}
        button{text-align: center; color: rgba(36, 130, 126);   font-family: 'Cute Font', cursive;
                cursor: pointer; border:rgba(99, 186, 181) solid 1px;  border-radius: 7px; width: 8%; font-size: 25px;}
        button:hover{color: rgba(255, 255, 255, 0.8); box-shadow: rgba(99, 186, 181, 0.7) 0 80px 0px 2px inset;}
    </style>
</head>

<body>

<header>
	<jsp:include page="../header.jsp">
		<jsp:param value="${url }" name="url"/>
	</jsp:include>
</header>

<script type="text/javascript">
function deleteCheck(){
	var conf = confirm("정말로 삭제하시겠습니까?");
	if(conf==true){
		location.href='deleteProc?postNum=${board.post_num}';
	}
}
</script>
    <section>

        <div id="content">${board.post_sub }</div><br>
        <input type="hidden" name="post_num" value="${board.post_num }">
        <button id="bu1" onclick="history.go(-1)">뒤로가기</button>
        <button id="bu2" onclick="location.href='update?post_num=${board.post_num }'">수정</button>
        <button id="bu3" onclick="deleteCheck()">삭제</button>

    </section>

<footer>
	<jsp:include page="../footer.jsp"/>
</footer>


</body>

</html>