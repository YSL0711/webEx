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
	//1. 파라미터 값 가져오기
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2"); // 오타 수정: num1 -> num2
	
	//2. 변수 초기화
	int n1 = 0;
	int n2 = 0;
	int n3 = 0;
	//3. num1과 num2의 값이 null이 아니면 형변환
	if(num1 != null && num2 != null){
		n1 = Integer.parseInt(num1); // 변수명 수정: n1
		n2 = Integer.parseInt(num2); // 변수명 수정: n2
		//4. 계산
		n3 = n1 + n2;
	}
	%>


	<form action="">
	<!-- //5. 이 값을 태그의 value로 지정 -->
		<input type="text" name="num1" id="" value="<%= n1 %>" />
		+
		<input type="text" name="num2" id="" value="<%= n2 %>"/>
		<input type="submit" value="=" />
		<input type="text" name="result" value="<%= n3 %>" />
	</form>


</body>
</html>
