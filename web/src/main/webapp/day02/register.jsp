<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register.jsp</title>
<style>
*{
font-size : 18px;
}
h2 {
	font-size : 25px;
	text-align: center;
}
</style>
</head>
<body>
	<form action="registerOk.jsp">
		<h2>가입신청서</h2>
		ID: <input type="text" name="id" id="" /> <br>
		NAME : <input type="text" name="name" id="" /><br>
		주민등록번호 : <input type="text" name="no1" id="" />
			-<input type="password" name="no2" id="" /><br>
		비밀번호 : <input type="text" name="pw" id="" /><br>
		전화번호 : <input type="text" name="pn1" id="" />
			-<input type="text" name="pn2" id="" />
			-<input type="text" name="pn3" id="" /><br>
		주소 : <input type="text" name="addrs" id="" /><br>
		EMAIL : <input type="text" name="email1" id="" />
			@ <input type="text" name="email2" id="" /><br>
		성별 : 남<input type="radio" name="gendr1" value="male" />
			   여<input type="radio" name="gendr2" value="female" /> <br>
		취미 : 음악감상<input type="checkbox" name="hobby1" value="music" />
			   독서<input type="checkbox" name="hobby2" value="reading" />
			   운동<input type="checkbox" name="hobby3" value="exer" /><br> 
			   <input type="submit" value="가입하기" />
			   <input type="reset" value="취소하기" />
	</form>
</body>
</html>