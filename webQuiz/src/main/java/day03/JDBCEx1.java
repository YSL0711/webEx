package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx1 {

	//데이터베이스에 연결하는 8steps
	//	01==> 다른 방법
	
	public static void main(String[] args) {
		// 1. 환경변수
		// final이나 private 다는 것이 보안에 좋음
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "scott";
		String password = "tiger";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		// 2. 드라이버로딩
		try {
			Class.forName(driver);
			// 3. Connectiofn
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("conn : " + conn);
			DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패(클래스를 못 찾았음)");

		} catch (SQLException e) {
			e.printStackTrace(); // 원인 모름,,, 스택을 추적해서 출력
		}

		// 4. sql문장
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT*FROM DEPT");

		// 5. sql문장 객체
		try {
			pstmt = conn.prepareStatement(sb.toString());

			// 6. 실행 (ResultSet)
			rs = pstmt.executeQuery();

			// 7. 레코드별 로직 처리
//			for (int i = 0; i < 4; i++) {
			while (rs.next()) {
				// rs.next(); // 전달받은 리절트셋의 첫 번째 레코드로 이동
				int deptno = rs.getInt("deptno"/* 1 << 넣을 수도 있음 */);
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + ":" + dname + ":" + loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			// 8. 자원반납
		} finally {
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

}
