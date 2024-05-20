<%@page import="java.util.Arrays"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
		// 아이디
		String id = request.getParameter("id");
		
		// 이름
		String name = request.getParameter("name");
		
		// 주민등록번호
		String identifiNum1 = request.getParameter("identifiNum1");
		String identifiNum2 = request.getParameter("identifiNum2");
		
		String pw = request.getParameter("pw");
		
		// 전화번호
		String call1 = request.getParameter("call1");
		String call2 = request.getParameter("call2");
		String call3 = request.getParameter("call3");
		
		// 주소 
		String addr = request.getParameter("addr");
		
		// 이메일
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		if (email2.equalsIgnoreCase("")) {
			email2 =  request.getParameter("email3");
		}
		
		// 성별
		String gender = request.getParameter("gender");
		
		// 취미
		String[] hobby = request.getParameterValues("hobby");
		
		out.println("<h2>ID: " + id + "</h2>");
		out.println("<h2>NAME: " + name + "</h2>");
		out.println("<h2>주민등록번호: " + identifiNum1 + "-" + identifiNum2 + "</h2>");
		out.println("<h2>비밀번호: " + pw + "</h2>");
		out.println("<h2>전화번호: " + call1 + "-" + call2 + "-" + call3 + "</h2>");
		out.println("<h2>주소: " + addr + "</h2>");
		out.println("<h2>이메일: " + email1 + "@" + email2 + "</h2>");
		out.println("<h2>성별: " + gender + "</h2>");
		out.println("<h2>취미: " + (hobby==null ? "없음":Arrays.asList(hobby)) + "</h2>");
	%>


</body>
</html>