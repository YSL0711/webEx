<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- h1태그로 오늘의 날짜와 현재 시간 출력 -->
	<%
	// Date 객체를 생성
		Date d = new Date(); 
		/*java.util.Date d = new java.util.Date(); */
		/* ctrl+space 잘 쓰자 임포트할 때 */

	// SimpleDateFormat 사용하여 날짜와 시간을 형식화
	/* java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("HH:mm:ss");
    */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh24시 mm분 ss초");
    
   
	// 형식화된 날짜와 시간을 문자열로 가져옴
	String time = sdf.format(d);
	
	out.println("<h1>"+time+"</h1>");
	%>

	<h1><%=time%></h1>

</body>
</html>
