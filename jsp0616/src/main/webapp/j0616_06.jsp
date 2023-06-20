<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>bean</title>
</head>
<body>
<%
 request.setCharacterEncoding("UTF-8");
%>



  <jsp:useBean id="student" class="com.java.www.Student" />
  
  <!-- 7번 겟할 때 -->
  <jsp:setProperty property="*" name="student" />


<!-- 6번 겟할 때 -->
<%--   <jsp:setProperty property="stuNo" name="student" value="1" />
  <jsp:setProperty property="name" name="student" value="honggildong" />
  <jsp:setProperty property="kor" name="student" value="100" /> 
  <jsp:setProperty property="eng" name="student" value="100" />
  <jsp:setProperty property="math" name="student" value="100" /> --%>
  
 학번 : <jsp:getProperty property="stuNo" name="student" />
 이름 : <jsp:getProperty property="name" name="student" />
 국어 : <jsp:getProperty property="kor" name="student" />
 영어 : <jsp:getProperty property="eng" name="student" />
 수학 : <jsp:getProperty property="math" name="student" />
</body>
</html>