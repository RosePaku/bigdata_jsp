<!-- login_cookie -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--아이디를 쿠키에 저장하기 cid,cpw-->
	<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    // 아이디와 비밀번호가 "admin"과 "1234"와 일치하지 않을 경우

    if(!(id.equals("admin") && pw.equals("1234"))){
        // 로그인 실패를 나타내는 login_cookie.jsp로 리다이렉트
        response.sendRedirect("login_cookie.jsp?idCheck=0");
    }
    /* <!-- 쿠키 저장 --> */
    // cid 쿠키 생성 및 설정
    Cookie cid = new Cookie("cid",id); 
    cid.setMaxAge(60*60); // 쿠키의 유효 시간 설정 (1시간)
    response.addCookie(cid); // 쿠키를 응답 헤더에 추가

    // cpw 쿠키 생성 및 설정
    Cookie cpw = new Cookie("cpw",pw);
    cpw.setMaxAge(60*60); // 쿠키의 유효 시간 설정 (1시간)
    response.addCookie(cpw); // 쿠키를 응답 헤더에 추가

    out.println("id : "+id+"<br>");
    out.println("pw : "+pw+"<br>");

    %>
	<a href="login_confirm.jsp">쿠키확인</a>
</body>
</html>