
<%@page import="java.util.Arrays"%>
<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAO"%>
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
	
	/* 1. 파라미터 값 가져오기 */
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");	
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String motive = request.getParameter("motive");

	/* 2.출력 */
	out.println("<h3> id :" + id + "</h3>");	
	out.println("<h3> pw :" + pw + "</h3>");
	out.println("<h3> name :" + name + "</h3>");
	out.println("<h3> gender :" + gender + "</h3>");
	out.println("<h3> motive :" + (motive==null ? "없음":Arrays.asList(motive)) + "</h3>");

	/* MemberDAO */
	MemberDAO dao = new MemberDAO();

	/* 파라미터값을 가지고 vo 객체를 생성 */
	/* MemberVO vo = new MemberVO(0, id, name, pw, gender, motive); */
	MemberVO vo = new MemberVO();
	//vo 객체 만들어주기
	vo.setId(id);
	vo.setPw(pw);	
	vo.setName(name);
	vo.setGender(gender);
	vo.setMotive(motive);
	
	//4. db에 입력
	dao.addMember(vo);
	//5. login.jsp로 리다이렉트
	response.sendRedirect("login.jsp");
	
	%>

</body>
</html>