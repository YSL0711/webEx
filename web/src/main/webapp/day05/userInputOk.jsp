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
	//Cookie
	//서버가 사용자 브라우저에 남기는 작은 정보 조각

	String txt = request.getParameter("txt");

	Cookie c = new Cookie("txt", txt);

	//이 쿠키의 유통기한 1년으로 지정
	/* 60*60*24는 초 단위로 1년을 나타냅니다.
	1분은 60초이므로 60초 * 60분 * 24시간 = 1일이 됩니다.
	따라서 1년은 1일 * 365일 = 365일이 됩니다.
	setMaxAge() 메서드는 쿠키의 유효 기간을 초 단위로 설정합니다.
	따라서 c.setMaxAge(60*60*24);는 쿠키의 유효 기간을 1년(365일)으로 설정하는 것입니다. */
	c.setMaxAge(60 * 1);

	//사용자 브라우저에 저장
	response.addCookie(c);

	out.println("<h3>" + txt + "</h3>");
	%>

	<a href="userCookieList.jsp">쿠키 보러 가기</a>

</body>
</html>


<!-- 정보를 저장

session
Cookie

 -->