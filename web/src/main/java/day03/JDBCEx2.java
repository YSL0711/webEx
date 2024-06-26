package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//DAO(Data Access Object)

public class JDBCEx2 {

    public static void main(String[] args) {

        // 1. 환경변수
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "scott";
        String password = "tiger";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // 2. 드라이버로딩
        try {
            Class.forName(driver);
            // 3. Connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("conn : " + conn);
           
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 4. sql문장
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM EMP WHERE DEPTNO = 10");

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
                int sal = rs.getInt("sal");
                int deptno = rs.getInt("deptno");
                Date hiredate = rs.getDate("hiredate");
                System.out.println(empno + ":" + ename + ":" + sal + ":" + deptno + ":" + hiredate);
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
