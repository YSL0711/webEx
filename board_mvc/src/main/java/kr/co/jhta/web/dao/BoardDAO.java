package kr.co.jhta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.jhta.web.vo.BoardVO;


public class BoardDAO {
	private Connection conn;

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();

	public BoardDAO() {
		conn = DBConnection.getInstance().getConnection();

	} // BoardDAO() end

	// 전체 조회
	public ArrayList<kr.co.jhta.web.vo.BoardVO> selectAll(int startNo, int endNo) {
		sb.setLength(0);
		sb.append("SELECT rn, bno, writer, title, contents, regdate, hits, ip, status ");
		sb.append("FROM (SELECT ROWNUM rn, bno, writer, title, contents, regdate, hits, ip, status ");
		sb.append("FROM (SELECT bno, writer, title, contents, regdate, hits, ip, status ");
		sb.append("FROM board ");
		sb.append("ORDER BY bno desc ) ");	
		//SQL 쓸 때 윗 문장 뒤에 어떤 물음표가 나오느냐 순으로 셋해줘야 함.
		sb.append("WHERE ROWNUM <= ? ) "); //끝번호
		sb.append("WHERE RN >= ? ");  //시작번호
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, endNo);
			pstmt.setInt(2, startNo);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String regdate = rs.getString("regdate");
				int hits = rs.getInt("hits");
				String ip = rs.getString("ip");
				int status = rs.getInt("status");

				BoardVO vo = new BoardVO(bno, writer, title, contents, regdate, hits, ip, status);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	} // selectAll() End

	// 1건 조회
	public BoardVO getOne(int bno) {
		sb.setLength(0);
		sb.append("SELECT bno, writer, title, contents, to_char(regdate, 'yyyy-mm-dd hh24:mi') regdate, hits, ip, status ");
		sb.append("FROM board WHERE bno = ?");
		BoardVO vo = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String regdate = rs.getString("regdate");
				int hits = rs.getInt("hits");
				String ip = rs.getString("ip");
				int status = rs.getInt("status");

				vo = new BoardVO(bno, writer, title, contents, regdate, hits, ip, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return vo;
	} // getOne() End

	// 1건 추가
	public void addOne(BoardVO vo) {
		sb.setLength(0);
		sb.append("INSERT INTO board ");
		sb.append("VALUES (board_bno_seq.nextval, ?, ?, ?, SYSDATE, 0, ?, 1 )");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContents());
			pstmt.setString(4, vo.getIp());

			int result = pstmt.executeUpdate();
			System.out.println("insert result : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	} // addOne() End

	// 1건 변경
	public void updateOne(BoardVO vo) {
		// 제목, 내용, 작성자만 변경
		sb.setLength(0);
		sb.append("UPDATE board ");
		sb.append("SET writer = ?, title = ?, contents = ? ");
		sb.append("WHERE bno = ? ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getBno());

			int result = pstmt.executeUpdate();
			System.out.println("update result : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	} // updateOne() End

	// 1건 삭제
	public void deleteOne(int bno) {
		// 게시물 번호로 게시물 삭제
		sb.setLength(0);
		sb.append("DELETE FROM board ");
		sb.append("WHERE bno = ?");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, bno);
			int result = pstmt.executeUpdate();
			System.out.println("delete result : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	} // deleteOne() End

	public void raiseHits(int bno) {
	    sb.setLength(0);
	    sb.append("UPDATE board SET hits = hits + 1 WHERE bno = ? ");

	    try {
	        pstmt = conn.prepareStatement(sb.toString());
	        pstmt.setInt(1, bno);
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public int getTotalCount() {
		sb.setLength(0);
		sb.append("SELECT COUNT(*) cnt FROM BOARD ");
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			rs.next();
			
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
