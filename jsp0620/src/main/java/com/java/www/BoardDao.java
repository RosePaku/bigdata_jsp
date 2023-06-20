package com.java.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;;

public class BoardDao {

	// private로 막아야함 (접근 권한)
	private Context context;
	private DataSource dataSource;
	private Connection conn;
	private Board board;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private int bno, bhit, bgroup, bindent, bstep, result;
	private String id, btitle, bcontent, bfile;
	private Date bdate;

	private String query;

	// 게시글 저장
	public int insertOne(String userId, String userBtitle,
			String userBcontent, String userBfile) {
		try {
			conn = getConnection();
			query = " INSERT INTO board values ("
					+ "board_seq.nextval,?,?,?,sysdate,"
					+ "0,board_seq.currval,0,0,?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userBtitle);
			pstmt.setString(3, userBcontent);
			pstmt.setString(4, userBfile);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}// 게시글 저장

	// 게시글 1개 가져오기
	public Board selectOne(int userBno) {

		try {
			conn = getConnection();
			query = " SELECT * FROM Board WHERE bno=? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userBno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bno = rs.getInt("bno");
				id = rs.getString("id");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getDate("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bfile = rs.getString("bfile");
				board = new Board(bno, id, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bfile);

			} // while

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return board;
	}// 게시글 1개 가져오기

	// 게시글 전체가져오기
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = new ArrayList<>();

		try {
			conn = getConnection();
			query = " SELECT * FROM Board";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bno = rs.getInt("bno");
				id = rs.getString("id");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getDate("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bfile = rs.getString("bfile");
				list.add(new Board(bno, id, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bfile));

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;

	}// 게시글 전체가져오기

	// 커넥션 메소드
	public Connection getConnection() {
		Connection connection = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}// 커넥션 메소드
}