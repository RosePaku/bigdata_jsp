<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>확인</title>
</head>
<body>
    <%
    String birth = request.getParameter("birth");
    int confirm = 0;
    /* 예외 처리 문구 */ 
    if (birth != null && !birth.isEmpty()) {
        confirm = 2013 - Integer.parseInt(birth);
    }

    if(confirm>=18){
    %>
    <script>alert("주류판매 가능");</script>
    <%
    out.println(confirm+"세 판매 가능.<br>");
    /* response.sendRedirect("https://gaga.tistory.com/53"); */
    }
    
    else {%>
        <script>alert("주류판매 불가");</script>
        <%
        out.println(confirm+"세 판매 금지");
    /* response.sendRedirect("https://namu.wiki/w/%EA%B8%88%EC%97%B0"); */
    }
    %>

</body>
</html>