package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.Board;


public class BViewService implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int bno = Integer.parseInt(request.getParameter("bno")); // 파라미터값
		BoardDao bdao = new BoardDao(); // 객체선언
		bdao.updateHit(bno); // 조회수 1증가
		Board board = bdao.selectOne(bno); // 메소드호출 후 객체 받음

		request.setAttribute("board", board); // request추가

	}

}
