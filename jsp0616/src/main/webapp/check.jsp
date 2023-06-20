<%@page import="org.apache.catalina.util.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	  <%
	     // 사용자로부터 전달받은 파라미터 값 가져오기
	     String id = request.getParameter("id");
	     String name = request.getParameter("name");
	     String[] hobbys = request.getParameterValues("hobbys");
	     
	     // id가 "aaa", "bbb", "ccc" 중 하나와 일치하면
	     if (id != null && (id.equals("aaa") || id.equals("bbb") || id.equals("ccc"))) {
	    	 // memberCheck=0을 파라미터로 가지고 join02_info_input.jsp로 리다이렉트
	    	 response.sendRedirect("join02_info_input.jsp?memberCheck=0");
	     } else {
	    	 // id와 name을 파라미터로 가지고 join03_success.jsp로 리다이렉트
	    	 response.sendRedirect("join03_success.jsp?id=" + id + "&name=" + name);
	     }
	  %>
	
	</body>
</html>
