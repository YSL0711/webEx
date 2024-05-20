<%@page import="kr.co.j.vo.DeptVO"%>
<%@page import="kr.co.j.dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	if( dname != null && loc != null){
		DeptDAO dao = new DeptDAO();
		
		DeptVO vo = new DeptVO();
		vo.setDname(dname);
		vo.setLoc(loc);

	dao.addOne(vo);
	
	response.sendRedirect("list.jsp");
	
	}
%>