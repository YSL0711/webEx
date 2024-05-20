package day01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//localhost:8080/web/gugudan.do : 구구단 3단 출력
//서블릿
//
//1. HttpServlet 상속
//2. doGet() Override
//3. 서블릿(@WebServlet)을 톰캣에서 등록(@ = anotation을 줘서)
//4. h3태그 출력

//웹은 소문자로!!
@WebServlet("/gugudan.do")
public class GuGuDan3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("GuGuDan3 서블릿 실행중");
		
		PrintWriter out = resp.getWriter();
		//	import 단축키 : ctrl+shift+o
		
		out.println("<html>");
		out.println("<head><title>GuGuDan3</title></head>");
		out.println("<body>");
			for(int i=1; i<10; i++) {
				out.println("<h3> 3*"+i+"</h3>");
		out.println("</body>");
		out.println("</html>");
		
		}
	}

}
