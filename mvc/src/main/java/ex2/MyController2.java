package ex2;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyControl")
public class MyController2 extends HttpServlet {
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 한글처리
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 2. 파라미터 값 가져오기
		String cmd = req.getParameter("cmd");
		String url = "";
		String msg = "";
		// 3. 파라미터 값이 무엇인지에 따라 
		// 4. 이동할 url과 값을 결정, 전달 메세지 속성에 담기
		if(cmd == null || cmd.equals("kr")) {
			msg = "안녕하세요";
			url = "ex2/korea.jsp";
			req.setAttribute("msg", msg);
		} else if(cmd.equals("cn")) {
			msg = "니하오";
			url = "ex2/cn.jsp";
			req.setAttribute("msg", msg);
		} else if(cmd.equals("jp")) {
			msg = "곤방와";
			url = "ex2/cn.jsp";
			req.setAttribute("msg", msg);
		}
		// 5. forward
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
