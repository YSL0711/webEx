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

	public MemberVO getOne(String id) {
        String query = "SELECT id, pw, name FROM member WHERE id = ?";
        MemberVO vo = null;

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                vo = new MemberVO();
                vo.setId(id);
                vo.setName(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }

	// addMember
	public void addMember(MemberVO vo) {
		// 4~7
		// SQL문 작성 전, 초기화 먼저 한다. sb는 stringBuffer인데 매번 새롭게 만든다.
		// 메모리 낭비가 생기겠지. 그 기존에 만들었던 내용을! 초기화하기 위해서.
		// sb길이를 0으로 만들어서 초기화.
		sb.setLength(0);

		// 4번째. sql문.
		sb.append("INSERT INTO member ");
		sb.append("VALUES (MEMBER_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ? )");

		// 5번째. 문장 객체
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getMotive());

			// 6.실행
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

	// 자원반납
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
