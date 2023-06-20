package com.java.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;;

public class MemberDao {

	// private로 막아야함 (접근 권한)
	private Context context = null;
	private DataSource dataSource = null;
	private Connection conn = null;
	private Member member = null;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String id, pw, name, phone, gender, hobby;
	private String query;

	// 로그인 메소드
	public Member selectLogin(String userId, String userPw) {
		try {
			conn = getConnection();
			query = "select * from member WHERE id=? and pw=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				name = rs.getString("name");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				hobby = rs.getString("hobby");
				member = new Member(id, pw, name, phone, gender, hobby);

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
		return member;

	}// 로그인 메소드

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