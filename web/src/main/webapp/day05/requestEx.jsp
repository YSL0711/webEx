<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// .jsp ==> _jsp.java (_jspService(HttpServletRequest request, HttpServletResponse response))파일로 변환 ==> _jsp.class
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// GET, POST 방식?
		String method = request.getMethod();
		
		String queryString = request.getQueryString();
		
		String ip = request.getRemoteAddr();
		
		out.println("<h2> method : " + method + "</h2>");
		out.println("<h2> queryString : " + queryString + "</h2>");
		out.println("<h2> ip : " + ip + "</h2>");
	%>
	
</body>
</html>