package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import vo.MemberVO;
import vo.ProductVO;

public class ProductDAO {

	/*
	 * 1~3 기본생성자
	 */
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();

//	생성자 웹에서는 퍼블릭으로 만들자
	public ProductDAO() {
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

	// 다수 제품 정보 불러오기
	public ArrayList<ProductVO> getData(Set<Integer> key) {
		sb.setLength(0);
		sb.append("SELECT pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile ");
		sb.append("FROM product ");
		sb.append("WHERE pno = ? ");
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		try {
			pstmt = conn.prepareStatement(sb.toString());

			for (Integer pno : key) {
				pstmt.setInt(1, pno);
				rs = pstmt.executeQuery();
				rs.next();

				String pname = rs.getString("pname");
				int price = rs.getInt("price");
				int dcratio = rs.getInt("dcratio");
				String prodesc = rs.getString("prodesc");
				int qty = rs.getInt("qty");
				String imgfile = rs.getString("imgfile");
				String bigfile = rs.getString("bigfile");

				ProductVO vo = new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

//	전체조회 : selectAll() 4~7

//	어레이리스트, 리스트 다 쓸 수 있다.
//	리스트는 인터페이스. 어레이리스트는 그 인터페이스의 구현이므로.

	public ArrayList<ProductVO> selectAll() {
		// 4.SQL문
		sb.setLength(0); // 문자 길이를 0으로(즉 있는 내용 삭제)
		// 일할 땐 * 쓰지 마세요. 나중에 추가하므로, 컬럼명 직접 쓰는 게 나음.
		sb.append("SELECT pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile ");
		sb.append("FROM product ");
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		try {
			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				int price = rs.getInt("price");
				int dcratio = rs.getInt("dcratio");
				String prodesc = rs.getString("prodesc");
				int qty = rs.getInt("qty");
				String imgfile = rs.getString("imgfile");
				String bigfile = rs.getString("bigfile");

				ProductVO vo = new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile);
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 1건조회: getOne(int pno);
	 */

	public ProductVO getOne(int pno) {

		sb.setLength(0);
		sb.append("SELECT pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile ");
		sb.append("FROM product ");
		sb.append("WHERE pno =?");
		ProductVO vo = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String pname = rs.getString("pname");
				int price = rs.getInt("price");
				int dcratio = rs.getInt("dcratio");
				String prodesc = rs.getString("prodesc");
				int qty = rs.getInt("qty");
				String imgfile = rs.getString("imgfile");
				String bigfile = rs.getString("bigfile");

				vo = new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	/*
	 * 상품명으로도 찾겄지! 문자열에 패턴으로 검색하는 연산자? ==> like 이퀄 쓰면 아스키 코드로 검색 = 대소문자까지 같아야.
	 */

	// public ArrayList<ProductVO> findByName(String pname)
	// like 연산자 포함

	public ArrayList<ProductVO> findByName(String pname) {
		sb.setLength(0);
		sb.append("SELECT pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile ");
		sb.append("FROM product ");
		sb.append("WHERE pname like ? ");
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 물음표 채워주기!
			pstmt.setString(1, "%" + pname + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int pno = rs.getInt("pno");
				int price = rs.getInt("price");
				int dcratio = rs.getInt("dcratio");
				String prodesc = rs.getString("prodesc");
				int qty = rs.getInt("qty");
				String imgfile = rs.getString("imgfile");
				String bigfile = rs.getString("bigfile");

				ProductVO vo = new ProductVO(pno, pname, price, dcratio, prodesc, qty, imgfile, bigfile);
				list.add(vo);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
