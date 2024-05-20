<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>두수의 합 : ${num1 + num2}</h1>
	
	<!-- 두수중 큰 값 출력하기 -->
	<h1>${num1 > num2 ? num1 : num2}</h1>
	
	<%-- <c:if test="조건">
		// 만족시 실행
	</c:if> --%>
	
	<c:if test="${num1 > num2 }">
		<h1>num1이 더 크다</h1>
	</c:if>
</body>
</html>