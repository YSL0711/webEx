package kr.co.jhta.web.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.jhta.web.vo.EmpVO;


public class EmpDAO {
	private SqlSessionFactory factory;

	public EmpDAO() {

		// 1. 설계도
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			// 2. 건설노동자
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

			// 3. 공장
			factory = builder.build(r);
			// 4. 설계도 닫기
			r.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}// constructor end

	// 전체조회
	public List<EmpVO> selectAll(){
		//공장으로부터 자동차 생성
		SqlSession ss = factory.openSession(true);
		List<EmpVO> list = ss.selectList("AllDept");
		return list;

	}
	
	
	public void addOne(EmpVO vo ) {
			SqlSession ss = factory.openSession(true);

			/*ss.insert("별칭", 전달파라미터);*/
			ss.insert("addOne", vo);
			ss.close();
			}

}
