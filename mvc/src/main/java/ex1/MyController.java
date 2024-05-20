package ex1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 서블릿 작성 방법
// 1. HttpServlet 상속
// 2. doGet(), doPost() override
// 3. @WebServlet

// localhost:8080/mvc/MyController?cmd=hello 요청 ==> hello.jsp 파일로 이동
@WebServlet("/MyController")
public class MyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 2. 파라미터 값 가져오기
		String cmd = req.getParameter("cmd");
		System.out.println("cmd : " + cmd);
		
		String url = "";
		
		String msg = "";
		
		if(cmd == null || cmd.equals("hello")) {
			msg = "안녕하세요";
			req.setAttribute("msg", msg);
			url = "hello.jsp";
		}
		
		// forward 방식으로 hello.jsp 로 이동
		RequestDispatcher rd = req.getRequestDispatcher(url);
		
		rd.forward(req, resp);
	}
}
