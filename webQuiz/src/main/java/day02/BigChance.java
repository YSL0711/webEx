package day02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// localhost:8080/web/bigChance.do
// 로또번호 6자리 숫자..

// 이미지로 출력
// <img src="" alt=""/>

@WebServlet("/BigChance.do")
public class BigChance extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title> 대박로또 인생은 한 방! </title>");
		out.println("</head>");
		out.println("<body>");
//	      localhost:8080/web/bigChance.do
//	      localhost:8080/web/<==webapp
//	      out.println("<img src='../images/ball5.png'/>");

//	      Date d new Date();
		Lotto lt = new Lotto();

		int[] m = lt.getM();
		for (int i = 0; i < m.length; i++) {
			out.println("<img src='./images/ball" + m[i] + ".png'/>");
		}

		out.println("</body>");
		out.println("</html>");

	}

	// out.println("<img src='../images/ball5.png'/>);

}
