<%@ page import="com.java.www.Member"%>
<%@ page import="com.java.www.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dologin</title>
</head>
<body>
	<%
	String userId = request.getParameter("id");
	String userPw = request.getParameter("pw");
	MemberDao mdao = new MemberDao();
	Member member = mdao.selectLogin(userId, userPw);

	if (member != null) {

		session.setAttribute("sessionId", member.getId());
		session.setAttribute("sessionName", member.getName());

	%>

	<script>
		alert("로그인이 되었습니다");
		location.href = "main.jsp";
	</script>



	<%
	} else {
	%>
	<script>
		alert("다시 로그인 하세요.");
		history.back();
	</script>

	<!-- response.sendRedirect("login.jsp?loginCheck=0"); -->
	<%
	}
	%>



</body>
</html>