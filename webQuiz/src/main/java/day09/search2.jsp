
<%@page import="kr.co.jhta.web.vo.EmpVO"%>
<%@page import="dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String empnoString = request.getParameter("empno");
	if (empnoString != null) {
		int empno = Integer.parseInt(empnoString);
		String ename = request.getParameter("ename");
	
	
		EmpDAO dao = new EmpDAO();
		EmpVO vo = dao.searchEmp(empno, ename);
		out.println(vo !=null);
	}
%>
