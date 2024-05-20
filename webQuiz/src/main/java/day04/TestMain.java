package day04;

import java.util.ArrayList;

import dao.DeptDAO;
import vo.DeptVO;

public class TestMain {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		
		DeptVO vo = dao.selectOne(30);
		
		System.out.println("vo : " + vo);
		
		System.out.println("--------------------------");
		
		ArrayList<DeptVO> list = dao.selelctAll();

		System.out.println(list);
		
		System.out.println("--------------------------");
		
		DeptVO vo2 = new DeptVO();
		vo2.setDname("AI");
		vo2.setLoc("부산");
		
		dao.insertOne(vo2);
		
		DeptVO vo3 = new DeptVO(1, "영업", "대구");
		dao.updateOne(vo3);
		
		dao.deleteOne(2);
	}

}
