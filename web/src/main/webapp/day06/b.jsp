<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 다른 파일 불러오기(a.jsp) -->
	<!-- 2가지 방법이 있음
	1. include 지시자를 사용
		copy&paste 효과가 난다.
		소스를 긁어다 붙여줌
	-->
	
	<!-- 
	2. jsp action tag
		컴파일 된 결과를 삽입해준다.
				결과물이 들어가는 것.
	 -->

<!-- 1번 방법	 -->
	<%-- <%@ include file="a.jsp" %>
	
	<%
		/* a변수를 출력 */
		out.println("b.jsp에서 a의 값 : " + a);
	%> --%>
	
<!-- 2번 방법 -->	
 <jsp:include page="a.jsp"></jsp:include>

</body>
</html>