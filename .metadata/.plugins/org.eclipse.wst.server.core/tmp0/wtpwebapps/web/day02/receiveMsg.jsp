<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>receiveMsg.jsp</title>
</head>
<body>
	<%
	/* 모든 코드가 _jspService() */
	/* _jspService() */
	String msg = request.getParameter("msg");
	
	/* 브라우저에 h2태그로 출력 */
	out.println("<h2>"+ msg + "</h2>");
	%>
</body>
</html>