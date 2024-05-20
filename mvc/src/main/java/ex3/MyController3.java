package ex3;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mc")
public class MyController3 extends HttpServlet {
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String type = req.getParameter("type");
		String url = "";
		String msg = "";
		ActionCommand ac = new HelloCommand();
		if (type == null || type.equals("hello")) {
			// 3. 파라미터 값에 따라 ur1, 데이터 지정
//			url = "ex3/hello.jsp";
//			msg = "안녕하세요";
			ac = new HelloCommand();
		} else if (type.equals("ip")) {
			ac = new IPCommand();
		} else if (type.equals("now")) {
			ac = new NowCommand();
		} else if (type.equals("dept")) {
			ac = new DeptCommand();
		}

		url = ac.execute(req, resp);

		// 4. forwarding
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
