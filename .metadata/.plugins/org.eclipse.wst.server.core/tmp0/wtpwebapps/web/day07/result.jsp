<%@page import="dao.FileDAO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result.jsp</title>
</head>
<body>
	<%
	//upload 디렉토리의 실제 경로 얻어오기
	String saveDir = application.getRealPath("/upload");

	out.println(saveDir);

	//첨부파일의 최대크기
	/* 		*각1024개
		1kbyte ==> 1Mbyte ==> 1Gbyte ==> 1Tbyte ==> */
	//30MB
	int maxFileSize = 1024 * 1024 * 30;

	//cos.jar : MultipartRequest

	/* 요청객체가 생성자로 들어가고 있다'request' */
	//만약 동일한 이름 파일이 있다면? 새로운 객체를 만듬. 걔가 처리(뒤에 번호를 붙여줌!).
	MultipartRequest mr = new MultipartRequest(request, saveDir, maxFileSize, "UTF-8", new DefaultFileRenamePolicy());

	//네임값을 찾아와준다
	Enumeration params = mr.getParameterNames();

	//가지고 있던 엘리먼츠 중 존재하면 스트링으로 가져옴
	while (params.hasMoreElements()) {
		String name = (String) params.nextElement();
		System.out.println("name : " + name);

		String value = mr.getParameter(name);
		out.println("<h2>" + name + ":" + value + "</h2>");
	}

	out.println("<hr>");

	String filename = mr.getFilesystemName("filename");
	String original = mr.getOriginalFileName("filename");
	File file = mr.getFile("filename");
	String type = mr.getContentType("filename");

	out.println("<h2> 저장 파일명 : " + filename + "</h2>");
	out.println("<h2> 실제 파일명 : " + original + "</h2>");
	out.println("<h2> 컨텐츠 타입 : " + type + "</h2>");

	FileDAO dao = new FileDAO();

	String title = mr.getParameter("title");
	String writer = mr.getParameter("writer");
	String contents = mr.getParameter("contents");
	dao.addOne(title, writer, contents, filename);
	%>


	<a href="view.jsp">이미지 보기</a>
	<a href="dirView.jsp">저장 디렉토리 파일 목록보기</a>

	<!-- 파라미터 값 가져오기 String title =
	mr.getParameter("title"); String writer = mr.getParameter("writer");
	String contents = mr.getParameter("contents"); String f =
	mr.getOriginalFileName("filename"); /* String title =
	request.getParameter("title"); String writer =
	request.getParameter("writer"); String contents =
	request.getParameter("contents"); String filename =
	request.getParameter("filename"); out.println("
	<h2>제목: " + title + "</h2>
	"); out.println("
	<h2>작성자: " + writer + "</h2>
	"); out.println("
	<h2>내용: " + contents + "</h2>
	"); out.println("
	<h2>첨부파일: " + filename + "</h2>
	");  -->

</body>
</html>