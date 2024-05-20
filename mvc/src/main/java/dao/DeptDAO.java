package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.DeptVO;

public class DeptDAO {
	// 1. 멤버필드
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();
	
	// 생성자 2~3
	public DeptDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
	// 전제 데이터 가져오기 메서드 selectAll()
	public DeptVO selectOne(int deptno) {
		// 4~7
		sb.append("SELECT * FROM dept WHERE deptno = ?");
		DeptVO vo = null;
		try {
			// 5
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);	// 첫번째 ? 에 이 값을 할당해
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int dno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				vo = new DeptVO();
				vo.setDeptno(dno);
				vo.setDname(dname);
				vo.setLoc(loc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 부서번호로 부서정보 가져오기
		// 부서정보 : 부서번호, 부서명, 부서위치
		return vo;
	}
	
	// 전체조회
	public ArrayList<DeptVO> selectAll() {
		sb.setLength(0);	// 문자 길이를 0으로 (즉 있는 내용을 삭제)
		sb.append("SELECT deptno, dname, loc FROM dept");
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				DeptVO vo = new DeptVO(deptno, dname, loc);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertOne(DeptVO vo) {
		sb.setLength(0);
		sb.append("INSERT INTO dept VALUES(DEPT_DEPTNO.nextval, ?, ?)");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getDname());
			pstmt.setString(2, vo.getLoc());
			
			int result = pstmt.executeUpdate();
			
			System.out.println("result : " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateOne(DeptVO vo) {
		sb.setLength(0);
		sb.append("UPDATE dept SET dname = ?, loc = ? WHERE deptno = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getDname());
			pstmt.setString(2, vo.getLoc());
			pstmt.setInt(3, vo.getDeptno());
			
			int result = pstmt.executeUpdate();
			System.out.println("수정완료 : " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteOne(int deptno) {
		sb.setLength(0);
		sb.append("DELETE FROM dept WHERE deptno = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
	}
}
