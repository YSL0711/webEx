package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.FileVO;

public class FileDAO {
	// 1~3 기본생성자
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();

	public FileDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
	public int getNumber() {
		sb.setLength(0);
//		별칭 ==> x처럼 
		sb.append("SELECT fuleup_no_seq.nextval x FROM dual ");
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			rs.next();
			result = rs.getInt("x");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<FileVO> selectAll() {
		sb.setLength(0);
		sb.append("SELECT no, title, writer, contents, ");
		sb.append("FROM fileuploadtest ");
		ArrayList<FileVO> list = new ArrayList<FileVO>();

		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				/* String filename = rs.getString("filename"); */
				/* FileVO vo = new FileVO(no, title, writer, contents, filename); */
				FileVO vo = new FileVO(no, title, writer, contents);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addOne(int filenumber, String title, String writer, String contents) {
		sb.setLength(0);
		sb.append("INSERT INTO fileuploadtest ");
		sb.append("VALUES (?, ? , ? , ? )" );
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, filenumber);
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setString(4, contents);
			/* pstmt.setString(4, filename); */
			int result = pstmt.executeUpdate();

			System.out.println("result : "+result);

		}catch(SQLException e){
		e.printStackTrace();
		}
	}

	//FileDAO 
	
	public void close() {
		try {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
