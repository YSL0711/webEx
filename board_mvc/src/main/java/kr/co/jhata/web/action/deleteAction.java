package kr.co.jhata.web.action;

import java.io.UnsupportedEncodingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class deleteAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 1.파라미터 bno 값 가져오기
		String b = "";
		try {
			req.setCharacterEncoding("UTF-8");
			
			b = req.getParameter("bno");
			if(b != null) {
				int bno = Integer.parseInt(b);
				
				BoardDAO dao = new BoardDAO();
				BoardVO vo = new BoardVO();
				dao.deleteOne(bno); 
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "board.do?cmd=list";
	}
}
		
		
	