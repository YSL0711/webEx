package day01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//public class MyWindow extends JFrame{
////	상속을 받으면 구현하지 않아도 가져다가 쓸 수 있다.
//	MyWindow(){
//		super();	//생략되어있는 것
//		setLocation(100, 100); //위치 설정
//		setSize(800, 600);
//		setVisible(true);
//	}
//	
//}


//Servlet
//웹에서 동작하는 자바 프로그램
//서블릿 작성 순서
//1.HttpServlet 상속
//2. doGet() , doPost() override
//3. @WebServlet()
//localhost:8080/web/hello.do

//! Servlet을 상속받자.
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	System.out.println("doGet() method");
	
//	req  : 사용자의 요청 객체
//	resp : 서버의 응답을 객체로 만든 것
	
//	응답객체로부터 PrintWriter 객체를 얻어오기
	
	PrintWriter out = resp.getWriter();	
	
//	사용자 브라우저에 아래 내용을 전달
	out.println("<html>");
	out.println("<head><title>My Servlet</title></head>");
	out.println("<body>");
	for(int i=0 ; i <101; i++) {
		out.println("<h2>Hello Servlet World</h2>");
	}
	out.println("</body>");
	out.println("</html>");
	
	//	MyWindow mw = new MyWindow();
}
}