<!-- 
해당 코드는 페이지 직접적으로 실행하는게 아니라
notice_write를 통해 실행하는 것
 -->

<%@page import="java.io.*, com.oreilly.servlet.multipart.*, com.oreilly.servlet.*, com.java.www.BoardDao"%>
<%@page import="com.java.www.BoardDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <% if(session.getAttribute("sessionId")==null) {%>
    <script>alert("로그인을 하셔야 글쓰기가 가능합니다.");
    location.href="login.jsp";
    </script>
    <%}%>

  <meta charset="UTF-8">
  <title>Pages - Login</title>

</head>
<body>
  <%

/*   String uploadPath = "c:/upload";
  int size = 10*1024*1024; // 10MB
  String charset = "UTF-8";
  String filename = "";
  String userBtitle = "";
  String userBcontent = "";
  String userBfile = "";

  try {
    MultipartRequest multi = new MultipartRequest(request, uploadPath, size, charset, new DefaultFileRenamePolicy());
    userBtitle = multi.getParameter("btitle");
    userBcontent = multi.getParameter("bcontent");
    File file = multi.getFile("file");
    if (file != null) {
      filename = file.getName();
      userBfile = filename;
      // 파일 처리 작업 수행
    }
    
    String userId = (String) session.getAttribute("sessionId");
    BoardDao bdao = new BoardDao();
    int result = bdao.insertOne(userId, userBtitle, userBcontent, userBfile);
    
    // 파일 업로드 및 게시글 등록이 성공적으로 처리되었을 때의 동작
    // 예를 들어, 성공 메시지를 출력하고 리스트 페이지로 리다이렉트하는 등의 동작을 수행할 수 있습니다.
    response.sendRedirect("notice_list.jsp");
  } catch (IOException e) {
    e.printStackTrace();
    // 파일 업로드나 예외 처리 과정에서 오류가 발생했을 때의 동작
    // 예를 들어, 오류 메시지를 출력하고 이전 페이지로 이동하는 등의 동작을 수행할 수 있습니다.
  } 
   */
  
  /* 업로드에 대한 구문
  교수님이 작성한거 */ 
   
   String uploadPath = "c:/upload";
  int size = 10*1024*1024; // 10mb
  MultipartRequest multi = 
  new MultipartRequest(request,uploadPath,size,"utf-8",new DefaultFileRenamePolicy());

  String userId = (String) session.getAttribute("sessionId");
  String userBtitle = multi.getParameter("btitle");
  String userBcontent = multi.getParameter("bcontent");
  String userBfile = multi.getFilesystemName("bfile");

  BoardDao bdao = new BoardDao();
  int result = bdao.insertOne(userId,userBtitle,userBcontent,userBfile);   
   
  %>

  <script>
    alert("게시글이 등록되었습니다.");
    location.href ="notice_list.jsp";
  </script>
</body>
</html>