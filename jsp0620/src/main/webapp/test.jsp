<!-- 23강 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- el 태그 -->
    <!-- 데이터를 넘겨 받아야지만 el 태그 가능 -->
    ${1}
    <%= request.getParameter("id") %>
    ${param.id}
    <%= session.getAttribute("sessionId") %>

    <!-- ${sessionScope.sessionId} -->
    ${sessionId} // 약식

    <!-- 아래는 불가능 -->
    <%--  <%if(${sessionId}==null) {%> --%> 

    ${1+2}
    ${1*2}
    ${3/2}
    <hr>
    <%
    out.println(1+2);
    %>
    <%= 1+2 %>
    

</body>
</html>