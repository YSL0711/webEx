package ex3;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NowCommand implements ActionCommand{

	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(date);
		req.setAttribute("msg", now);
		return "ex3/now.jsp";
	}

}
