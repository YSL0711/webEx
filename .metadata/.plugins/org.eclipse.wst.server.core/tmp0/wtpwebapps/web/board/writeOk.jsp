<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    
    	String writer = request.getParameter("writer");
    	String title = request.getParameter("title");
    	String contents = request.getParameter("contents");
    
    	
    	BoardDAO dao = new BoardDAO();
    	BoardVO vo = new BoardVO();
    	vo.setTitle(title);
    	vo.setWriter(writer);
    	vo.setContents(contents);
    	/*
    	String ip  = request.getRemoteAddr();
    	vo.setIp(ip);
    	 */
    	vo.setIp(request.getRemoteAddr());
    	
    	
    	
    	
    	dao.addOne(vo);
    	
    	
    	response.sendRedirect("list.jsp");
    	
    	
    %>