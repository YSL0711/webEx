package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.DeptVO;

public class TestMain {
	public static void main(String[] args) {
		System.out.println("Hello MyBatis World");

// 1. MyBatis 의 설정파일을 읽기
//Connection conn <== MyBatis에서는 SqlSession	<== SqlSessionFactory <== SqlSessionFactoryBuilder

		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");

//2. 건설 노동자 : SqlSessionFactoryBuilder
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

//3. 공장 건설
			SqlSessionFactory factory = builder.build(r);

//4. 설계도 닫기
			r.close();

//5. 자동차 생산
			SqlSession ss = factory.openSession(true); // true : auto commit , false 수동커밋

			System.out.println("ss : " + ss);

			// JDBC : Connection
			// MyBatis : SqlSession

//	ss.selectList("별칭명");
			System.out.println("---------------------------");

// 1건 추가
			DeptVO vo2 = new DeptVO(99, "회계", "LA");
			ss.insert("addOne", vo2);

			System.out.println("---------------------------");

			List<DeptVO> list = ss.selectList("AllDept");

			System.out.println("list : " + list);

			// for문 사용해서 부서번호 : 부서명 : 위치 형식으로 출력
			for (DeptVO vo : list) {
				System.out.println(vo.getDeptno() + " : " + vo.getDname() + " : " + vo.getLoc());
			}
			// Stream 사용해서 부서번호 : 부서명 : 위치 형식으로 출력
			list.stream()
					.forEach(vo -> System.out.println(vo.getDeptno() + " : " + vo.getDname() + " : " + vo.getLoc()));

			System.out.println("----------------------------");

			// 자바에서 var 쓰기. 자바스크립트 아닌가?
			// 가능한.
			/* var m = 100; */

// 1건 데이터 조회
			/* ss.selectOne("별칭", 전달매개변수); */
			DeptVO vo = ss.selectOne("selectOne", 20);

			System.out.println("1건 조회 : " + vo.getDeptno() + " : " + vo.getDname() + " : " + vo.getLoc());

			System.out.println("-------------------------");
			
// 2번 부서 확인..   1건 수정      부서명 IT | 지역 울산
	         DeptVO vo3 = new DeptVO();
	         vo3.setDeptno(2);
	         vo3.setDname("IT");
	         vo3.setLoc("울산");
	         
	         ss.update("modifyOne", vo3);
	         DeptVO vo4 = ss.selectOne("SelectOne", 2);
	         
	         System.out.println("수정 후 : " + vo4.getDeptno() + " : " + vo4.getDname() + " : " + vo4.getLoc());
			
// 3번 부서를 삭제

			ss.delete("deleteDeptOne", 3);

			// 6. 자원반납

			ss.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}