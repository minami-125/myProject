<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value='${pageContext.request.contextPath }/'/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>meditation</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${root }resources/css/all.css">

    <style>
        section{margin-top: 3%; margin-bottom: 70px; font-family: 'Cute Font', cursive; color: rgba(29, 104, 101); text-align: center;}
        #t1{font-size: 50px; text-align: center; }
        img{width: 40px; height: 20px;}
        a{font-size: 30px; text-decoration: none; color: rgba(36, 130, 126);}
        table{ width: 40%; margin-left: 30%; text-align: center; border-spacing: 7px;}
        td{width: 10%; height: 60px;}
        .cell{background-color: rgba(255, 255, 255, 0.7);}

    </style>
</head>

<body>

	<header>
		<jsp:include page="header.jsp"/>
	</header>

    <section>
        <div id="t1">[YouTube 추천 채널]</div><br>

        <table>
            <tr>
                <td class="cell">
	                <a href="https://www.youtube.com/channel/UCBv2aQduvdXtYAAT3-EW41g/videos" target="blank">
	                <img src="${root }resources/images/youtube.png" ><br>닥터지하고</a></td>
                <td class="cell">
                	<a href="https://www.youtube.com/channel/UCKmEDAD5k5KFMcY5wvGIeGQ/videos" target="blank">
                	<img src="${root }resources/images/youtube.png"><br>에일린</a></td>
            </tr>
            <tr>
                <td class="cell">
                	<a href="https://www.youtube.com/c/MeditationandHealing/videos" target="blank">
                	<img src="${root }resources/images/youtube.png" ><br>Meditation and Healing</a></td>
                <td class="cell">
                	<a href="https://www.youtube.com/c/calm/videos" target="blank">
                	<img src="${root }resources/images/youtube.png"><br>Calm</a></td>
            </tr>
        </table>

    </section>

<footer>
	<jsp:include page="footer.jsp"/>
</footer>

</body>

</html>