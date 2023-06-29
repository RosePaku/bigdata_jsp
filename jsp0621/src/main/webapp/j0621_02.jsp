<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	   <c:set var="varName" value="홍길" /> <!-- 변수 varName에 "홍길"이라는 값을 할당 -->
	   <% String name="이순신"; %> <!-- 변수 name에 "이순신"이라는 문자열 할당 -->
	   <h3>이름 : <c:out value="${varName}" /> </h3> <!-- 변수 varName의 값을 출력 -->
	   <h3>이름 : ${varName } </h3> <!-- 변수 varName의 값을 출력 -->
	   <h3>스크립트릿 이름 : ${name} </h3> <!-- 변수 name의 값을 출력 -->
	   
	   <hr>
	   <c:if test="${varName =='홍길동' }"> <!-- 조건식(varName이 '홍길동'과 같은지)을 검사 -->
	      <h2>정답입니다. 홍길동</h2>
	   </c:if>
	   <c:if test="${varName !='홍길동' }"> <!-- 조건식(varName이 '홍길동'과 다른지)을 검사 -->
	      <h2>오답입니다. ${varName } 입니다.</h2>
	   </c:if>
	   
	   <hr>
	   <%if(name.equals("홍길동")){%> <!-- 조건식(name이 "홍길동"과 같은지)을 검사 -->
	    	<h2>정답입니다. 홍길동</h2> 
	   <%}else{%>
	    	 <h2>오답입니다. <%=name %> 입니다.</h2>
	   <%}%>
	   
	   <hr>
	   <c:forEach var="i" begin="1" end="10" step="1"> <!-- 1부터 10까지의 숫자를 반복하여 변수 i에 할당 -->
	      ${i}<br> <!-- 변수 i의 값을 출력 -->
	   </c:forEach>
	   <hr>
	   <h3>board객체</h3>
	   <h3>${board.bno}</h3> <!-- board 객체의 bno 속성 값을 출력 -->
	   <h3>${board.id}</h3> <!-- board 객체의 id 속성 값을 출력 -->
	   <h3>${board.btitle}</h3> <!-- board 객체의 btitle 속성 값을 출력 -->
	   
	   <hr>
	   <c:forEach var="b" items="${list}"> <!-- list에 있는 각 항목을 변수 b에 할당하여 반복 -->
	      <h3>${b.bno }</h3> <!-- 변수 b의 bno 속성 값을 출력 -->
	      <h3>${b.id }</h3> <!-- 변수 b의 id 속성 값을 출력 -->
	      <h3>${b.btitle }</h3> <!-- 변수 b의 btitle 속성 값을 출력 -->
	      <br>
	   </c:forEach>
	  
	</body>
</html>
