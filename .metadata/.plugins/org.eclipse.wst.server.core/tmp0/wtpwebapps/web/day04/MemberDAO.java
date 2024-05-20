package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;

public class MemberDAO {

	// 1. 환경변수
	// 1. 멤버필드
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();

	public MemberDAO() {

		// 2.드라이버로딩
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}

	// 3.connection

	public MemberVO searchUser(String id, String pw) {

		sb.setLength(0);
		sb.append("SELECT id, pw, name FROM member WHERE id =? and pw = ? ");
		MemberVO vo = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				vo = new MemberVO();
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
