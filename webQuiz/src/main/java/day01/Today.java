package day01;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/today.do")
public class Today extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String today=req.getParameter("today");
	
		PrintWriter out = resp.getWriter();
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<meta charset='UTF-8'>");
	      out.println("<title>지금 시간은</title>");
	      out.println("</head>");
	      out.println("<body>");
//	      자바의 문법
	      Date d = new Date();
	      
	      SimpleDateFormat sdf = 
	    		  		new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
	      String time = sdf.format(d);
	      
	      out.println("<h3>" + time +"</h3>");
	      
	      out.println("</body>");
	      out.println("</html>");
		
	}
	
}
