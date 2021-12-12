<%@page import="com.spring.beans.boardPage"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var='root' value='${pageContext.request.contextPath}/'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>list</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${root }resources/css/all.css">

    <style>
        section{margin-top: 5%;}
        footer{padding-top: 78px; position: absolute;}
        table{margin-left: 25%; border-top: rgba(99, 186, 181) solid 1px; border-collapse: collapse; width: 47%; background-color: rgba(255, 255, 255, 0.5)}
        tr{height: 30px; border-bottom: rgba(99, 186, 181) solid 1px;}
        .d1{ width: 10%; text-align: center;}
        .d2{ width: 60%;}
        .d3{ width: 30%; text-align: center;}
        #r1{color: rgba(29, 104, 101); font-family: 'Jua', sans-serif; font-size: 20px;text-align: center;}
        #r2{font-family: 'Cute Font', cursive; font-size: 25px; color: rgba(29, 104, 101);}
        #pagesize{margin-left: 25%;}
        #index{position: relative;}
    </style>
</head>

<body>
<%
boardPage pages=(boardPage)request.getAttribute("pages");//������ �۾��� �� ���ڵ��� ������ ���� pages��� �Ӽ����� �����߾��µ�, �̰� �������� �ڵ�
	int number=pages.getContent_num();//ȭ�鿡 ��� �� ��ȣ
%>
<c:set var="url" value="/freeboard/list"/>
	<header>
		<jsp:include page="../header.jsp">
			<jsp:param value="${url }" name="url"/>
		</jsp:include>
	</header>

    <section>
    
    	<select id="pagesize" onChange="location.href=this.value">
    		<option selected="selected">�������� �� ��</option>
    		<option value="list?pageSize=5">5��</option>
    		<option value="list?pageSize=10">10��</option>
    		<option value="list?pageSize=15">15��</option>
    	</select>

        <table>
            <tr>
            	<td class="d1" id="r1">��ȣ</td>
                <td class="d2" id="r1">����</td>
                <td class="d3" id="r1">��¥</td>
            </tr>
            
            <c:forEach var="readboard" items="${list1 }">
	            <tr>
	            	<td class="d1" id="r2"><%= number-- %></td>
	                <td class="d2" id="r2"><a href="read?post_num=${readboard.post_num }">
	                <c:choose>
	                	<c:when test="${fn:length(readboard.post_sub) }>10">
	                	<c:out value="${fn:substring(readboard.post_sub,0,9) }">...</c:out>
	                	</c:when>
	                	<c:otherwise>
	                	<c:out value="${readboard.post_sub }"/>
	                	</c:otherwise>
	                </c:choose>
	                </a></td>
	                <td class="d3" id="r2">${readboard.post_date }</td>
	            </tr>
            </c:forEach>
        </table>

	<p align="center" id="index"><%
	if(pages.getStartPage()>10){
		%><a href="list?pageNum=<%=pages.getStartPage()-10 %>">[����]</a>&nbsp;
		<%
	}
	for(int i=pages.getStartPage(); i<=pages.getEndPage(); i++){
		%><a href="list?pageNum=<%=i%>">[<%=i %>]</a>&nbsp;
		<%
	}
	if(pages.getEndPage()<pages.getPageCount()){
		%><a href="list?pageNum=<%=pages.getStartPage()+10 %>">[����]</a>&nbsp;
		<%
	}
	%>
	
	</p>
    </section>
 
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>  


</body>

</html>