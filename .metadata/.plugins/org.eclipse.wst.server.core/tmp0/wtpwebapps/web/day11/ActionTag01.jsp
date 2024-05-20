<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		<%@ include file="test.jsp" %>
	
		<jsp:include page=""></jsp:include> 
	
		<jsp:XXX> JSP Action tag
	--%>
	
	<h2>현재 페이지는 actionTag01.jsp 입니다.</h2>
	
	<jsp:forward page="forward1.jsp"></jsp:forward>
	
	<%-- <%
		RequestDispatcher rd = request.getRequestDispatcher("forward1.jsp");
		rd.forward(request, response);
	%> --%>
</body>
</html>