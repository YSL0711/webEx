package day06;

import java.util.ArrayList;
import java.util.HashSet;

import dao.ProductDAO;
import vo.ProductVO;

public class TestMain2 {
	public static void main(String[] args) {
		
		ProductDAO dao = new ProductDAO();
		HashSet hs = new HashSet<Integer>();
		hs.add(3);
		hs.add(3);
		hs.add(11);
		
		ArrayList<ProductVO> list = dao.getData(hs);
		System.out.println("사이즈 : " + list.size());
		System.out.println("list : " + list);
		

	}

}
