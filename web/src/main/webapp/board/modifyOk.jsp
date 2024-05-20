<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	String b = request.getParameter("bno");
	
	System.out.println("게시물번호 : " + b);
	out.println("작성자 : " + writer);
	out.println("제목 : " + title);
	out.println("내용 : " + contents);
	
	if (b != null) {
		int bno = Integer.parseInt(b);
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getOne(bno);
		//파라미터값으로 새로운 값 지정 후, 수정
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setBno(bno);
		 dao = new BoardDAO();
		dao.updateOne(vo);
	}
	response.sendRedirect("list.jsp");
%>