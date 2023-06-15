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
@WebServlet("/BirthConfirm")
public class BirthConfirm extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// form 모든데이터 -> request
		request.setCharacterEncoding("UTF-8");
		System.out.println("doAction");
		String birth = request.getParameter("birth");
		int num_birth = Integer.parseInt(birth);

		// System.currentTimeMillis()는
		// 현재 시간을 밀리초 단위로 반환하는 메서드입니다.
		// 이 값을 Date 클래스의 생성자에 전달하여
		// 현재 시간에 해당하는 Date 객체를 생성합니다.
		// Date today = new Date(System.currentTimeMillis());
		Date today = new Date();

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);

		int age = year - num_birth;
		System.out.println("당신의 출생년도 : " + num_birth);
		System.out.println("현재 년도 : " + year);
		System.out.println("당신의 나이 : " + age);
		String content = "";
		if (age >= 18) {
			content = "<h2 style='color:blue; font-weight:600;'>" + "주류 판매가 가능합니다." + "</h2>";
			;
		} else {
			content = "<h2 style='color:red; font-weight:600;'>" + "미성년자! 주류 판매 금지." + "</h2>";
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>미성년자 확인</title></head>");
		writer.println("<body>");
		writer.println(content);
		writer.println("</body>");
		writer.println("</html>");
		writer.close();

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
