package kr.co.jhta.web.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.jhta.web.vo.BoardVO;

public class BoardDAO {

	public SqlSessionFactory factory;

	public BoardDAO() {
		// 설계도
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			// 건설노동자
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// 공장
			factory = builder.build(r);
			// 설계도 닫기
			r.close();
		} catch (IOException e) {
			System.out.println("config.xml파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}

	public int getTotalCount() {
		SqlSession ss = factory.openSession(true); // openSession(true) : autocommit
//		ss.selectOne("별칭", 매개변수);
		int count = ss.selectOne("kr.co.jhta.board.getTotal"); // 별칭 : namespace명.id
		ss.close();
		return count;
	}

	// 전체 게시물
	public List<BoardVO> selectAll(int startNo, int endNo) {
		SqlSession ss = factory.openSession(true);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNo", startNo);
		map.put("endNo", endNo);
		//ss.selectList("별칭", map);

		List<BoardVO> list = ss.selectList("kr.co.jhta.board.allSelectBoard", map);
		ss.close();
		return list;
	}
	
	public void addOne(BoardVO vo) {
		SqlSession ss = factory.openSession(true);
		/* ss.insert("별칭", 전달객체); */
		ss.insert("kr.co.jhta.board.addOne", vo);
		ss.close();
	}
	
	public BoardVO getOne(int bno) {
		SqlSession ss = factory.openSession(true);
		BoardVO vo = ss.selectOne("kr.co.jhta.board.getOne", bno);
		ss.close();
		return vo;
	}
	
	public void updateOne(BoardVO vo) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.board.updateOne", vo);
		ss.close();
	}
	
	public void deleteOne(int bno) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.board.deleteOne", bno);
		ss.close();
	}
	
}