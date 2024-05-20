package day04;

import dao.MemberDAO;
import jakarta.servlet.http.Cookie;
import vo.MemberVO;

public class TestMain2 {

	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = dao.searchUser("aaa", "bbb");
		
		System.out.println("vo : " + vo);
		
		System.out.println("name : " + vo.getName());
		
		
		Cookie c;
	}

}
