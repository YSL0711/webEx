<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteOk.jsp</title>
</head>
<body>

	<%
	String b = request.getParameter("bno");

	if (b != null) {
		int bno = Integer.parseInt(b);

		BoardDAO dao = new BoardDAO();

		dao.deleteOne(bno);

	}
/* 	response.sendRedirect("list.jsp"); */
	%>

</body>
</html>
