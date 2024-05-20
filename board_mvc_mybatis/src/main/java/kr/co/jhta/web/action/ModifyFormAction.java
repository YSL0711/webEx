package kr.co.jhta.web.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jhta.web.dao.BoardDAO;
import kr.co.jhta.web.vo.BoardVO;

public class ModifyFormAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 1.파라미터 bno 값 가져오기
		String b = req.getParameter("bno");
		if (b != null) {
			int bno = Integer.parseInt(b);
			// 2. dao 생성
			BoardDAO dao = new BoardDAO();
			// 3. 특정 게시물 정보를 vo로 넘겨받기
			BoardVO vo = dao.getOne(bno);
			// 4.req 요청객체에 vo를 속성으로 지정
			req.setAttribute("vo", vo);
		}
		return "views/modifyForm.jsp";

	}
}
