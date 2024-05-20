package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import vo.EmpVO;


public class EmpDAO {

	// 1. 환경변수
	// 1. 멤버필드
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public EmpDAO() {

		try {
			// 2.드라이버로딩
			Class.forName(driver);
			// 3. Connection
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4. sql문장
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM EMP");

		// 5. sql문장 객체
		try {
			pstmt = conn.prepareStatement(sb.toString());

			// 6. 실행 (ResultSet)
			rs = pstmt.executeQuery();
			// 7. 레코드별 로직 처리
			// 목표 : 실행 ==> 사원정보를 출력
			// 부서번호 10인 사원의 사번, 이름, 급여, 부서번호
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				System.out.println(empno + ":" + ename + ":" + job + ":" + mgr + ":" + hiredate + ":" + sal + ":" + comm
						+ ":" + deptno);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public EmpVO searchEmp(int empno, String ename) {
		StringBuffer sb = new StringBuffer(); // StringBuffer 객체 선언

		// 쿼리 문자열을 StringBuffer에 추가
		sb.append("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno ");
		sb.append("FROM emp WHERE empno = ? OR ename = ?");

		EmpVO vo = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new EmpVO();
				vo.setEmpno(empno);
				vo.setEname(ename);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo;
	}

}
