<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 앞에서 전달한 파라미터 값을 가져와서 화면에 출력 -->
	<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	%>
	<h1>
		ID :
		<%=id%></h1>
	<h1>
		PWD :
		<%=pwd%></h1>

	<!-- 1. DB연결
2. 테이블 -->
	<%
	// 1. 환경변수
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "scott";
	String password = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 2. 드라이버로딩  
	Class.forName(driver);
	
	conn = DriverManager.getConnection(url, username, password);
	
	//4. sql 문장
	StringBuffer sb = new StringBuffer();
	sb.append("SELECT id, pw, name From member WHERE id = ? and pw = ? ");
	
	//작성한 sql문을 한 번 출력
	System.out.println("SQL : " + sb.toString());
	
	//5. sql문장 객체
	pstmt = conn.prepareStatement(sb.toString());
	pstmt.setString(1, id);
	pstmt.setString(2, pwd);
	
	//6. 실행(ResultSet)
	rs = pstmt.executeQuery();
	
	//7. 레코드별 로직 처리
	if(rs.next()){
	String name = rs.getString("name");
	//8.자원반납
	out.println("name : " + name);
	}else{
		out.println("<h1> 아이디 또는 패스워드를 확인해주세요.</h1>");
	}
	
	%>
	
	
	
</body>
</html>












