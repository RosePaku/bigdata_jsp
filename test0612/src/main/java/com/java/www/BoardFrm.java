package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormMeber
 */
@WebServlet("/BoardFrm")
public class BoardFrm extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// form 모든데이터 -> request
		request.setCharacterEncoding("UTF-8");
		System.out.println("doAction");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);

		// response.setContentType("text/html; charset=UTF-8");
		// PrintWriter writer = response.getWriter();
		// writer.println("<html>");
		// writer.println("<head><title>미성년자 확인</title></head>");
		// writer.println("<body>");
		// writer.println(content);
		// writer.println("</body>");
		// writer.println("</html>");
		// writer.close();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}
