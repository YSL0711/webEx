package kr.co.jhta.web.action;

import java.io.UnsupportedEncodingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 1.파라미터 bno 값 가져오기
		String b = "";
		try {
			req.setCharacterEncoding("UTF-8");
			
			b = req.getParameter("bno");
			if(b != null) {
				int bno = Integer.parseInt(b);
				String writer = req.getParameter("writer");
				String title = req.getParameter("title");
				String contents = req.getParameter("contents");
				
				BoardDAO dao = new BoardDAO();
				BoardVO vo = new BoardVO();
				vo.setBno(bno);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContents(contents);
				dao.updateOne(vo); 
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "board.do?cmd=detail&bno="+b;
	}
}
		
		
	